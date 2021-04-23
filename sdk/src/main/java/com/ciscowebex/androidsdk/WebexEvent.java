/*
 * Copyright 2016-2020 Cisco Systems Inc
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

package com.ciscowebex.androidsdk;

import com.ciscowebex.androidsdk.internal.model.ActivityModel;
import com.ciscowebex.androidsdk.internal.model.LocusModel;
import com.ciscowebex.androidsdk.internal.model.LocusParticipantInfoModel;
import com.ciscowebex.androidsdk.internal.model.PersonModel;
import com.ciscowebex.androidsdk.utils.WebexId;

/**
 * Interface for all Webex events.
 *
 * @since 2.3.0
 */
public interface WebexEvent {

    /**
     * Returns the identifier of the user that caused the event to be sent. For example, for a messsage received event,
     * the author of the message will be the actor. For a membership deleted event, the actor is the person who removed the user
     * from space.
     *
     * @return The identifier of the user that caused the event to be sent.
     */
    String getActorId();

    /**
     * Base class for all Webex events.
     */
    abstract class Base implements WebexEvent {

        private String _actorId;

        protected Base(ActivityModel activity) {
            PersonModel person = activity.getActor();
            if (person != null) {
                _actorId = new WebexId(WebexId.Type.PEOPLE, WebexId.DEFAULT_CLUSTER, person.getId()).getBase64Id();
            }
        }

        protected Base(LocusModel locus) {
            LocusParticipantInfoModel participant = locus.getHost();
            if (participant != null) {
                _actorId = new WebexId(WebexId.Type.PEOPLE, WebexId.DEFAULT_CLUSTER, participant.getId()).getBase64Id();
            }
        }

        /**
         * @see WebexEvent
         */
        @Override
        public String getActorId() {
            return _actorId;
        }
    }
}
