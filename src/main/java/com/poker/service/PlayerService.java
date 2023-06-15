package com.poker.service;

import com.poker.entity.Player;
import com.poker.repository.PTableRepository;
import com.poker.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class PlayerService {
    Logger log = (Logger) LoggerFactory.getLogger(PlayerService.class);
    @Autowired
    private PlayerRepository repository;

    @Autowired
    JdbcTemplate template;

    @Autowired
    private PTableRepository tableRepo;

    public Player createPlayer(Player player) {
        System.out.println();
        template.execute("select",getPS());
        return repository.save(player);
    }

    public PreparedStatementCallback<Boolean> getPS() {
        return new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return true;
            }
        };
    }
}
