package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memory_limit;
    private String cf_index;
    private String address;

    public EnvController(@Value("${port:NOT SET}")String port,
                         @Value("${memory.limit:NOT SET}")String memory_limit,
                         @Value("${cf.instance.index:NOT SET}")String cf_index,
                         @Value("${address:NOT SET}")String address) {
        this.port = port;
        this.memory_limit = memory_limit;
        this.cf_index = cf_index;
        this.address = address;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){

        Map<String, String> env = new HashMap<>();
        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memory_limit);
        env.put("CF_INSTANCE_INDEX", cf_index);
        env.put("CF_INSTANCE_ADDR", address);

        return env;
    }
}
