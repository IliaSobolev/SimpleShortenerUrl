package com.simpleapi.springredistest.store.repository.link.redis;

import com.simpleapi.springredistest.store.entities.LinkEntity;
import com.simpleapi.springredistest.store.repository.link.LinkReposirory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisLink implements LinkReposirory {

    private final ValueOperations<String, String> valueOperations;

    @Override
    public void saveLink(LinkEntity link){
        valueOperations.set(link.shortUrl(), link.longUrl());
    }

    @Override
    public String getLink(String link) {
        return valueOperations.get(link);
    }
}
