import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.transaction.Transactional;
import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderService {
    @GET
    public Response getAllOrders() {
        List<Order> orders = Order.listAll();

        return Response.ok(orders).build();
    }

    @GET
    @Path("/{orderId}")
    public Response getOrderById(@PathParam("orderId") int orderId) {
        Order order = Order.findById(orderId);

        if (order != null) {
            return Response.ok(order).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Transactional
    public Response createOrder(Order order) {
        Order newOrder = order;
        if (newOrder != null) {
            newOrder.persist(); // Sauvegarde la nouvelle commande dans la base de données
            return Response.status(Response.Status.CREATED).entity(newOrder).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}