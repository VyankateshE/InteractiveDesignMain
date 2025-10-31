package com.operation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "User")
public class User {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Integer id;
	
    private String name;

    String pathOfEditableHtml;

    String pathOfDownloadableHtml;

	public Integer getId() {
		return id;
	}

	public void setId(Integer ID) {
		this.id = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPathOfEditHTML() {
		return pathOfEditableHtml;
	}

	public void setPathOfEditHTML(String PATH_OF_EDIT_HTML) {
		this.pathOfEditableHtml = PATH_OF_EDIT_HTML;
	}

	public String getPathOfDownloadHTML() {
		return pathOfDownloadableHtml;
	}

	public void setPathOfDownloadHTML(String PATH_OF_DOWNLOAD_HTML) {
		this.pathOfDownloadableHtml = PATH_OF_DOWNLOAD_HTML;
	}

	public User(Integer id, String name, String PATH_OF_EDIT_HTML, String PATH_OF_DOWNLOAD_HTML) {
		super();
		this.id = id;
		this.name = name;
		this.pathOfEditableHtml = PATH_OF_EDIT_HTML;
		this.pathOfDownloadableHtml = PATH_OF_DOWNLOAD_HTML;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
    
    
}
