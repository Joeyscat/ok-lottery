package fun.oook.lottery.api.coonfig;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYu
 * @since 0.0.1
 */
@Component
public class LuaScript {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private DefaultRedisScript<Long> script;

    @PostConstruct
    public void init() {
        script = new DefaultRedisScript<>();
        script.setResultType(Long.class);
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/tokenCheck.lua")));
    }

    public Long tokenCheck(final String gameKey, final String currentTime) {
        final List<String> keys = new ArrayList<>();
        keys.add(gameKey);
        keys.add(currentTime);

        return redisTemplate.execute(script, keys, 0, 0);
    }
}
