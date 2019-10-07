package com.cjwstorm.bean;

import java.util.Objects;

public class ResponseResult<T> {
    private Integer state;
    private String msg;
    private T data;

    public ResponseResult(Integer state, String msg, T data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    //自定义一个常用的构造方法
    public ResponseResult(Integer state, Throwable throwable) {
        this.state = state;
        this.msg = throwable.getMessage();
    }

    //自定义一个常用的构造方法
    public ResponseResult(Integer state, String message) {
        this.state = state;
        this.msg = message;
    }

    public ResponseResult() {
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseResult<?> that = (ResponseResult<?>) o;
        return Objects.equals(state, that.state) &&
                Objects.equals(msg, that.msg) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, msg, data);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
