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

package com.webcohesion.ofx4j.domain.data.profile.info;

import com.webcohesion.ofx4j.domain.data.profile.AbstractMessageSetInfo;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.ChildAggregate;

/**
 * @author Ryan Heaton
 */
@Aggregate("EMAILMSGSET")
public class EmailMessageSetInfo extends AbstractMessageSetInfo {

    private EmailV1MessageSetInfo version1Info;

    @ChildAggregate(order = 0)
    public EmailV1MessageSetInfo getVersion1Info() {
        return version1Info;
    }

    public void setVersion1Info(EmailV1MessageSetInfo version1Info) {
        this.version1Info = version1Info;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "EmailMessageSetInfo{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "version1Info=" + version1Info +
                "}";
    }
}