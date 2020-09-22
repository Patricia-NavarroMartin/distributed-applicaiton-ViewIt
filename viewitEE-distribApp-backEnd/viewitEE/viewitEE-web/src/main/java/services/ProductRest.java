package services;

import entities.Product;
import entities.inherited.Ticket;
import interceptors.LoggerInterceptor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sessionbeans.dao.ProductFacadeLocal;
import sessionbeans.dao.TicketFacadeLocal;

@Path("/product")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
@Interceptors(LoggerInterceptor.class)public class ProductRest {
    @Context 
    private UriInfo uriInfo;
    @PersistenceContext (unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;
    @EJB
    private ProductFacadeLocal productFacade;
    @EJB
    private TicketFacadeLocal ticketFacade;
    
    @GET
    public List<Product> getProducts(){
        return productFacade.findAll();
    }
    
    @GET
    @Path("/tickets")
    public List<Ticket> getTickets(){
        return ticketFacade.findAll();
    }
}
