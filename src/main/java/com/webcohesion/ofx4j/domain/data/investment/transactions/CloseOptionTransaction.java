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
 * Transaction for closing an option position due to expiration, exercise, or assignment.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("CLOSUREOPT")
public class CloseOptionTransaction extends BaseOtherInvestmentTransaction
        implements TransactionWithSecurity {

    private SecurityId securityId;
    private String optionAction;
    private Double units;
    private Integer sharesPerContact;
    private String subAccountSecurity;
    private String relatedTransactionId;
    private Double gain;

    public CloseOptionTransaction() {
        super(TransactionType.CLOSE_OPTION);
    }

    /**
     * Gets the security id of the option.
     *
     * @return the security id of the option
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @ChildAggregate(order = 20)
    public SecurityId getSecurityId() {
        return securityId;
    }

    /**
     * Sets the security id of the option.
     *
     * @param securityId the security id of the option
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setSecurityId(SecurityId securityId) {
        this.securityId = securityId;
    }

    /**
     * Gets the action being performed (i.e. "EXERCISE", "ASSIGN", "EXPIRE" This is a required field
     * according to the OFX spec.
     *
     * @return the option action
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "OPTACTION", required = true, order = 30)
    public String getOptionAction() {
        return optionAction;
    }

    /**
     * Sets the action being performed (i.e. "EXERCISE", "ASSIGN", "EXPIRE" This is a required field
     * according to the OFX spec.
     *
     * @param optionAction the option action
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setOptionAction(String optionAction) {
        this.optionAction = optionAction;
    }

    /**
     * Gets the action as one of the well-known types.
     *
     * @return the type of close or null if it's not a well-known type
     */
    public CloseOptionAction getOptionActionEnum() {
        return CloseOptionAction.fromOfx(getOptionAction());
    }

    /**
     * Gets the number of units of the option that were closed. This is a required field according
     * to the OFX spec.
     *
     * @return the number of units closed
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "UNITS", required = true, order = 40)
    public Double getUnits() {
        return units;
    }

    /**
     * Sets the number of units of the option that were closed. This is a required field according
     * to the OFX spec.
     *
     * @param units the number of units closed
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setUnits(Double units) {
        this.units = units;
    }

    /**
     * Gets the number of shares per contact. This is a required field according to the OFX spec.
     *
     * @return the number of shares per contact
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "SHPERCTRCT", required = true, order = 50)
    public Integer getSharesPerContact() {
        return sharesPerContact;
    }

    /**
     * Sets the number of shares per contact. This is a required field according to the OFX spec.
     *
     * @param sharesPerContact the number of shares per contact
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setSharesPerContact(Integer sharesPerContact) {
        this.sharesPerContact = sharesPerContact;
    }

    /**
     * Gets the sub account type for the security (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @return the sub account type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "SUBACCTSEC", required = true, order = 60)
    public String getSubAccountSecurity() {
        return subAccountSecurity;
    }

    /**
     * Sets the sub account type for the security (e.g. CASH, MARGIN, SHORT, OTHER).
     *
     * @param subAccountSecurity the sub account type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setSubAccountSecurity(String subAccountSecurity) {
        this.subAccountSecurity = subAccountSecurity;
    }

    /**
     * Gets the result of getSubAccountFund as one of the well-known types.
     *
     * @return the type of null if it wasn't one of the well known types
     */
    public SubAccountType getSubAccountSecurityEnum() {
        return SubAccountType.fromOfx(getSubAccountSecurity());
    }

    /**
     * Gets the related transaction id for the related buy or sell corresponding to the
     * EXERCISE or ASSIGN action. This is a required field according to the OFX spec if the
     * action or EXERCISE or ASSIGN.
     *
     * @return the related transaction id
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "RELFITID", order = 70)
    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    /**
     * Sets the related transaction id for the related buy or sell corresponding to the
     * EXERCISE or ASSIGN action. This is a required field according to the OFX spec if the
     * action or EXERCISE or ASSIGN.
     *
     * @param relatedTransactionId the related transaction id
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
    }

    /**
     * Gets the gain related to the transaction. This is an optional field according to the OFX spec.
     *
     * @return the gain related to the transaction
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "GAIN", order = 80)
    public Double getGain() {
        return gain;
    }

    /**
     * Sets the gain related to the transaction. This is an optional field according to the OFX spec.
     *
     * @param gain the gain related to the transaction
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setGain(Double gain) {
        this.gain = gain;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "CloseOptionTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "securityId=" + securityId +
                ", optionAction='" + optionAction + '\'' +
                ", units=" + units +
                ", sharesPerContact=" + sharesPerContact +
                ", subAccountSecurity='" + subAccountSecurity + '\'' +
                ", relatedTransactionId='" + relatedTransactionId + '\'' +
                ", gain=" + gain +
                "}";
    }
}
