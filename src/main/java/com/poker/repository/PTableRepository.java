package com.poker.repository;

import com.poker.entity.PTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PTableRepository extends JpaRepository<PTable, Long> {
}
