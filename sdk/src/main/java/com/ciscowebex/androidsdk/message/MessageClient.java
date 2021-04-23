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

import java.util.List;

import android.net.Uri;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.ciscowebex.androidsdk.CompletionHandler;
import com.ciscowebex.androidsdk.utils.EmailAddress;

/**
 * MessageClient represents a client to the Webex platform.
 * It can send and receive messages.
 * <p>
 * Use {@link com.ciscowebex.androidsdk.Webex#messages()} to get an instance of MessageClient.
 *
 * @since 0.1
 */
public interface MessageClient {

    /**
     * Sets a {@link MessageObserver} in this client.
     *
     * @param observer the observer object.
     * @see MessageObserver
     * @since 1.4.0
     */
    void setMessageObserver(MessageObserver observer);

    /**
     * Lists all messages in a space by space Id asynchronously. If present, it includes the associated file attachment for each message.
     * <p>
     * The list sorts the messages in descending order by creation date.
     *
     * @param spaceId  The identifier of a space.
     * @param before   If not nil, list messages sent only before this condition.
     * @param max      The maximum number of messages to be listed in the response.
     * @param mentions If not nil, only list messages with any mention listed here.
     * @param handler  A closure to be executed once the request has finished with a list of messages based on the above criteria.
     * @since 2.1
     */
    void list(@NonNull String spaceId, @Nullable Before before, @IntRange(from = 0, to = Integer.MAX_VALUE) int max, @Nullable Mention[] mentions, @NonNull CompletionHandler<List<Message>> handler);

    /**
     * Retrieves a message asynchronously by message Id.
     *
     * @param messageId The identifier of the message.
     * @param handler   A closure to be executed once the message has been retrieved.
     * @since 0.1
     */
    void get(@NonNull String messageId, @NonNull CompletionHandler<Message> handler);

    /**
     * Posts a message to a space or a person asynchronously.
     * <p>
     * The content of the message can be plain text, html, or markdown.
     * To notify specific person or everyone in a space, mentions should be used.
     * Having <code>@johndoe</code> in the content of the message does not generate notification.
     *
     * @param target  The identifier of a space or a person or an email address to which the message is to be posted.
     * @param draft   The content of message to be posted to the space.
     * @param handler A closure to be executed once the message has posted.
     * @since 2.5.0
     */
    void post(@NonNull String target, @NonNull Message.Draft draft, @NonNull CompletionHandler<Message> handler);

    /**
     * Edit a previous sent message asynchronously.
     * <p>
     * @param originalMessage The message that is editing.
     * @param text The new text that will replace original message, if not edit this value, please set the value same with original message.
     * @param mentions The mentioned person list that will replace original message, if not edit this value, please set the value same with original message.
     * @param handler A closure to be executed once the message has edited. A {@link com.ciscowebex.androidsdk.message.MessageObserver.MessageEdited} event will gain if success.
     *                Developer can call {@link Message#update(MessageObserver.MessageEdited)} method to update to original message.
     * @since 2.8.0
     */
    void edit(@NonNull Message originalMessage, @Nullable Message.Text text, @Nullable Mention[] mentions, @NonNull CompletionHandler<MessageObserver.MessageEdited> handler);

    /**
     * Posts a message with optional file attachments to a person asynchronously.
     * <p>
     * The content of the message can be plain text, html, or markdown.
     *
     * @param id      The identifier of a person to which the message is to be posted.
     * @param text    The content of message to be posted to the person. The content can be plain text, html, or markdown.
     * @param files   Local files to be attached with the message. Null if no files to be attached.
     * @param handler A closure to be executed once the message has posted.
     * @since 2.1.0
     */
    void postToPerson(@NonNull String id, @Nullable String text, @Nullable LocalFile[] files, @NonNull CompletionHandler<Message> handler);

    /**
     * Posts a message with optional file attachments to a person asynchronously.
     * <p>
     * The content of the message can be plain text, html, or markdown.
     *
     * @param id      The identifier of a person to which the message is to be posted.
     * @param text    The content of message to be posted to the person. The content can be plain text, html, or markdown.
     * @param files   Local files to be attached with the message. Null if no files to be attached.
     * @param handler A closure to be executed once the message has posted.
     * @since 2.3.0
     */
    void postToPerson(@NonNull String id, @Nullable Message.Text text, @Nullable LocalFile[] files, @NonNull CompletionHandler<Message> handler);

