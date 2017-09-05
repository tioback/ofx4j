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

import com.webcohesion.ofx4j.domain.data.investment.accounts.SubAccountType;
import com.webcohesion.ofx4j.domain.data.investment.positions.Inv401KSource;
import com.webcohesion.ofx4j.domain.data.seclist.SecurityId;
import com.webcohesion.ofx4j.meta.ChildAggregate;

/**
 * Base class for all investment transactions for selling securities.
 * <br>
 * This class exposes a read-only view of the flattened aggregates that are
 * common to all sell investment transactions as a convenience to application
 * developers who may not find the ofx aggregation model intuitive.
 *
 * @author Jon Perlow
 */
public abstract class BaseSellInvestmentTransaction extends BaseInvestmentTransaction
        implements TransactionWithSecurity {

    private SellInvestmentTransaction sellInvestment;

    BaseSellInvestmentTransaction(TransactionType transactionType) {
        super(transactionType);
    }

    /**
     * Gets the sell investment transaction child aggregate.
     *
     * @return the sell investment transaction child aggregate
     */
    // @Override
    @ChildAggregate(order = 10)
    public SellInvestmentTransaction getSellInvestment() {
        return sellInvestment;
    }

    /**
     * Sets the sell investment transaction child aggregate.
     *
     * @param sellInvestment the sell investment transaction child aggregate
     */
    public void setSellInvestment(SellInvestmentTransaction sellInvestment) {
        this.sellInvestment = sellInvestment;
    }

    /**
     * Gets the investment transaction aggregate.
     *
     * @return the investment transaction aggregate
     */
    // @Overridden
    public InvestmentTransaction getInvestmentTransaction() {
        return getSellInvestment().getInvestmentTransaction();
    }

    /**
     * Gets the id of the security that was sold. This is a required field according to the OFX
     * spec.
     *
     * @return the security id of the security that was bought
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public SecurityId getSecurityId() {
        return getSellInvestment().getSecurityId();
    }

    /**
     * Gets the number of units of the security that was sold. For security-based actions other
     * than stock splits, this is the quantity sold. For stocks, mutual funds, and others, this
     * is the number of shares. For bonds, this is the face value. For options, this is the number of
     * contacts. This is a required field according to the OFX spec.
     *
     * @return the number of units purchased.
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getUnits() {
        return getSellInvestment().getUnits();
    }

    /**
     * Gets the price per commonly-quoted unit. For stocks, mutual funds, and others, this is the
     * share price. For bonds, this is the percentage of par. For options, this is the per share (not
     * per contact) price. This is a required field according to the OFX spec.
     *
     * @return the per unit price
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getUnitPrice() {
        return getSellInvestment().getUnitPrice();
    }

    /**
     * Gets the portion of the unit price that is attributed to the dealer markdown. This is an
     * optional field according to the OFX spec.
     *
     * @return the per unit markedown price
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getMarkdown() {
        return getSellInvestment().getMarkdown();
    }

    /**
     * Gets the transaction commission for the sale. This is an optional field according to the
     * OFX spec.
     *
     * @return the transaction commision
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getCommission() {
        return getSellInvestment().getCommission();
    }

    /**
     * Gets the taxes for the sale. This is an optional field according to the OFX spec.
     *
     * @return the transaction taxes
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getTaxes() {
        return getSellInvestment().getTaxes();
    }

    /**
     * Gets the fees for the sale. This is an optional field according to the OFX spec.
     *
     * @return the transaction fees
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getFees() {
        return getSellInvestment().getFees();
    }

    /**
     * Gets the load for the sale. This is an optional field according to the OFX spec.
     *
     * @return the load
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getLoad() {
        return getSellInvestment().getLoad();
    }

    /**
     * Gets the withholding for the sale. This is an optional field according to the OFX spec.
     *
     * @return the withholding
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getWithholding() {
        return getSellInvestment().getWithholding();
    }

    /**
     * Gets whether the sale was tax exempt. This is an optional field according to the OFX spec.
     *
     * @return whether the transaction was tax exempt
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Boolean getTaxExempt() {
        return getSellInvestment().getTaxExempt();
    }

    /**
     * Gets the total for the sale. Should be equal to
     * (units * (unitPrice + markdown)) + (commision + fees + load + taxes + penalty + withholding +
     * statewithholding) according to the OFX spec. This is a required field according to the OFX
     * spec.
     *
     * @return the total
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getTotal() {
        return getSellInvestment().getTotal();
    }

    /**
     * Gets the gain sale. This is aan optional field according to the OFX spec.
     *
     * @return the gain for the sale
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getGain() {
        return getSellInvestment().getGain();
    }

    /**
     * Gets the currency code for the transaction. Only one of currency code or original currency
     * info should be set according to the OFX spec. If neither are set, means the default currency.
     *
     * @return the currency code for the transaction.
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public String getCurrencyCode() {
        return getSellInvestment().getCurrencyCode();
    }

    /**
     * Gets the origianl currency info for the transaction.
     *
     * @return the currency info for the transaction.
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public OriginalCurrency getOriginalCurrencyInfo() {
        return getSellInvestment().getOriginalCurrencyInfo();
    }

    /**
     * Gets the sub account type for the security (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account type
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public String getSubAccountSecurity() {
        return getSellInvestment().getSubAccountSecurity();
    }

    /**
     * Gets the result of getSubAccountSecurity as one of the well-known types.
     *
     * @return the type of null if it wasn't one of the well known types.
     */
    public SubAccountType getSubAccountSecurityEnum() {
        return SubAccountType.fromOfx(getSubAccountSecurity());
    }

    /**
     * Gets the sub account type that the money went to  (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account fund
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public String getSubAccountFund() {
        return getSellInvestment().getSubAccountFund();
    }

    /**
     * Gets the result of getSubAccountFund as one of the well-known types.
     *
     * @return the type of null if it wasn't one of the well known types.
     */
    public SubAccountType getSubAccountFundEnum() {
        return SubAccountType.fromOfx(getSubAccountFund());
    }

    /**
     * Gets the loan id if this transaction was due to a loan or loan repayment on a 401k. This is an
     * optional field according to the OFX spec.
     *
     * @return the loan id
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public String getLoadId() {
        return getSellInvestment().getLoanId();
    }

    /**
     * Gets the state withholding for the sale. This is an optional field according to the OFX spec.
     *
     * @return the state withholding
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getStateWithholding() {
        return getSellInvestment().getStateWithholding();
    }

    /**
     * Gets the penalty for the sale. This is an optional field according to the OFX spec.
     *
     * @return the state withholding
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public Double getPenalty() {
        return getSellInvestment().getPenalty();
    }

    /**
     * Gets the 401K source for the sale. Should be one of "PRETAX", "AFTERTAX", "MATCH",
     * "PROFITSHARING", "ROLLOVER", "OTHERVEST", "OTHERNONVEST".  This is an optional field
     * according to the OFX spec.
     *
     * @return the 401k source
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public String get401kSource() {
        return getSellInvestment().get401kSource();
    }

    /**
     * Gets the 401k source as one of the well-known types.
     *
     * @return the 401k source or null if its not one of the well-known types
     */
    public Inv401KSource get401kSourceEnum() {
        return Inv401KSource.fromOfx(get401kSource());
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "BaseSellInvestmentTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "sellInvestment=" + sellInvestment +
                "}";
    }
}
