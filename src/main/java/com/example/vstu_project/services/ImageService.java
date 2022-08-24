package com.example.vstu_project.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String loadNewFile(MultipartFile file);

}
