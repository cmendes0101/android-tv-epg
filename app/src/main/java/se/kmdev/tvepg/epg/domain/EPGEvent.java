package se.kmdev.tvepg.epg.domain;

/**
 * Created by Kristoffer.
 */
public class EPGEvent {

    private long start;
    private long end;
    private String title;
    private String imageURL;
    private String description;
    private int episodeSeason;
    private int episodeNumber;

    public long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCurrent() {
        long now = System.currentTimeMillis();
        return now >= start && now <= end;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEpisodeSeason() {
        return episodeSeason;
    }

    public void setEpisodeSeason(int episodeSeason) {
        this.episodeSeason = episodeSeason;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }


}
