package com.operation.Entity;

public class FileUploadResponse {
	
	    private String fileName1;
	    private String fileName2;
	    private String message;
	    //private String[] jsonData;
	    
	    
	    
	    public FileUploadResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    public FileUploadResponse(String fileName1, String fileName2, String message) {
			super();
			this.fileName1 = fileName1;
			this.fileName2 = fileName2;
			this.message = message;
		}
		
	   
		public String getFileName1() {
			return fileName1;
		}
		
		
		public void setFileName1(String fileName1) {
			this.fileName1 = fileName1;
		}
		public String getFileName2() {
			return fileName2;
		}
		public void setFileName2(String fileName2) {
			this.fileName2 = fileName2;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
//		public String[] getJsonData() {
//			return jsonData;
//		}
//		public void setJsonData(String[] jsonData) {
//			this.jsonData = jsonData;
//		}
	    
	    

}
