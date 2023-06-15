package com.poker.controller;


import com.poker.entity.PTable;
import com.poker.service.PTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/table")
public class PTableController {
    Logger log = (Logger) LoggerFactory.getLogger(PTableController.class);

    @Autowired
    private PTableService service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<?> getTable(Long tableId) {
        Optional<PTable> obj = service.getPTable(tableId);
        log.info("obj: " + obj.get().toString());
        return new ResponseEntity<>(obj.get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateTable(@RequestBody PTable requestBody) {
        return new ResponseEntity<>(service.updatePlayerTable(requestBody),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllTable() {
        List<PTable> tables = service.getAllTables();
        tables.sort(new Comparator<PTable>() {
            @Override
            public int compare(PTable o1, PTable o2) {
                return o2.getEntry_fee()-o1.getEntry_fee();
            }
        });
        return new ResponseEntity<>(tables,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTable(@RequestBody PTable ptable) {
        return new ResponseEntity<>(service.createTable(ptable),HttpStatus.CREATED);
    }
}
