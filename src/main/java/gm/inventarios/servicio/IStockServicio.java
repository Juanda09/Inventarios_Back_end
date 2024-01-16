package gm.inventarios.servicio;

import gm.inventarios.modelo.Stock;

import java.util.List;

public interface IStockServicio {
    public List<Stock> Listar_Stock();
    public Stock registrar_stock(Stock stock);
}
