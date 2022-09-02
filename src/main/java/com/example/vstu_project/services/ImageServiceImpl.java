package com.example.vstu_project.services;

import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Value("${upload_dir}")
    private String UPLOAD_DIR;

    public String loadNewFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            resizeImages(String.valueOf(path));

        } catch (IOException e) {
            e.printStackTrace();
        }


        return fileName;
    }

    private void resizeImages(String srcPath) throws IOException {
        Thumbnails.of(srcPath).forceSize(300, 150).toFile(srcPath);
    }

}
