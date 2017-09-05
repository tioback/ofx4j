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
 * Transaction for selling stock.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("SELLSTOCK")
public class SellStockTransaction extends BaseSellInvestmentTransaction {

    private String sellType;

    public SellStockTransaction() {
        super(TransactionType.SELL_STOCK);
    }

    /**
     * Gets the type of stock sale (i.e. "SELL" or "SELLSHORT"). This is a required field
     * according to the OFX spec.
     *
     * @return the sell type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "SELLTYPE", required = true, order = 20)
    public String getSellType() {
        return sellType;
    }

    /**
     * Sets the type of stock sale (i.e. "SELL" or "SELLSHORT"). This is a required field
     * according to the OFX spec.
     *
     * @param sellType the sell type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setSellType(String sellType) {
        this.sellType = sellType;
    }

    /**
     * Gets the sell type as one of the well-known types.
     *
     * @return the type of sale or null if it's not known
     */
    public SellType getSellTypeEnum() {
        return SellType.fromOfx(sellType);
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "SellStockTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "sellType='" + sellType + '\'' +
                "}";
    }
}
