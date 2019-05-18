package sod.songs.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SongControllerTest {

    public static final String FIRST_SONG = "First Song";
    public static final String CLASSICAL = "classical";
    public static final String TITLE = "title";
    public static final String TAGS = "tags";
    @Autowired
    private MockMvc mvc;

    @Test
    public void whenCreatesASongRetrieves200AndJsonRepresentation() throws Exception {
        JSONArray tagsJson = new JSONArray();
        tagsJson.put(CLASSICAL);

        JSONObject songJson = new JSONObject();
        songJson.put(TITLE, FIRST_SONG);
        songJson.put(TAGS, tagsJson);

        mvc.perform(MockMvcRequestBuilders.post("/songs")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(songJson.toString()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(FIRST_SONG))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tags").value(CLASSICAL));
    }
}
