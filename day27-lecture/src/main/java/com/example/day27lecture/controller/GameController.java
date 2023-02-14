package com.example.day27lecture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.day27lecture.models.Comment;
import com.example.day27lecture.models.Game;
import com.example.day27lecture.services.GameService;

@Controller
public class GameController {
    
    @Autowired
    GameService gameSvc;

    @GetMapping(path ="/game")
    public String getAllGames(Model model, 
    @RequestParam(defaultValue = "30") int limit, 
    @RequestParam(defaultValue = "0") int offset ) {
        List<Game> listGames = new ArrayList<Game>();
        listGames = gameSvc.getGames(limit, offset);
        model.addAttribute("listGames", listGames);
        model.addAttribute("next", offset + limit);
        return "list";   
    }

    @GetMapping("/game/{gid}")
    public String getGameById(Model model, @PathVariable Integer gid) {
        // Game game = new Game();
        Game game = gameSvc.getGameByGid(gid);
        model.addAttribute("game", game);
        model.addAttribute("comment", new Comment());
        return "gameForm";
    }

    // @PostMapping("/comment")
    // public String postComment(@RequestBody MultiValueMap<String, String> form, Model model){
    //     Comment comment = Comment.create(form);
    //     String commentId = gameSvc.addComment(comment);
    //     System.out.println("commentId: " + commentId);
    //     // model.addAttribute("comment", comment);
    //     return "redirect:/";

    // }

}
