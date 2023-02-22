package sg.edu.nus.iss.day16workshop.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@RedisHash("payload")
public class Payload implements Serializable{
    @Id
    private Integer id;

    private String itemName;
}
