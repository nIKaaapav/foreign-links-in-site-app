package dao.mappers;

import entyty.LinkData;
import entyty.Site;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LinkDataMapper {
    public static LinkData mapRows(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int level = resultSet.getInt("level");
        int countsForeignLinks = resultSet.getInt("countsForeignLinks");
        String link = resultSet.getString("link");

        return LinkData.builder()
                .link(link)
                .id(id)
                .level(level)
                .countsForeignLinks(countsForeignLinks)
                .build();
    }
}
