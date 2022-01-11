package com.example.opr323.Model;

public class Record {
    private String text;
    private Access access;

    public Record(String text, Access access) {
        this.text = text;
        this.access = access;
    }

    public String getText() {
        return text;
    }

    public Access getAccess() {
        return access;
    }
}
