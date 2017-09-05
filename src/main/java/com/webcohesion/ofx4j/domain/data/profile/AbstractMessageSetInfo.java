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

import com.webcohesion.ofx4j.meta.ChildAggregate;

import java.util.List;

/**
 * Information about a message set.
 *
 * @author Ryan Heaton
 * @see "Section 7.2.1, OFX Spec"
 */
public abstract class AbstractMessageSetInfo {

    private List<VersionSpecificMessageSetInfo> versionSpecificInformationList;

    /**
     * List of information about a message set for each version supported.
     *
     * @return List of information about a message set for each version supported.
     */
    @ChildAggregate(order = 0)
    protected List<VersionSpecificMessageSetInfo> getVersionSpecificInformationList() {
        return versionSpecificInformationList;
    }

    /**
     * List of information about a message set for each version supported.
     *
     * @param versionSpecificInformationList List of information about a message set for each version supported.
     */
    public void setVersionSpecificInformationList(List<VersionSpecificMessageSetInfo> versionSpecificInformationList) {
        this.versionSpecificInformationList = versionSpecificInformationList;
    }

    @Override
    public String toString() {
        return "AbstractMessageSetInfo{" +
                "versionSpecificInformationList=" + versionSpecificInformationList +
                "}";
    }
}
