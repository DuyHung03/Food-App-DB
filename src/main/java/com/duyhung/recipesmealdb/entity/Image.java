package com.duyhung.recipesmealdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Transactional
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "[images]")
public class Image {
    @Id
    @GeneratedValue
    private Long image_id;
    private String url;

    public Image(String url) {
        this.url = url;
    }
}
