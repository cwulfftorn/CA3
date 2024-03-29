package rest;

import com.google.gson.Gson;
import entities.User;
import facades.SwappiApi;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class DemoResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            List<User> users = em.createQuery("select user from User user").getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    //SWAPPI-API
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("people")
    public String getFromPeople() {
        SwappiApi sa = new SwappiApi();
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Works" + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("planets")
    public String getFromPlanets() {
        SwappiApi sa = new SwappiApi();
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Works" + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("spaceships")
    public String getFromSpaceships() {
        SwappiApi sa = new SwappiApi();
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Works" + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("vehicles")
    public String getFromVehicles() {
        SwappiApi sa = new SwappiApi();
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Works" + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("films")
    public String getFromFilms() {
        SwappiApi sa = new SwappiApi();
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Works" + thisuser + "\"}";
    }
}
