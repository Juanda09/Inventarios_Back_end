package gm.inventarios.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProducto;
    String descripcion;
    @ManyToOne
    Categoria categoria;
    @ManyToOne
    Provedores provedor;
    Double precio;
    Integer existencia;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
}
