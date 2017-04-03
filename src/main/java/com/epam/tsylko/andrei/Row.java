package com.epam.tsylko.andrei;


public class Row {

    private String name;
    private Type type;
    private String length;
    private Index index;
    private boolean AI;

    public Row(String name, Type type, String length, Index index, boolean AI) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.index = index;
        this.AI = AI;
    }


    public Row(String name, Type type, String length) {
        this.name = name;
        this.length = length;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getLength() {
        return length;
    }

    public Index getIndex() {
        return index;
    }

    public boolean isAI() {
        return AI;
    }
}
