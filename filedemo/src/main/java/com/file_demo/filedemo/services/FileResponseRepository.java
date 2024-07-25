package com.file_demo.filedemo.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.file_demo.filedemo.payload.FileResponse;

public interface FileResponseRepository extends JpaRepository<FileResponse, Long>{

	//void save(String name);

	

}
