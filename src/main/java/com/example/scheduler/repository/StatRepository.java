package com.example.scheduler.repository;

import com.example.scheduler.entity.Stat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {

    Stat findByUserEmail(String email);

    @Query("select s, s.user from Stat s where s.user.email = :email")
    Stat fastFindByUserEmail(@Param("email") String email);
}