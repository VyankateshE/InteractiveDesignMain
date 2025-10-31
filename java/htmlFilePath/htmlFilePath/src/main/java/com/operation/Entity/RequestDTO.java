package com.operation.Entity;

public class RequestDTO {

    private Integer id;
    private String jsonData;
    private String downloadType;
    
    
    
	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestDTO(Integer id, String jsonData, String downloadType) {
		super();
		this.id = id;
		this.jsonData = jsonData;
		this.downloadType = downloadType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public String getDownloadType() {
		return downloadType;
	}
	public void setDownloadType(String downloadType) {
		this.downloadType = downloadType;
	}
    
    

}
