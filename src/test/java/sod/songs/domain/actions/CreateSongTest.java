package sod.songs.domain.actions;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;
import sod.songs.domain.entities.Song;
import sod.songs.domain.entities.Tag;

import java.util.Arrays;
import java.util.List;

import static com.greghaskins.spectrum.Spectrum.describe;
import static com.greghaskins.spectrum.Spectrum.it;
import static org.junit.Assert.assertEquals;

@RunWith(Spectrum.class)
public class CreateSongTest {


    {
        describe("when a user creates a Song", () -> {
            it("then it has a title and a list of tags", () -> {

                String title = "First Song";
                List<String> tags = Arrays.asList("classical");

                Song song = new CreateSong().create(title, tags);

                assertEquals(song.getTitle(), title);
                assertEquals(song.getTags(), Arrays.asList(new Tag("classical")));
                assertEquals(song.getTags().get(0).name, "classical");
            });
        });
    }
}