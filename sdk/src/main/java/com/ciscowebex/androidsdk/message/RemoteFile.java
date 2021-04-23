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

package com.ciscowebex.androidsdk.message;

/**
 * A data type represents a remote file on the Cisco Webex.
 * The content of the remote file can be downloaded via {@link MessageClient#downloadFile}.
 *
 * @since 1.4.0
 */
public interface RemoteFile {

    /**
     * A data type represents a thumbnail file.
     * The thumbnail typically is an image file which provides preview of the remote file without downloading.
     * The content of the thumbnail can be downloaded via {@link MessageClient#downloadThumbnail}.
     *
     * @since 1.4.0
     */
    interface Thumbnail {

        /**
         * Returns the width of the thumbnail.
         * @return The width of the thumbnail.
         */
        int getWidth();

        /**
         * Returns the height of the thumbnail.
         * @return The height of the thumbnail.
         */
        int getHeight();

        /**
         * Returns the MIME type of the thumbnail.
         * @return The MIME type of the thumbnail.
         */
        String getMimeType();

        @Deprecated
        String getUrl();

        @Deprecated
        void setUrl(String url);

        @Deprecated
        void setWidth(int width);

        @Deprecated
        void setMimeType(String mimeType);

        @Deprecated
        void setHeight(int height);
    }

    /**
     * Returns the display name of this remote file.
     * @return The display name of this remote file.
     */
    String getDisplayName();

    /**
     * Returns the size in bytes of this remote file.
     * @return the size in bytes of this remote file.
     */
    long getSize();

    /**
     * Returns the MIME type of this remote file.
     * @return The MIME type of this remote file.
     */
    String getMimeType();

    /**
     * Returns the thumbnail of this remote file.
     * @return The thumbnail of this remote file.
     */
    Thumbnail getThumbnail();

    /**
     * Set the display name of this remote file.
     * @param displayName the display name of this remote file.
     * @deprecated
     */
    @Deprecated
    void setDisplayName(String displayName);

    /**
     * Set the size of this remote file, in bytes.
     * @param size the size of the file
     * @deprecated
     */
    @Deprecated
    void setSize(Long size);

    /**
     * Set the MIME type string of this remote file, according to <a href="https://tools.ietf.org/html/rfc6838">RFC6838</a>.
     * @param mimeType the MIME type string
     */
    @Deprecated
    void setMimeType(String mimeType);

    /**
     * Returns the URL string for this remote file.
     * @return The URL string for this remote file.
     *
     * @deprecated
     */
    @Deprecated
    String getUrl();

    /**
     * Set the URL string of this remote file.
     * @param url the URL string of this remote file.
     * @deprecated
     */
    @Deprecated
    void setUrl(String url);

    /**
     * Set the thumbnail of this remote file.
     * @param thumbnail The thumbnail of this remote file.
     * @deprecated
     */
    @Deprecated
    void setThumbnail(Thumbnail thumbnail);
}
