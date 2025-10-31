package com.operation.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.operation.Entity.User;
import com.operation.config.PropertiesConfig;
import com.operation.repository.UserRepository;

@Service
public class UserService {

	PropertiesConfig propertiesConfig;
	
	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean doesNameExist(String name) {
		return userRepository.existsByName(name);
	}

	public User createUser(String name) {
		User user = new User();
		user.setName(name);
		return userRepository.save(user);
	}
	
	
	 public String editUser(Integer id, User user){
	        User updatedUser = userRepository.findById(id).get();
	        if(user.getName()!=null)
	            updatedUser.setName(user.getName());
	        if(user.getPathOfEditHTML()!=null)
	            updatedUser.setPathOfEditHTML(user.getPathOfEditHTML());
	        if(user.getPathOfDownloadHTML()!=null)
	            updatedUser.setPathOfDownloadHTML(user.getPathOfDownloadHTML());
	        userRepository.save(updatedUser);
	        return "Template updated successfully";
	    }

	    public String deleteUser(Integer id){
	        User user1 = userRepository.findById(id).get();
	        userRepository.delete(user1);
	        return "Template deleted successfully";
	    }

	public String saveFile(MultipartFile file, Integer userId, String fileType) throws IOException {
		String fileName = userId + "_" + fileType;
		Path filePath = Paths.get(propertiesConfig.getUploadFolder(), fileName);
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		return filePath.toString();
	}

	public void updateUserWithFilePaths(User user, String editableHtmlPath, String downloadableHtmlPath) {

		user.setPathOfEditHTML(editableHtmlPath);
		user.setPathOfDownloadHTML(downloadableHtmlPath);
		userRepository.save(user);

	}
	
	public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
