package com.example.songr.web;

import com.example.songr.domain.Album;
import com.example.songr.infrastructure.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @GetMapping("/albums")
    List<String> getAllalbums() {
        List<Album> albums = new ArrayList<>();
        List<String> alb_ins = new ArrayList<>();

        albums.add(new Album("One", "Maher Zain", 15, 47.16, "https://pbs.twimg.com/media/Cj9cwB1WUAAXGp5?format=jpg&name=medium"));
        albums.add(new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU"));
        albums.add(new Album("Ihlam Maaya", "Hamza Namira", 10, 35.45, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU"));

        Album alb1 = new Album("One", "Maher Zain", "https://pbs.twimg.com/media/Cj9cwB1WUAAXGp5?format=jpg&name=medium");
        Album alb2 = new Album("Ihlam Maaya", "Hamza Namira","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU");
        Album alb3 = new Album("Ihlam Maaya", "Hamza Namira",  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZr1Rfyq721YDFxEflgIp8jYgjgXftLlTjUT5qftdhm69lSs_zeITjNt9-dYFhmz7pAjc&usqp=CAU");

        alb_ins.add("Album Title : "+alb1.getTitle()+" and Artist is : " + alb1.getArtist()+ "and Album Length is"+alb1.getLength());
        alb_ins.add("Album Title : "+alb2.getTitle()+" and Artist is : " + alb2.getArtist()+ "and Album Length is"+alb2.getLength());
        alb_ins.add("Album Title : "+alb3.getTitle()+" and Artist is : " + alb3.getArtist()+ "and Album Length is"+alb3.getLength());

        return alb_ins;
    }

}



