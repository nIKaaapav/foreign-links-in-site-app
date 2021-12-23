package entyty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Site {
    private final int id;
    private final String link;

    public Site(int id, String link) {
        this.id = id;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Links{" +
                "id=" + id +
                ", link='" + link + '\'' +
                '}';
    }

}
