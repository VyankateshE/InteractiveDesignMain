package com.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;


class FileProcessor implements Callable<Void> {
	private final String jsonPath;
	private final String path;
	private final String outputFolder;

	private final String typeOfDownload; // Add this line

	public FileProcessor(String jsonPath, String path, String outputFolder, String typeOfDownload) {
		this.jsonPath = jsonPath;
		this.path = path;
		this.outputFolder = outputFolder;
		this.typeOfDownload = typeOfDownload;
	}

	@Override
	public Void call() {
		// The rest of your file processing logic here
		// ...
		String threadName = Thread.currentThread().getName();
		Date processingStartTime = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDate1 = dateFormat.format(processingStartTime);
		formattedDate1 += ":06";

		String jsonFile = jsonPath.substring(jsonPath.lastIndexOf(File.separator) + 1, jsonPath.lastIndexOf(".json"));

		System.out.println(threadName + " started For " + jsonFile + " at " + formattedDate1);
		try {
			// Specify the path to the HTML file you want to modify
			String filePath = path;

			// Modify the HTML content as needed
			String jsonContent = new String(Files.readAllBytes(Paths.get(jsonPath)));

			// Write the modified HTML content back to the file
			String timestamp = String.valueOf(System.currentTimeMillis());

			// Write the modified HTML content to the new file
			if (typeOfDownload.equalsIgnoreCase("HTML")) {
				String modifiedHtmlContent = modifyHtml(filePath, jsonContent, false);
				
				

				String newFilePath = outputFolder + File.separator + jsonFile + "_" + timestamp + ".html";

				// Encrypt the JSON data
				String encryptedData = null;
				try {
					encryptedData = JsonService.encrypt(modifiedHtmlContent);
				} catch (Exception e) {
					e.printStackTrace();
				}

				String EncriptHtmlContain = JsonService.secureHtmlContain(encryptedData);
				
				BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath));
				writer.write(EncriptHtmlContain);
				writer.close();

			}

			if (typeOfDownload.equalsIgnoreCase("PDF")) {

				String modifiedHtmlContent = modifyHtml(filePath, jsonContent, true);
				String currentDirectory = System.getProperty("user.dir");
				Path uploadPath = Paths.get(currentDirectory);
				String folderName = "HtmlDownloadTemp";
				// Create the folder if it doesn't exist
				Path folderPath = uploadPath.resolve(folderName);

				if (!Files.exists(folderPath)) {
					Files.createDirectories(folderPath);
				}
				String tempFile = jsonFile + "_" + timestamp + ".html";
				String folderPathString = folderPath.toString() + File.separator + tempFile;

				BufferedWriter writer = new BufferedWriter(new FileWriter(folderPathString));
				writer.write(modifiedHtmlContent);
				writer.close();
				
				String pdfPath = outputFolder + File.separator +tempFile.replaceFirst("[.][^.]+$", "") + ".pdf";
				
				getPdf(folderPathString, pdfPath);

			}
		
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error modifying the HTML file.");

		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime processingEndTime = LocalDateTime.now();
		String formattedDate = processingEndTime.format(formatter);
		System.out.println(threadName + " finished processing file: " + jsonFile + " at " + formattedDate);

		return null;
	}

	private static String modifyHtml(String filePath, String jsonData, boolean isPdf) throws IOException {

		StringBuilder htmlContent = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				htmlContent.append(line).append("\n");
			}
		}
		

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
			newHtmlContent = JsonService.decrypt(encryptedHtmlContent);
		} catch (Exception e) {
			System.err.println("Error during decryption: " + e.getMessage());
			return htmlContent.toString();
		}

		if (isPdf) {
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

	
	
	public void getPdf(String htmlFilePath, String outputPdfPath) {

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
			 page.pdf(new Page.PdfOptions().setPath(Paths.get(outputPdfPath)).setWidth(width + "px")
					.setHeight(height + "px").setScale(1.0).setFormat("A3").setPrintBackground(true));

			// Close the browser
			browser.close();

		} catch (Exception e) {
			System.err.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	
	}

	public void savePdfToFolder(ResponseEntity<byte[]> response, String folderPath, String filename) {
		if (response.getStatusCode() == HttpStatus.OK) {
			byte[] pdfByteArray = response.getBody();

			// Ensure the folder exists
			File folder = new File(folderPath);
			if (!folder.exists() && !folder.mkdirs()) {
				System.err.println("Failed to create the folder at: " + folderPath);
				return;
			}

			String outputPath = folderPath + File.separator + filename;

			try (FileOutputStream fos = new FileOutputStream(outputPath)) {
				fos.write(pdfByteArray);
				System.out.println("PDF downloaded and saved to: " + outputPath);
			} catch (IOException e) {
				e.printStackTrace();
				// Handle the exception
			}
		} else {
			System.out.println("HTTP request failed with response code: " + response.getStatusCodeValue());
		}
	}

}
