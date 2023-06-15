package com.poker.controller;

import com.poker.entity.Player;
import com.poker.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    Logger log = (Logger) LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService service;

    @PostMapping
    public ResponseEntity<?> addPlayer(@RequestBody Player player) {
        return new ResponseEntity<>(service.createPlayer(player), HttpStatus.CREATED);
    }
}
