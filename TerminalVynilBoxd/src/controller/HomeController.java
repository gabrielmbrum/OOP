package controller;

import service.HomeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HomeController {
    private HomeService service;
    public List<Integer> globalSearch (String text) {
        List<Integer> songsId = service.searchSongs(text);
        songsId.add(-1); //divisor of songs ids and artists ids
        List<Integer> artistsId = service.searchArtists(text);

        return (Stream.concat(songsId.stream(), artistsId.stream()).toList());
    }
}
