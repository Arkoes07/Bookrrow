package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Enum class for specifying status of a transaction
 *
 * pending  : book is requested from borrower to owner
 * rejected : borrow request is reject by owner of the book
 * ongoing  : borrow request is accepted by owner of the book
 * finished : transaction is marked as finish by owner of the book
 *
 * @author DP Nala Krisnanda
 * @version 1.0
 * @since 2019-05-17
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TransactionStatus {
    PENDING("Pending", "PENDING"),
    REJECTED("Rejected", "REJECTED"),
    ONGOING("Ongoing", "ONGOING"),
    FINISHED("Finished", "FINISHED");

    private String transactionStatus;
    private String keyName;

    /**
     * constructor for assign value of transaction status and the key name
     * @param transactionStatus is the value of the enum
     * @param keyName key name of the enum
     */
    TransactionStatus(String transactionStatus, String keyName) {
        this.transactionStatus = transactionStatus;
        this.keyName = keyName;
    }

    /**
     * get the value of an enum
     * @return the enum value
     */
    public String getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * get the key name of an enum
     * @return the enum key name
     */
    public String getKeyName() {
        return keyName;
    }
}
