/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Actor;
import hr.algebra.model.Director;
import hr.algebra.model.Genre;
import hr.algebra.model.Movie;
import hr.algebra.model.MovieActor;
import hr.algebra.model.MovieDirector;
import hr.algebra.model.MovieGenre;
import hr.algebra.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class SqlRepository <T> implements Repository <T> {

    private static final String DELETE_ALL_TABLES = "{ CALL DeleteAllTables () }";
    
    private static final String ID_ACTOR = "IDActor";
    private static final String ACTOR_NAME = "Name";

    private static final String CREATE_ACTOR = "{ CALL CreateActor (?,?) }";
    private static final String UPDATE_ACTOR = "{ CALL UpdateActor (?,?) }";
    private static final String DELETE_ACTOR = "{ CALL DeleteActor (?) }";
    private static final String SELECT_ACTOR = "{ CALL SelectActor (?) }";
    private static final String SELECT_ACTORS = "{ CALL SelectActors }";
    
    
    private static final String ID_DIRECTOR = "IDDirector";
    private static final String DIRECTOR_NAME = "Name";

    private static final String CREATE_DIRECTOR = "{ CALL CreateDirector (?,?) }";
    private static final String UPDATE_DIRECTOR = "{ CALL UpdateDirector (?,?) }";
    private static final String DELETE_DIRECTOR = "{ CALL DeleteDirector (?) }";
    private static final String SELECT_DIRECTOR = "{ CALL SelectDirector (?) }";
    private static final String SELECT_DIRECTORS = "{ CALL SelectDirectors }";
    
    
    private static final String ID_GENRE = "IDGenre";
    private static final String GENRE_NAME = "Name";

    private static final String CREATE_GENRE = "{ CALL CreateGenre (?,?) }";
    private static final String UPDATE_GENRE = "{ CALL UpdateGenre (?,?) }";
    private static final String DELETE_GENRE = "{ CALL DeleteGenre (?) }";
    private static final String SELECT_GENRE = "{ CALL SelectGenre (?) }";
    private static final String SELECT_GENRES = "{ CALL SelectGenres }";
    
    
    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String PUBDATE = "PubDate";
    private static final String DESCRIPTION = "Description";
    private static final String DURATION = "Duration";
    private static final String YEAR = "Year";
    private static final String POSTERURL = "PosterURL";
    private static final String TRAILERURL = "TrailerURL";

    private static final String CREATE_MOVIE = "{ CALL CreateMovie (?,?,?,?,?,?,?,?) }";
    private static final String UPDATE_MOVIE = "{ CALL UpdateMovie (?,?,?,?,?,?,?,?) }";
    private static final String DELETE_MOVIE = "{ CALL DeleteMovie (?) }";
    private static final String SELECT_MOVIE = "{ CALL SelectMovie (?) }";
    private static final String SELECT_MOVIES = "{ CALL SelectMovies }";
    
    
    private static final String MOVIE_ID = "MovieID";
    private static final String ACTOR_ID = "ActorID";

    private static final String CREATE_MOVIE_ACTOR = "{ CALL CreateMovieActor (?,?) }";
    private static final String DELETE_MOVIE_ACTOR = "{ CALL DeleteMovieActor (?,?) }";
    private static final String DELETE_MOVIE_ACTORS = "{ CALL DeleteMovieActors (?) }";
    private static final String GET_ACTORS_FOR_MOVIE = "{ CALL GetMovieActors (?) }";
    private static final String GET_MOVIES_FOR_ACTOR = "{ CALL GetActorMovies (?) }";
    
    private static final String GENRE_ID = "GenreID";
    
    private static final String CREATE_MOVIE_GENRE = "{ CALL CreateMovieGenre (?,?) }";
    private static final String DELETE_MOVIE_GENRE = "{ CALL DeleteMovieGenre (?,?) }";
    private static final String DELETE_MOVIE_GENRES = "{ CALL DeleteMovieGenres (?) }";
    private static final String GET_GENRES_FOR_MOVIE = "{ CALL GetMovieGenres (?) }";
    private static final String GET_MOVIES_FOR_GENRE = "{ CALL GetGenreMovies (?) }";
    
    private static final String DIRECTOR_ID = "DirectorID";
    
    private static final String CREATE_MOVIE_DIRECTOR = "{ CALL CreateMovieDirector (?,?) }";
    private static final String DELETE_MOVIE_DIRECTOR = "{ CALL DeleteMovieDirector (?,?) }";
    private static final String DELETE_MOVIE_DIRECTORS = "{ CALL DeleteMovieDirectors (?) }";
    private static final String GET_DIRECTORS_FOR_MOVIE = "{ CALL GetMovieDirectors (?) }";
    private static final String GET_MOVIES_FOR_DIRECTOR = "{ CALL GetDirectorMovies (?) }";
    
    private static final String ID_USER = "IDUser";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String ROLE_ID = "RoleID";
    
    private static final String CREATE_USER  = "{ CALL CreateUser (?, ?, ?) }";
    private static final String SELECT_USER = "{ CALL SelectUser (?, ?) }";
    private static final String SELECT_USER_BY_USERNAME = "{ CALL SelectUserByUsername (?) }";

    @Override
    public int createActor(Actor actor) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_ACTOR)) {
            
            stmt.setString(ACTOR_NAME, actor.getName());
            
            stmt.registerOutParameter(ID_ACTOR, Types.INTEGER);
            
            stmt.executeUpdate();
            
            return stmt.getInt(ID_ACTOR);
            
        }
    }

    @Override
    public void createActors(List<Actor> actors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_ACTOR)) {
            
            for (Actor actor : actors) {
                stmt.setString(ACTOR_NAME, actor.getName());
                
                stmt.registerOutParameter(ID_ACTOR, Types.INTEGER);
                
                stmt.executeUpdate();   
            }
        }
    }

    @Override
    public void updateActor(int id, Actor actor) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(UPDATE_ACTOR)) {
            
            stmt.setString(ACTOR_NAME, actor.getName());
            
            stmt.setInt(ID_ACTOR, id);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public void deleteActor(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_ACTOR)) {

            stmt.setInt(ID_ACTOR, id);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public Optional<Actor> selectActor(int id) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_ACTOR)) {

            stmt.setInt(ID_ACTOR, id);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    return Optional.of(new Actor(
                            rs.getInt(ID_ACTOR), 
                            rs.getString(ACTOR_NAME) )
                    );
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Actor> selectActors() throws Exception {
        List<Actor> actors = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_ACTORS)) {
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    actors.add(new Actor(
                            rs.getInt(ID_ACTOR), 
                            rs.getString(ACTOR_NAME))
                    );
                }
            }
        }
        
        return actors;
    }

    @Override
    public int createDirector(Director director) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_DIRECTOR)) {
            
            stmt.setString(DIRECTOR_NAME, director.getName());
            
            stmt.registerOutParameter(ID_DIRECTOR, Types.INTEGER);
            
            stmt.executeUpdate();
            
            return stmt.getInt(ID_DIRECTOR);
            
        }
    }

    @Override
    public void createDirectors(List<Director> directors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_DIRECTOR)) {
            
            for (Director director : directors) {
                stmt.setString(DIRECTOR_NAME, director.getName());
                
                stmt.registerOutParameter(ID_DIRECTOR, Types.INTEGER);
                
                stmt.executeUpdate();   
            }
        }
    }

    @Override
    public void updateDirector(int id, Director director) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(UPDATE_DIRECTOR)) {
            
            stmt.setString(DIRECTOR_NAME, director.getName());
            
            stmt.setInt(ID_DIRECTOR, id);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public void deleteDirector(int id) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_DIRECTOR)) {

            stmt.setInt(ID_DIRECTOR, id);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public Optional<Director> selectDirector(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_DIRECTOR)) {

            stmt.setInt(ID_DIRECTOR, id);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    return Optional.of(new Director(
                            rs.getInt(ID_DIRECTOR), 
                            rs.getString(DIRECTOR_NAME) )
                    );
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Director> selectDirectors() throws Exception {
        List<Director> directors = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_DIRECTORS)) {
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    directors.add(new Director(
                            rs.getInt(ID_DIRECTOR), 
                            rs.getString(DIRECTOR_NAME))
                    );
                }
            }
        }
        
        return directors;
    }

    @Override
    public int createGenre(Genre genre) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_GENRE)) {
            
            stmt.setString(GENRE_NAME, genre.getName());
            
            stmt.registerOutParameter(ID_GENRE, Types.INTEGER);
            
            stmt.executeUpdate();
            
            return stmt.getInt(ID_GENRE);
            
        }
    }

    @Override
    public void createGenres(List<Genre> genres) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_GENRE)) {
            
            for (Genre genre : genres) {
                stmt.setString(GENRE_NAME, genre.getName());
                
                stmt.registerOutParameter(ID_GENRE, Types.INTEGER);
                
                stmt.executeUpdate();   
            }
        }
    }

    @Override
    public void updateGenre(int id, Genre genre) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(UPDATE_GENRE)) {
            
            stmt.setString(GENRE_NAME, genre.getName());
            
            stmt.setInt(ID_GENRE, id);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public void deleteGenre(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_GENRE)) {

            stmt.setInt(ID_GENRE, id);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public Optional<Genre> selectGenre(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_GENRE)) {

            stmt.setInt(ID_GENRE, id);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    return Optional.of(new Genre(
                            rs.getInt(ID_GENRE), 
                            rs.getString(GENRE_NAME) )
                    );
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Genre> selectGenres() throws Exception {
        List<Genre> genres = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_GENRES)) {
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    genres.add(new Genre(
                            rs.getInt(ID_GENRE), 
                            rs.getString(GENRE_NAME))
                    );
                }
            }
        }
        
        return genres;
    }

    @Override
    public int createMovie(Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {
            
            stmt.setString(TITLE, movie.getTitle());
            stmt.setString(PUBDATE, movie.getPubDate().format(Movie.DATE_FORMATTER));
            stmt.setString(DESCRIPTION, movie.getDescription());
            stmt.setInt(DURATION, movie.getDuration());
            stmt.setInt(YEAR, movie.getYear());
            stmt.setString(POSTERURL, movie.getPosterURL());
            stmt.setString(TRAILERURL, movie.getTrailerURL());
            
            stmt.registerOutParameter(ID_MOVIE, Types.INTEGER);
            
            stmt.executeUpdate();
            
            return stmt.getInt(ID_MOVIE);
            
        }
    }

    @Override
    public void createMovies(List<Movie> movies) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {
            
            for (Movie movie : movies) {
                stmt.setString(TITLE, movie.getTitle());
                stmt.setString(PUBDATE, movie.getPubDate().format(Movie.DATE_FORMATTER));
                stmt.setString(DESCRIPTION, movie.getDescription());
                stmt.setInt(DURATION, movie.getDuration());
                stmt.setInt(YEAR, movie.getYear());
                stmt.setString(POSTERURL, movie.getPosterURL());
                stmt.setString(TRAILERURL, movie.getTrailerURL());
                
                stmt.registerOutParameter(ID_MOVIE, Types.INTEGER);
                
                stmt.executeUpdate();   
            }
        }
    }

    @Override
    public void updateMovie(int id, Movie movie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(UPDATE_MOVIE)) {
            
            stmt.setString(TITLE, movie.getTitle());
            stmt.setString(PUBDATE, movie.getPubDate().format(Movie.DATE_FORMATTER));
            stmt.setString(DESCRIPTION, movie.getDescription());
            stmt.setInt(DURATION, movie.getDuration());
            stmt.setInt(YEAR, movie.getYear());
            stmt.setString(POSTERURL, movie.getPosterURL());
            stmt.setString(TRAILERURL, movie.getTrailerURL());
            
            stmt.setInt(ID_MOVIE, id);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public void deleteMovie(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_MOVIE)) {

            stmt.setInt(ID_MOVIE, id);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public Optional<Movie> selectMovie(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_MOVIE)) {

            stmt.setInt(ID_MOVIE, id);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    return Optional.of(
                    new Movie(
                            rs.getInt(ID_MOVIE), 
                            rs.getString(TITLE), 
                            LocalDateTime.parse(
                            rs.getString(PUBDATE),Movie.DATE_FORMATTER
                            ), 
                            rs.getString(DESCRIPTION), 
                            rs.getInt(DURATION), 
                            rs.getInt(YEAR), 
                            rs.getString(POSTERURL), 
                            rs.getString(TRAILERURL))
                    );
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Movie> selectMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_MOVIES)) {
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    movies.add(
                    new Movie(
                            rs.getInt(ID_MOVIE), 
                            rs.getString(TITLE), 
                            LocalDateTime.parse(
                            rs.getString(PUBDATE), Movie.DATE_FORMATTER
                            ), 
                            rs.getString(DESCRIPTION), 
                            rs.getInt(DURATION), 
                            rs.getInt(YEAR), 
                            rs.getString(POSTERURL), 
                            rs.getString(TRAILERURL))
                    );
                }
            }
        }
        
        return movies;
    }

    @Override
    public void createMovieActor(MovieActor movieActor) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_MOVIE_ACTOR)) {
            
            stmt.setInt(MOVIE_ID, movieActor.getMovieID());
            stmt.setInt(ACTOR_ID, movieActor.getActorID());
            
            stmt.executeUpdate();
        }
    }

    @Override
    public void createMovieActors(List<MovieActor> movieActors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_MOVIE_ACTOR)) {
            
            for (MovieActor movieActor : movieActors) {
                stmt.setInt(MOVIE_ID, movieActor.getMovieID());
                stmt.setInt(ACTOR_ID, movieActor.getActorID());
                
                stmt.executeUpdate();   
            }
        }
    }

    @Override
    public void deleteMovieActor(int movieID, int actorID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_MOVIE_ACTOR)) {

            stmt.setInt(MOVIE_ID, movieID);
            stmt.setInt(ACTOR_ID, actorID);
            
            stmt.executeUpdate(); 
        }
    }
    
    @Override
    public void deleteMovieActors(int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_MOVIE_ACTORS)) {

            stmt.setInt(MOVIE_ID, movieID);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public List<Actor> getActorsForMovie(int movieID) throws Exception {
        List<Actor> actors = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(GET_ACTORS_FOR_MOVIE)) {
            
            stmt.setInt(MOVIE_ID, movieID);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    actors.add(new Actor(
                            rs.getInt(ID_ACTOR), 
                            rs.getString(ACTOR_NAME))
                    );
                }
            }
        }catch (SQLException e) {
        throw new Exception("Error fetching movie actors", e);
        }
        
        return actors;
    }

    @Override
    public List<Movie> getMoviesForActor(int actorID) throws Exception {
        List<Movie> movies = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(GET_MOVIES_FOR_ACTOR)) {
            
            stmt.setInt(ACTOR_ID, actorID);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    movies.add(
                    new Movie(
                            rs.getInt(ID_MOVIE), 
                            rs.getString(TITLE), 
                            LocalDateTime.parse(
                            rs.getString(PUBDATE), Movie.DATE_FORMATTER
                            ), 
                            rs.getString(DESCRIPTION), 
                            rs.getInt(DURATION), 
                            rs.getInt(YEAR), 
                            rs.getString(POSTERURL), 
                            rs.getString(TRAILERURL))
                    );
                }
            }
        }catch (SQLException e) {
        throw new Exception("Error fetching movie actors", e);
        }
        
        return movies;
    }

    @Override
    public int createMovieGenre(MovieGenre movieGenre) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_MOVIE_GENRE)) {
            
            stmt.setInt(MOVIE_ID, movieGenre.getMovieID());
            stmt.setInt(GENRE_ID, movieGenre.getGenreID());
            
            stmt.executeUpdate();
           
            return stmt.getInt(MOVIE_ID);
        }
    }

    @Override
    public void createMovieGenres(List<MovieGenre> movieGenres) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_MOVIE_GENRE)) {
            
            for (MovieGenre movieGenre : movieGenres) {
                stmt.setInt(MOVIE_ID, movieGenre.getMovieID());
                stmt.setInt(GENRE_ID, movieGenre.getGenreID());
                
                stmt.executeUpdate();   
            }
        }
    }

    @Override
    public void deleteMovieGenre(int movieID, int genreID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_MOVIE_GENRE)) {

            stmt.setInt(MOVIE_ID, movieID);
            stmt.setInt(GENRE_ID, genreID);
            
            stmt.executeUpdate(); 
        }
    }
    
    @Override
    public void deleteMovieGenres(int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_MOVIE_GENRES)) {

            stmt.setInt(MOVIE_ID, movieID);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public List<Genre> getGenresForMovie(int movieID) throws Exception {
        List<Genre> genres = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(GET_GENRES_FOR_MOVIE)) {
            
            stmt.setInt(MOVIE_ID, movieID);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    genres.add(new Genre(
                            rs.getInt(ID_GENRE), 
                            rs.getString(GENRE_NAME))
                    );
                }
            }
        }catch (SQLException e) {
        throw new Exception("Error fetching movie actors", e);
        }
        
        return genres;
    }

    @Override
    public List<Movie> getMoviesForGenre(int genreID) throws Exception {
        List<Movie> movies = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(GET_MOVIES_FOR_GENRE)) {
            
            stmt.setInt(GENRE_ID, genreID);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    movies.add(
                    new Movie(
                            rs.getInt(ID_MOVIE), 
                            rs.getString(TITLE), 
                            LocalDateTime.parse(
                            rs.getString(PUBDATE), Movie.DATE_FORMATTER
                            ), 
                            rs.getString(DESCRIPTION), 
                            rs.getInt(DURATION), 
                            rs.getInt(YEAR), 
                            rs.getString(POSTERURL), 
                            rs.getString(TRAILERURL))
                    );
                }
            }
        }catch (SQLException e) {
        throw new Exception("Error fetching movie actors", e);
        }
        
        return movies;
    }

    @Override
    public int createMovieDirector(MovieDirector movieDirector) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_MOVIE_DIRECTOR)) {
            
            stmt.setInt(MOVIE_ID, movieDirector.getMovieID());
            stmt.setInt(DIRECTOR_ID, movieDirector.getDirectorID());
            
            stmt.executeUpdate();
           
            return stmt.getInt(MOVIE_ID);
        }
    }

    @Override
    public void createMovieDirectors(List<MovieDirector> movieDirectors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(CREATE_MOVIE_DIRECTOR)) {
            
            for (MovieDirector movieDirector : movieDirectors) {
                stmt.setInt(MOVIE_ID, movieDirector.getMovieID());
                stmt.setInt(DIRECTOR_ID, movieDirector.getDirectorID());
                
                stmt.executeUpdate();   
            }
        }
    }

    @Override
    public void deleteMovieDirector(int movieID, int directorID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_MOVIE_DIRECTOR)) {

            stmt.setInt(MOVIE_ID, movieID);
            stmt.setInt(DIRECTOR_ID, directorID);
            
            stmt.executeUpdate(); 
        }
    }
    
    @Override
    public void deleteMovieDirectors(int movieID) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_MOVIE_DIRECTORS)) {

            stmt.setInt(MOVIE_ID, movieID);
            
            stmt.executeUpdate(); 
        }
    }

    @Override
    public List<Director> getDirectorsForMovie(int movieID) throws Exception {
        List<Director> directors = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(GET_DIRECTORS_FOR_MOVIE)) {
            
            stmt.setInt(MOVIE_ID, movieID);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    directors.add(new Director(
                            rs.getInt(ID_DIRECTOR), 
                            rs.getString(DIRECTOR_NAME))
                    );
                }
            }
        }catch (SQLException e) {
        throw new Exception("Error fetching movie actors", e);
        }
        
        return directors;
    }

    @Override
    public List<Movie> getMoviesForDirector(int directorID) throws Exception {
        List<Movie> movies = new ArrayList<>();
        
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(GET_MOVIES_FOR_DIRECTOR)) {
            
            stmt.setInt(DIRECTOR_ID, directorID);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    movies.add(
                    new Movie(
                            rs.getInt(ID_MOVIE), 
                            rs.getString(TITLE), 
                            LocalDateTime.parse(
                            rs.getString(PUBDATE), Movie.DATE_FORMATTER
                            ), 
                            rs.getString(DESCRIPTION), 
                            rs.getInt(DURATION), 
                            rs.getInt(YEAR), 
                            rs.getString(POSTERURL), 
                            rs.getString(TRAILERURL))
                    );
                }
            }
        }catch (SQLException e) {
        throw new Exception("Error fetching movie actors", e);
        }
        
        return movies;
    }

    @Override
    public void deleteAllTables() throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(DELETE_ALL_TABLES)) {
            
            stmt.executeUpdate(); 
        }catch (SQLException e) {
        throw new Exception("Error fetching movie actors", e);
        }
    }

    @Override
    public int createUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_USER)) {
            stmt.setString(USERNAME, user.getUsername());
            stmt.setString(PASSWORD, user.getPassword());

            stmt.registerOutParameter(ID_USER, Types.INTEGER);

            stmt.executeUpdate();

            return stmt.getInt(ID_USER);
        } catch (SQLException e) {
            throw new Exception("Error fetching movie actors", e);
        }
    }

    @Override
    public Optional<User> selectUser(String username, String password) throws Exception {
         DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_USER)) {

            stmt.setString(USERNAME, username);
            stmt.setString(PASSWORD, password);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    return Optional.of(new User(
                            rs.getInt(ID_USER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getInt(ROLE_ID))
                    );
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> selectUserByUserName(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        
        try(Connection con = dataSource.getConnection();
            CallableStatement stmt = con.prepareCall(SELECT_USER_BY_USERNAME)) {

            stmt.setString(USERNAME, username);
            
            try(ResultSet rs = stmt.executeQuery())
            {
                if(rs.next())
                {
                    return Optional.of(new User(
                            rs.getInt(ID_USER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getInt(ROLE_ID))
                    );
                }
            }
        }
        return Optional.empty();
    }

    


}
