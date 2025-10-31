package com.operation.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map; // Import Map from java.util package
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.operation.Entity.RequestDTO;
import com.operation.Entity.User;
import com.operation.config.PropertiesConfig;
import com.operation.repository.LogBookRepository;
import com.operation.repository.UserRepository;
import com.operation.service.EncryptionService;
import com.operation.service.LogService;
import com.operation.service.UserService;

@RestController
public class FileController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	LogBookRepository logBookRepository;

	@Autowired
	EncryptionService encryptionService;

	@Autowired
	PropertiesConfig propertiesConfig;

	@Autowired
	UserService userService;

	@Autowired
	LogService logService;

	private static final Logger LOGGER = Logger.getLogger(HtmlController.class.getName());

	public FileController(UserRepository userRepository, LogBookRepository logBookRepository) {
		this.userRepository = userRepository;
		this.logBookRepository = logBookRepository;
	}

	/*
	 * ___________________________________________________________________________________________
	 */ /****
		 * getPdf API
		 * 
		 * @throws SQLException
		 * 
		 * @throws DocumentException
		 *******/

	@GetMapping("/getFile")
	public ResponseEntity<?> getById(@RequestBody RequestDTO requestDTO) throws SQLException {

		Date startDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = sdf.format(startDate);
		LOGGER.info("Started processing request at: " + formattedDate);

		try {
			validateRequest(requestDTO);
			User user = userRepository.findById(requestDTO.getId())
					.orElseThrow(() -> new NoSuchElementException("User with specified ID not found"));
			String filePath = user.getPathOfEditHTML();

			String jsonData = requestDTO.getJsonData();
			// jsonData = EncryptionService.decrypt(jsonData);

			String downloadType = requestDTO.getDownloadType().trim();

			String nano = DateTimeFormatter.ofPattern("yyyyMMddHHmmssnnnnnnnnn").format(LocalDateTime.now())
					.substring(0, 21);

			if (downloadType.equalsIgnoreCase("HTML")) {
				try {
					// Modify the HTML content
					String modifiedHtmlContent = modifyHtml(filePath, jsonData, false);

					// Encrypt the JSON data
					String encryptedData = EncryptionService.encrypt(modifiedHtmlContent);

					// Generate a new path for the modified HTML file
					String newHtmlPath = propertiesConfig.getUploadFolder() + user.getId() + "_" + nano + ".html";

					String EncriptHtmlContain = encryptionService.secureHtmlContain(encryptedData);

					// Write the modified HTML content to a file
					writeToFile(newHtmlPath, EncriptHtmlContain);

					LOGGER.info("HTML file has been modified and encrypted successfully.");
					logService.logToDatabase(requestDTO, "Success", null, startDate);

					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.TEXT_HTML);
					return ResponseEntity.ok().headers(headers).body(modifiedHtmlContent);
				} catch (Exception e) {

					LOGGER.info("Error occurred while modifying and encrypting HTML file: " + e.getMessage());
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body("Error occurred while modifying and encrypting HTML file");
				}

			} else if (downloadType.equalsIgnoreCase("PDF")) {
				String modifiedHtmlContent = modifyHtml(filePath, jsonData, true);

				String pdfName = user.getId() + "_" + nano + ".pdf";
				String pdfPath = propertiesConfig.getUploadFolder() + pdfName;
				String tempHtml = createTempHtmlFile(String.valueOf(user.getId()), nano, modifiedHtmlContent);

				byte[] pdfContains = getPdf(tempHtml, pdfPath);
				
				
				if (new File(tempHtml).delete()) {
			        System.out.println("Temp File Deleted.");
			    } 

				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.setContentType(MediaType.APPLICATION_PDF);
				responseHeaders.setContentDispositionFormData("attachment", "output.pdf");
				return ResponseEntity.ok().headers(responseHeaders).body(pdfContains);

			} else {
				return ResponseEntity.ok().body("No file created. Invalid download type specified.");
			}
		} catch (NoSuchElementException e) {
			String errorMessage = "User with specified ID not found.";
			LOGGER.warning(errorMessage);
			return handleFailure(errorMessage, requestDTO, startDate);
		} catch (IOException e) {
			String errorMessage = "Error processing request.";
			LOGGER.severe(errorMessage);
			e.printStackTrace();
			return handleFailure(errorMessage, requestDTO, startDate);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = "Validation failed for the request.";
			LOGGER.warning(errorMessage);
			return handleFailure(errorMessage, requestDTO, startDate);
		}
	}

	/**********************************************************************/

	private String createTempHtmlFile(String userId, String nano, String modifiedHtmlContent) throws IOException {
		String tempFolder = propertiesConfig.getTempFolder();
		Path folderPath = Paths.get(tempFolder);
		if (!Files.exists(folderPath)) {
			Files.createDirectories(folderPath);
		}
		String tempHtml = tempFolder + userId + "_" + nano + ".html";
		writeToFile(tempHtml, modifiedHtmlContent);
		return tempHtml;
	}

	public byte[] getPdf(String htmlFilePath, String outputPdfPath) {

		try (Playwright playwright = Playwright.create()) {
			BrowserType chromium = playwright.chromium();
			Browser browser = chromium.launch();
			Page page = browser.newPage(new Browser.NewPageOptions().setViewportSize(1080, 1080));

			// Navigate to the local HTML file
			page.navigate("file:///" + htmlFilePath);

			// Wait for the page to fully load
			page.waitForLoadState(LoadState.NETWORKIDLE);

			// Sleep for additional time if needed (optional)
			TimeUnit.SECONDS.sleep(4); // Adjust timeout as necessary

			// Get the size of the webpage content after it's fully loaded
			Object contentSize = page
					.evaluate("() => { " + "const rect = document.documentElement.getBoundingClientRect();" + "return {"
							+ "width: Math.ceil(rect.width)," + "height: Math.ceil(rect.height)" + "};" + "}");

			// Convert contentSize from JavaScript object to Java Map
			@SuppressWarnings("unchecked")
			Map<String, Object> sizeMap = (Map<String, Object>) contentSize;
			int width = ((Number) sizeMap.get("width")).intValue(); // Use Number to handle both Integer and Double
			int height = ((Number) sizeMap.get("height")).intValue(); // Use Number to handle both Integer and Double

			// Generate the PDF directly from the webpage with specific settings
			byte[] pdfBytes = page.pdf(new Page.PdfOptions().setPath(Paths.get(outputPdfPath)).setWidth(width + "px")
					.setHeight(height + "px").setScale(1.0).setFormat("A3").setPrintBackground(true));

			// Close the browser
			browser.close();

			System.out.println("PDF file created successfully.");

			return pdfBytes;
		} catch (Exception e) {
			System.err.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	private static String modifyHtml(String filePath, String jsonData, boolean page) throws IOException {
		System.out.println("Enter in modifyHtml");

		StringBuilder htmlContent = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				htmlContent.append(line).append("\n");
			}
		}
		System.out.println("HTML content read successfully.");

		String start1 = "const a=\"";
		String end1 = "function _0x40ef(){const _0x4fc939=";

		int start1Index = htmlContent.indexOf(start1);
		int end1Index = htmlContent.indexOf(end1);

		if (start1Index == -1 || end1Index == -1) {
			System.err.println("Error: Start or end pattern not found in HTML content.");
			return htmlContent.toString();
		}

		start1Index += start1.length();
		end1Index -= 2;
		String encryptedHtmlContent = htmlContent.substring(start1Index, end1Index);

		String newHtmlContent;
		try {
			newHtmlContent = EncryptionService.decrypt(encryptedHtmlContent);
		} catch (Exception e) {
			System.err.println("Error during decryption: " + e.getMessage());
			return htmlContent.toString();
		}

		System.out.println("Decryption successful.");

		if (page) {
			newHtmlContent = newHtmlContent.replaceAll("let pagination = \"true\"", "let pagination = \"\"");
		}

		String toFind = "var jsonData1";
		int startIndex = newHtmlContent.indexOf(toFind);
		if (startIndex != -1) {
			int endIndex = newHtmlContent.indexOf("]; var custom_language", startIndex);
			if (endIndex != -1) {
				String start = newHtmlContent.substring(0, startIndex + toFind.length());
				String end = newHtmlContent.substring(endIndex + 2);
				String finalString = start + "=[" + jsonData + "]\n" + end;
				return finalString;
			} else {
				System.err.println("Error: End pattern not found after 'jsonData1'.");
			}
		} else {
			System.err.println("Error: 'var jsonData1' not found in decrypted content.");
		}

		return newHtmlContent;
	}

	private ResponseEntity<?> handleFailure(String errorMessage, RequestDTO requestDTO, Date startDate)
			throws SQLException {
		LOGGER.warning("Failure: " + errorMessage);
		logService.logToDatabase(requestDTO, "Failure", errorMessage, startDate);
		System.out.println("Failure: " + errorMessage);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	}

	private void validateRequest(RequestDTO requestDTO) {
		if (requestDTO.getId() == null || requestDTO.getJsonData() == null || requestDTO.getDownloadType() == null) {
			throw new NullPointerException("Id, JSON data, or download type is null.");
		}
	}

	private void writeToFile(String filePath, String content) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.write(content);
			LOGGER.info("HTML File save In : " + filePath);
		}
	}

}
