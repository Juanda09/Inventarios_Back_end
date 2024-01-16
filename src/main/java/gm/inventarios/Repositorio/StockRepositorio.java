package gm.inventarios.Repositorio;

import gm.inventarios.modelo.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepositorio extends JpaRepository<Stock,Integer> {
}
