/*
 * Copyright 2016-2021 Cisco Systems Inc
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

package com.ciscowebex.androidsdk.internal.model;

import android.net.Uri;

import java.util.List;

public class LocusParticipantControlsModel {
    private Uri url;
    private LocusParticipantAudioControlModel audio;
    private LocusParticipantChallengeControlModel challenge;
    private LocusParticipantLocalRecordControlModel localRecord;
    private List<LocusLinkModel> links;


    public LocusParticipantControlsModel(Uri url, List<LocusLinkModel> links,
                                         LocusParticipantAudioControlModel audio,
                                         LocusParticipantLocalRecordControlModel localRecord,
                                         LocusParticipantChallengeControlModel challenge) {
        this.url = url;
        this.links = links;
        this.audio = audio;
        this.challenge = challenge;
        this.localRecord = localRecord;
    }

    public LocusParticipantAudioControlModel getAudio() {
        return audio;
    }

    public LocusParticipantLocalRecordControlModel getLocalRecord() {
        return localRecord;
    }

    public LocusParticipantChallengeControlModel getChallenge() {
        return challenge;
    }

    public List<LocusLinkModel> getLinks() {
        return links;
    }

    public Uri getUrl() {
        return url;
    }
}
