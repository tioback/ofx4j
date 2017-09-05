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

package com.webcohesion.ofx4j.domain.data.seclist;

/**
 * The type of debt.
 *
 * @author Jon Perlow
 * @see "Section 13.8.5.6, OFX Spec"
 */
public enum StockType {
    COMMON,
    PREFERRED,
    CONVERTIBLE,
    OTHER;

    public static StockType fromOfx(String ofxVal) {
        if ("COMMON".equals(ofxVal)) {
            return COMMON;
        } else if ("PREFERRED".equals(ofxVal)) {
            return PREFERRED;
        } else if ("CONVERTIBLE".equals(ofxVal)) {
            return CONVERTIBLE;
        } else if ("OTHER".equals(ofxVal)) {
            return OTHER;
        } else {
            return null;
        }
    }
}
