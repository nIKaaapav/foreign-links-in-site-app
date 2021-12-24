package servise;

import dao.JDBCLinkDataDao;
import entyty.LinkData;
import helpers.FindLinks;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class LinksService {
    private final JDBCLinkDataDao linkDataDao;

    public LinksService(Connection connection) {
        this.linkDataDao = new JDBCLinkDataDao(connection);
    }

    public void postLinks(String link){
        List<LinkData> allLinks = FindLinks.getAllLinks(link);

        allLinks.stream().forEach(x -> linkDataDao.postLink(x.getLink(), x.getLevel(), x.getCountsForeignLinks()));
    }

    public List<LinkData> getAllLinksInSite(String link){
        return linkDataDao.getLinks(link);
    }

    public int totalForeignLinks(List<LinkData> links){
        Stream<Integer> integerStream = links.stream()
                .map(elem -> elem.getCountsForeignLinks());
        Optional<Integer> reduceForeignLinks = integerStream.reduce((x, y) -> x + y);
        return reduceForeignLinks.isPresent() ?  reduceForeignLinks.get() : 0;
    }
}
