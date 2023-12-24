import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "\"order\"")
public class Order extends PanacheEntity {
    public int activationFee = 10;  // = 10 par défaut
    public float monthFee = 20.0f; // = 20.0 par défaut
    public float carbonFP = 300.0f; // = 300.0 par défaut

    public Long projectId;
    public Long contactId;
}
