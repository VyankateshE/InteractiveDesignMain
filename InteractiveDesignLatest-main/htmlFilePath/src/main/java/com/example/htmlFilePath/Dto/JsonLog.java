package com.example.htmlFilePath.Dto;

import lombok.Data;

@Data
public class JsonLog {
    private String uid;
    private String date;
    private String time;
    private String message;

    public JsonLog() {}

    public JsonLog(String uid, String date, String time, String message) {
        this.uid = uid;
        this.date = date;
        this.time = time;
        this.message = message;
    }
}
