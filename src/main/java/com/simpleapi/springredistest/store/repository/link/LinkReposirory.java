package com.simpleapi.springredistest.store.repository.link;

import com.simpleapi.springredistest.store.entities.LinkEntity;

public interface LinkReposirory {
    void saveLink(LinkEntity link) ;
    String getLink(String link);
}
