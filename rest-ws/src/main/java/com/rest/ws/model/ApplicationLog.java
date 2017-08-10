package com.rest.ws.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appl_logs")
public class ApplicationLog implements Serializable {

	private static final long serialVersionUID = 6887705364148748491L;
	
	@Id
	private long id;
	
	@Column(name = "issued_date")
	private Date date;
	
	@Column(name = "log_level")
	private String logLevel;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "data_size")
	private int dataSize;
	
	@Column(name = "source")
	private String source;
	
	protected ApplicationLog() {
		
	}

	public Date getDate() {
		return date;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public String getMessage() {
		return message;
	}

	public int getDataSize() {
		return dataSize;
	}

	public String getSource() {
		return source;
	}

	@Override
	public String toString() {
		return "ApplicationLog [date=" + date + ", logLevel=" + logLevel + ", message=" + message + ", dataSize="
				+ dataSize + ", source=" + source + "]";
	}

}
