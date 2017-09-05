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

package com.webcohesion.ofx4j.domain.data.investment.positions;

import com.webcohesion.ofx4j.domain.data.investment.accounts.SubAccountType;
import com.webcohesion.ofx4j.domain.data.seclist.SecurityId;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;
import com.webcohesion.ofx4j.meta.Element;

import java.util.Date;

/**
 * Class for the investment position aggregate.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.6.1, OFX Spec"
 */
@Aggregate("INVPOS")
public class InvestmentPosition {

    private SecurityId securityId;
    private String heldInAccount;
    private String positionType;
    private Double units;
    private Double unitPrice;
    private Double marketValue;
    private Date marketValueDate;
    private String currencyCode;
    private String memo;
    private String inv401kSource;

    /**
     * Gets the security id for the position. This is a required field according to the OFX spec.
     *
     * @return the security id for the position
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    @ChildAggregate(required = true, order = 10)
    public SecurityId getSecurityId() {
        return securityId;
    }

    /**
     * Sets the security id for the position. This is a required field according to the OFX spec.
     *
     * @param securityId the security id for the position
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    public void setSecurityId(SecurityId securityId) {
        this.securityId = securityId;
    }

    /**
     * Gets the sub-account type. One of "CASH", "MARGIN", "SHORT", "OTHER". This is a required field
     * according to the OFX spec.
     *
     * @return the sub-account type
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    @Element(name = "HELDINACCT", required = true, order = 20)
    public String getHeldInAccount() {
        return heldInAccount;
    }

    /**
     * Sets the sub-account type. One of "CASH", "MARGIN", "SHORT", "OTHER". This is a required field
     * according to the OFX spec.
     *
     * @param heldInAccount the sub-account type
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    public void setHeldInAccount(String heldInAccount) {
        this.heldInAccount = heldInAccount;
    }

    /**
     * Gets the sub-account type as one of the well-known types.
     *
     * @return the sub-account type or null if it's not one of the well-known types
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    SubAccountType getHeldInAccountEnum() {
        return SubAccountType.fromOfx(getHeldInAccount());
    }

    /**
     * Gets the position type. One of SHORT or LONG. This is a required field according to the OFX
     * spec.
     *
     * @return the position type
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    @Element(name = "POSTYPE", required = true, order = 30)
    public String getPositionType() {
        return positionType;
    }

    /**
     * Sets the position type. One of SHORT or LONG. This is a required field according to the OFX
     * spec.
     *
     * @param positionType the position type
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    /**
     * Gets the position type as one of the well-known types.
     *
     * @return the position type or null if it's not one of the well-known types
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    public PositionType getPositionTypeEnum() {
        return PositionType.fromOfx(getPositionType());
    }

    /**
     * Gets the number of units in the position. For stocks, mutual funds, and others, this
     * is the number of shares. For bonds, this is the face value. For options, this is the number of
     * contacts. This is a required field according to the OFX spec.
     *
     * @return the number of units in the position
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    @Element(name = "UNITS", required = true, order = 40)
    public Double getUnits() {
        return units;
    }

    /**
     * Sets the number of units in the position. For stocks, mutual funds, and others, this
     * is the number of shares. For bonds, this is the face value. For options, this is the number of
     * contacts. This is a required field according to the OFX spec.
     *
     * @param units the number of units in the position
     * @see "Section 13.9.2.6.1, OFX Spec"
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
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    @Element(name = "UNITPRICE", required = true, order = 50)
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the price per commonly-quoted unit. For stocks, mutual funds, and others, this is the
     * share price. For bonds, this is the percentage of par. For options, this is the per share (not
     * per contact) price. This is a required field according to the OFX spec.
     *
     * @param unitPrice the per unit price
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets the market value of this position. This is a required field according to the OFX spec.
     *
     * @return the market value of the position
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    @Element(name = "MKTVAL", required = true, order = 60)
    public Double getMarketValue() {
        return marketValue;
    }

    /**
     * Sets the market value of this position. This is a required field according to the OFX spec.
     *
     * @param marketValue the market value of the position
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    /**
     * Gets the date and time of the unit price and market value. This is a required field according
     * to the OFX spec.
     *
     * @return the market value date
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    @Element(name = "DTPRICEASOF", required = true, order = 70)
    public Date getMarketValueDate() {
        return marketValueDate;
    }

    /**
     * Sets the date and time of the unit price and market value. This is a required field according
     * to the OFX spec.
     *
     * @param marketValueDate the market value date
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    public void setMarketValueDate(Date marketValueDate) {
        this.marketValueDate = marketValueDate;
    }

    /**
     * Gets the currency code of the position. This is an optional field according to the OFX spec.
     * If not present, it's the default currency of the account.
     *
     * @return the currency code of the position or null for the default currency
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    @Element(name = "CURRENCY", order = 80)
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the currency code of the position. This is an optional field according to the OFX spec.
     * If not present, it's the default currency of the account.
     *
     * @param currencyCode the currency code of the position or null for the default currency
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * Gets the memo associated with the position. This is an optional field according to the OFX
     * spec.
     *
     * @return the memo
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    @Element(name = "MEMO", order = 90)
    public String getMemo() {
        return memo;
    }

    /**
     * Sets the memo associated with the position. This is an optional field according to the OFX
     * spec.
     *
     * @param memo the memo
     * @see "Section 13.9.2.6.1, OFX Spec"
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * Gets the 401K source for the sale. Should be one of "PRETAX", "AFTERTAX", "MATCH",
     * "PROFITSHARING", "ROLLOVER", "OTHERVEST", "OTHERNONVEST".  This is an optional field
     * according to the OFX spec.
     *
     * @return the 401k source
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    @Element(name = "INV401KSOURCE", order = 100)
    public String get401kSource() {
        return inv401kSource;
    }

    /**
     * Sets the 401K source for the sale. Should be one of "PRETAX", "AFTERTAX", "MATCH",
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
     * @return the 401k source or null if it's not one of the well-known types
     */
    public Inv401KSource get401kSourceEnum() {
        return Inv401KSource.fromOfx(get401kSource());
    }

    @Override
    public String toString() {
        return "InvestmentPosition{" +
                "securityId=" + securityId +
                ", heldInAccount='" + heldInAccount + '\'' +
                ", positionType='" + positionType + '\'' +
                ", units=" + units +
                ", unitPrice=" + unitPrice +
                ", marketValue=" + marketValue +
                ", marketValueDate=" + marketValueDate +
                ", currencyCode='" + currencyCode + '\'' +
                ", memo='" + memo + '\'' +
                ", inv401kSource='" + inv401kSource + '\'' +
                "}";
    }
}
