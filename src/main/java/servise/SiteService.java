package servise;

import dao.JDBCSiteDao;
import entyty.Site;

import java.sql.Connection;
import java.util.List;

public class SiteService {
    private final JDBCSiteDao siteDao;

    public SiteService(Connection connection) {
        this.siteDao = new JDBCSiteDao(connection);
    }

    public List<Site> getLinks(){
        return siteDao.getLinks();
    }

    public void postLink(String link){
        siteDao.postLink(link);
    }
}
