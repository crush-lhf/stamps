package com.bysj.stamps.common;

/**
 * @author lihf
 * @version 1.0
 * @address 邮政
 */
public enum Status {
    SUCCESS(1, "操作成功"), FAILE(-1, "操作失败"), EXCEPTION(0, "操作异常");

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private int status;
    private String msg;

    Status(int status, String msg) {
        this.msg = msg;
        this.status = status;
    }
}
