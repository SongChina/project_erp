package com.cskaoyan.bean;

import java.util.Date;

public class MaterialReceive2 {
    private String receiveId;

    private String materialId;

    private Integer amount;

    private Date receiveDate;

    private String sender;

    private String receiver;

    private String note;

    public String getReceiveId() {
        return receiveId;
    }

    @Override
    public String toString() {
        return "MaterialReceive2{" +
                "receiveId='" + receiveId + '\'' +
                ", materialId='" + materialId + '\'' +
                ", amount=" + amount +
                ", receiveDate=" + receiveDate +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}