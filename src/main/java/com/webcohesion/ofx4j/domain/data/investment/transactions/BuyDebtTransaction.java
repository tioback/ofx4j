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
 * Transaction for buying debt (i.e. bonds, CDs, etc.,).
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("BUYDEBT")
public class BuyDebtTransaction extends BaseBuyInvestmentTransaction {

    private Double accruedInterest;

    public BuyDebtTransaction() {
        super(TransactionType.BUY_DEBT);
    }

    /**
     * Gets the amount of accrued interest on the debt. This is an optional field according to the
     * OFX spec.
     *
     * @return the amount of accrued interest
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "ACCRDINT", order = 20)
    public Double getAccruedInterest() {
        return accruedInterest;
    }

    /**
     * Sets the amount of accrued interest on the debt. This is an optional field according to the
     * OFX spec.
     *
     * @param accruedInterest the amount of accrued interest
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setAccruedInterest(Double accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "BuyDebtTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "accruedInterest=" + accruedInterest +
                "}";
    }
}
