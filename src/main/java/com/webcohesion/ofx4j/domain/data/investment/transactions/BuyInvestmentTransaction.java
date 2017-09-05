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
import com.webcohesion.ofx4j.domain.data.seclist.SecurityId;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;
import com.webcohesion.ofx4j.meta.Element;

/**
 * Buy investment transaction aggregate ("INVBUY").
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.3, OFX Spec"
 */
@Aggregate("INVBUY")
public class BuyInvestmentTransaction {

    private InvestmentTransaction investmentTransaction;
    private SecurityId securityId;
    private Double units;
    private Double unitPrice;
    private Double markup;
    private Double commission;
    private Double taxes;
    private Double fees;
    private Double load;
    private Double total;
    private String currencyCode;
    private OriginalCurrency originalCurrencyInfo;
    private String subAccountSecurity;
    private String subAccountFund;

    /**
     * Gets the investment transaction child aggregate.
     *
     * @return the investment transaction child aggregate
     */
    @ChildAggregate(order = 10)
    public InvestmentTransaction getInvestmentTransaction() {
        return investmentTransaction;
    }

    /**
     * Sets the investment transaction child aggregate.
     *
     * @param investmentTransaction the investment transaction child aggregate
     */
    public void setInvestmentTransaction(InvestmentTransaction investmentTransaction) {
        this.investmentTransaction = investmentTransaction;
    }

