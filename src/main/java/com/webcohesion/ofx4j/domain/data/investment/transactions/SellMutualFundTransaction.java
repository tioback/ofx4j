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
 * Transaction for selling mutual fund.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("SELLMF")
public class SellMutualFundTransaction extends BaseSellInvestmentTransaction {

    private String sellType;
    private Double averageCostBasis;
    private String relatedTransactionId;

    public SellMutualFundTransaction() {
        super(TransactionType.SELL_MUTUAL_FUND);
    }

    /**
     * Gets the type of sale. One of "SELL" or "SELLSHORT".
     *
     * @return The type of sale
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "SELLTYPE", order = 20)
    public String getSellType() {
        return sellType;
    }

    /**
     * Sets the type of sale. One of "SELL" or "SELLSHORT".
     *
     * @param sellType The type of sale
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setSellType(String sellType) {
        this.sellType = sellType;
    }

    /**
     * Gets the sell type as one of the well-known types.
     *
     * @return the type of sale or null if it's not known.
     */
    public SellType getSellTypeEnum() {
        return SellType.fromOfx(sellType);
    }

    /**
     * Gets the average cost basis of the sale.
     *
     * @return The average cost basis of the sale
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "AVGCOSTBASIS", order = 30)
    public Double getAverageCostBasis() {
        return averageCostBasis;
    }

    /**
     * Sets the average cost basis of the sale.
     *
     * @param averageCostBasis The average cost basis of the sale
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setAverageCostBasis(Double averageCostBasis) {
        this.averageCostBasis = averageCostBasis;
    }

    /**
     * Gets any related transaction id for a mutual fund sale (e.g. for a mutual fund exchange).
     * This is an optional field according to the OFX spec.
     *
     * @return the related transaction id
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "RELFITID", order = 40)
    public String getRelatedTransactionId() {
        return relatedTransactionId;
    }

    /**
     * Sets any related transaction id for a mutual fund sale (e.g. for a mutual fund exchange).
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
        return "SellMutualFundTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "sellType='" + sellType + '\'' +
                ", averageCostBasis=" + averageCostBasis +
                ", relatedTransactionId='" + relatedTransactionId + '\'' +
                "}";
    }
}
