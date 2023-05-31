package com.nitesh.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("PHOTO")
public class Photo {

    @Id
    private Integer id;

    @NotEmpty
    private String fileName;

    private String contentType;

    @JsonIgnore
    private byte[] data;

    public Photo() {
    }

    public Photo(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }


}
