package com.epam.tsylko.andrei;


public enum Index {
    PRIMARY("Primary");

    private String index;

    Index(String type) {
        this.index = type;
    }

    public String getType() {
        return index;
    }
}
