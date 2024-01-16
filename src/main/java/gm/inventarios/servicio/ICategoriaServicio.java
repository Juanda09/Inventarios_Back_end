package gm.inventarios.servicio;

import gm.inventarios.modelo.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaServicio {
    public Categoria guardarCategoria(Categoria categoria);
    public List<Categoria> listarCategorias();
    public Categoria encontrarporid(Integer id);
}
