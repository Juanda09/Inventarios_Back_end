package gm.inventarios.Repositorio;

import gm.inventarios.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Integer> {
}