    /**
     * Posts a message with optional file attachments to a person asynchronously.
     * <p>
     * The content of the message can be plain text, html, or markdown.
     *
     * @param email   The email address of a person to which the message is to be posted.
     * @param text    The content of message to be posted to the person. The content can be plain text, html, or markdown.
     * @param files   Local files to be attached with the message. Null if no files to be attached.
     * @param handler A closure to be executed once the message has posted.
     * @since 2.1.0
     */
    void postToPerson(@NonNull EmailAddress email, @Nullable String text, @Nullable LocalFile[] files, @NonNull CompletionHandler<Message> handler);

    /**
     * Posts a message with optional file attachments to a person asynchronously.
     * <p>
     * The content of the message can be plain text, html, or markdown.
     *
     * @param email   The email address of a person to which the message is to be posted.
     * @param text    The content of message to be posted to the person. The content can be plain text, html, or markdown.
     * @param files   Local files to be attached with the message. Null if no files to be attached.
     * @param handler A closure to be executed once the message has posted.
     * @since 2.3.0
     */
    void postToPerson(@NonNull EmailAddress email, @Nullable Message.Text text, @Nullable LocalFile[] files, @NonNull CompletionHandler<Message> handler);

    /**
     * Posts a message with optional file attachments to a space asynchronously.
     * <p>
     * The content of the message can be plain text, html, or markdown.
     * To notify specific person or everyone in a space, mentions should be used.
     * Having <code>@johndoe</code> in the content of the message does not generate notification.
     *
     * @param id       The identifier of a space to which the message is to be posted.
     * @param text     The content of message to be posted to the space. The content can be plain text, html, or markdown.
     * @param mentions Notify either one or all in a space about this message.
     * @param files    Local files to be attached with the message. Null if no files to be attached.
     * @param handler  A closure to be executed once the message has posted.
     * @since 2.1.0
     */
    void postToSpace(@NonNull String id, @Nullable String text, @Nullable Mention[] mentions, @Nullable LocalFile[] files, @NonNull CompletionHandler<Message> handler);

    /**
     * Posts a message with optional file attachments to a space asynchronously.
     * <p>
     * The content of the message can be plain text, html, or markdown.
     * To notify specific person or everyone in a space, mentions should be used.
     * Having <code>@johndoe</code> in the content of the message does not generate notification.
     *
     * @param id       The identifier of a space to which the message is to be posted.
     * @param text     The content of message to be posted to the space. The content can be plain text, html, or markdown.
     * @param mentions Notify either one or all in a space about this message.
     * @param files    Local files to be attached with the message. Null if no files to be attached.
     * @param handler  A closure to be executed once the message has posted.
     * @since 2.3.0
     */
    void postToSpace(@NonNull String id, @Nullable Message.Text text, @Nullable Mention[] mentions, @Nullable LocalFile[] files, @NonNull CompletionHandler<Message> handler);

    /**
     * Downloads a file attachement asynchronously.
     * See <a href="https://help.webex.com/en-us/yuwad5/Share-Files-with-Others-in-Cisco-Webex-Teams">File Sharing</a> for more details.
     *
     * @param remoteFile        The reference to the file attachment to be downloaded. Use @{link Message#getRemoteFiles()} to get the references.
     * @param path              The local file directory to save the remote file.
     * @param progressHandler   The download progress indicator.
     * @param completionHandler A closure to be executed when the download has completed. The URI contains the path to the downloaded file.
     * @since 1.4.0
     */
    void downloadFile(@NonNull RemoteFile remoteFile,
                      @Nullable java.io.File path,
                      @Nullable ProgressHandler progressHandler,
                      @NonNull CompletionHandler<Uri> completionHandler);