    /**
     * Gets the id of the security that was bought. This is a required field according to the OFX
     * spec.
     *
     * @return the security id of the security that was bought
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @ChildAggregate(required = true, order = 20)
    public SecurityId getSecurityId() {
        return securityId;
    }

    /**
     * Sets the id of the security that was bought. This is a required field according to the OFX
     * spec.
     *
     * @param securityId the security id of the security that was bought
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setSecurityId(SecurityId securityId) {
        this.securityId = securityId;
    }

    /**
     * Gets the number of units of the security that was bought. For security-based actions other
     * than stock splits, this is the quantity bought. For stocks, mutual funds, and others, this
     * is the number of shares. For bonds, this is the face value. For options, this is the number of
     * contacts. This is a required field according to the OFX spec.
     *
     * @return the number of units purchased.
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "UNITS", required = true, order = 30)
    public Double getUnits() {
        return units;
    }

    /**
     * Sets the number of units of the security that was bought. For security-based actions other
     * than stock splits, this is the quantity bought. For stocks, mutual funds, and others, this
     * is the number of shares. For bonds, this is the face value. For options, this is the number of
     * contacts. This is a required field according to the OFX spec.
     *
     * @param units the number of units purchased.
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setUnits(Double units) {
        this.units = units;
    }

    /**
     * Gets the price per commonly-quoted unit. For stocks, mutual funds, and others, this is the
     * share price. For bonds, this is the percentage of par. For options, this is the per share (not
     * per contact) price. This is a required field according to the OFX spec.
     *
     * @return the per unit price
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "UNITPRICE", required = true, order = 40)
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the price per commonly-quoted unit. For stocks, mutual funds, and others, this is the
     * share price. For bonds, this is the percentage of par. For options, this is the per share (not
     * per contact) price. This is a required field according to the OFX spec.
     *
     * @param unitPrice the per unit price
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets the portion of the unit price that is attributed to the dealer markup. This is an
     * optional field according to the OFX spec.
     *
     * @return the per unit markeup price
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "MARKUP", order = 50)
    public Double getMarkup() {
        return markup;
    }

    /**
     * Sets the portion of the unit price that is attributed to the dealer markup. This is an
     * optional field according to the OFX spec.
     *
     * @param markup the per unit markeup price
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setMarkup(Double markup) {
        this.markup = markup;
    }

    /**
     * Gets the transaction commission for the purchase. This is an optional field according to the
     * OFX spec.
     *
     * @return the transaction commision
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "COMMISSION", order = 60)
    public Double getCommission() {
        return commission;
    }

    /**
     * Sets the transaction commission for the purchase. This is an optional field according to the
     * OFX spec.
     *
     * @param commission the transaction commision
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    /**
     * Gets the taxes for the purchase. This is an optional field according to the OFX spec.
     *
     * @return the transaction taxes
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "TAXES", order = 70)
    public Double getTaxes() {
        return taxes;
    }

    /**
     * Sets the taxes for the purchase. This is an optional field according to the OFX spec.
     *
     * @param taxes the transaction taxes
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    /**
     * Gets the fees for the purchase. This is an optional field according to the OFX spec.
     *
     * @return the transaction fees
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "FEES", order = 80)
    public Double getFees() {
        return fees;
    }

    /**
     * Sets the fees for the purchase. This is an optional field according to the OFX spec.
     *
     * @param fees the transaction fees
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setFees(Double fees) {
        this.fees = fees;
    }

    /**
     * Gets the load for the purchase. This is an optional field according to the OFX spec.
     *
     * @return the load
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "LOAD", order = 90)
    public Double getLoad() {
        return load;
    }

    /**
     * Sets the load for the purchase. This is an optional field according to the OFX spec.
     *
     * @param load the load
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setLoad(Double load) {
        this.load = load;
    }

    /**
     * Gets the total for the purchase. Should be equal to
     * (units * (unitPrice + markup)) + (commision + fees + taxes) according to the OFX
     * spec. This is a required field according to the OFX spec.
     *
     * @return the total
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "TOTAL", required = true, order = 100)
    public Double getTotal() {
        return total;
    }

    /**
     * Sets the total for the purchase. Should be equal to
     * (units * (unitPrice + markup)) + (commision + fees + taxes) according to the OFX
     * spec. This is a required field according to the OFX spec.
     *
     * @param total the total
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Gets the currency code for the transaction. Only one of currency code or original currency
     * info should be set according to the OFX spec. If neither are set, means the default currency.
     *
     * @return the currency code for the transaction.
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "CURRENCY", order = 110)
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the currency code for the transaction. Only one of currency code or original currency
     * info may be set according to the OFX spec. If neither are set, means the default currency.
     *
     * @param currencyCode the currency code for the transaction.
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        this.originalCurrencyInfo = null;
    }

    /**
     * Gets the original currency info for the transaction.
     *
     * @return the original currency info for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @ChildAggregate(order = 120)
    public OriginalCurrency getOriginalCurrencyInfo() {
        return originalCurrencyInfo;
    }

    /**
     * Sets the original currency info for the transaction
     *
     * @param originalCurrencyInfo the original currency info for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setOriginalCurrencyInfo(OriginalCurrency originalCurrencyInfo) {
        this.originalCurrencyInfo = originalCurrencyInfo;
        this.currencyCode = null;
    }

    /**
     * Gets the sub account type for the security (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account type
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "SUBACCTSEC", order = 130)
    public String getSubAccountSecurity() {
        return subAccountSecurity;
    }

    /**
     * Sets the sub account type for the security (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @param subAccountSecurity the sub account type
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setSubAccountSecurity(String subAccountSecurity) {
        this.subAccountSecurity = subAccountSecurity;
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
     * Gets the sub account type that the money came from. (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account fund
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "SUBACCTFUND", order = 140)
    public String getSubAccountFund() {
        return subAccountFund;
    }

    /**
     * Sets the sub account type that the money came from. (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @param subAcctFund the sub account fund
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setSubAccountFund(String subAcctFund) {
        this.subAccountFund = subAcctFund;
    }

    /**
     * Gets the result of getSubAccountFund as one of the well-known types.
     *
     * @return the type or null if it wasn't one of the well known types.
     */
    public SubAccountType getSubAccountFundEnum() {
        return SubAccountType.fromOfx(getSubAccountFund());
    }

    @Override
    public String toString() {
        return "BuyInvestmentTransaction{" +
                "investmentTransaction=" + investmentTransaction +
                ", securityId=" + securityId +
                ", units=" + units +
                ", unitPrice=" + unitPrice +
                ", markup=" + markup +
                ", commission=" + commission +
                ", taxes=" + taxes +
                ", fees=" + fees +
                ", load=" + load +
                ", total=" + total +
                ", currencyCode='" + currencyCode + '\'' +
                ", originalCurrencyInfo=" + originalCurrencyInfo +
                ", subAccountSecurity='" + subAccountSecurity + '\'' +
                ", subAccountFund='" + subAccountFund + '\'' +
                "}";
    }
}
