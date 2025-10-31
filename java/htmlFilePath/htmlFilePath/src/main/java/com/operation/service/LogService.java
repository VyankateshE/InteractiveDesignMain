package com.operation.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operation.Entity.LogData;
import com.operation.Entity.RequestDTO;
import com.operation.repository.LogBookRepository;

@Service
public class LogService {
	
	@Autowired
	LogBookRepository logBookRepository;
	
	
	public void logToDatabase(RequestDTO request, String result, String errorMessage, Date startTime) {
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
