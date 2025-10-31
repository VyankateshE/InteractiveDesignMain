package com.operation.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.operation.Entity.FileUploadResponse;
import com.operation.Entity.LogData;
import com.operation.Entity.RequestDTO;
import com.operation.Entity.User;
import com.operation.config.PropertiesConfig;
import com.operation.repository.LogBookRepository;
import com.operation.repository.UserRepository;
import com.operation.service.FileProcessor;
import com.operation.service.FileToMultipartFile;
import com.operation.service.LogService;
import com.operation.service.EncryptionService;
import com.operation.service.UserService;

@RestController
public class HtmlController {

	@Autowired
	RestTemplate restTemplate = new RestTemplate();

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

	public HtmlController(UserRepository userRepository, LogBookRepository logBookRepository) {
		this.userRepository = userRepository;
		this.logBookRepository = logBookRepository;
	}

	@CrossOrigin(origins = "http://localhost:5500")
	@PostMapping("/uploadFile")
	public ResponseEntity<?> uploadFile(@RequestParam("editableHtml") MultipartFile editFile,
			@RequestParam("downloadableHtml") MultipartFile downloadFile, @RequestParam("name") String name)
			throws IOException {

		// Check if the name already exists
		if (doesNameExist(name)) {
			return ResponseEntity.badRequest().body("Name already exists. Please choose a different name.");
		}

		// Create a new user
		User user = userService.createUser(name);

		// Generate file names using the user's ID
		String editFileName = generateFileName(user.getId(), "editable_html.html");
		String downloadFileName = generateFileName(user.getId(), "downloadable_html.html");

		// Save the uploaded files
		saveFile(editFileName, editFile, true); // Encrypt and save editable HTML
		saveFile(downloadFileName, downloadFile, false); // Save downloadable HTML without encryption

		// Set file paths for the user
		String folderPath = getDownloadFolder();
		String editFilePath = folderPath + File.separator + editFileName;
		String downloadFilePath = folderPath + File.separator + downloadFileName;
		user.setPathOfEditHTML(editFilePath);
		user.setPathOfDownloadHTML(downloadFilePath);

		// Update the user in the repository
		userRepository.save(user);

		// Prepare response
		FileUploadResponse response = new FileUploadResponse();
		response.setFileName1(editFilePath);
		response.setFileName2(downloadFilePath);
		response.setMessage("Files uploaded successfully.");

		return ResponseEntity.ok().body(response);
	}

	private String generateFileName(Integer userId, String fileType) {
		return userId + "_" + fileType;
	}

	private void saveFile(String fileName, MultipartFile multipartFile, boolean encrypt) throws IOException {
		String folderPath = getDownloadFolder();
		Path filePath = Paths.get(folderPath).resolve(fileName);

		try (InputStream inputStream = multipartFile.getInputStream()) {
			if (encrypt) {
				String encryptedData = encryptionService.encryptFile(inputStream);
				String secureHtml = encryptionService.secureHtmlContain(encryptedData);
				Files.write(filePath, secureHtml.getBytes());
			} else {
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			}
		}
	}

	private String getDownloadFolder() throws IOException {
		String downloadFolder = propertiesConfig.getDownloadFolder();
		Path downloadPath = Paths.get(downloadFolder);
		if (!Files.exists(downloadPath)) {
			Files.createDirectories(downloadPath);
		}
		return downloadPath.toString();
	}

	public boolean doesNameExist(String name) {
		Optional<User> item = userRepository.findByName(name);
		return item.isPresent();
	}

	/*
	 * _________________________________________________________________________________________________________
	 */

	@PutMapping("/editTemplate/{id}")
	public ResponseEntity<String> editUser(@PathVariable Integer id, @RequestBody User user) {

		try {
			String result = userService.editUser(id, user);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {

			return ResponseEntity.badRequest().body("Failed to edit user template.");
		}
	}

	/*
	 * ________________________________________________________________________________________________________
	 */

	@DeleteMapping("/deleteTemplate/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {

		try {
			String result = userService.deleteUser(id);
			HttpHeaders headers = new HttpHeaders();
			// http://localhost:9998
			headers.add("Access-Control-Allow-Origin", "*");
			headers.add("Access-Control-Allow-Methods", "DELETE");
			headers.add("Access-Control-Allow-Headers", "Content-Type");
			return ResponseEntity.ok().headers(headers).body(result);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Failed to delete user template.");
		}
	}

	/*
	 * _____________________________________________________________________________________________________________
	 */

	@GetMapping("/getTemplate/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) {

		User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
		return ResponseEntity.ok(user);
		// User user = repository.findById(id).get();
		// return ResponseEntity.ok(user);
	}

	/*
	 * ______________________________________________________________________________________________________________
	 */

	@GetMapping("/getTemplate")
	public ResponseEntity<List<User>> getUserTemplates() {
		try {
			List<User> userList = userService.getAllUsers();
			return ResponseEntity.ok().header("Access-Control-Allow-Origin", "http://127.0.0.1:5501")
					.header("Access-Control-Allow-Methods", "GET")
					.header("Access-Control-Allow-Headers", "Content-Type").body(userList);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/*
	 * _______________________________________________________________________________________________________________
	 */

	@GetMapping("/getDataFromDates")
	public ResponseEntity<List<LogData>> getDataFromDates(@RequestParam("startDateStr") String startDateStr,
			@RequestParam("endDateStr") String endDateStr) throws ParseException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET");
		headers.add("Access-Control-Allow-Headers", "Content-Type");

		if (ObjectUtils.isEmpty(startDateStr) || ObjectUtils.isEmpty(endDateStr)) { // StringUtils.isEmpty(startDate)
			List<LogData> logData = logBookRepository.findAll();
			return ResponseEntity.ok().headers(headers).body(logData);
		}
		SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate2 = inputDateFormat.parse(startDateStr);

		// Step 2: Format the Date object to the desired format
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String outputDateStr = outputDateFormat.format(startDate2);

		// Step 3: Parse the formatted date string back to a Date object
		Date finalStartDate = outputDateFormat.parse(outputDateStr);

		Date endDate2 = inputDateFormat.parse(endDateStr);

		// Step 2: Format the Date object to the desired format
		String outputDateStr1 = outputDateFormat.format(endDate2);

		// Step 3: Parse the formatted date string back to a Date object
		Date finalEndDate = outputDateFormat.parse(outputDateStr1);

		List<LogData> data = logBookRepository.findBySendRequestTimeBetween(finalStartDate, finalEndDate);
		return ResponseEntity.ok().headers(headers).body(data);

	}

	/**********************************************************************/

	private void logToDatabase(RequestDTO request, String result, String errorMessage, Date startTime) {
		try {
			Date endTime = new Date();
			LogData logData = new LogData();
			logData.setError_message(errorMessage);
			logData.setResult(result);
			logData.setSendRequestTime(startTime);
			logData.setOutputResponseTime(endTime);
			logData.setUser_id(request.getId());
			logData.setTypeRequested(request.getDownloadType());
			logData.setWhichAppRequestSentBy("Restful API");
			logBookRepository.save(logData);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
