package dao;

import dao.mappers.SiteMapper;
import entyty.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCSiteDao implements SiteDao<Site> {
    private final Connection connection;

    private static String selectAll = "select * from site";
    private static String post = "insert into site(link) VALUES (?);";

    public JDBCSiteDao(Connection connection) {
        this.connection = connection;
    }

    public void postLink(String link){
        try( PreparedStatement ps = connection.prepareStatement(post)) {
            ps.setString(1, link);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Site> getLinks(){
        ArrayList<Site> arrayLinks = new ArrayList();

        try( PreparedStatement ps = connection.prepareStatement(selectAll)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                Site link = SiteMapper.mapRows(resultSet);
                arrayLinks.add(link);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayLinks;
    }
}
