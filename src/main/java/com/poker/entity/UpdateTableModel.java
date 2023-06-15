package com.poker.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTableModel implements Serializable {
    private String playerNames;
    private Long tableId;
}
