package sod.songs.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateSongRequest {
    public List<String> tags;
    public String title;

    @JsonCreator
    public CreateSongRequest(@JsonProperty("title") String title, @JsonProperty("tags") List<String> tags) {
        this.tags = tags;
        this.title = title;
    }
}
