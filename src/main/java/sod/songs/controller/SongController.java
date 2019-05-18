package sod.songs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sod.songs.domain.actions.CreateSong;
import sod.songs.domain.entities.Song;

@RestController
public class SongController {

    private final CreateSong createSong;

    @Autowired
    public SongController(CreateSong createSong) {
        this.createSong = createSong;
    }

    @RequestMapping(value = "/songs", method = RequestMethod.POST)
    public ResponseEntity<CreateSongResponse> post(@RequestBody CreateSongRequest request) {
        Song song = createSong.create(request.title, request.tags);
        return new ResponseEntity<>(new CreateSongResponse(song), HttpStatus.OK);
    }
}
