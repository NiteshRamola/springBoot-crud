package com.nitesh.crud.controller;

import com.nitesh.crud.model.Photo;
import com.nitesh.crud.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotosController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/")
    public String hello() {
        return "Hello Nitesh";
    }

    @GetMapping("/photos")
    public Iterable<Photo> get() {
        return photoService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo getById(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return photo;
    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("file") MultipartFile file) throws IOException {
        Photo photo = photoService.save(file.getOriginalFilename(), file.getBytes(), file.getContentType());

        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id) {
        photoService.remove(id);
    }
}
