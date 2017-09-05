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
@Aggregate("INTERXFERMSGSET")
public class InterbankTransferMessageSetInfo extends AbstractMessageSetInfo {

    private InterbankTransferV1MessageSetInfo version1Info;

    @ChildAggregate(order = 0)
    public InterbankTransferV1MessageSetInfo getVersion1Info() {
        return version1Info;
    }

    public void setVersion1Info(InterbankTransferV1MessageSetInfo version1Info) {
        this.version1Info = version1Info;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "InterbankTransferMessageSetInfo{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "version1Info=" + version1Info +
                "}";
    }
}