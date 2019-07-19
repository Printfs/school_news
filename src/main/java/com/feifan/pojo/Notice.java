package com.feifan.pojo;

public class Notice {
    private int noticeId;
    private String titlt;
    private String content;
    private String publishTime;
    private String publisher;

    public Notice() {
    }

    public Notice(int noticeId, String titlt, String content, String publishTime, String publisher) {
        this.noticeId = noticeId;
        this.titlt = titlt;
        this.content = content;
        this.publishTime = publishTime;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", titlt='" + titlt + '\'' +
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

    public String getTitlt() {
        return titlt;
    }

    public void setTitlt(String titlt) {
        this.titlt = titlt;
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
