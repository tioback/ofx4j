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

import com.webcohesion.ofx4j.domain.data.MessageSetType;
import com.webcohesion.ofx4j.domain.data.profile.VersionSpecificMessageSetInfo;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.Element;

/**
 * @author Jon Perlow
 * @author Ryan Heaton
 * @see "Section 13.7.2.1, OFX Spec"
 */
@Aggregate("SECLISTMSGSETV1")
public class SecurityListV1MessageSetInfo extends VersionSpecificMessageSetInfo {

    private Boolean supportsSecurityListDownload;

    public MessageSetType getMessageSetType() {
        return MessageSetType.investment_security;
    }

    @Element(name = "SECLISTRQDNLD", required = true, order = 10)
    public Boolean getSupportsSecurityListDownload() {
        return supportsSecurityListDownload;
    }

    public void setSupportsSecurityListDownload(Boolean supportsSecurityListDownload) {
        this.supportsSecurityListDownload = supportsSecurityListDownload;
    }

    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "SecurityListV1MessageSetInfo{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "supportsSecurityListDownload=" + supportsSecurityListDownload +
                "}";
    }
}