package com.convert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static Date startDate = new Date();

	public static void main(String[] args) {

		LOGGER.info("Started processing request at: " + startDate);
		LOGGER.info("====================================");

		try {
			checkSpace();
			processFiles();
			LOGGER.info("Processing completed successfully.");
			LOGGER.info("====================================");
		} catch (Exception e) {
			LOGGER.severe("An error occurred: " + e.getMessage());
		}
	}

	/*---------------------------------------------------------------------------------------*/
	private static void processFiles() throws IOException {

		String inputFolder = AppConfig.getProperty("inputFolder");
		String outputFolder = AppConfig.getProperty("outputFolder");
		Integer id = Integer.parseInt(AppConfig.getProperty("id"));
		String typeOfDownload = AppConfig.getProperty("typeOfDownload");
		checkFolder(outputFolder);

		String pathOfEditHtml = JsonDao.getPath(id);

		int numberOfThreads = Runtime.getRuntime().availableProcessors();
		System.out.println(" numberOfThreads : " + numberOfThreads);

		List<File> files = findJsonFiles(inputFolder, typeOfDownload, id);
		
		System.out.println(" ===="+files.size());

		List<Callable<Void>> tasks = new ArrayList<>();

		for (File file : files) {

//			try {
//				file = JsonService.decryptJson(file);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

			System.out.println("Found file: " + file.getName());
			tasks.add(new FileProcessor(file.getAbsolutePath(), pathOfEditHtml, outputFolder, typeOfDownload));
			processSingleJsonFile(file, pathOfEditHtml, typeOfDownload, id);
		}

		// int numberOfThreads = Integer.parseInt(AppConfig.getProperty("noOfThreads"));
		ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

		try {
			List<Future<Void>> futures = executor.invokeAll(tasks);
			for (Future<Void> future : futures) {
				future.get();
			}
			JsonService.logToDatabase("-", "Success", startDate, id, typeOfDownload, "Batch");
		} catch (Exception e) {
			LOGGER.severe("Error processing files: " + e.getMessage());
		}
		executor.shutdown();

	}

	private static void processSingleJsonFile(File file, String pathOfEditableHtml, String typeOfDownload, Integer id) {
		try {
			String fileContent = FileUtils.readFileToString(file, "UTF-8");
			if (!JsonService.isJsonEmpty(fileContent) && !fileContent.isEmpty()) {

				JSONObject jsonObject = new JSONObject(fileContent);
				JSONObject englishObject = jsonObject.optJSONObject("english");
				if (!(englishObject == null)) {

					for (String key : englishObject.keySet()) {
						Object value = englishObject.get(key);
						if (value instanceof JSONArray) {

							JSONArray arrayValue = (JSONArray) value;

							if (arrayValue.length() == 0) {
								JsonService.logToDatabase("No Data for " + file.getName(), "Error", startDate, id,
										typeOfDownload, "Batch");
								continue; // Skip to the next iteration
							}

							for (int i = 0; i < arrayValue.length(); i++) {
								JSONObject saObject = arrayValue.optJSONObject(i);

								if (saObject == null || saObject.length() == 0) {
									JsonService.logToDatabase("No Data for " + file.getName(), "Error", startDate, id,
											typeOfDownload, "Batch");
									continue; // Skip to the next iteration
								}

								boolean hasData = false;
								Iterator<String> keys = saObject.keys();
								while (keys.hasNext()) {
									String key1 = keys.next();
									if (!saObject.isNull(key1)) {
										hasData = true;
										break;
									}
								}

								if (!hasData) {
									JsonService.logToDatabase("No Data for " + file.getName(), "Error", startDate, id,
											typeOfDownload, "Batch");
									continue;
								}

								if (!saObject.has("name") || saObject.optString("name").isEmpty()) {
									JsonService.logToDatabase("No name for: " + "No Name", "Error", startDate, id,
											typeOfDownload, "Batch");
									continue;
								}

							}
						}
					}
				} else {

					JsonService.logToDatabase("No 'english' object found", "Error", startDate, id, typeOfDownload,
							"Batch");
				}
			} else {

				JsonService.logToDatabase(file.getName() + " is Empty files", "Error", startDate, id, typeOfDownload,
						"Batch");
				System.out.println(file.getName() + " is an empty JSON file.");
			}
		} catch (IOException e) {
			throw new RuntimeException("Error reading the JSON file: " + file.getName());
		}
	}

	/*---------------------------------------------------------------------------------------*/

	private static List<File> findJsonFiles(String inputFolder, String typeOfDownload, Integer id) throws IOException {
		File folder = checkFolder(inputFolder); 
		File[] files = folder.listFiles();		 
		if (files == null || files.length == 0) {

			JsonService.logToDatabase("No JSON files exist", "Error", startDate, id, typeOfDownload, "Batch");
			throw new RuntimeException("No JSON files exist");
		} else {
			return Arrays.stream(files).filter(file -> file.isFile() && file.getName().toLowerCase().endsWith(".json"))
					.collect(Collectors.toList());
		}
	}

	/*---------------------------------------------------------------------------------------*/

	private static File checkFolder(String folderPath) throws IOException {
		File dir = new File(folderPath);
		if (!dir.exists() && !dir.mkdirs()) {
			throw new IOException("Failed to create Folder: " + folderPath);
		}
		return dir;
	}
	/*---------------------------------------------------------------------------------------*/

	private static void checkSpace() throws IOException {
		String outputFolder = AppConfig.getProperty("outputFolder");
		File drive = new File(outputFolder.substring(0, 1) + ":");
		long freeSpaceInBytes = drive.getUsableSpace();

		if (freeSpaceInBytes < 1024 * 1024) {
			throw new IOException("Insufficient free space on drive " + drive + ".");
		}
	}
	/*---------------------------------------------------------------------------------------*/

}
