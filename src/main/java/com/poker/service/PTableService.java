package com.poker.service;

import com.poker.controller.PTableController;
import com.poker.entity.PTable;
import com.poker.entity.TableStatus;
import com.poker.repository.PTableRepository;
import com.poker.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PTableService  {
    Logger log = (Logger) LoggerFactory.getLogger(PTableService.class);

    @Autowired @Lazy
    private PTableController controller;

    @Autowired
    private PTableRepository tableRepo;

    @Autowired
    private PlayerRepository playerRepo;

    @Cacheable(value = "ptables", key = "#tableId")
    public Optional<PTable> getPTable(Long tableId) {
        return tableRepo.findById(tableId);
    }

    @CachePut(value = "ptables", key = "#obj.id")
    public PTable updatePlayerTable(PTable obj) {
        if(obj.getStatus().equals(TableStatus.COMPLETED.getValue()))
            tableRepo.save(new PTable(obj.getEntry_fee()));
        return tableRepo.save(obj);
    }

    @Cacheable(value = "ptables", key="")
    public List<PTable> getAllTables() {
        return tableRepo.findAll();
    }

    @CacheEvict(value = "ptables", key="#id" )
    public void deleteTable(Long id) {
        tableRepo.delete(tableRepo.getReferenceById(id));
    }

    public PTable createTable(PTable ptable) {
        return tableRepo.save(ptable);
    }
}
