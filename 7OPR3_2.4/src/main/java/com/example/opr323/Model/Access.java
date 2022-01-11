package com.example.opr323.Model;

public class Access {
    private String code;
    private String pin;

    public Access(String code, String pin) {
        this.code = code;
        this.pin = pin;
    }

    public String getCode() {
        return code;
    }

    public String getPin() {
        return pin;
    }
}
