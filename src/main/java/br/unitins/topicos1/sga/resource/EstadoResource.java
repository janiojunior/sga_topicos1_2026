package br.unitins.topicos1.sga.resource;

import java.util.List;

import br.unitins.topicos1.sga.dto.EstadoDTO;
import br.unitins.topicos1.sga.model.Estado;
import br.unitins.topicos1.sga.repository.EstadoRepository;
import br.unitins.topicos1.sga.service.EstadoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadoResource {

    @Inject
    EstadoService service;

    @GET
    public List<Estado> buscarTodos() {
        return service.findAll();
    }

    @GET
    @Path("/find/{nome}")
    public List<Estado> buscarPeloNome(String nome) {
        return service.findByNome(nome);
    }

    @POST
    @Transactional
    public Estado incluir(EstadoDTO estado) {
        return service.create(estado);
    }

}
