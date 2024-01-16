package gm.inventarios.modelo;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idStock;

    @ManyToOne
    Producto producto;

    String Tipo_de_stock;
    Integer Cantidad;
    String Motivo;
    String Observaciones;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
}
