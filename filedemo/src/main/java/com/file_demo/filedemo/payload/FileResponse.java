package com.file_demo.filedemo.payload;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Image_Name")
public class FileResponse {

    public FileResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileResponse(String name, String fullname, String message) {
		super();
		this.name = name;
		this.fullname = fullname;
		this.message = message;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "full_Name")
    private String fullname;
    
    @Column(name = "message")
    private String message;
}
