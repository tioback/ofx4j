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

package com.webcohesion.ofx4j.domain.data.investment.statements;

import com.webcohesion.ofx4j.domain.data.TransactionWrappedResponseMessage;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;

/**
 * Investment statement transaction response.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.1, OFX Spec"
 */
@Aggregate("INVSTMTTRNRS")
public class InvestmentStatementResponseTransaction
        extends TransactionWrappedResponseMessage<InvestmentStatementResponse> {

    private InvestmentStatementResponse message;

    /**
     * Gets the the statement response message.
     *
     * @return the statement response message.
     */
    @ChildAggregate(required = true, order = 30)
    public InvestmentStatementResponse getMessage() {
        return message;
    }

    /**
     * Sets the the statement response message.
     *
     * @param message the statement response message.
     */
    public void setMessage(InvestmentStatementResponse message) {
        this.message = message;
    }

    // Inherited.
    public InvestmentStatementResponse getWrappedMessage() {
        return getMessage();
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "InvestmentStatementResponseTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "message=" + message +
                "}";
    }
}
