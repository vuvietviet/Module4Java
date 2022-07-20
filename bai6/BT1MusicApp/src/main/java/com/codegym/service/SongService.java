package com.codegym.service;

import com.codegym.dao.SongDao;
import com.codegym.model.Song;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SongService implements CRUD<Song> {
    @Autowired
    SongDao songDao;

    @Override
    public void create(Song song) {
        songDao.save(song);
    }

    @Override
    public void edit(Song song) {
        songDao.edit(song);
    }

    @Override
    public void delete(int id) {
        songDao.delete(id);
    }

    @Override
    public List<Song> getAll() {
        return songDao.getList();
    }

    public Song findById(int id){
        return songDao.findById(id);
    }
}
