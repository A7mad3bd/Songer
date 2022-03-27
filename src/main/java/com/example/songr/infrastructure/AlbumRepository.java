package com.example.songr.infrastructure;

import com.example.songr.Models.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album,Long> {
     Album findAlbumByTitle(String name);
}
