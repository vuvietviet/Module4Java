package com.example.demo_springboot.repository;

import com.example.demo_springboot.model.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IBlogRepo extends PagingAndSortingRepository<Blogs,Long> {
    Page<Blogs> findByTitleContaining (Pageable pageable, String title);

    @Query(nativeQuery = true, value = "SELECT * FROM blog_c0322g1.blogs where title like concat('%',:title,'%');")
    List<Blogs> findAllByTitleContaining(String title);
    Optional<Blogs> findByTitle(String title);
}
