package br.unitins.topicos1.sga.service;

import java.util.List;

import br.unitins.topicos1.sga.dto.EstadoDTO;
import br.unitins.topicos1.sga.model.Estado;

public interface EstadoService {
    List<Estado> findAll();
    Estado findById(Long id);
    Estado findBySigla(String sigla);
    List<Estado> findByNome(String nome);
    Estado create(EstadoDTO dto);
    void update(Long id, EstadoDTO dto);
    void delete(Long id);
}
