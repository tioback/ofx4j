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
 * Transaction for buying options.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.4.4, OFX Spec"
 */
@Aggregate("BUYOPT")
public class BuyOptionTransaction extends BaseBuyInvestmentTransaction {

    private String optionBuyType;
    private Integer sharesPerContact;

    public BuyOptionTransaction() {
        super(TransactionType.BUY_OPTION);
    }

    /**
     * Gets the type of option purchase (i.e. "BUYTOOPEN" or "BUYTOCLOSE"). This is a required field
     * according to the OFX spec.
     *
     * @return the option buy type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "OPTBUYTYPE", required = true, order = 20)
    public String getOptionBuyType() {
        return optionBuyType;
    }

    /**
     * Sets the type of option purchase (i.e. "BUYTOOPEN" or "BUYTOCLOSE"). This is a required field
     * according to the OFX spec.
     *
     * @param optionBuyType the option buy type
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setOptionBuyType(String optionBuyType) {
        this.optionBuyType = optionBuyType;
    }

    /**
     * Gets the option buy type as one of the well-known types.
     *
     * @return the type of purchase or null if it's not known
     */
    public OptionBuyType getOptionBuyTypeEnum() {
        return OptionBuyType.fromOfx(optionBuyType);
    }

    /**
     * Gets the number of shares per contact. This is a required field according to the OFX spec.
     *
     * @return the number of shares per contact
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    @Element(name = "SHPERCTRCT", required = true, order = 30)
    public Integer getSharesPerContract() {
        return sharesPerContact;
    }

    /**
     * Sets the number of shares per contact. This is a required field according to the OFX spec.
     *
     * @param sharesPerContact the number of shares per contact
     * @see "Section 13.9.2.4.4, OFX Spec"
     */
    public void setSharesPerContract(Integer sharesPerContact) {
        this.sharesPerContact = sharesPerContact;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "BuyOptionTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "optionBuyType='" + optionBuyType + '\'' +
                ", sharesPerContact=" + sharesPerContact +
                "}";
    }
}
