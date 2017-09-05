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
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.Element;

/**
 * Transaction for journal fund transactions between sub-accounts within the same investment
 * account.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("JRNLFUND")
public class JournalFundTransaction extends BaseOtherInvestmentTransaction {

    private String subAccountFrom;
    private String subAccountTo;
    private Double total;

    public JournalFundTransaction() {
        super(TransactionType.JOURNAL_FUND);
    }

    /**
     * Gets the sub account type the transer is from (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "SUBACCTFROM", order = 20)
    public String getFromSubAccountFund() {
        return subAccountFrom;
    }

    /**
     * Sets the sub account type the transer is from (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @param subAccountFrom the sub account type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setFromSubAccountFund(String subAccountFrom) {
        this.subAccountFrom = subAccountFrom;
    }

    /**
     * Gets the result of getFromSubAccountFund as one of the well-known types.
     *
     * @return the type of null if it wasn't one of the well known types.
     */
    public SubAccountType getFromSubAccountFundEnum() {
        return SubAccountType.fromOfx(getFromSubAccountFund());
    }

    /**
     * Gets the sub account type that the transfer is to (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account fund
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "SUBACCTTO", order = 30)
    public String getToSubAccountFund() {
        return subAccountTo;
    }

    /**
     * Sets the sub account type that the transfer is to (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @param subAccountTo the sub account fund
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setToSubAccountFund(String subAccountTo) {
        this.subAccountTo = subAccountTo;
    }

    /**
     * Gets the result of getToSubAccountFund as one of the well-known types.
     *
     * @return the type of null if it wasn't one of the well known types.
     */
    public SubAccountType getToSubAccountFundEnum() {
        return SubAccountType.fromOfx(getToSubAccountFund());
    }

    /**
     * Gets the total for the transaction.
     *
     * @return the total
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "TOTAL", order = 40)
    public Double getTotal() {
        return total;
    }

    /**
     * Sets the total for the transaction.
     *
     * @param total the total
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "JournalFundTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "subAccountFrom='" + subAccountFrom + '\'' +
                ", subAccountTo='" + subAccountTo + '\'' +
                ", total=" + total +
                "}";
    }
}
