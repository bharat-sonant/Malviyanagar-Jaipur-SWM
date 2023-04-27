package com.vCare.malviyanagarjaipurswm.Model;

public class PaymentHistoryModel {
    String transactionDateTime;
    String transactionAmount;
    String retrievalReferenceNo;
    String paymentCollectionByName;
    String payMethod;
    String merchantTransactionId;

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getRetrievalReferenceNo() {
        return retrievalReferenceNo;
    }

    public void setRetrievalReferenceNo(String retrievalReferenceNo) {
        this.retrievalReferenceNo = retrievalReferenceNo;
    }

    public String getpaymentCollectionByName() {
        return paymentCollectionByName;
    }

    public void setpaymentCollectionByName(String paymentCollectionByName) {
        this.paymentCollectionByName = paymentCollectionByName;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getMerchantTransactionId() {
        return merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }

    public PaymentHistoryModel() {
    }

    public PaymentHistoryModel(String transactionDateTime, String transactionAmount, String retrievalReferenceNo, String paymentCollectionByName, String payMethod, String merchantTransactionId) {
        this.transactionDateTime = transactionDateTime;
        this.transactionAmount = transactionAmount;
        this.retrievalReferenceNo = retrievalReferenceNo;
        this.paymentCollectionByName = paymentCollectionByName;
        this.payMethod = payMethod;
        this.merchantTransactionId = merchantTransactionId;
    }
}