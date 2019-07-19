package com.feifan.pojo;

public class Notice {
    private int noticeId;
    private String title;
    private String content;
    private String publishTime;
    private String publisher;

    public Notice() {
    }

    public Notice(int noticeId, String title, String content, String publishTime, String publisher) {
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
        this.publishTime = publishTime;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
