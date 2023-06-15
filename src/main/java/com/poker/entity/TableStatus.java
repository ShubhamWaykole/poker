package com.poker.entity;

public enum TableStatus {
    WAITING_FOR_PLAYER_TO_JOIN("Waiting for players to join"),
    ACTIVE("Table is live"),
    COMPLETED("Table completed");

    private String value;

    TableStatus(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
