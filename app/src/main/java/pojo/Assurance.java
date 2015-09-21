package pojo;

import java.io.Serializable;

/**
 * Created by eit on 9/14/15.
 */
public class Assurance implements Serializable{

    private String title, status, startDate, commentCount, summary,
        sourceUrl, source, completionDate, enableFeedback;

    private Official official;
    private Integer id;

    public Assurance(){}

    public Assurance(Integer id, String title, String status, String startDate, String commentCount, String summary){
        this.setStatus(status);
        this.setTitle(title);
        this.setStartDate(startDate);
        this.setCommentCount(commentCount);
        this.setSummary(summary);
        this.setId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Official getOfficial() {
        return official;
    }

    public void setOfficial(Official official) {
        this.official = official;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getEnableFeedback() {
        return enableFeedback;
    }

    public void setEnableFeedback(String enableFeedback) {
        this.enableFeedback = enableFeedback;
    }
}
