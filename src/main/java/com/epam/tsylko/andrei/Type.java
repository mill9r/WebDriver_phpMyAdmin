package com.epam.tsylko.andrei;


public enum Type {
    CHAR("CHAR"),VARCHAR("VARCHAR"),INT("INT");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
