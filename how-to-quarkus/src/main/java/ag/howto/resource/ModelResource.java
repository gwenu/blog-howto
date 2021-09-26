package ag.howto.resource;

import ag.howto.entity.Model;
import ag.howto.repository.ModelRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/models")
public class ModelResource {

    @Inject
    ModelRepository modelRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModels() {
        return Response.ok(modelRepository.getModels()).build();
    }

    @GET
    @Path("id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModel(@PathParam("id") Long id) {
        Optional<Model> modelOptional = modelRepository.findByIdOptional(id);
        return modelOptional.isPresent()
                ? Response.ok(modelOptional.get()).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

}