package dao;

import java.util.List;

public interface LinkDataDao<M> {
    void postLink(String link, int level, int countsForeignLinks);
    List<M> getLinks(String url);
}