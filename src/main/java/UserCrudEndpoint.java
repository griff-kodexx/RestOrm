import com.google.gson.Gson;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by kodexx on 3/14/18.
 */
@Path("/users")
public class UserCrudEndpoint{
    @Inject @Named("jpa")
    private CRUD userCrud;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(String jsonObject){
        Gson gson = new Gson();
        if(userCrud.addUser(gson.fromJson(jsonObject, User.class))){
           return Response.status(200).entity("Added successfully").build();
        }
        return Response.status(201).entity("Failed!!").build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id")  int id){
        User user  = userCrud.getById(id);
        if (user!=null){
            return Response.status(200).entity(new Gson().toJson(user)).build();
        }
        return Response.status(201).entity("User not found!!").build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, String jsonObject){
        User user = new Gson().fromJson(jsonObject, User.class);
        user.setId(id);
        if (userCrud.updateUser(user)){
            return Response.status(200).entity("Updated!!").build();

        }
        return Response.status(201).entity("Update FIaled!!").build();

    }

}
