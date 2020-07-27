package com.example.demo.core.entity;

/**
 * @date: 2020/7/23 21:53
 * @description:
 **/
public class Position {
    private String securityCode;
    private Integer quantity;

    // closed为true表示进行了cancel操作
    private Boolean closed;


    public Position() {
        super();
    }

    public Position(String securityCode, Integer quantity) {
        this.securityCode = securityCode;
        this.quantity = quantity;
        this.closed = Boolean.FALSE;
    }



    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }


    @Override
    public String toString() {
        return "{" +
                "securityCode = '" + securityCode + '\'' +
                ", quantity = " + quantity +
                '}';
    }
}
