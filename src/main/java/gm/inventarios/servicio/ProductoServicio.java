package gm.inventarios.servicio;

import gm.inventarios.Repositorio.ProductoRepositorio;
import gm.inventarios.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        List<Producto> productos= this.productoRepositorio.findAll();
        return productos;
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto = this.productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    @Transactional
    public Producto guardarProducto(Producto producto){
        return this.productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProductoporId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);

    }
}
