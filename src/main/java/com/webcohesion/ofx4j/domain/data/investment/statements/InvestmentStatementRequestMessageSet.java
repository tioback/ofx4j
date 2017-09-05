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

import com.webcohesion.ofx4j.domain.data.MessageSetType;
import com.webcohesion.ofx4j.domain.data.RequestMessage;
import com.webcohesion.ofx4j.domain.data.RequestMessageSet;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;

import java.util.ArrayList;
import java.util.List;

/**
 * Investment statement request message set.
 *
 * @author Jon Perlow
 * @see "Section 13.7.1.2.1, OFX Spec"
 */
@Aggregate("INVSTMTMSGSRQV1")
public class InvestmentStatementRequestMessageSet extends RequestMessageSet {

    private InvestmentStatementRequestTransaction statementRequest;

    public MessageSetType getType() {
        return MessageSetType.investment;
    }

    /**
     * Gets the statement request.
     *
     * @return the request
     */
    @ChildAggregate(order = 0)
    public InvestmentStatementRequestTransaction getStatementRequest() {
        return statementRequest;
    }

    /**
     * Sets the statement request.
     *
     * @param statementRequest the request
     */
    public void setStatementRequest(InvestmentStatementRequestTransaction statementRequest) {
        this.statementRequest = statementRequest;
    }

    // Inherited.
    public List<RequestMessage> getRequestMessages() {
        ArrayList<RequestMessage> requestMessages = new ArrayList<RequestMessage>();
        if (getStatementRequest() != null) {
            requestMessages.add(getStatementRequest());
        }
        return requestMessages;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "InvestmentStatementRequestMessageSet{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "statementRequest=" + statementRequest +
                "}";
    }
}
