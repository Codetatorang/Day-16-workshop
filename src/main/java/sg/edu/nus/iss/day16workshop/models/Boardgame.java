package sg.edu.nus.iss.day16workshop.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RedisHash("boardgame")
public class Boardgame {
    @Id
    private Integer id;
    private Integer count;
}
