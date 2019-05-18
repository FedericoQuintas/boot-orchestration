package sod.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sod.songs.domain.actions.CreateSong;

@Configuration
public class ActionsConfiguration {

    @Bean
    public CreateSong createSongAction() {
        return new CreateSong();
    }
}

