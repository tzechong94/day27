package com.example.day27lecture.models;

import org.bson.Document;
import org.springframework.util.MultiValueMap;

public class Comment {
    
    private String cid;
    private String user;
    private Integer rating;
    private String cText;
    private Integer gid;
    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getcText() {
        return cText;
    }
    public void setcText(String cText) {
        this.cText = cText;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Document toDocument() {
        Document doc = new Document();
        doc.put("c_id", getCid());
        doc.put("user", getUser());
        doc.put("rating", getRating());
        doc.put("c_text", getcText());
        return doc;
    }
    
    public static Comment create(MultiValueMap<String, String> form){
        Comment comment = new Comment();
        comment.setGid(Integer.parseInt(form.getFirst("gid")));
        comment.setUser(form.getFirst("username"));
        comment.setRating(Integer.parseInt(form.getFirst("rating")));
        comment.setcText(form.getFirst("comment"));
        return comment;
    }
    
}
