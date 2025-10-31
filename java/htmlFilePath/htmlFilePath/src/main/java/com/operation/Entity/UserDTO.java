package com.operation.Entity;


public class UserDTO {

	 private String NAME;
     private String editableHtml;
     private String downloadableHtml;
	
	
	
	
	
	public UserDTO() {
		super();
		
	}
	
	
	public UserDTO(String downloadHTML, String editHTML, String name) {
		super();
		this.downloadableHtml = downloadHTML;
		this.editableHtml = editHTML;
		this.NAME = name;
	}
	public String getdownloadHTML() {
		return downloadableHtml;
	}
	public void setdownloadHTML(String downloadHTML) {
		this.downloadableHtml = downloadHTML;
	}
	public String geteditHTML() {
		return editableHtml;
	}
	public void seteditHTML(String editHTML) {
		this.editableHtml = editHTML;
	}
	public String getName() {
		return NAME;
	}
	public void setName(String NAME) {
		this.NAME = NAME;
	}



}
