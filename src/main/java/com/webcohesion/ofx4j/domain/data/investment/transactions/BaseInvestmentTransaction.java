/*
 * Copyright 2010 Web Cohesion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webcohesion.ofx4j.domain.data.investment.transactions;

import java.util.Date;

/**
 * Base class for all investment transactions.
 * <br>
 * This class exposes a read-only view of the flattened aggregates that are
 * common to all investment transactions as a convenience to application
 * developers who may not find the ofx aggregation model intuitive.
 *
 * @author Jon Perlow
 */
public abstract class BaseInvestmentTransaction {

    private final TransactionType transactionType;

    BaseInvestmentTransaction(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Gets the type of transaction.
     *
     * @return the type of transaction
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Gets the {@link InvestmentTransaction} aggregate.
     *
     * @return the {@link InvestmentTransaction} aggregate
     */
    public abstract InvestmentTransaction getInvestmentTransaction();

    /**
     * Gets the unique financial institution assigned transaction id. This is a
     * required field according to the OFX spec.
     *
     * @return the financial institution asssigned transaction id
     * @see "Section 13.9.2.4.1, OFX Spec"
     */
    public String getTransactionId() {
        return getInvestmentTransaction().getTransactionId();
    }

    /**
     * Gets the server assigned transaction id. This is an optional field
     * according to the OFX spec.
     *
     * @return the server assigned transaction id
     * @see "Section 13.9.2.4.1, OFX Spec"
     */
    public String getServerId() {
        return getInvestmentTransaction().getServerId();
    }

    /**
     * Gets the trade date of the transaction. For stock splits, this is the
     * day of record. This is a required field according to the OFX spec.
     *
     * @return the trade date
     * @see "Section 13.9.2.4.1, OFX Spec"
     */
    public Date getTradeDate() {
        return getInvestmentTransaction().getTradeDate();
    }

    /**
     * Gets the settlement date of the transaction. For stock splits, this is the
     * day of of execution. This is an optional field according to the OFX spec.
     *
     * @return the trade date
     * @see "Section 13.9.2.4.1, OFX Spec"
     */
    public Date getSettlementDate() {
        return getInvestmentTransaction().getSettlementDate();
    }

    /**
     * For a reveral transaction, gets the financial institution assigned
     * transaction id for the transaction being revesed.
     *
     * @return the transaction id of the transaction being reversed
     * @see "Section 13.9.2.4.1, OFX Spec"
     */
    public String getReversalTransactionId() {
        return getInvestmentTransaction().getReversalTransactionId();
    }

    /**
     * Gets the memo associated with the transaction. This is an optional field
     * according to the OFX spec.
     *
     * @return the memo
     * @see "Section 13.9.2.4.1, OFX Spec"
     */
    public String getMemo() {
        return getInvestmentTransaction().getMemo();
    }

    @Override
    public String toString() {
        return "BaseInvestmentTransaction{" +
                "transactionType=" + transactionType +
                "}";
    }
}