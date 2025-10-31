package org.example;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

import static org.hibernate.sql.ast.SqlTreeCreationLogger.LOGGER;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:06");
        String formattedDate1 = dateFormat.format(processingStartTime);
        System.out.println(threadName + " started processing file: " + jsonPath + " at " + formattedDate1);
        try {
            // Specify the path to the HTML file you want to modify
            String filePath = path;
            // Read the HTML file into a StringBuilder
            StringBuilder htmlContent = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                htmlContent.append(line).append("\n");
            }
            reader.close();
//            System.out.println(htmlContent.toString());
            // Modify the HTML content as needed
            String result = new String(Files.readAllBytes(Paths.get(jsonPath)));
            String modifiedHtmlContent = modifyHtml(htmlContent.toString(),result);

            //       Write the modified HTML content back to the file
            String timestamp = String.valueOf(System.currentTimeMillis());
            String lastPath = jsonPath.substring(jsonPath.lastIndexOf("\\")+1);
            String newFilePath = outputFolder+ "\\" + lastPath+".html";

            // Write the modified HTML content to the new file
            if(typeOfDownload == "HTML") {

                BufferedWriter writer = new BufferedWriter(new FileWriter(newFilePath));
                writer.write(modifiedHtmlContent);
                writer.close();
//            System.out.println(modifiedHtmlContent);
            }
            if(typeOfDownload == "PDF"){
                String currentDirectory = System.getProperty("user.dir");
                Path uploadPath = Paths.get(currentDirectory);
                String folderName = "HtmlDownloadTemp";
                // Create the folder if it doesn't exist
                Path folderPath = uploadPath.resolve(folderName);

                try {
                    if (!Files.exists(folderPath)) {
                        Files.createDirectories(folderPath);
                        System.out.println("Folder created: " + folderPath);
                    } else {
                        System.out.println("Folder already exists: " + folderPath);
                    }
                } catch (IOException e) {
                    System.err.println("Error creating the folder: " + e.getMessage());
                }

                String folderPathString = folderPath.toString();
                folderPathString += "\\"+ lastPath + "_editable_html" + ".html";
                BufferedWriter writer = new BufferedWriter(new FileWriter(folderPathString));
                writer.write(modifiedHtmlContent);
                writer.close();
                File file = new File(folderPathString);

                MultipartFile multipartFile=convertFileToMultipartFile(file);
                ResponseEntity<?> response = getPdf(multipartFile,"abc",outputFolder,folderPathString);

                System.out.println(response);
            }
            System.out.println("HTML file has been modified successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error modifying the HTML file.");


        }

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:06");
        Date processingEndTime = new Date();
        String formattedDate = dateFormat.format(processingEndTime);
        System.out.println(threadName + " finished processing file: " + jsonPath + " at " + processingEndTime);

        return null;
    }
    private static String modifyHtml(String htmlContent,String toReplaceContent) {
        // Modify the HTML content here as needed
        // For example, you can search and replace text or add new elements

        String toFind = "var jsonData1";
        int startIndex = getSecondLastIndex(htmlContent,toFind);
        // int startIndex = htmlContent.lastIndexOf("var jsonData1");

        if (startIndex != -1) {
            // Find the ending index of the JSON object
            int endIndex = htmlContent.indexOf("]; var custom_language", startIndex);
//            System.out.println(startIndex);
//            System.out.println(endIndex);

            if (endIndex != -1) {
                // Extract the parts of the HTML string before and after the JSON object
                String start = htmlContent.substring(0, startIndex+13);
                String end = htmlContent.substring(endIndex + 2); // +2 to skip the "};"

                // Construct the final modified HTML string
                String finalString = start +"=["+ toReplaceContent + "]\n" + end;
//                System.out.print(finalString);

                // For demonstration, let's replace all occurrences of "old text" with "new text"
                return finalString.replace(htmlContent, finalString);
            }
        }

        // If "jsonData1" or the ending delimiter "};" is not found, return the original HTML content

        // For demonstration, let's replace all occurrences of "old text" with "new text"
        return htmlContent;
    }

    public static int getSecondLastIndex(String htmlContent, String toFind){
        int lastIndex = -1;
        int secondToLastIndex = -1;

        while (true) {
            lastIndex = htmlContent.indexOf(toFind, lastIndex + 1);

            if (lastIndex == -1) {
                break;  // No more occurrences found
            }

            secondToLastIndex = lastIndex;
        }
        return  secondToLastIndex;

    }

    public static MultipartFile convertFileToMultipartFile(File file) throws IOException {
        // Open an input stream from the file
        byte[] fileContent = Files.readAllBytes(file.toPath());
        MultipartFile multipartFile = new FileToMultipartFile(file.getName(), file.getName(), "application/octet-stream", fileContent);
        return multipartFile;
    }
    public ResponseEntity<byte[]> getPdf(MultipartFile multipartFile1, String name, String outputFolder, String newFilePath) {
        try {
            // Define the API endpoint URL
            String apiUrl = "http://localhost:3010/api/v1/s3Upload/uploadHtml";

            // Create a RestTemplate
            RestTemplate restTemplate = new RestTemplate();

            // Set the request headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // Build the request body
            MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
            requestBody.add("name", name);
            requestBody.add("file", new FileSystemResource(new File(newFilePath)));

            // Create a UriComponents object to build the URL
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);

            // Make the POST request and get the ResponseEntity
            ResponseEntity<byte[]> responseEntity = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.POST,
                    new HttpEntity<>(requestBody, headers),
                    byte[].class
            );

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                // Save the response content as a PDF file (optional)
                try (FileOutputStream fos = new FileOutputStream(outputFolder + "\\" + multipartFile1.getOriginalFilename() + ".pdf")) {
                    fos.write(responseEntity.getBody());
                }

                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.setContentType(MediaType.APPLICATION_PDF);
                responseHeaders.setContentDispositionFormData("attachment", "output.pdf");

                return ResponseEntity
                        .ok()
                        .headers(responseHeaders)
                        .body(responseEntity.getBody());
            } else {
                System.out.println("HTTP request failed with response code: " + responseEntity.getStatusCodeValue());
                // Handle the error case
                // You can also return an error ResponseEntity here
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions here
        }

        // Handle the case when something goes wrong
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during PDF download".getBytes());
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
