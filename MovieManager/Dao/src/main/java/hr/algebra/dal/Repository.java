/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.model.Actor;
import hr.algebra.model.Movie;
import hr.algebra.model.Director;
import hr.algebra.model.Genre;
import hr.algebra.model.MovieActor;
import hr.algebra.model.MovieDirector;
import hr.algebra.model.MovieGenre;
import hr.algebra.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author andru
 */
public interface Repository {

    int createActor(Actor actor) throws Exception;
    void createActors(List<Actor> actors) throws Exception;
    void updateActor(int id, Actor actor) throws Exception;
    void deleteActor(int id) throws Exception;
    Optional<Actor> selectActor(int id) throws Exception;
    List<Actor> selectActors() throws Exception;

    int createDirector(Director director) throws Exception;
    void createDirectors(List<Director> directors) throws Exception;
    void updateDirector(int id, Director director) throws Exception;
    void deleteDirector(int id) throws Exception;
    Optional<Director> selectDirector(int id) throws Exception;
    List<Director> selectDirectors() throws Exception;
    
    int createGenre(Genre genre) throws Exception;
    void createGenres(List<Genre> genres) throws Exception;
    void updateGenre(int id, Genre genre) throws Exception;
    void deleteGenre(int id) throws Exception;
    Optional<Genre> selectGenre(int id) throws Exception;
    List<Genre> selectGenres() throws Exception;
    
    int createMovie(Movie movie) throws Exception;
    void createMovies(List<Movie> movies) throws Exception;
    void updateMovie(int id, Movie movie) throws Exception;
    void deleteMovie(int id) throws Exception;
    Optional<Movie> selectMovie(int id) throws Exception;
    List<Movie> selectMovies() throws Exception;
    
    void createMovieActor(MovieActor movieActor) throws Exception;
    void createMovieActors(List<MovieActor> movieActors) throws Exception;
    void deleteMovieActor(int movieID, int actorID) throws Exception;
    void deleteMovieActors(int movieID) throws Exception;
    List<Actor> getActorsForMovie(int movieID) throws Exception;
    List<Movie> getMoviesForActor(int actorID) throws Exception;
    
    int createMovieGenre(MovieGenre movieGenre) throws Exception;
    void createMovieGenres(List<MovieGenre> movieGenres) throws Exception;
    void deleteMovieGenre(int movieID, int genreID) throws Exception;
    void deleteMovieGenres(int movieID) throws Exception;
    List<Genre> getGenresForMovie(int movieID) throws Exception;
    List<Movie> getMoviesForGenre(int genreID) throws Exception;
    
    
    int createMovieDirector(MovieDirector movieDirector) throws Exception;
    void createMovieDirectors(List<MovieDirector> movieDirectors) throws Exception;
    void deleteMovieDirector(int movieID, int directorID) throws Exception;
    void deleteMovieDirectors(int movieID) throws Exception;
    List<Director> getDirectorsForMovie(int movieID) throws Exception;
    List<Movie> getMoviesForDirector(int directorID) throws Exception;
    
    void deleteAllTables() throws Exception;
    
    int createUser(User user) throws Exception;
    Optional<User> selectUser(String username, String password) throws Exception;
    Optional<User> selectUserByUserName(String username) throws Exception;
}
