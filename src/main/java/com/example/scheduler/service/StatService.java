package com.example.scheduler.service;

import com.example.scheduler.entity.Stat;
import com.example.scheduler.repository.StatRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StatService {

    private final StatRepository repository;

    public StatService(StatRepository repository) {
        this.repository = repository;
    }

    public Stat findStat(String email) {
        return repository.findByUserEmail(email);
    }

    public Stat fastFindByUserEmail(String email) {
        return repository.fastFindByUserEmail(email);
    }
}