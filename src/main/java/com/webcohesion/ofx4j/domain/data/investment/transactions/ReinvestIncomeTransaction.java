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
 * Transaction for reinvestment transactions.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("REINVEST")
public class ReinvestIncomeTransaction extends BaseOtherInvestmentTransaction
        implements TransactionWithSecurity {

    private SecurityId securityId;
    private String incomeType;
    private Double total;
    private String subAccountSecurity;
    private Double units;
    private Double unitPrice;
    private Double commission;
    private Double taxes;
    private Double fees;
    private Double load;
    private Boolean taxExempt;
    private String currencyCode;
    private OriginalCurrency originalCurrencyInfo;
    private String inv401kSource;

    public ReinvestIncomeTransaction() {
        super(TransactionType.REINVEST_INCOME);
    }

    /**
     * Gets the id of the security that was reinvested in. This is a required field according to the
     * OFX spec.
     *
     * @return the security id of the security that was reinvested in
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @ChildAggregate(required = true, order = 20)
    public SecurityId getSecurityId() {
        return securityId;
    }

    /**
     * Sets the id of the security that was reinvested in. This is a required field according to the
     * OFX spec.
     *
     * @param securityId the security id of the security that was reinvested in
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setSecurityId(SecurityId securityId) {
        this.securityId = securityId;
    }

    /**
     * Gets the type of income. One of "CGLONG" (long term capital gains), "CGSHORT" (short term
     * capital gains), "DIV" (dividend), INTEREST, or MISC. This is a required field according to the
     * OFX spec.
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
     * capital gains), "DIV" (dividend), INTEREST, or MISC. This is a required field according to the
     * OFX spec.
     *
     * @param incomeType the type of income
     * @see "Section 13.9.2.4.4, OFX Spec" This is a required field according to the OFX spec.
     */
    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    /**
     * Gets the type of income as one of the well-known types.
     *
     * @return the income type or null if it's not one of the well-known types
     */
    public IncomeType getIncomeTypeEnum() {
        return IncomeType.fromOfx(getIncomeType());
    }

    /**
     * Gets the total income received. This is a required field according to the OFX spec.
     *
     * @return the total
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "TOTAL", required = true, order = 40)
    public Double getTotal() {
        return total;
    }

    /**
     * Sets the total income received. This is a required field according to the OFX spec.
     *
     * @param total the total
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Gets the sub account type for the security (e.g. CASH, MARGIN, SHORT, OTHER). This is a
     * required field according to the OFX spec.
     *
     * @return the sub account type
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "SUBACCTSEC", order = 50)
    public String getSubAccountSecurity() {
        return subAccountSecurity;
    }

    /**
     * Sets the sub account type for the security (e.g. CASH, MARGIN, SHORT, OTHER). This is a
     * required field according to the OFX spec.
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
     * @return the type of null if it wasn't one of the well known types
     */
    public SubAccountType getSubAccountSecurityEnum() {
        return SubAccountType.fromOfx(getSubAccountSecurity());
    }

    /**
     * Gets the number of units of the security that was reinvested in. This is a required field
     * according to the OFX spec.
     *
     * @return the number of units purchased
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "UNITS", required = true, order = 60)
    public Double getUnits() {
        return units;
    }

    /**
     * Sets the number of units of the security that was reinvested in. This is a required field
     * according to the OFX spec.
     *
     * @param units the number of units purchased
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setUnits(Double units) {
        this.units = units;
    }

    /**
     * Gets the price per commonly-quoted unit. This is a required field according to the OFX spec.
     *
     * @return the per unit price
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "UNITPRICE", required = true, order = 70)
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the price per commonly-quoted unit. This is a required field according to the OFX spec.
     *
     * @param unitPrice the per unit price
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets the transaction commission for the reinvestment. This is an optional field according to
     * the OFX spec.
     *
     * @return the transaction commision
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "COMMISSION", order = 80)
    public Double getCommission() {
        return commission;
    }

    /**
     * Sets the transaction commission for the reinvestment. This is an optional field according to
     * the OFX spec.
     *
     * @param commission the transaction commision
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    /**
     * Gets the taxes for the reinvestment. This is an optional field according to the OFX spec.
     *
     * @return the transaction taxes
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "TAXES", order = 90)
    public Double getTaxes() {
        return taxes;
    }

    /**
     * Sets the taxes for the reinvestment. This is an optional field according to the OFX spec.
     *
     * @param taxes the transaction taxes
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    /**
     * Gets the fees for the reinvestment. This is an optional field according to the OFX spec.
     *
     * @return the transaction fees
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "FEES", order = 100)
    public Double getFees() {
        return fees;
    }

    /**
     * Sets the fees for the reinvestment. This is an optional field according to the OFX spec.
     *
     * @param fees the transaction fees
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setFees(Double fees) {
        this.fees = fees;
    }

    /**
     * Gets the load for the reinvestment. This is an optional field according to the OFX spec.
     *
     * @return the load
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "LOAD", order = 110)
    public Double getLoad() {
        return load;
    }

    /**
     * Sets the load for the reinvestment. This is an optional field according to the OFX spec.
     *
     * @param load the load
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setLoad(Double load) {
        this.load = load;
    }

    /**
     * Gets whether the income was tax exempt. This is an optional field according to the OFX spec.
     *
     * @return whether the transaction was tax exempt
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "TAXEXEMPT", order = 120)
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
     * Gets the currency code for the transaction. Only one of currency code or original currency
     * info should be set according to the OFX spec. If neither are set, means the default currency.
     *
     * @return the currency code for the transaction
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "CURRENCY", order = 130)
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
     * @return the original currency info for the transaction.
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "ORIGCURRENCY", order = 140)
    public OriginalCurrency getOriginalCurrencyInfo() {
        return originalCurrencyInfo;
    }

    /**
     * Sets the original currency info for the transaction.
     *
     * @param originalCurrencyInfo the original currency info for the transaction.
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setOriginalCurrencyInfo(OriginalCurrency originalCurrencyInfo) {
        this.originalCurrencyInfo = originalCurrencyInfo;
        this.currencyCode = null;
    }

    /**
     * Gets the 401K source for the reinvestment. Should be one of "PRETAX", "AFTERTAX", "MATCH",
     * "PROFITSHARING", "ROLLOVER", "OTHERVEST", "OTHERNONVEST".  This is an optional field
     * according to the OFX spec.
     *
     * @return the state withholding
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "INV401KSOURCE", order = 150)
    public String get401kSource() {
        return inv401kSource;
    }

    /**
     * Sets the 401K source for the reinvestment. Should be one of "PRETAX", "AFTERTAX", "MATCH",
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
     * @return the type of close or null if it's not well known
     */
    public Inv401KSource get401kSourceEnum() {
        return Inv401KSource.fromOfx(get401kSource());
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "ReinvestIncomeTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "securityId=" + securityId +
                ", incomeType='" + incomeType + '\'' +
                ", total=" + total +
                ", subAccountSecurity='" + subAccountSecurity + '\'' +
                ", units=" + units +
                ", unitPrice=" + unitPrice +
                ", commission=" + commission +
                ", taxes=" + taxes +
                ", fees=" + fees +
                ", load=" + load +
                ", taxExempt=" + taxExempt +
                ", currencyCode='" + currencyCode + '\'' +
                ", originalCurrencyInfo=" + originalCurrencyInfo +
                ", inv401kSource='" + inv401kSource + '\'' +
                "}";
    }
}
