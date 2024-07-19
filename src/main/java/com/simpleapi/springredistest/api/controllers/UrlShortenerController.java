package com.simpleapi.springredistest.api.controllers;

import com.simpleapi.springredistest.store.usecases.link.LinkUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UrlShortenerController {

    private final LinkUsecase linkUsecase;

    @PostMapping(value = "/api/v1/shorten")
    public String createLink(@RequestBody String link) {
        return linkUsecase.createLink(link);
    }

    @GetMapping(value = "/{uuid}")
    public String getLink(@PathVariable String uuid){
        return linkUsecase.getLink(uuid);
    }
}
