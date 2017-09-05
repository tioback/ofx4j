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

package com.webcohesion.ofx4j.domain.data.signup;

import com.webcohesion.ofx4j.domain.data.MessageSetType;
import com.webcohesion.ofx4j.domain.data.ResponseMessage;
import com.webcohesion.ofx4j.domain.data.ResponseMessageSet;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan Heaton
 */
@Aggregate("SIGNUPMSGSRSV1")
public class SignupResponseMessageSet extends ResponseMessageSet {

    private AccountInfoResponseTransaction accountInfoResponse;

    public MessageSetType getType() {
        return MessageSetType.signup;
    }

    /**
     * The account info response.
     *
     * @return The account info response.
     */
    @ChildAggregate(order = 0)
    public AccountInfoResponseTransaction getAccountInfoResponse() {
        return accountInfoResponse;
    }

    /**
     * The account info response.
     *
     * @param accountInfoResponse The account info response.
     */
    public void setAccountInfoResponse(AccountInfoResponseTransaction accountInfoResponse) {
        this.accountInfoResponse = accountInfoResponse;
    }

    /**
     * The response messages.
     *
     * @return The response messages.
     */
    public List<ResponseMessage> getResponseMessages() {
        ArrayList<ResponseMessage> messages = new ArrayList<ResponseMessage>();

        if (getAccountInfoResponse() != null) {
            messages.add(getAccountInfoResponse());
        }

        return messages;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "SignupResponseMessageSet{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "accountInfoResponse=" + accountInfoResponse +
                "}";
    }
}