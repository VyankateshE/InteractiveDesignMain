package org.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws ClassNotFoundException {

        // sample data
        int id = 4;
        String inputFolder = "D:\\InteractiveDesigner_20_03_2024\\java\\testingHtmlTemplate\\TestingJSON";
        String outputFolder = "D:\\InteractiveDesigner_20_03_2024\\java\\testingHtmlTemplate\\TestingHtml";
        String typeOfDownload = "HTML";
//        String typeOfDownload = "PDF";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = new Date();

        // Specify the drive letter for the C: drive
        File drive = new File("D:");

        // Get the free space in bytes on the E: drive
        long freeSpaceInBytes = drive.getUsableSpace();

        // Convert 1 MB to bytes
        long oneMBInBytes = 1024 * 1024;

        try {
            if (freeSpaceInBytes < oneMBInBytes) {
                throw new InsufficientSpaceException("There is less than 1 MB of free space on the E: drive.");
            }
        } catch (InsufficientSpaceException e) {
        	JsonService.logToDatabase("Memory not Sufficient ", "Error", startDate, id, typeOfDownload, "Batch");
            System.err.println(e.getMessage());
        }

//        if (!folderExists(inputFolder)) {
//            logToDatabase("Input Folder doesn't exists ", "Error", startDate, id, typeOfDownload, "Batch");
//            throw new RuntimeException("Input folder does not exist: " + inputFolder);
//        }
        
        
     // Create input folder if it doesn't exist
        File inputDir = new File(inputFolder);
        if (!inputDir.exists()) {
            if (!inputDir.mkdirs()) {
            	JsonService.logToDatabase("Failed to create Input Folder", "Error", startDate, id, typeOfDownload, "Batch");
                throw new RuntimeException("Failed to create Input Folder: " + inputFolder);
            } else {
            	JsonService.logToDatabase("Input Folder created successfully", "Info", startDate, id, typeOfDownload, "Batch");
            }
        }

     //   boolean k = true;


        File[] files1 = inputDir.listFiles();
        if (files1 == null || files1.length == 0) {
        	JsonService.logToDatabase("No JSON files exist", "Error", startDate, id, typeOfDownload, "Batch");
            throw new RuntimeException("No JSON files exist");
        }

        // Additional logging for debugging
        System.out.println("Found the following files in the input folder:");
        for (File file : files1) {
            if (file.isFile()) {
                System.out.println("Found file: " + file.getName());
                
                if (!file.getName().toLowerCase().endsWith(".json")) {
                	JsonService.logToDatabase("The folder contains non-JSON files", "Error", startDate, id, typeOfDownload, "Batch");
                    throw new RuntimeException("The folder contains non-JSON files.");
                }
                
                try {
                    String fileContent = FileUtils.readFileToString(file, "UTF-8");
                    if (JsonService.isJsonEmpty(fileContent) || fileContent.isEmpty()) {
                    	JsonService.logToDatabase(file.getName()+" is Empty JSON files ", "Error", startDate, id, typeOfDownload, "Batch");
                        System.out.println(file.getName() + " is an empty JSON file.");
//                        throw new RuntimeException("Empty JSON files");
                    } else {
                    	
                    	
                    JSONObject jsonObject = new JSONObject(fileContent);
                      JSONObject englishObject = jsonObject.optJSONObject("english");
                      if (englishObject == null) {
                    	  JsonService.logToDatabase("No 'english' object found", "Error", startDate, id, typeOfDownload, "Batch");
//                          throw new RuntimeException("No 'english' object found in " + file.getName());
                      }
               
                      
                      for (String key : englishObject.keySet()) {
                          Object value = englishObject.get(key);
                          if (value instanceof JSONArray) {
                             
                              JSONArray arrayValue = (JSONArray) value;
                            
                              for (int i = 0; i < arrayValue.length(); i++) {
                            	  
               
                                  
                      			JSONObject element = arrayValue.getJSONObject(i);
                    			
                      			if (element == null) {
                      				JsonService.logToDatabase("Object Is Empty", "Error", startDate, id, typeOfDownload, "Batch");
                                     // throw new RuntimeException(" Object Is Empty " + file.getName());
                                  }
                      			
                      			
                      			
                      			JSONObject saObject = arrayValue.optJSONObject(i);
                      			if(saObject.length()>1) {
                      			
//                      			if (saArray == null || saArray.length() == 0) {
//                                      logToDatabase("Empty 'SA' attribute ", "Error", startDate, id, typeOfDownload, "Batch");
////                                      throw new RuntimeException("No 'SA' attribute or empty 'SA' array in " + file.getName());
//                                      k=false;
//                                  }
                                  
//                                  for (int j = 0; j < saArray.length(); j++) {
//                                      JSONObject saObject = saArray.optJSONObject(j);
                                      if (saObject == null || saObject.length() == 0) {
                                    	  JsonService.logToDatabase("Empty  object Of "+file.getName(), "Error", startDate, id, typeOfDownload, "Batch");
                                          //throw new RuntimeException("Empty 'SA' object in " + file.getName());
                                         // k=false;
                                      }
                                      
                                     
                                      int nameAttributeLength = saObject.optString("name", "").length();
                                      if ( !saObject.has("name") ||  nameAttributeLength == 0) {
                                    	  JsonService.logToDatabase("The name is missing in "+file.getName(), "Error", startDate, id, typeOfDownload, "Batch");
//                                          throw new RuntimeException("The name attribute is missing in the SA object of " + file.getName());
                                         // k=false;
                                      }
                                      
                                    
                                      int addressAttributeLength = saObject.optString("address", "").length();
                                      if (!saObject.has("address") ||   addressAttributeLength == 0) {
                                    	  JsonService.logToDatabase("Address is missing "+file.getName(), "Error", startDate, id, typeOfDownload, "Batch");
//                                          throw new RuntimeException("The address attribute is missing in the SA object of " + file.getName());
                                          //k=false;
                                      }
                                     
                                     
                                      // Check for other attributes if needed
                                  }
                                  
                                  System.out.println(file.getName() + " is not an empty JSON file.");
                      			
                      			
                      			

                                  
                              }
                          } else {
                              // If the value is not an array, print it directly
                              System.out.println("Key: " + key + ", Value: " + value);
                          }
                      }

                    	
                    		
                    		
                    	}
                    
                    	
                    	
                    	
//                        
                  
                } catch (IOException e) {
                    throw new RuntimeException("Error reading the JSON file: " + file.getName());
                }
            }
        }
       

//        if (!folderExists(outputFolder)) {
//            logToDatabase("Output Folder doesn't exists ", "Error", startDate, id, typeOfDownload, "Batch");
//            throw new RuntimeException("Output folder does not exist: " + outputFolder);
//        }
        
     // Create output folder if it doesn't exist
        File outputDir = new File(outputFolder);
        if (!outputDir.exists()) {
            if (!outputDir.mkdirs()) {
            	JsonService.logToDatabase("Failed to create Output Folder", "Error", startDate, id, typeOfDownload, "Batch");
                throw new RuntimeException("Failed to create Output Folder: " + outputFolder);
            } else {
            	JsonService.logToDatabase("Output Folder created successfully", "Info", startDate, id, typeOfDownload, "Batch");
            }
        }

        // Load properties from the application.properties file
        Properties properties = new Properties();

        // Load properties from the application.properties file on the classpath
        try (InputStream input = Main.class.getResourceAsStream("/application.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                System.err.println("application.properties file not found on the classpath.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading properties file.");
        }
        
        Configuration configuration = new Configuration().configure();
        
        // Read the custom property noOfThreads
        String threads = configuration.getProperty("noOfThreads");
        
       
        if (threads == null) {
            // Default value if property not found
        	threads = "1";
        }

        // Create a thread pool with the desired number of threads
        ExecutorService executor = Executors.newFixedThreadPool(Integer.parseInt(threads));

        LOGGER.info("Started processing request at: " + startDate);

        String dbUrl = "jdbc:mysql://localhost:3306/interactive_designer_html_template";
        String dbUser = "root";
        String dbPassword = "amol.kore";

        String pathOfEditableHtml = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String sql = "SELECT path_of_editable_html FROM user WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String pathOfEditableHtml1 = resultSet.getString("path_of_editable_html");
                System.out.println("Retrieved pathOfEditableHtml: " + pathOfEditableHtml1);
                pathOfEditableHtml = pathOfEditableHtml1;
            } else {
                System.out.println("No record found for the specified ID.");
                JsonService.logToDatabase("Invalid id", "Error", startDate, id, typeOfDownload, "Batch");
            }
            Date startDate1 = new Date();
            LOGGER.info("Ended processing request at: " + startDate1);
        } catch (SQLException e) {
            Date startDate1 = new Date();
            LOGGER.info("Error in processing request at: " + startDate1);
            e.printStackTrace();
        }

        File folder = new File(inputFolder);
        File[] files = folder.listFiles();

        if (files != null) {
            List<Callable<Void>> tasks = new ArrayList<>();
            for (File file : files) {
                if (file.isFile()) {
                    // Submit file processing tasks to the thread pool
                    // executor.submit(new FileProcessor(file.getAbsolutePath(), pathOfEditableHtml,
                    // outputFolder, typeOfDownload));
                	
  
                    Callable<Void> task = new FileProcessor(file.getAbsolutePath(), pathOfEditableHtml, outputFolder,typeOfDownload);
                    tasks.add(task);
                }
            }
            try {
                List<Future<Void>> futures = executor.invokeAll(tasks);

                // Now, you can iterate through the futures to check if tasks completed
                // successfully
                for (Future<Void> future : futures) {
                    try {
                        future.get(); // This will block until the task is completed
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Folder is empty or does not exist.");
        }

        // Shutdown the executor when all tasks are complete
        executor.shutdown();

        //if(k) {
        	JsonService.logToDatabase(null, "Success", startDate, id, typeOfDownload, "Batch");
       // }
        
    }


    
    

   

}


class InsufficientSpaceException extends Exception {
    public InsufficientSpaceException(String message) {
        super(message);
    }
}