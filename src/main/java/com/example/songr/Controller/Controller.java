package com.example.songr.Controller;

import com.example.songr.Models.Album;
import com.example.songr.Models.Song;
import com.example.songr.infrastructure.AlbumRepository;
import com.example.songr.infrastructure.SongRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {


    //from albumRepository
    //provides more fine-grained control over where and how autowiring
    // should be accomplished provides more fine-grained control over where
    // and how autowiring should be accomplished

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;


    public Controller(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @RequestMapping("/")
    String HelloWorld() {
        return "index";
    }

    @GetMapping("/capitalize/{name}")
    public String getcapitalize(@PathVariable String name) {
        return name.toUpperCase();
    }

    //    @ResponseBody
    @GetMapping("/albumslist")
    public ModelAndView getthreealbum(Model model) {
        List<String> albums = new ArrayList<>();

        Album alb1 = new Album("One", "Maher Zain", 15, 47.16, "https://pbs.twimg.com/media/Cj9cwB1WUAAXGp5?format=jpg&name=medium");
        Album alb2 = new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU");
        Album alb3 = new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU");
        albums.add(" Album Title : " + alb1.getTitle() + " and Artist is : " + alb1.getArtist() + " and Album Length is " + alb1.getLength());
        albums.add(" Album Title : " + alb2.getTitle() + " and Artist is : " + alb2.getArtist() + " and Album Length is " + alb2.getLength());
        albums.add(" Album Title : " + alb3.getTitle() + " and Artist is : " + alb3.getArtist() + " and Album Length is " + alb3.getLength());

        model.addAttribute("albumslist", albums);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("albumslist");
        return modelAndView;

    }

    @RequestMapping(value = "/addalbum", method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView createNewAlbum(@ModelAttribute Album album) {
        albumRepository.save(album);
        return new RedirectView("allalbums");
    }

    @GetMapping("/allalbums")
    public String getAllAlbums(Model model) {
        model.addAttribute("albumsList", albumRepository.findAll());
        return "albums";
    }

    //A user should be able to see the songs that belong to an album when looking at that album.
    //A user should be able to see information about all the songs on the site.
    @GetMapping("/allsongs")
    public String getAllSongs(Model model) {
        model.addAttribute("songlist", songRepository.findAll());
        return "Song";
    }

    @ResponseBody
    @PostMapping("/createsong")
    public RedirectView createNewSong(@ModelAttribute Song song,@RequestParam Long id,Model model) {
        model.addAttribute("albums",albumRepository.findAll());

        Album alb = albumRepository.getAlbumById(id);
        if(alb!=null) {
            Song s1=new Song(song.getTitle(),song.getLength(),song.getTrack_number(),alb);
            songRepository.save(s1);
        }
        return new RedirectView("allsongs");
    }
    @GetMapping("/createsong")
    public String ViewSong(Model model) {
        model.addAttribute("albums",albumRepository.findAll());
        return "Song";
    }

//    //    @PostMapping("/createsong")
//    @RequestMapping(value = "/createsong", method = {RequestMethod.GET, RequestMethod.POST})
//    public String createNewSong(@ModelAttribute String title, @ModelAttribute Long length, @ModelAttribute Long track_number, @ModelAttribute Album album) {
//        Song s1 = new Song(title, length, track_number, album);
//        songRepository.save(s1);
//        return ("allsongs");
//    }

    // A user should be able to view a page with data about one particular album.
    @ResponseBody
    @GetMapping("/album/{id}")
    Album getAlbum(@PathVariable Long id, Model model) {
        Album album = albumRepository.findById(id).orElseThrow(IllegalStateException::new);
        return album;
    }

    //A user should be able to add songs to an album.
    @RequestMapping(value = "/addsongto/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView createNewSong(@PathVariable Long id, @ModelAttribute Song song) {
        Album foundAlbum = albumRepository.findById(id).get();
        song.setAlbum(foundAlbum);
        songRepository.save(song);
        return new RedirectView("/allsongs");
    }
}