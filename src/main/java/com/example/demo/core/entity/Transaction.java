package com.example.demo.core.entity;

/**
 * @date: 2020/7/23 21:51
 * @description: Transaction record entity
 **/
public class Transaction {

    private Long transactionId;
    private Long tradId;
    private Long version;
    private String securityCode;
    private Integer quantity;
    private String operation;
    private String buyOrSell;

    public Transaction() {
    }

    public Transaction(String securityCode, Integer quantity, String operation, String buyOrSell) {
        this.securityCode = securityCode;
        this.quantity = quantity;
        this.operation = operation;
        this.buyOrSell = buyOrSell;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTradId() {
        return tradId;
    }

    public void setTradId(Long tradId) {
        this.tradId = tradId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getBuyOrSell() {
        return buyOrSell;
    }

    public void setBuyOrSell(String buyOrSell) {
        this.buyOrSell = buyOrSell;
    }

    @Override
    public String toString() {
        return "{" +
                "transactionId=" + transactionId +
                ", tradId=" + tradId +
                ", version=" + version +
                ", securityCode='" + securityCode + '\'' +
                ", quantity=" + quantity +
                ", operation='" + operation + '\'' +
                ", buyOrSell='" + buyOrSell + '\'' +
                '}';
    }
}
