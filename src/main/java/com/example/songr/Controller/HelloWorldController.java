package com.example.songr.Controller;

import com.example.songr.Models.Album;
import com.example.songr.infrastructure.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    AlbumRepository albumRepository;
    //from albumRepository
    //provides more fine-grained control over where and how autowiring
    // should be accomplished provides more fine-grained control over where
    // and how autowiring should be accomplished

    @RequestMapping("/")
    public ModelAndView Hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("songer");
        return modelAndView;
    }

    @RequestMapping("/hello")
    String HelloWorld() {
        return "index";
    }

    @GetMapping("/capitalize/{name}")
    public String getcapitalize(@PathVariable String name) {
        return name.toUpperCase();
    }

    @ResponseBody
    @GetMapping("/albums")
    public ModelAndView getthreealbum(Model model) {
        List<String> albums = new ArrayList<>();

        Album alb1 = new Album("One", "Maher Zain", 15, 47.16, "https://pbs.twimg.com/media/Cj9cwB1WUAAXGp5?format=jpg&name=medium");
        Album alb2 = new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU");
        Album alb3 = new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU");
        albums.add("Album Title : " + alb1.getTitle() + " and Artist is : " + alb1.getArtist() + "and Album Length is" + alb1.getLength());
        albums.add("Album Title : " + alb2.getTitle() + " and Artist is : " + alb2.getArtist() + "and Album Length is" + alb2.getLength());
        albums.add("Album Title : " + alb3.getTitle() + " and Artist is : " + alb3.getArtist() + "and Album Length is" + alb3.getLength());

        model.addAttribute("AlbumsList", alb1);
        model.addAttribute("AlbumsList", alb2);
        model.addAttribute("AlbumsList", alb2);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("songer");
        return modelAndView;

    }


    @PostMapping("/addalbum")
    public RedirectView createNewAlbum(@ModelAttribute Album album) {
        albumRepository.save(album);
        return new RedirectView("allalbums");
    }

    @GetMapping("/allalbums")
    public String getAllAlbums(Model model) {
        model.addAttribute("AlbumsList", albumRepository.findAll());
        return "songer";
    }

}



