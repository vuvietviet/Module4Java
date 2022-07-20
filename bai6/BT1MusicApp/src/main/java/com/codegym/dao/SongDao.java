package com.codegym.dao;

import com.codegym.model.Song;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class SongDao {
    @Autowired
    EntityManager entityManager;

    public List<Song> getList(){
        String queryStr = "SELECT s FROM Song s";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        return (List<Song>) query.getResultList();
    }

    public void save(Song song){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(song);
        txn.commit();
    }

    public void edit(Song song) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(song);
        txn.commit();
    }

    public void delete(int id){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(findById(id));
        txn.commit();
    }


    public Song findById(int id){
        String query = "SELECT s FROM Song s where s.id=:id";
        Song song = entityManager.createQuery(query,Song.class).setParameter("id",id).getSingleResult();
        return song;
    }

}
