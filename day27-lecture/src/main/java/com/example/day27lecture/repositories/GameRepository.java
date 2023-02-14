package com.example.day27lecture.repositories;

// import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.example.day27lecture.models.Game;

@Repository
public class GameRepository {
    
    private final String listAllSQL = "select * from game limit ? offset ?";
    // private final String listNameAndGidSQL = "select gid, name from game limit ? offset ?";
    // private final String gameByGidSQL = "select * from game where gid = ?";

    // select game.gid, game.name, AVG(comment.rating) as rating
    // from game
    // left join comment
    // on game.gid = comment.gid
    // group by game.gid;
    // where game.gid = ?

    private final String gameByGidSQL2 = "select game.gid as gid, game.name as name, game.image as image, AVG(comment.rating) as rating "
                            + "from game "
                            + "left join comment "
                            + "on game.gid = comment.gid "
                            + "where game.gid = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Game> getGames(int limit, int offset) {
        // List<Game> resultList = new ArrayList<Game>();
        // resultList = jdbcTemplate.query(listNameAndGidSQL, BeanPropertyRowMapper.newInstance(Game.class), limit, offset);
        // return resultList;


        SqlRowSet rs = jdbcTemplate.queryForRowSet(listAllSQL, limit, offset);
        List<Game> games = new LinkedList<>();
        while (rs.next()) {
            games.add(Game.createSummary(rs));
        }
        return games;
    }

    public Game getGameByGid(int gid) {
        Game game = new Game();
        game = jdbcTemplate.queryForObject(gameByGidSQL2, BeanPropertyRowMapper.newInstance(Game.class), gid);
        // SqlRowSet rs = jdbcTemplate.queryForRowSet(gameByGidSQL2, gid);
        // Game game = Game.createSummary2(rs);
        return game;
    }

    // public List<Game> getGames() {
    //     return getGames(30,0);
    // }

}
