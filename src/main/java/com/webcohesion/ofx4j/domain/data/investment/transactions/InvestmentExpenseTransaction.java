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
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;
import com.webcohesion.ofx4j.meta.Element;

/**
 * Transaction for an investment expense
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("INVEXPENSE")
public class InvestmentExpenseTransaction extends BaseOtherInvestmentTransaction {

    private SecurityId securityId;
    private Double total;
    private String subAccountSecurity;
    private String subAccountFund;
    private String currencyCode;
    private OriginalCurrency originalCurrencyInfo;
    private String inv401kSource;

    public InvestmentExpenseTransaction() {
        super(TransactionType.INVESTMENT_EXPENSE);
    }

    /**
     * Gets the id of the security for the expense. This is a required field according to the OFX
     * spec.
     *
     * @return the security id of the security for the expsense
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @ChildAggregate(required = true, order = 20)
    public SecurityId getSecurityId() {
        return securityId;
    }

    /**
     * Sets the id of the security for the expense. This is a required field according to the OFX
     * spec.
     *
     * @param securityId the security id of the security for the expsense
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setSecurityId(SecurityId securityId) {
        this.securityId = securityId;
    }

    /**
     * Gets the total for the expense.
     *
     * @return the total
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "TOTAL", required = true, order = 30)
    public Double getTotal() {
        return total;
    }

    /**
     * Sets the total for the expense.
     *
     * @param total the total
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Gets the sub account type for the security (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account type
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "SUBACCTSEC", order = 40)
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
     * Gets the sub account type for the fund. (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account fund
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "SUBACCTFUND", order = 50)
    public String getSubAccountFund() {
        return subAccountFund;
    }

    /**
     * Sets the sub account type for the fund. (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @param subAccountFund the sub account fund
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setSubAccountFund(String subAccountFund) {
        this.subAccountFund = subAccountFund;
    }

    /**
     * Gets the result of getSubAccountFund as one of the well-known types.
     *
     * @return the type of null if it wasn't one of the well known types
     */
    public SubAccountType getSubAccountFundEnum() {
        return SubAccountType.fromOfx(getSubAccountFund());
    }

    /**
     * Gets the currency code for the transaction. Only one of currency code or original currency
     * code should be set according to the OFX spec. If neither are set, means the default currency.
     *
     * @return the currency code for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "CURRENCY", order = 60)
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * sets the currency code for the transaction. Only one of currency code or original currency
     * code should be set according to the OFX spec. If neither are set, means the default currency.
     *
     * @param currencyCode the currency code for the transaction
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
    @Element(name = "ORIGCURRENCY", order = 70)
    public OriginalCurrency getOriginalCurrencyInfo() {
        return originalCurrencyInfo;
    }

    /**
     * Sets the original currency info for the transaction.
     *
     * @param originalCurrencyInfo the original currency info for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setOriginalCurrencyInfo(OriginalCurrency originalCurrencyInfo) {
        this.originalCurrencyInfo = originalCurrencyInfo;
        this.currencyCode = null;
    }

    /**
     * Gets the 401K source for the transaction. Should be one of "PRETAX", "AFTERTAX", "MATCH",
     * "PROFITSHARING", "ROLLOVER", "OTHERVEST", "OTHERNONVEST".  This is an optional field
     * according to the OFX spec.
     *
     * @return the 401k source
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "INV401KSOURCE", order = 180)
    public String get401kSource() {
        return inv401kSource;
    }

    /**
     * Sets the 401K source for the transaction. Should be one of "PRETAX", "AFTERTAX", "MATCH",
     * "PROFITSHARING", "ROLLOVER", "OTHERVEST", "OTHERNONVEST".  This is an optional field
     * according to the OFX spec.
     *
     * @param inv401kSource the 401k source
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void set401kSource(String inv401kSource) {
        this.inv401kSource = inv401kSource;
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
        return "InvestmentExpenseTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "securityId=" + securityId +
                ", total=" + total +
                ", subAccountSecurity='" + subAccountSecurity + '\'' +
                ", subAccountFund='" + subAccountFund + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", originalCurrencyInfo=" + originalCurrencyInfo +
                ", inv401kSource='" + inv401kSource + '\'' +
                "}";
    }
}
