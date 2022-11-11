package com.example.scheduler.controller;

import com.example.scheduler.entity.Stat;
import com.example.scheduler.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatController {

    private final StatService service;

    public StatController(StatService service) {
        this.service = service;
    }

    @PostMapping("/stat")
    public ResponseEntity<Stat> findByEmail(@RequestBody String email) {

        return ResponseEntity.ok(service.findStat(email));
    }

    @PostMapping("/stat2")
    public ResponseEntity<Stat> fastFindByUserEmail(@RequestBody String email) {

        return ResponseEntity.ok(service.fastFindByUserEmail(email));
    }


}