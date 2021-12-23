package servlet;

import entyty.LinkData;
import servise.LinksService;
import servise.SiteService;
import templete.TemplateEngine;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinksServlet extends HttpServlet {
    private final TemplateEngine te = TemplateEngine.folder();
    final Connection connection;
    final LinksService linksService;

    public LinksServlet(Connection conn) {
        connection = conn;
        linksService = new LinksService(conn);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String link = req.getParameter("url");

        List<LinkData> links = linksService.getAllLinksInSite(link);
        Map<String, Object> data = new HashMap<>();

        data.put("links", links);
        data.put("total", links.size());

        te.render("/link.ftl", data, resp);
    }
}
