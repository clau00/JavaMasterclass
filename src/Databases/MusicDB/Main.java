package Databases.MusicDB;

import Databases.MusicDB.model.Artist;
import Databases.MusicDB.model.Datasource;
import Databases.MusicDB.model.SongArtist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()){
            System.out.println("Cannot open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_DESC);
        if(artists == null) {
            System.out.println("No artists!");
            return;
        }
        for(Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albums = datasource.queryAlbumsForArtist("Carole King", Datasource.ORDER_BY_ASC);
        if(albums == null) {
            System.out.println("No albums!");
            return;
        }
        for(String album : albums) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsBySong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if(songArtists == null) {
            System.out.println("No artist for the song!");
            return;
        }
        for(SongArtist songArtist : songArtists) {
            System.out.println("Artist: " + songArtist.getSongArtist() + ", Album: " + songArtist.getAlbumName() + ", Track: " + songArtist.getTrack());
        }

        datasource.querySongsMetadata();

        int numSongs = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + numSongs);

        datasource.createViewForSOngArtists();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a title: ");
        String title = scanner.nextLine();

        List<SongArtist> songArtistsList = datasource.querySongInfoView(title);
        if(songArtistsList.isEmpty()) {
            System.out.println("No artist for the song!");
            return;
        }
        for(SongArtist songArtist : songArtistsList) {
            System.out.println("FROM VIEW - Artist: " + songArtist.getSongArtist() + ", Album: " + songArtist.getAlbumName() + ", Track: " + songArtist.getTrack());
        }

        datasource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark", 1);

        datasource.close();
    }

}
