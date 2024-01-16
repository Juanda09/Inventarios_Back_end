package gm.inventarios.servicio;

import gm.inventarios.Repositorio.CategoriaRepositorio;

import gm.inventarios.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriaServicio implements ICategoriaServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return this.categoriaRepositorio.save(categoria);
    }

    @Override
    public List<Categoria> listarCategorias() {
        List<Categoria> Categorias = this.categoriaRepositorio.findAll();
        return Categorias;
    }

    @Override
    public Categoria encontrarporid(Integer id) {
        return this.categoriaRepositorio.findById(id).get();
    }
}
