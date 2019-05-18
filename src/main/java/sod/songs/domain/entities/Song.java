package sod.songs.domain.entities;

import java.util.List;

public class Song {

    private final SongTitle title;
    private List<Tag> tags;

    public Song(SongTitle songTitle, List<Tag> tags) {
        this.title = songTitle;
        this.tags = tags;
    }

    public String getTitle() {
        return title.value;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
