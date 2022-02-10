package com.orb.caveweb.models;

public class Response<T> {


    private T object;


    private String status;

    public Response() {
    }

    public Response(T object, String status) {
        this.object = object;
        this.status = status;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
