package gm.inventarios.controlador;

import gm.inventarios.modelo.Producto;
import gm.inventarios.modelo.Stock;
import gm.inventarios.servicio.ProductoServicio;
import gm.inventarios.servicio.StockServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Inventario-app/stock")
@CrossOrigin(value = "http://localhost:4200/*")
public class Stockcontrolador {
    @Autowired
    private StockServicio stockServicio;
    @Autowired
    private ProductoServicio productoServicio;
    @GetMapping("/lista")
    public List<Stock> listar_Stock(){
        return this.stockServicio.Listar_Stock();
    }
    @PostMapping("/agregar-stock")
    public Stock agregar_stock(@RequestBody Stock stock){
        if (stock.getTipo_de_stock().equals("Entrada")){
            Producto producto= this.productoServicio.buscarProductoPorId(stock.getProducto().getIdProducto());
            Integer Existencias =producto.getExistencia();
            Integer Cantidad = stock.getCantidad();
            Existencias = Existencias + Cantidad;
            producto.setExistencia(Existencias);
            this.productoServicio.guardarProducto(producto);
        }
        else if(stock.getTipo_de_stock().equals("Salida")) {
            Producto producto= this.productoServicio.buscarProductoPorId(stock.getProducto().getIdProducto());
            Integer Existencias =producto.getExistencia();
            Integer Cantidad = stock.getCantidad();
            Existencias = Existencias - Cantidad;
            producto.setExistencia(Existencias);
            this.productoServicio.guardarProducto(producto);
        }
        return this.stockServicio.registrar_stock(stock);
    }
}
