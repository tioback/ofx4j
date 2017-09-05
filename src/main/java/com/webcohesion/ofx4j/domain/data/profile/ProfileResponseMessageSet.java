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

package com.webcohesion.ofx4j.domain.data.profile;

import com.webcohesion.ofx4j.domain.data.MessageSetType;
import com.webcohesion.ofx4j.domain.data.ResponseMessage;
import com.webcohesion.ofx4j.domain.data.ResponseMessageSet;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan Heaton
 * @see "Section 7 OFX Spec"
 */
@Aggregate("PROFMSGSRSV1")
public class ProfileResponseMessageSet extends ResponseMessageSet {

    private ProfileResponseTransaction profileResponse;

    public MessageSetType getType() {
        return MessageSetType.profile;
    }

    /**
     * The profile response.
     *
     * @return The profile response.
     */
    @ChildAggregate(required = true, order = 0)
    public ProfileResponseTransaction getProfileResponse() {
        return profileResponse;
    }

    /**
     * The profile response.
     *
     * @param profileResponse The profile response.
     */
    public void setProfileResponse(ProfileResponseTransaction profileResponse) {
        this.profileResponse = profileResponse;
    }

    // Inherited.
    public List<ResponseMessage> getResponseMessages() {
        ArrayList<ResponseMessage> messages = new ArrayList<ResponseMessage>();

        if (getProfileResponse() != null) {
            messages.add(getProfileResponse());
        }

        return messages;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "ProfileResponseMessageSet{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "profileResponse=" + profileResponse +
                "}";
    }
}