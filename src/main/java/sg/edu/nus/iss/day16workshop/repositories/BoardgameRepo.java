package sg.edu.nus.iss.day16workshop.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day16workshop.models.Boardgame;

@Repository
public class BoardgameRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    public Boardgame save(Boardgame boardgame){
        redisTemplate.opsForValue().set(boardgame.getId(), boardgame);
        return boardgame;
    }

    public Boardgame findBoardgameById(Integer id){
        Boardgame bg = (Boardgame) redisTemplate.opsForValue().get(id);
        return bg;
    }
}
