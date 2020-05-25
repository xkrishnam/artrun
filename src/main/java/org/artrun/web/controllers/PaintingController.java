package org.artrun.web.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.artrun.web.domain.Painting;
import org.artrun.web.domain.User;
import org.artrun.web.repositories.PaintingRepository;
import org.artrun.web.repositories.UserRepository;
import org.artrun.web.utils.GenericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PaintingController {

    @Value("${file.upload-dir}")
    private String fileUploadLocation;

    @Autowired
    private PaintingRepository pRepository;

    @Autowired
    private UserRepository uRepository;

    @PostMapping("/uploadPainting")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,
            @RequestParam("price") Integer price, @RequestParam("uid") Long uid) {

        Painting p = new Painting();
        p.setTitle(title);
        p.setPrice(price);

        User u = uRepository.getOne(uid);

        p.setArtist(u);
        new GenericUtil<Painting>().setCommonDates(p);
        p = pRepository.save(p);
        // Normalize file name
        String fileName = StringUtils.cleanPath(p.getId() + ".jpg");
        Path upldLocation = Paths.get(fileUploadLocation).toAbsolutePath().normalize();
        try {

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = upldLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return "Painting Uploaded successfully";
        } catch (IOException ex) {
            System.out.println("Could not upload file " + fileName + ". Please try again!" + ex);
        }
        return "Painting Upload failed";
    }

}