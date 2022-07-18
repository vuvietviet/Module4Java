package model;

import java.util.List;

public class Song {
    private int id;
    private String name;
    private String singer;
    private String category;
    private String file;

    public Song() {
    }

    public Song(int id, String name, String singer, String category, String file) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.file = file;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
