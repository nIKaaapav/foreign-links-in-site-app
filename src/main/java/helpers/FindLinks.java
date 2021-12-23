package helpers;

import entyty.LinkData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindLinks {
    private static String SELECT_CSS_QUERY = "a";
    private static String SELECT_CSS_ATTRIBUTE = "href";

    private static void findForeignHref(List<LinkData> linksOnForeignSites, List<String> visitedLinksInThisSite, String url, String baseUrl, int level) throws IOException {
       Document doc = Jsoup.connect(url).get();

       Elements elements = doc.select(SELECT_CSS_QUERY);

       List<String> hrefs = elements.stream().map(x -> x.absUrl(SELECT_CSS_ATTRIBUTE)).filter(el -> !el.contains(baseUrl)).collect(Collectors.toList());
       linksOnForeignSites.add(new LinkData(linksOnForeignSites.size() + 1, url, hrefs.size(), level));

        for(Element element : elements){
            String href = element.absUrl(SELECT_CSS_ATTRIBUTE);
            if (href.contains(baseUrl) && !href.equals(baseUrl) && !visitedLinksInThisSite.contains(href)){
                visitedLinksInThisSite.add(href);
                findForeignHref(linksOnForeignSites, visitedLinksInThisSite, href, baseUrl, level + 1);
            }
        }
    }

    public static List<LinkData> getAllLinks(String url) {
        ArrayList<LinkData> listForeign = new ArrayList<>();
        ArrayList<String> listThisSite = new ArrayList<>();
        try {
            findForeignHref(listForeign, listThisSite,url, url, 1);
            System.out.println(listForeign.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listForeign;
    }
}
