package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {
    @Id
    private int id;
    private String name;
    private String singer;
    @ManyToOne
    private Category category;
    private String file;
    private String link;

    public Song() {
    }

    public Song(int id, String name, String singer, Category category, String file, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.file = file;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
