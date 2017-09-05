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
 * Transaction for investment income that is realized as cash into the investment account.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("INCOME")
public class IncomeTransaction extends BaseOtherInvestmentTransaction
        implements TransactionWithSecurity {

    private SecurityId securityId;
    private String incomeType;
    private Double total;
    private String subAccountSecurity;
    private String subAccountFund;
    private Boolean taxExempt;
    private Double withholding;
    private String currencyCode;
    private OriginalCurrency originalCurrencyInfo;
    private String inv401kSource;

    public IncomeTransaction() {
        super(TransactionType.INCOME);
    }

    /**
     * Gets the id of the security that the income was for. This is a required field according to the
     * OFX spec.
     *
     * @return the security id of the security that the income was for
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @ChildAggregate(required = true, order = 20)
    public SecurityId getSecurityId() {
        return securityId;
    }

    /**
     * Sets the id of the security that the income was for. This is a required field according to the
     * OFX spec.
     *
     * @param securityId the security id of the security that the income was for
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setSecurityId(SecurityId securityId) {
        this.securityId = securityId;
    }

    /**
     * Gets the type of income. One of "CGLONG" (long term capital gains), "CGSHORT" (short term
     * capital gains), "DIV" (dividend), INTEREST, or MISC>
     *
     * @return the type of income
     * @see "Section 13.9.2.4.4, OFX Spec" This is a required field according to the OFX spec.
     */
    @Element(name = "INCOMETYPE", required = true, order = 30)
    public String getIncomeType() {
        return incomeType;
    }

    /**
     * Sets the type of income. One of "CGLONG" (long term capital gains), "CGSHORT" (short term
     * capital gains), "DIV" (dividend), INTEREST, or MISC>
     *
     * @param incomeType the type of income
     * @see "Section 13.9.2.4.4, OFX Spec" This is a required field according to the OFX spec.
     */
    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    /**
     * Gets the income type as one of the well-known types.
     *
     * @return the income type or null if it's not well known
     */
    public IncomeType getIncomeTypeEnum() {
        return IncomeType.fromOfx(getIncomeType());
    }

    /**
     * Gets the total income received.
     *
     * @return the total
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "TOTAL", required = true, order = 40)
    public Double getTotal() {
        return total;
    }

    /**
     * Sets the total income received.
     *
     * @param total the total
     * @see "Section 13.9.2.4.4, OFX Spec"
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
    @Element(name = "SUBACCTSEC", order = 50)
    public String getSubAccountSecurity() {
        return subAccountSecurity;
    }

    /**
     * Sets the sub account type for the security (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @param subAcctSec the sub account type
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setSubAccountSecurity(String subAcctSec) {
        this.subAccountSecurity = subAcctSec;
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
     * Gets the sub account type that the security is from (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account fund for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "SUBACCTFUND", order = 60)
    public String getSubAccountFund() {
        return subAccountFund;
    }

    /**
     * Sets the sub account type that the security is from (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @param subAcctFund the sub account fund for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setSubAccountFund(String subAcctFund) {
        this.subAccountFund = subAcctFund;
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
     * Gets whether the income was tax exempt. This is an optional field according to the OFX spec.
     *
     * @return whether the transaction was tax exempt
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "TAXEXEMPT", order = 70)
    public Boolean getTaxExempt() {
        return taxExempt;
    }

    /**
     * Sets whether the income was tax exempt. This is an optional field according to the OFX spec.
     *
     * @param taxExempt whether the transaction was tax exempt
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setTaxExempt(Boolean taxExempt) {
        this.taxExempt = taxExempt;
    }

    /**
     * Gets the withholding for the income. This is an optional field according to the OFX spec.
     *
     * @return the withholding
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "WITHHOLDING", order = 80)
    public Double getWithholding() {
        return withholding;
    }

    /**
     * Sets the withholding for the income. This is an optional field according to the OFX spec.
     *
     * @param withholding the withholding
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setWithholding(Double withholding) {
        this.withholding = withholding;
    }

    /**
     * Gets the currency code for the transaction. Only one of currency code or original currency
     * info should be set according to the OFX spec. If neither are set, means the default currency.
     *
     * @return the currency code for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "CURRENCY", order = 90)
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the currency code for the transaction. Only one of currency code or original currency
     * info should be set according to the OFX spec. If neither are set, means the default currency.
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
     * @return the currency info for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @ChildAggregate(order = 120)
    public OriginalCurrency getOriginalCurrencyInfo() {
        return originalCurrencyInfo;
    }

    /**
     * Sets the original currency info for the transaction.
     *
     * @param originalCurrencyInfo the currency info for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setOriginalCurrencyInfo(OriginalCurrency originalCurrencyInfo) {
        this.originalCurrencyInfo = originalCurrencyInfo;
        this.currencyCode = null;
    }

    /**
     * Gets the 401K source for the sale. Should be one of "PRETAX", "AFTERTAX", "MATCH",
     * "PROFITSHARING", "ROLLOVER", "OTHERVEST", "OTHERNONVEST".  This is an optional field
     * according to the OFX spec.
     *
     * @return the state withholding
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "INV401KSOURCE", order = 110)
    public String get401kSource() {
        return inv401kSource;
    }

    /**
     * Sets the 401K source for the sale. Should be one of "PRETAX", "AFTERTAX", "MATCH",
     * "PROFITSHARING", "ROLLOVER", "OTHERVEST", "OTHERNONVEST".  This is an optional field
     * according to the OFX spec.
     *
     * @param inv401kSource the state withholding
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void set401kSource(String inv401kSource) {
        this.inv401kSource = inv401kSource;
    }

    /**
     * Gets the 401(k) source as one of the well-known types.
     *
     * @return the type of close or null if it's not well known.
     */
    public Inv401KSource get401kSourceEnum() {
        return Inv401KSource.fromOfx(get401kSource());
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "IncomeTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "securityId=" + securityId +
                ", incomeType='" + incomeType + '\'' +
                ", total=" + total +
                ", subAccountSecurity='" + subAccountSecurity + '\'' +
                ", subAccountFund='" + subAccountFund + '\'' +
                ", taxExempt=" + taxExempt +
                ", withholding=" + withholding +
                ", currencyCode='" + currencyCode + '\'' +
                ", originalCurrencyInfo=" + originalCurrencyInfo +
                ", inv401kSource='" + inv401kSource + '\'' +
                "}";
    }
}