    /**
     * Downloads the thumbnail (preview image) of a file attachment asynchronously.
     * Note Cisco Webex doesn't generate thumbnail for all files.
     * See <a href="https://help.webex.com/en-us/yuwad5/Share-Files-with-Others-in-Cisco-Webex-Teams">File Sharing</a> for more details.
     *
     * @param remoteFile        The remote file whose thumbnail to be downloaded.
     * @param path              The local file directory to save the thumbnail.
     * @param progressHandler   The download progress indicator.
     * @param completionHandler A closure to be executed when the download has completed. The URI contains the path to the downloaded thumbnail.
     * @since 1.4.0
     */
    void downloadThumbnail(@NonNull RemoteFile remoteFile,
                           @Nullable java.io.File path,
                           @Nullable ProgressHandler progressHandler,
                           @NonNull CompletionHandler<Uri> completionHandler);

    /**
     * Deletes a message asynchronously by message id.
     *
     * @param messageId The identifier of the message.
     * @param handler   A closure to be executed once the request has finished.
     * @since 0.1
     */
    void delete(@NonNull String messageId, @NonNull CompletionHandler<Void> handler);

    /**
     * Lists all messages in a space by space Id. If present, it includes the associated media content attachment for each message.
     * <p>
     * The list sorts the messages in descending order by creation date.
     *
     * @param spaceId         The identifier of the space.
     * @param before          If not nil, only list messages sent only before this date and time, in ISO8601 format.
     * @param beforeMessage   If not nil, only list messages sent only before this message by id.
     * @param mentionedPeople If not nil, only list messages metion people.
     * @param max             The maximum number of messages in the response.
     * @param handler         A closure to be executed once the request has finished.
     * @since 0.1
     * @deprecated
     */
    @Deprecated
    void list(@NonNull String spaceId, @Nullable String before, @Nullable String beforeMessage, @Nullable String mentionedPeople, @IntRange(from = 0, to = Integer.MAX_VALUE) int max, @NonNull CompletionHandler<List<Message>> handler);

    /**
     * Posts a plain text message, and optionally, a media content attachment, to a space by space Id.
     *
     * @param spaceId     The identifier of the space where the message is to be posted.
     * @param personId    The identifier of the recipient of this private 1:1 message.
     * @param personEmail The email address of the recipient when sending a private 1:1 message.
     * @param text        The plain text message to be posted to the space.
     * @param markdown    The markdown text message to be posted to the space.
     * @param files       A public URL that Cisco Webex can use to fetch attachments. Currently supports only a single URL. Cisco Webex downloads the content from the URL one time shortly after the message is created and automatically converts it to a format that all Cisco Webex clients can render.
     * @param handler     A closure to be executed once the request has finished.
     * @since 0.1
     * @deprecated
     */
    @Deprecated
    void post(@Nullable String spaceId,
              @Nullable String personId,
              @Nullable String personEmail,
              @Nullable String text,
              @Nullable String markdown,
              @Nullable String[] files,
              @NonNull CompletionHandler<Message> handler);

    /**
     * Posts a message with optional file attachments to a space or a person asynchronously.
     * <p>
     * The content of the message can be plain text, html, or markdown.
     * To notify specific person or everyone in a space, mentions should be used.
     * Having <code>@johndoe</code> in the content of the message does not generate notification.
     *
     * @param idOrEmail The identifier of a space or a person or an email address to which the message is to be posted.
     * @param text      The content of message to be posted to the space. The content can be plain text, html, or markdown.
     * @param mentions  Notify either one or all in a space about this message. Ignored if post to a person or an email.
     * @param files     Local files to be attached with the message. Nil if no files to be attached.
     * @param handler   A closure to be executed once the message has posted.
     * @since 1.4.0
     * @deprecated
     */
    @Deprecated
    void post(@NonNull String idOrEmail,
              @Nullable String text,
              @Nullable Mention[] mentions,
              @Nullable LocalFile[] files,
              @NonNull CompletionHandler<Message> handler);

    /**
     * Mark all messages in the space read.
     *
     * @param spaceId the id of space.
     * @since 2.3.0
     */
    void markAsRead(@NonNull String spaceId);

    /**
     * Mark messages sent before the specified message in the space are read, including the specified message.
     * <p>
     *
     * @param spaceId   the id of space.
     * @param messageId the id of a message.
     * @since 2.3.0
     */
    void markAsRead(@NonNull String spaceId, @NonNull String messageId);

    /**
     * A callback to indicate the progress of an action in already processed size (bytes).
     *
     * @since 1.4.0
     */
    interface ProgressHandler {
        void onProgress(double bytes);
    }
}
