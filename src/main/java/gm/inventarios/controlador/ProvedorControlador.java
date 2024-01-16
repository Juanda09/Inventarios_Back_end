package gm.inventarios.controlador;

import gm.inventarios.excepciones.RecursoNoEncontrado;
import gm.inventarios.modelo.Producto;
import gm.inventarios.modelo.Provedores;
import gm.inventarios.servicio.ProvedoresServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Inventario-app/provedor")
@CrossOrigin(value = "http://localhost:4200/*")
public class ProvedorControlador {
    @Autowired
    private ProvedoresServicio provedoresServicio;
    @GetMapping("/lista")
    public List<Provedores> listar_provedores(){
        return this.provedoresServicio.Listaprovedores();
    }
    @PostMapping("/agregar-provedor")
    public Provedores guardar_provedor(@RequestBody Provedores provedores){
        return this.provedoresServicio.guardarprovedor(provedores);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Provedores> obtenerprovedorporId(@PathVariable Integer id) {
        Provedores provedor = this.provedoresServicio.buscarprovedorporid(id);
        if (provedor != null){
            return ResponseEntity.ok(provedor);
        }
        else {
            throw new RecursoNoEncontrado("No se encontro ningun provedor");
        }
    }
    @PutMapping("Actualizar/{id}")
    public ResponseEntity<Provedores>actualizarProveedor(@PathVariable Integer id, @RequestBody Provedores proveedorRecibido){
        Provedores provedores = this.provedoresServicio.buscarprovedorporid(id);
        provedores.setNombre(proveedorRecibido.getNombre());
        provedores.setDireccion(proveedorRecibido.getDireccion());
        provedores.setEmail(proveedorRecibido.getEmail());
        provedores.setTelefono(proveedorRecibido.getTelefono());
        this.provedoresServicio.guardarprovedor(provedores);
        return ResponseEntity.ok(provedores);
    }
}
