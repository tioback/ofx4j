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
 * Transaction for buying mutual funds.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("BUYMF")
public class BuyMutualFundTransaction extends BaseBuyInvestmentTransaction {

    private String buyType;
    private String relatedTransactionId;

    public BuyMutualFundTransaction() {
        super(TransactionType.BUY_MUTUAL_FUND);
    }


    /**
     * Gets the type of purchase (i.e. "BUY" or "BUYTOCOVER"). This is a required field according to
     * the OFX spec.
     *
     * @return the buy type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "BUYTYPE", required = true, order = 20)
    public String getBuyType() {
        return buyType;
    }

    /**
     * Sets the type of purchase (i.e. "BUY" or "BUYTOCOVER"). This is a required field according to
     * the OFX spec.
     *
     * @param buyType the buy type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    /**
     * Gets the buy type as one of the well-known types.
     *
     * @return the type of purchase or null if it's not known
     */
    public BuyType getBuyTypeEnum() {
        return BuyType.fromOfx(buyType);
    }

    /**
     * Gets any related transaction id for a mutual fund purchase (e.g. for a mutual fund exchange).
     * This is an optional field according to the OFX spec.
     *
     * @return the related transaction id
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "RELFITID", order = 30)
    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    /**
     * Sets any related transaction id for a mutual fund purchase (e.g. for a mutual fund exchange).
     * This is an optional field according to the OFX spec.
     *
     * @param relatedTransactionId the related transaction id
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setRelatedTransactionId(String relatedTransactionId) {
        this.relatedTransactionId = relatedTransactionId;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "BuyMutualFundTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "buyType='" + buyType + '\'' +
                ", relatedTransactionId='" + relatedTransactionId + '\'' +
                "}";
    }
}
