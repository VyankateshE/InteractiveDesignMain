package com.convert;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "log_data")
public class LogData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "send_request_time")
	private Date sendRequestTime;
	@Column(name = "user_id")
	private int user_id;
	@Column(name = "result")
	private String result;
	@Column(name = "error_message")
	private String error_message;
	@Column(name = "output_response_time")
	private Date outputResponseTime;
	@Column(name = "type_requested")
	private String typeRequested;
	@Column(name = "which_app_request_sent_by")
	private String whichAppRequestSentBy;

	public LogData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogData(int id, Date sendRequestTime, int user_id, String result, String error_message,
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
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
