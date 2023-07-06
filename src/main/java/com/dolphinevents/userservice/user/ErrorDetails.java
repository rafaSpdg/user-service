package com.dolphinevents.userservice.user;

import java.time.LocalDate;

import org.springframework.http.HttpStatusCode;

public class ErrorDetails {

    private HttpStatusCode status;

    private LocalDate date;

    private String message;

    private String details;

    public ErrorDetails(HttpStatusCode status, LocalDate date, String message, String details) {
        this.status= status;
        this.date= date;
        this.message= message;
        this.details= details;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }   
}
