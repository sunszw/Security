package com.security.json;

import java.io.Serializable;

public class Json<T> implements Serializable {

    private static final long serialVersionUID = -1895250040667524079L;
    private Integer state;
    private String message;
    private T data;

    public Json() {
    }

    public Json(Integer state) {
        this.state = state;
    }

    public Json(Throwable throwable) {
        this.message = throwable.getMessage();
    }

    public Json(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Json{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
