package com.nitesh.crud.repository;

import com.nitesh.crud.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
