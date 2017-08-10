package com.web.client.dto;

import java.util.Date;

public class ApplicationLog {
	
	private Date  date;
    private String logLevel;
    private String message;
    private int dataSize;
    private String source;

    public ApplicationLog() {}
    
    public ApplicationLog(Date date, String logLevel, String message, int dataSize, String source) {
        this.date = date;
        this.logLevel = logLevel;
        this.message = message;
        this.dataSize = dataSize;
        this.source = source;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "ApplicationLog{" +
                "date='" + date + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", message='" + message + '\'' +
                ", dataSize=" + dataSize +
                ", source='" + source + '\'' +
                '}';
    }

}
