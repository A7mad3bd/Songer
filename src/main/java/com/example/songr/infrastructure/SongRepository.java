package com.example.songr.infrastructure;

import com.example.songr.Models.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {

}
