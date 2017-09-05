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
package com.webcohesion.ofx4j.domain.data.tax1099;


import com.webcohesion.ofx4j.domain.data.common.T1099Request;
import com.webcohesion.ofx4j.meta.Aggregate;
import com.webcohesion.ofx4j.meta.Element;

/**
 * @author Aparna Gawali
 * aparna.gawali@sungard.com
 */
@Aggregate("TAX1099RQ")
public class Tax1099Request extends T1099Request {

    private String taxYear;

    @Element(name = "TAXYEAR", required = true, order = 0)
    public String getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(String taxYear) {
        this.taxYear = taxYear;
    }


    @Override
    public String toString() {
        String inherited = super.toString().replaceFirst("^\\w+\\{", "").replaceAll("}$", "");
        return "Tax1099Request{" +
                (inherited.trim().isEmpty() ? "" : (inherited + ", ")) +
                "taxYear='" + taxYear + '\'' +
                "}";
    }
}
