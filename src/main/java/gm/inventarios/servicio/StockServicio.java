package gm.inventarios.servicio;

import gm.inventarios.Repositorio.StockRepositorio;
import gm.inventarios.modelo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockServicio implements IStockServicio {

    @Autowired
    private StockRepositorio stockRepositorio;
    @Override
    public List<Stock> Listar_Stock() {
        return this.stockRepositorio.findAll();
    }

    @Override
    public Stock registrar_stock(Stock stock) {
        return this.stockRepositorio.save(stock);
    }
}
