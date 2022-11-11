package com.example.scheduler.repository;

import com.example.scheduler.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUserEmailOrderByTitleAsc(String email);

    @Query("select c, c.user from Category c where " +
            "(:title is null or :title = '' " +
            "or lower(c.title) like lower(concat('%', :title, '%')))" +
            "and c.user.email =:email " +
            "order by c.title asc")
    List<Category> findByTitle(@Param("title") String title, @Param("email") String email);

    @Modifying
    @Query("delete from Category c where c.id = :id")
    void simpleDelete(@Param("id") Long id);
}
