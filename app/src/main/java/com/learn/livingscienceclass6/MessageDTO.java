package com.learn.livingscienceclass6;

public class MessageDTO {
    private String name;
    private String email;
    private String msg;
    private String timeDate;

    public MessageDTO(String name, String email, String msg, String timeDate) {
        this.name = name;
        this.email = email;
        this.msg = msg;
        this.timeDate = timeDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }
}
