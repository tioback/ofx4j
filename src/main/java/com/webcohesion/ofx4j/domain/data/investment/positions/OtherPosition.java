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

package com.webcohesion.ofx4j.domain.data.investment.positions;

import com.webcohesion.ofx4j.meta.Aggregate;

/**
 * Represents other types of positions.
 *
 * @author Jon Perlow
 * @see "Section 13.9.2.6.1, OFX Spec"
 */
@Aggregate("POSOTHER")
public class OtherPosition extends BasePosition {
    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "OtherPosition{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "}";
    }
}
