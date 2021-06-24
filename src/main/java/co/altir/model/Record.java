package co.altir.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("record")
public class Record {

    @Id
    private String id;
    private String value;

}
