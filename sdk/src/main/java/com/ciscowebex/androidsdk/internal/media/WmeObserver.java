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

package com.ciscowebex.androidsdk.internal.media;

import android.util.Size;
import com.cisco.wx2.diagnostic_events.MediaLine;

import java.util.List;

public interface WmeObserver {

    void onRemoteVideoAvailable(boolean available);
    void onAuxVideoAvailable(int vid, boolean available);
    void onRemoteSharingAvailable(boolean available);

    void onActiveSpeakerChanged(long[] oldCSIs, long[] newCSIs);
    void onCSIChanged(long vid, long[] oldCSIs, long[] newCSIs);
    void onAvailableMediaChanged(int count);

    void onMediaDecodeSizeChanged(WMEngine.Media media, long vid, Size size);
    void onMediaRenderSizeChanged(WMEngine.Media media, long vid, Size size);

    void onTrackMuted(WmeTrack.Type track, long vid, boolean mute);
    void onCameraSwitched();

    void onError(MediaError error);

    void onICEComplete();
    void onICEFailed();
    void onICEReportReady(boolean connectSuccess, List<MediaLine> mediaLines);
    void onMediaQualityMetricsReady(String eventMetric);
    void onMediaError(int mid, int vid, int errorCode);

    void onMediaRxStart(WMEngine.Media media, Long csi);
    void onMediaRxStop(WMEngine.Media media, Integer mediaStatus);
    void onMediaTxStart(WMEngine.Media media);
    void onMediaTxStop(WMEngine.Media media);
    void onMediaBlocked(WMEngine.Media media, boolean blocked);
}
