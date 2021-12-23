package entyty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LinkData {
    private final int id;
    private final String link;
    private final int level;
    private final int countsForeignLinks;

    public LinkData(int id, String link, int countsForeignLinks, int level) {
        this.id = id;
        this.link = link;
        this.countsForeignLinks = countsForeignLinks;
        this.level = level;
    }

    @Override
    public String toString() {
        return "LinkData{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", level=" + level +
                ", countsForeignLinks=" + countsForeignLinks +
                '}';
    }
}
