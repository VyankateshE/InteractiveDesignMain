package com.operation.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.Callable;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

public class FileProcessor implements Callable<Void> {

	private final String pdfPath;
	private final String tempHtml;

	public FileProcessor(String pdfPath, String tempHtml) {
		this.pdfPath = pdfPath;
		this.tempHtml = tempHtml;
	}

	@Override
	public Void call() {
		try {
			File file = new File(tempHtml);
			byte[] fileContent = Files.readAllBytes(file.toPath());
			MultipartFile multipartFile = new FileToMultipartFile("file", file.getName(), "application/octet-stream",
					fileContent);
			ResponseEntity<byte[]> response = getPdf(multipartFile, "abc", pdfPath, tempHtml);

			if (!response.getStatusCode().is2xxSuccessful()) {
				System.out.println(" Failed to PDF generation !");
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error Creating PDF file.");
		}
		return null;
	}

	public ResponseEntity<byte[]> getPdf(MultipartFile multipartFile, String name, String outputFolder,
			String newFilePath) {

	String apiUrl = "http://localhost:3010/api/v1/s3Upload/uploadHtml";
			// String apiUrl = "https://estateagents.club/api/api/v1/s3Upload/uploadHtml";

		try {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);

			// Ensure the file exists
			File file = new File(newFilePath);
			if (!file.exists()) {
				throw new IOException("File not found: " + newFilePath);
			}

			MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
//			requestBody.add("name", name);
			requestBody.add("file", new FileSystemResource(file));

			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);
			System.out.println("Sending request to: " + apiUrl);
			System.out.println("newFilePath: " + newFilePath);
			System.out.println("name: " + name);

			ResponseEntity<byte[]> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST,
					new HttpEntity<>(requestBody, headers), byte[].class);

			System.out.println("Response status code: " + responseEntity.getStatusCode());
			System.out.println(
					"responseEntity: " + (responseEntity.getBody() != null ? responseEntity.getBody().length : "null"));

			if (responseEntity.getStatusCode().is2xxSuccessful()) {
				savePdf(responseEntity.getBody(), outputFolder);
				return createPdfResponse(responseEntity.getBody());
			} else {
				System.err.println("HTTP request failed with response code: " + responseEntity.getStatusCode());
				throw new RuntimeException("HTTP request failed: " + responseEntity.getStatusCode());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error occurred: " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Error occurred during PDF download".getBytes());
	}
//    public ResponseEntity<byte[]> getPdf(MultipartFile multipartFile, String name, String outputFolder,
//                                          String newFilePath) {
//        try {
////            String apiUrl = "https://estateagents.club/api/api/v1/s3Upload/uploadHtml";
//        	
//        	String apiUrl = "http://localhost:3010/api/v1/s3Upload/uploadHtml";
//            
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//            MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
//            requestBody.add("name", name);
//            requestBody.add("file", new FileSystemResource(new File(newFilePath)));
//
//            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);
//
//            ResponseEntity<byte[]> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST,
//                    new HttpEntity<>(requestBody, headers), byte[].class);
//
//            if (responseEntity.getStatusCode().is2xxSuccessful()) {
//                savePdf(responseEntity.getBody(), outputFolder);
//                return createPdfResponse(responseEntity.getBody());
//            } else {
//                System.err.println("HTTP request failed with response code: " + responseEntity.getStatusCode());
//                throw new RuntimeException("HTTP request failed: " + responseEntity.getStatusCode());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("Error occurred during PDF download".getBytes());
//    }

	private void savePdf(byte[] content, String outputFolder) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(outputFolder)) {
			fos.write(content);
		}
	}

	private ResponseEntity<byte[]> createPdfResponse(byte[] content) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_PDF);
		responseHeaders.setContentDispositionFormData("attachment", "output.pdf");
		return ResponseEntity.ok().headers(responseHeaders).body(content);
	}
}
