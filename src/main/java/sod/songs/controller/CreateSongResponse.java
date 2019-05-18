package sod.songs.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import sod.songs.domain.entities.Song;

import java.util.List;
import java.util.stream.Collectors;

public class CreateSongResponse {

    @JsonProperty("title") public final String title;
    @JsonProperty("tags") public final List<String> tags;

    public CreateSongResponse(Song song) {
        this.title = song.getTitle();
        this.tags = song.getTags().stream().map(tag-> tag.name).collect(Collectors.toList());
    }
}
