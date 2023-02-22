package sg.edu.nus.iss.day16workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.day16workshop.models.Boardgame;
import sg.edu.nus.iss.day16workshop.repositories.BoardgameRepo;

@RestController
@RequestMapping(path="/api/boardgame")
public class BoardgameController {
    @Autowired
    BoardgameRepo bgRepo;

    @PostMapping
    public ResponseEntity<Boardgame> save (@RequestBody Boardgame boardgame){
        Boardgame bg = bgRepo.save(boardgame);
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boardgame> findById(@PathVariable Integer id){
        Boardgame bg = bgRepo.findBoardgameById(id);
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }
}
