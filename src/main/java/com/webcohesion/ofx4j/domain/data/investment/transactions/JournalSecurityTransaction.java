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
 * Transaction for journal security transactions between sub-accounts within the same investment
 * account.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("JRNLSEC")
public class JournalSecurityTransaction extends BaseOtherInvestmentTransaction
        implements TransactionWithSecurity {

    private SecurityId securityId;
    private String subAccountFrom;
    private String subAccountTo;
    private Double total;

    public JournalSecurityTransaction() {
        super(TransactionType.JOURNAL_SECURITY);
    }

    /**
     * Gets the id of the security that was transferred. This is a required field according to the OFX
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
     * Sets the id of the security that was transferred. This is a required field according to the OFX
     * spec.
     *
     * @param securityId the security id of the security that was bought
     * @see "Section 13.9.2.4.3, OFX Spec"
     */
    public void setSecurityId(SecurityId securityId) {
        this.securityId = securityId;
    }

    /**
     * Gets the sub account type the transer is from (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "SUBACCTFROM", order = 30)
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
    @Element(name = "SUBACCTTO", order = 40)
    public String getToSubAccountFund() {
        return subAccountTo;
    }

    /**
     * sets the sub account type that the transfer is to (e.g. CASH, MARGIN, SHORT, OTHER).
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
    @Element(name = "TOTAL", order = 50)
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
        return "JournalSecurityTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "securityId=" + securityId +
                ", subAccountFrom='" + subAccountFrom + '\'' +
                ", subAccountTo='" + subAccountTo + '\'' +
                ", total=" + total +
                "}";
    }
}
