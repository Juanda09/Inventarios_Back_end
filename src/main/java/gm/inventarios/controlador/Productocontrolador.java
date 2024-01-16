package gm.inventarios.controlador;

import gm.inventarios.excepciones.RecursoNoEncontrado;
import gm.inventarios.modelo.Categoria;
import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Inventario-app/productos")
@CrossOrigin(value = "http://localhost:4200/*")
public class Productocontrolador {
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/lista")
    public List<Producto> obtenerproductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        return productos;
    }
    @PostMapping("/agregar-productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        return this.productoServicio.guardarProducto(producto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id) {
        Producto producto = productoServicio.buscarProductoPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        }
        else {
            throw new RecursoNoEncontrado("No se encontro el producto");
        }
    }
    @PutMapping("Actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto productoRecibido) {
        System.out.println("Fecha recibida desde el cliente: " + productoRecibido.getFecha());

        Producto producto = this.productoServicio.buscarProductoPorId(id);
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setFecha(productoRecibido.getFecha());

        this.productoServicio.guardarProducto(producto);

        System.out.println("Fecha actualizada en el servidor: " + producto.getFecha());

        return ResponseEntity.ok(producto);
    }
}
