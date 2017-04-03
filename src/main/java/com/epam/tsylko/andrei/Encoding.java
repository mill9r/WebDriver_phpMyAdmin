package com.epam.tsylko.andrei;


public enum Encoding {
    UTF("utf8_bin");

    private String encoding;

    Encoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }
}
