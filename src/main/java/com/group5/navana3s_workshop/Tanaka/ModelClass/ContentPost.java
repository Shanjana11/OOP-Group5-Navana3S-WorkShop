package com.group5.navana3s_workshop.Tanaka.ModelClass;

import java.time.LocalDateTime;

public class ContentPost {
    private String postId;
    private String platform; // Facebook, Instagram, YouTube, Banner
    private String title;
    private String caption;
    private String mediaUrl; // stored path or URL
    private LocalDateTime scheduledAt;
    //private PostStatus status;

    public ContentPost(String postId, String platform, String title, String caption, String mediaUrl, LocalDateTime scheduledAt) {
        this.postId = postId;
        this.platform = platform;
        this.title = title;
        this.caption = caption;
        this.mediaUrl = mediaUrl;
        this.scheduledAt = scheduledAt;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    @Override
    public String toString() {
        return "ContentPost{" +
                "postId='" + postId + '\'' +
                ", platform='" + platform + '\'' +
                ", title='" + title + '\'' +
                ", caption='" + caption + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", scheduledAt=" + scheduledAt +
                '}';
    }
}
