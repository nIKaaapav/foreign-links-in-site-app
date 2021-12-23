package servlet;

import entyty.Site;
import servise.LinksService;
import servise.SiteService;
import templete.TemplateEngine;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeServlet extends HttpServlet {
    private final TemplateEngine te = TemplateEngine.folder();
    final Connection connection;
    final SiteService siteService;
    final LinksService linksService;

    public HomeServlet(Connection conn) {
        connection = conn;
        siteService = new SiteService(conn);
        linksService = new LinksService(conn);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Site> products = siteService.getLinks();
            Map<String, Object> data = new HashMap<>();
            data.put("links", products);

            te.render("/home.ftl", data, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String link = req.getParameter("link");
        siteService.postLink(link);
        linksService.postLinks(link);

        resp.sendRedirect("/link?url=" + link);
    }
}
