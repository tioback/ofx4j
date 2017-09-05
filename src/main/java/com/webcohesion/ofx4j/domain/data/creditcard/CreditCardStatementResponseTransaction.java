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

import com.webcohesion.ofx4j.domain.data.TransactionWrappedResponseMessage;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;

/**
 * @author Ryan Heaton
 */
@Aggregate("CCSTMTTRNRS")
public class CreditCardStatementResponseTransaction extends TransactionWrappedResponseMessage<CreditCardStatementResponse> {

    private CreditCardStatementResponse message;

    /**
     * The message.
     *
     * @return The message.
     */
    @ChildAggregate(required = true, order = 30)
    public CreditCardStatementResponse getMessage() {
        return message;
    }

    /**
     * The message.
     *
     * @param message The message.
     */
    public void setMessage(CreditCardStatementResponse message) {
        this.message = message;
    }

    // Inherited.
    public CreditCardStatementResponse getWrappedMessage() {
        return getMessage();
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "CreditCardStatementResponseTransaction{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "message=" + message +
                '}';
    }
}