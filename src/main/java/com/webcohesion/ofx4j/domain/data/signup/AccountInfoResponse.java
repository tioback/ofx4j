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

import com.webcohesion.ofx4j.domain.data.ResponseMessage;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;
import com.webcohesion.ofx4j.meta.Element;

import java.util.Collection;
import java.util.Date;

/**
 * @author Ryan Heaton
 */
@Aggregate("ACCTINFORS")
public class AccountInfoResponse extends ResponseMessage {

    private Date lastUpdated = new Date(0); //default is never updated.
    private Collection<AccountProfile> accounts;

    public String getResponseMessageName() {
        return "account info";
    }

    /**
     * When the account info was last updated.
     *
     * @return When the account info was last updated.
     */
    @Element(name = "DTACCTUP", required = true, order = 0)
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * When the account info was last updated.
     *
     * @param lastUpdated When the account info was last updated.
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * The accounts.
     *
     * @return The accounts.
     */
    @ChildAggregate(order = 10)
    public Collection<AccountProfile> getAccounts() {
        return accounts;
    }

    /**
     * The accounts.
     *
     * @param accounts The accounts.
     */
    public void setAccounts(Collection<AccountProfile> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "AccountInfoResponse{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "lastUpdated=" + lastUpdated +
                ", accounts=" + accounts +
                "}";
    }
}