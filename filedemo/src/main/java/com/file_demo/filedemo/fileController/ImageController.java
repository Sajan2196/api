package com.file_demo.filedemo.fileController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file_demo.filedemo.payload.FileResponse;
import com.file_demo.filedemo.services.FileService;

@RequestMapping("/file")
@RestController
public class ImageController {

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) {
        String fileName = null;
        String fullName = null;
        String message=null;
		try {
        	
            fileName = this.fileService.uploadImage(path, image);
        } catch (IOException e) {
            e.printStackTrace();
            
            return new ResponseEntity<>(new FileResponse(message, fileName,fullName), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new FileResponse(message,fileName,fullName), HttpStatus.OK);
    }

    @GetMapping
    public String check() {
        return "All fine";
    }
}
