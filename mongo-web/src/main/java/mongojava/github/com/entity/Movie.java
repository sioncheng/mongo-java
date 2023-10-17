package mongojava.github.com.entity;

import java.io.Serializable;

public class Movie implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;

    private String title;

    private Integer year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
