package com.simpleapi.springredistest.store.usecases.link;

import com.simpleapi.springredistest.store.entities.LinkEntity;
import com.simpleapi.springredistest.store.repository.link.redis.RedisLink;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Log4j2
public class LinkUsecase implements ILinkUsecase {

    private final RedisLink redisLink;
    private static final String DOMAIN = "http://localhost:8080/";

    @Override
    public String createLink(String link) {
        log.info("Creating link: {}", link);
        String uuid = UUID.randomUUID().toString();
        LinkEntity linkEntity = new LinkEntity(uuid, link);
        redisLink.saveLink(linkEntity);
        return DOMAIN + uuid;
    }

    @Override
    public String getLink(String uuid) {
        log.info("Getting link: {}", uuid);
        return redisLink.getLink(uuid);
    }
}
