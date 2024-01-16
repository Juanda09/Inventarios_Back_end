package gm.inventarios.servicio;

import gm.inventarios.modelo.Producto;
import gm.inventarios.modelo.Provedores;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface IProvedoresServicio {
    public List<Provedores> Listaprovedores();
    public Provedores buscarprovedorporid(Integer id);
    public Provedores guardarprovedor(Provedores provedores);
}
