package com.bandas.banda.service;

import com.bandas.banda.model.Banda;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BandaService {
    private List<Banda> bandas = new ArrayList<>();

    public void salvarBanda(Banda banda) {
        if(Objects.isNull(banda.getId())) {
            var novoId = Integer.valueOf(bandas.size() + 1);
            banda.setId(novoId);
            bandas.add(banda);
        } else {
            var oldBanda = buscarPorId(banda.getId());
            var index = bandas.indexOf(banda);
            bandas.get(index).setNome(banda.getNome());
            bandas.get(index).setNumeroParticipantes(banda.getNumeroParticipantes());
            bandas.get(index).setGenero(banda.getGenero());
            bandas.get(index).setNacionalidade(banda.getNacionalidade());
    }
}
public List<Banda> listarTodos() {
    return bandas;
    }
    public Banda buscarPorId(Integer id) {
        var banda = new Banda();
        banda.setId(id);

        var index = bandas.indexOf(banda);
        if (index < 0) return null;
        return bandas.get(index);
    }
    public void remover(Banda banda){
        bandas.remove(banda);
    }
}
