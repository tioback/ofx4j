/*
 * Copyright 2008 Web Cohesion
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
package com.webcohesion.ofx4j.domain.data.tax1099;

import com.webcohesion.ofx4j.domain.data.MessageSetType;
import com.webcohesion.ofx4j.domain.data.ResponseMessage;
import com.webcohesion.ofx4j.domain.data.ResponseMessageSet;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Aparna Gawali
 * aparna.gawali@sungard.com
 */
@Aggregate("TAX1099MSGSRSV1")
public class Tax1099ResponseMessageSet extends ResponseMessageSet {

    private List<Tax1099ResponseTransaction> taxResponseTransaction;

    public MessageSetType getType() {
        return MessageSetType.tax1099;
    }

    /**
     * The taxResponseTransaction list.
     * <p>
     * Most OFX files have a single statement response, except MT2OFX
     * which outputs OFX with multiple statement responses
     * in a single banking response message set.
     *
     * @return The taxResponseTransaction list.
     */
    @ChildAggregate(order = 0)
    public List<Tax1099ResponseTransaction> getTaxResponseTransaction() {
        return taxResponseTransaction;
    }

    public void setTaxResponseTransaction(Tax1099ResponseTransaction taxResponseTransaction) {
        this.taxResponseTransaction = Collections.singletonList(taxResponseTransaction);
    }

    /**
     * The taxResponseTransaction.
     *
     * @param taxResponseTransaction The statement responses.
     */
    public void setTaxResponseTransaction(List<Tax1099ResponseTransaction> taxResponseTransaction) {
        this.taxResponseTransaction = taxResponseTransaction;
    }

    // Inherited.
    public List<ResponseMessage> getResponseMessages() {
        return new ArrayList<ResponseMessage>(taxResponseTransaction);
    }

    /**
     * The first statement response.
     *
     * @return the first bank statement response.
     * @deprecated Use getStatementResponses() because sometimes there are multiple responses
     */
    public Tax1099ResponseTransaction getStatementResponse() {
        return taxResponseTransaction == null || taxResponseTransaction.isEmpty() ? null : taxResponseTransaction.get(0);
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "Tax1099ResponseMessageSet{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "taxResponseTransaction=" + taxResponseTransaction +
                "}";
    }
}