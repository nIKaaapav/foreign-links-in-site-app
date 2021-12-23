package dao;

import java.util.List;
import java.util.Optional;

public interface SiteDao<M> {
    void postLink(String name);
    List<M> getLinks();
}
