package com.poker.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "PTable")
public class PTable implements Serializable {
    @JsonIgnore
    public static final int MAX_PARTICIPANTS = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "table")
    private List<Player> players;

    private String status;

    private Integer entry_fee;

    private Integer participantsCount;

    @OneToOne
    private Player winner;

    private String accessCode;

    public String toString() {
        StringBuilder sb  = new StringBuilder();
        sb.append(this.id);
        sb.append("\r\n");
        sb.append(this.players.toString());
        sb.append("\r\n");
        return sb.toString();
    }

    @JsonCreator
    public PTable(int entryFee) {
        this.entry_fee = entryFee;
        this.status = TableStatus.WAITING_FOR_PLAYER_TO_JOIN.getValue();
        this.participantsCount = 0;
        this.accessCode = getAlphaNumericString(6);
    }

    @JsonIgnore
    static String getAlphaNumericString(int n)
    {
        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
}
