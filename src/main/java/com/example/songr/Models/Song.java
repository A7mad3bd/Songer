package com.example.songr.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.*;

@JsonIgnoreProperties({"album"})
@Setter
@Getter
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private Long length;
    @NonNull
    private Long track_number;

    public Song() {
    }

    public Song(@NonNull String title, @NonNull Long length, @NonNull Long track_number, Album album) {
        this.title = title;
        this.length = length;
        this.track_number = track_number;
        this.album = album;
    }

    public Song(String title, long length, long track_number ) {
        this.title = title;
        this.length = length;
        this.track_number = track_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }


    public void setAlbum(Album album) {
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", trackNumber=" + track_number +
                ", album=" + album +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrack_number() {
        return track_number;
    }

    public void setTrack_number(Long track_number) {
        this.track_number = track_number;
    }

    @ManyToOne
    Album album;
}
