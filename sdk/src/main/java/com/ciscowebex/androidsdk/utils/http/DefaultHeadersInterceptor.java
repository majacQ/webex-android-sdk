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

package com.ciscowebex.androidsdk.utils.http;

import java.io.IOException;

import com.ciscowebex.androidsdk.internal.ServiceReqeust;
import com.ciscowebex.androidsdk.utils.TrackingIdGenerator;
import com.ciscowebex.androidsdk.utils.UserAgent;

import okhttp3.Interceptor;
import okhttp3.Response;

public class DefaultHeadersInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        okhttp3.Request.Builder requestBuilder = chain.request().newBuilder();
        requestBuilder.addHeader("Accept", "application/json")
                .header("User-Agent", UserAgent.value)
                .header("Spark-User-Agent", UserAgent.value)
                .header("Content-Type", "application/json; charset=utf-8")
                .header(ServiceReqeust.HEADER_TRACKING_ID, TrackingIdGenerator.shared.nextTrackingId());
        String url = chain.request().url().toString();
        if (!url.contains("wbx2.com") && !url.contains("ciscospark.com") && !url.contains("webex.com")) {
            requestBuilder.removeHeader("Spark-User-Agent");
            requestBuilder.removeHeader("Cisco-Request-ID");
            requestBuilder.removeHeader(ServiceReqeust.HEADER_TRACKING_ID);
        }
        return chain.proceed(requestBuilder.build());
    }
}
