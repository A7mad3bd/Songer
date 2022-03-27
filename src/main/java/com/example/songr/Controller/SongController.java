//package com.example.songr.Controller;
//import com.example.songr.Models.Album;
//import com.example.songr.Models.Song;
//import com.example.songr.infrastructure.AlbumRepository;
//import com.example.songr.infrastructure.SongRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//public class SongController {
//
//
//    private final SongRepository songRepository;
//    private final AlbumRepository albumRepository;
//
//
//    public SongController(SongRepository songRepository, AlbumRepository albumRepository) {
//        this.songRepository = songRepository;
//        this.albumRepository = albumRepository;
//    }
//
//    /**
//     * Creates a new Song
//     */
//    @ResponseBody
//    @PostMapping("/songs")
//    Song createNewSong(@ModelAttribute Song song) {
//    //    return SongRepository.save(song);
//    }
//
//    /**
//     * Creates a new Album
//     */
//    @ResponseBody
//    @PostMapping("/albums")
//    Album createNewAlbum(@RequestBody Album album) {
//        return AlbumRepository.save(album);
//    }
//
//
//    @ResponseBody
//    @GetMapping("/album/{title}")
//    Album findAlbumByTitle(@PathVariable String title) {
//        Album albumByTitle = AlbumRepository.findAlbumByTitle(title);
//        return albumByTitle;
//    }
//
//    /**
//     * Gets all the Songs
//     */
//    @ResponseBody
//    @GetMapping("/songs")
//    List<Song> getAllsongs() {
//        return (List<Song>) SongRepository.findAll();
//    }
//
//
//}
