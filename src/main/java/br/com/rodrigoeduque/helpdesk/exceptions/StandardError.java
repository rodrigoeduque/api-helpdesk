package br.com.rodrigoeduque.helpdesk.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 951329495573935094L;

    private Long timestamp;
    private Integer status;
    private String error;
    private String path;

    public StandardError() {
        super();
    }

    public StandardError(Long timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
