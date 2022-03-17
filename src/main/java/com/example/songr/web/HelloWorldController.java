package com.example.songr.web;

import com.example.songr.domain.Album;
import com.example.songr.infrastructure.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@RestController
@Controller
public class HelloWorldController {

    @Autowired//from albumRepository
    //provides more fine-grained control over where and how autowiring
    // should be accomplished provides more fine-grained control over where
    // and how autowiring should be accomplished
    AlbumRepository albumRepository;

    @RequestMapping("/")
    public ModelAndView Hello() {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("songer");
            return modelAndView;
    }

    @RequestMapping("/hello")
    String HelloWorld() {
        return "Hello World";
    }

    @GetMapping("/capitalize/{name}")
    public String getcapitalize(@PathVariable String name) {
        return name.toUpperCase();
    }


    @ResponseBody
    @GetMapping("/album")
    List<Album> getAllalbums() {
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("One", "Maher Zain", 15, 47.16, "https://pbs.twimg.com/media/Cj9cwB1WUAAXGp5?format=jpg&name=medium"));
        albums.add(new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU"));
        albums.add(new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU"));
        return albums;
    }
    @ResponseBody
    @GetMapping("/albums")
    String getalbums(Model Data) {
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("One", "Maher Zain", 15, 47.16, "https://pbs.twimg.com/media/Cj9cwB1WUAAXGp5?format=jpg&name=medium"));
        albums.add(new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU"));
        albums.add(new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU"));
       Data.addAttribute(albums);
        return "songer";
    }
}



