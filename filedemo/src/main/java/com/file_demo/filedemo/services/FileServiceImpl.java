  package com.file_demo.filedemo.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file_demo.filedemo.payload.FileResponse;


@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
    private FileResponseRepository fileResponseRepository;

	@Override
	public String uploadImage(String path, MultipartFile file ) throws IOException {
		
		
		//name
		String name = file.getOriginalFilename();
		System.out.println(name);
	
		
		String randomID  = UUID.randomUUID().toString();
		String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
		
		FileResponse fileResponse = new FileResponse();
	
		fileResponse.setName(name);
		fileResponse.setFullname(fileName1);
		

		fileResponseRepository.save(fileResponse);
		
		//path
		System.out.println(fileName1);
		String filePath = path + File.separator + fileName1;
		System.out.println(filePath);
		
		//create folder if not created
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		//file copy
		Files.copy(file.getInputStream(),Paths.get(filePath));

		return name;
	}

	

}
