package com.poker.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinTable(name = "Player_Table", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "table_id"))
    private PTable table;

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 31 + this.name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass() != obj.getClass())
            return false;
        if(((Player) obj).name != this.name)
            return false;
                return true;
    }
    public String toString() {
        return this.name;
    }

}
