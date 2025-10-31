package com.operation.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LogData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private Date sendRequestTime;
    private Integer user_id;
    private String result;
    private String error_message;
    private Date outputResponseTime;
    private String typeRequested;
    private String whichAppRequestSentBy;
    
    
    
	public LogData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LogData(int id, Date sendRequestTime, Integer user_id, String result, String error_message,
			Date outputResponseTime, String typeRequested, String whichAppRequestSentBy) {
		super();
		this.id = id;
		this.sendRequestTime = sendRequestTime;
		this.user_id = user_id;
		this.result = result;
		this.error_message = error_message;
		this.outputResponseTime = outputResponseTime;
		this.typeRequested = typeRequested;
		this.whichAppRequestSentBy = whichAppRequestSentBy;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getSendRequestTime() {
		return sendRequestTime;
	}
	public void setSendRequestTime(Date sendRequestTime) {
		this.sendRequestTime = sendRequestTime;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	public Date getOutputResponseTime() {
		return outputResponseTime;
	}
	public void setOutputResponseTime(Date outputResponseTime) {
		this.outputResponseTime = outputResponseTime;
	}
	public String getTypeRequested() {
		return typeRequested;
	}
	public void setTypeRequested(String typeRequested) {
		this.typeRequested = typeRequested;
	}
	public String getWhichAppRequestSentBy() {
		return whichAppRequestSentBy;
	}
	public void setWhichAppRequestSentBy(String whichAppRequestSentBy) {
		this.whichAppRequestSentBy = whichAppRequestSentBy;
	}
    
    
    
}
