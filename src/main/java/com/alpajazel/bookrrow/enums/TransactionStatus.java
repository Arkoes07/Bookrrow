package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TransactionStatus {
    PENDING("Pending", "PENDING"),
    REJECTED("Rejected", "REJECTED"),
    ONGOING("Ongoing", "ONGOING"),
    FINISHED("Finished", "FINISHED");

    private String transactionStatus;
    private String keyName;

    TransactionStatus(String transactionStatus, String keyName) {
        this.transactionStatus = transactionStatus;
        this.keyName = keyName;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public String getKeyName() {
        return keyName;
    }
}
