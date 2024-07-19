package com.simpleapi.springredistest.store.usecases.link;

public interface ILinkUsecase {
    String createLink(String link);
    String getLink(String uuid) ;
}
