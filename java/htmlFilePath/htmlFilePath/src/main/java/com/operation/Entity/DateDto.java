package com.operation.Entity;

public class DateDto {
    private String startDate;
    private String endDate;
    
    
    
    
    public DateDto() {
		super();
	}
    
	public DateDto(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
    
    
    
}