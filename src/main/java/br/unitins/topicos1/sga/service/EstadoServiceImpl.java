package br.unitins.topicos1.sga.service;

import java.util.List;

import br.unitins.topicos1.sga.dto.EstadoDTO;
import br.unitins.topicos1.sga.model.Estado;
import br.unitins.topicos1.sga.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    EstadoRepository repository;

    @Override
    public List<Estado> findAll() {
        return repository.findAll().list();
    }

    @Override
    public Estado findById(Long id) {
       return repository.findById(id);
    }

    @Override
    public Estado findBySigla(String sigla) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBySigla'");
    }

    @Override
    public List<Estado> findByNome(String nome) {
       return repository.findByNome(nome).list();
    }

    @Override
    @Transactional
    public Estado create(EstadoDTO dto) {
        Estado estado = new Estado();
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());
       
        repository.persist(estado);
        return estado;
    }

    @Override
    @Transactional
    public void update(Long id, EstadoDTO dto) {
        Estado estado = findById(id);

        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}
