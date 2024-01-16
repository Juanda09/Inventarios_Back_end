package gm.inventarios.controlador;

import gm.inventarios.excepciones.RecursoNoEncontrado;
import gm.inventarios.modelo.Categoria;
import gm.inventarios.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Inventario-app/categoria")
@CrossOrigin(value = "http://localhost:4200/*")
public class Categoriacontrolador {
    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("/lista")
    public List<Categoria> obtenercategorias(){
        return this.categoriaServicio.listarCategorias();
    }
    @PostMapping("/agregar-categoria")
    public Categoria guardarcategoria(@RequestBody Categoria categoria){
        return this.categoriaServicio.guardarCategoria(categoria);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaServicio.encontrarporid(id);
        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        }
        else {
            throw new RecursoNoEncontrado("No se encontro la categoria");
        }
    }
}
