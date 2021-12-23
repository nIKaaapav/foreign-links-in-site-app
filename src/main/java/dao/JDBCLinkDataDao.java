package dao;

import dao.mappers.LinkDataMapper;
import dao.mappers.SiteMapper;
import entyty.LinkData;
import entyty.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCLinkDataDao implements LinkDataDao<LinkData> {
    private final Connection connection;

    private static String select = "select * from link where link.link like ?";
    private static String post = "insert into link(link, level, \"countsForeignLinks\") values (?, ?, ?);";

    public JDBCLinkDataDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void postLink(String link, int level, int countsForeignLinks) {
        try( PreparedStatement ps = connection.prepareStatement(post)) {
            ps.setString(1, link);
            ps.setInt(2, level);
            ps.setInt(3, countsForeignLinks);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<LinkData> getLinks(String url) {
        ArrayList<LinkData> arrayLinks = new ArrayList();

        try( PreparedStatement ps = connection.prepareStatement(select)) {
            ps.setString(1, url + "%");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                LinkData link = LinkDataMapper.mapRows(resultSet);
                arrayLinks.add(link);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayLinks;
    }
}
