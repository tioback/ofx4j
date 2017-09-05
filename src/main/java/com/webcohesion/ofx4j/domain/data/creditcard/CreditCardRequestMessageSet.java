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

package com.webcohesion.ofx4j.domain.data.creditcard;

import com.webcohesion.ofx4j.domain.data.MessageSetType;
import com.webcohesion.ofx4j.domain.data.RequestMessage;
import com.webcohesion.ofx4j.domain.data.RequestMessageSet;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@Aggregate("CREDITCARDMSGSRQV1")
public class CreditCardRequestMessageSet extends RequestMessageSet {

    private CreditCardStatementRequestTransaction statementRequest;

    public MessageSetType getType() {
        return MessageSetType.creditcard;
    }

    /**
     * The request.
     *
     * @return The request.
     */
    @ChildAggregate(order = 0)
    public CreditCardStatementRequestTransaction getStatementRequest() {
        return statementRequest;
    }

    /**
     * The request.
     *
     * @param statementRequest The request.
     */
    public void setStatementRequest(CreditCardStatementRequestTransaction statementRequest) {
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
        return "CreditCardRequestMessageSet{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "statementRequest=" + statementRequest +
                '}';
    }
}
