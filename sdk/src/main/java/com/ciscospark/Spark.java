/*
 * Copyright (c) 2016-2017 Cisco Systems Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.ciscospark;

import com.ciscospark.auth.AuthorizationStrategy;
import com.ciscospark.auth.AuthorizeListener;
import com.ciscospark.membership.MembershipClient;
import com.ciscospark.message.MessageClient;
import com.ciscospark.people.PeopleClient;
import com.ciscospark.phone.Phone;
import com.ciscospark.room.RoomClient;
import com.ciscospark.team.TeamClient;
import com.ciscospark.team.TeamMembershipClient;

/**
 * @author Allen Xiao<xionxiao@cisco.com>
 * @version 0.1
 */
public class Spark {
    private AuthorizationStrategy strategy;

    /**
     * Get current sdk version
     *
     * @return major.minor.build-alpha/beta
     */
    public String version() {
        return "0.1";
    }

    public void init(AuthorizationStrategy strategy) {
        this.strategy = strategy;
    }

    public void authorize(AuthorizeListener listener) {
        strategy.authorize(listener);
    }

    public void deauthorize() {
        strategy.deauthorize();
    }

    public boolean isAuthorized() {
        return strategy.isAuthorized();
    }

    public Phone phone() {
        return new Phone(strategy.getToken());
    }

    public MessageClient messages() {
        return new MessageClient();
    }

    public PeopleClient people() {
        return new PeopleClient();
    }

    public MembershipClient memberships() {
        return new MembershipClient();
    }

    public TeamClient teams() {
        return new TeamClient();
    }

    public TeamMembershipClient teamMembershipClient() {
        return new TeamMembershipClient();
    }

    public RoomClient rooms() {
        return new RoomClient();
    }

}
