package com.operation.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileToMultipartFile implements MultipartFile {

	private final String name;
	private final String originalFilename;
	private final String contentType;
	private final byte[] content;

	public FileToMultipartFile(String name, String originalFilename, String contentType, byte[] content) {
		super();
		this.name = name;
		this.originalFilename = originalFilename;
		this.contentType = contentType;
		this.content = content;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return this.originalFilename;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return this.contentType;
	}

	@Override
	public boolean isEmpty() {
		return content.length == 0;
	}

	@Override
	public long getSize() {
		return content.length;
	}

	@Override
	public byte[] getBytes() throws IOException {

		return content;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return new ByteArrayInputStream(content);
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {

		try (OutputStream outputStream = new FileOutputStream(dest)) {
			outputStream.write(content);
		}
	}

}
