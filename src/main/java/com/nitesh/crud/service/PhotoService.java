package com.nitesh.crud.service;

import com.nitesh.crud.model.Photo;
import com.nitesh.crud.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }


    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo save(String fileName, byte[] data, String contentType) {
        Photo photo = new Photo();

        photo.setFileName(fileName);
        photo.setData(data);
        photo.setContentType(contentType);

        photoRepository.save(photo);

        return photo;
    }


}
