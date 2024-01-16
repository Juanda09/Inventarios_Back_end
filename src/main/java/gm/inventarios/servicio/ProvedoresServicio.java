package gm.inventarios.servicio;

import gm.inventarios.Repositorio.ProvedoresRepositorio;
import gm.inventarios.modelo.Provedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProvedoresServicio implements IProvedoresServicio {
    @Autowired
    private ProvedoresRepositorio provedoresRepositorio;
    @Override
    public List<Provedores> Listaprovedores() {
        return this.provedoresRepositorio.findAll();
    }

    @Override
    public Provedores buscarprovedorporid(Integer id) {
        return this.provedoresRepositorio.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Provedores guardarprovedor(Provedores provedores) {
        return this.provedoresRepositorio.save(provedores);
    }
}
