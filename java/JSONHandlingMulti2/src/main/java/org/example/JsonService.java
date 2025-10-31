package org.example;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;



public class JsonService {
	

    public static void logToDatabase(String errorMessage, String result, Date startDate, int id, String typeOfDownload,
            String whichAppRequested) {

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date endTime = new Date();

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        // Begin a transaction
        Transaction transaction = session.beginTransaction();

        try {
            // Perform database operations
            LogData info = new LogData();
            // Set properties on the entity
            info.setError_message(errorMessage);
            info.setResult(result);
            info.setTypeRequested(typeOfDownload);
            info.setUser_id(id);
            info.setWhichAppRequestSentBy(whichAppRequested);
            info.setSendRequestTime(startDate);
            info.setOutputResponseTime(endTime);
            session.save(info);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        // Close the session factory when done
        factory.close();
    }
    
    
    public static boolean folderExists(String folderPath) {
        File folder = new File(folderPath);
        return folder.exists() && folder.isDirectory();
    }
    
    public static boolean isJsonEmpty(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject.length() == 0;
        } catch (JSONException e) {
            // Not a valid JSON, or other JSON parsing error
            return false;
        }
    }
    
 //

	
	

}
