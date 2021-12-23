package dao.mappers;

import entyty.Site;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteMapper {
    public static Site mapRows(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String link = resultSet.getString("link");

       return Site.builder()
               .link(link)
               .id(id)
               .build();
    }
}
