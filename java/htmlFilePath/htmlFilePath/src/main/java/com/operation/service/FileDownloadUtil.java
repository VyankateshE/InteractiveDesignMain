package com.operation.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.operation.config.PropertiesConfig;

@Service
public class FileDownloadUtil {
	private Path foundFile;
	
	PropertiesConfig propertiesConfig;

	public Resource getFileAsResource(String fileCode) throws IOException {
		Path dirPath = Paths.get(propertiesConfig.getDownloadFolder());

		Files.list(dirPath).forEach(file -> {
			if (file.getFileName().toString().startsWith(fileCode)) {
				foundFile = file;
				return;
			}
		});

		if (foundFile != null) {
			return new UrlResource(foundFile.toUri());
		}

		return null;
	}
}
