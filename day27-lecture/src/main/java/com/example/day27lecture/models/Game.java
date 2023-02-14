package com.example.day27lecture.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {

    // gid, game
    private Integer gid;
    private String name;
    private Long year;
    private Integer ranking;
    private Integer usersRated;
    private String url;
    private String image;
    private float rating;

    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public Long getYear() {
        return year;
    }
    public void setYear(Long year) {
        this.year = year;
    }
    public Integer getRanking() {
        return ranking;
    }
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    public Integer getUsersRated() {
        return usersRated;
    }
    public void setUsersRated(Integer usersRated) {
        this.usersRated = usersRated;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static Game createSummary(SqlRowSet rs) {
        Game game = new Game();
        game.setGid(rs.getInt("gid"));
        game.setName(rs.getString("name"));
        game.setYear(rs.getLong("year"));
        game.setRanking(rs.getInt("ranking"));
        game.setUsersRated(rs.getInt("users_rated"));
        game.setUrl(rs.getString("url"));
        game.setImage(rs.getString("image"));
        return game;
    }

    // public static Game createSummary2(SqlRowSet rs) {
    //     Game game = new Game();
    //     game.setGid(rs.getInt("gid"));
    //     game.setName(rs.getString("name"));
    //     game.setRating(rs.getLong("rating"));
    //     return game;
    // }

    
}

