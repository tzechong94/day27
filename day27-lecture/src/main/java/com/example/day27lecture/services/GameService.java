package com.example.day27lecture.services;

import java.util.List;
// import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.day27lecture.models.Comment;
import com.example.day27lecture.models.Game;
import com.example.day27lecture.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepo;

    // @Autowired
    // private CommentRepository commentRepo;

    public List<Game> getGames() {
        return gameRepo.getGames(30, 0);
    }

    public List<Game> getGames(int limit, int offset){
        return gameRepo.getGames(limit, offset);
    }

    public Game getGameByGid(int gid) {
        return gameRepo.getGameByGid(gid);
    }

    // public String addComment(Comment comment) {
    //     String cid = UUID.randomUUID().toString().substring(0,8);
    //     comment.setCid(cid);
    //     commentRepo.insertComment(comment);
    //     return cid;
    // }
}
