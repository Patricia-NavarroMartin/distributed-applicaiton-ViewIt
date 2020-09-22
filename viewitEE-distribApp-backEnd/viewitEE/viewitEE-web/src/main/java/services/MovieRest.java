/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Movie;
import interceptors.LoggerInterceptor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sessionbeans.dao.MovieFacadeLocal;
import sessionbeans.singleton.ScreeningsCache;

@Path("/movies")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
@Interceptors(LoggerInterceptor.class)
public class MovieRest {
    
    @Context 
    private UriInfo uriInfo;
    @PersistenceContext (unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;
    @EJB
    private MovieFacadeLocal movieFacade;
    @EJB
    private ScreeningsCache screeningCache;
    
    @GET
    public List<Movie> getMovies(){
        return movieFacade.findAll();
    }
    
    @GET
    @Path("/{id}")
    public Movie getMovieInfo(@PathParam("id") Long movieId){
        //Get the movie (all the details)
        return movieFacade.find(movieId);
    }
    
    @POST
    @Path("/new")
    @Consumes (MediaType.APPLICATION_JSON)
    public Movie createMovie (Movie movie){
        System.out.println("Create movie has been called");
        movieFacade.create(movie);
        return movie;
    }
    
    @PUT
    @Path("/{id}/edit")
    public void editMovie (Movie movie){
        System.out.println(movie);
        movieFacade.edit(movie);
        //Refresh cached billboard
        screeningCache.resetScreeningsCache();
    }
    
    @DELETE
    @Path ("/remove")
    public void remove (Movie movie){
        System.out.println(movie);
        movieFacade.remove(movie);
    }   
    
}
