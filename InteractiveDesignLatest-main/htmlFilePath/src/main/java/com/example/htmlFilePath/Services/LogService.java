package com.example.htmlFilePath.Services;


import com.example.htmlFilePath.Entity.LogData;
import com.example.htmlFilePath.Repositor.LogBookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogService {

    @Autowired
    private LogBookRepo logBookRepo;

    /**
     * Logs activity (success/failure) into the database.
     *
     * @param userId ID of the user (nullable)
     * @param typeRequested Action type like "UPLOAD", "PDF", "DELETE"
     * @param result "SUCCESS" or "FAILURE"
     * @param message Additional info or error details
     * @param startTime When the request started
     */
    public void logActivity(Integer userId, String typeRequested, String result, String message, Date startTime) {
        try {
            LogData info = new LogData();
            info.setUser_id(userId);
            info.setTypeRequested(typeRequested);
            info.setResult(result);
            info.setMessage(message);
            info.setSendRequestTime(startTime);
            info.setOutputResponseTime(new Date());
            info.setWhichAppRequestSentBy("Restful API");

            logBookRepo.save(info);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to log activity: " + e.getMessage());
        }
    }
}
