/**
 * Copyright 2018 Comcast Cable Communications Management, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package vinyldns.java.model.zone;

import vinyldns.java.model.acl.ACLRule;

import java.util.Set;

public class ZoneACL {
    private Set<ACLRule> rules;

    public ZoneACL() {
    }

    public ZoneACL(Set<ACLRule> rules) {
        this.rules = rules;
    }

    public Set<ACLRule> getRules() {
        return rules;
    }

    public void setRules(Set<ACLRule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "ZoneACL{" +
                "rules=" + rules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZoneACL zoneACL = (ZoneACL) o;

        return rules.equals(zoneACL.rules);
    }

    @Override
    public int hashCode() {
        return rules.hashCode();
    }
}