package sod.songs.domain.actions;

import sod.songs.domain.entities.Song;
import sod.songs.domain.entities.SongTitle;
import sod.songs.domain.entities.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class CreateSong {

    public Song create(String songTitle, List<String> requestTags) {
        List<Tag> tags = requestTags.stream().map(tag -> new Tag(tag)).collect(Collectors.toList());
        return new Song(new SongTitle(songTitle), tags);

    }
}
