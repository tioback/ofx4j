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

import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.Element;

/**
 * Original currency aggregate ("ORIGCURRENCY"). For investment transactions in other currencies,
 * the financial institution can report the transaction as converted into the default currency
 * and then include this child aggregate to report what the original currency was and what the
 * rate of conversion was.
 *
 * @author Jon Perlow
 * @see "Section 5.2, OFX Spec"
 */
@Aggregate("ORIGCURRENCY")
public class OriginalCurrency {

    private double currencyRate;
    private String currencyCode;

    /**
     * Gets the rate of currency conversion. This is the ratio of "CURDEF" (the default currency in
     * the transaction response) to "CURSYM" (the original currency code below).
     *
     * @return the currency rate
     */
    @Element(name = "CURRATE", required = true, order = 10)
    public double getCurrencyRate() {
        return currencyRate;
    }

    /**
     * Sets the rate of currency conversion. This is the ratio of "CURDEF" (the default currency in
     * the transaction response) to "CURSYM" (the original currency code below).
     *
     * @param currencyRate the currency rate
     */
    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    /**
     * Gets the ISO-4217 3-letter currency identifier of the original currency.
     *
     * @return the currency code
     * @see java.util.Currency#getCurrencyCode()
     */
    @Element(name = "CURSYM", required = true, order = 20)
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the ISO-4217 3-letter currency identifier of the original currency.
     *
     * @param currencyCode the currency code
     * @see java.util.Currency#getCurrencyCode()
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "OriginalCurrency{" +
                "currencyRate=" + currencyRate +
                ", currencyCode='" + currencyCode + '\'' +
                "}";
    }
}
