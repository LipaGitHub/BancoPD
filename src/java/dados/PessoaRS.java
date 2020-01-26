/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import dto.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import java.util.ArrayList;

/**
 * REST Web Service
 *
 * @author filipapd
 */
@Path("PessoaRS")
@Stateless
public class PessoaRS {

    @Context
    private UriInfo context;

    @EJB(name = "Gestor")
    private GestorPessoasLocal gestor;

    /**
     * Creates a new instance of PessoaRS
     */
    public PessoaRS() {
    }

    /**
     * Retrieves representation of an instance of dados.PessoaRS
     *
     * @param nif
     * @return an instance of PessoaDTO
     */
    @GET
    @Path("{nif}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public PessoaDTO obtemPorNif(@PathParam("nif") String nif) {
        int nifp = Integer.parseInt(nif);
        PessoaDTO p = gestor.obtemPessoaPorNif(nifp);
        return p;
    }

    @GET
    @Path("{admin}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public Boolean loginAdmin(@PathParam("admin") AdministradorDTO admin) {
        return null;
    }

    @GET
    @Path("{pessoa}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public Boolean loginPessoa(@PathParam("pessoa") PessoaDTO pessoa) {
        return null;
    }

    @GET
    @Path("{listaConta}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public ArrayList<ContaDTO> listaContas(@PathParam("listaConta") PessoaDTO pessoa) {
        return null;
    }

    @GET
    @Path("{pessoa},{conta},{valor},{opt}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public Boolean accaoConta(@PathParam("pessoa") PessoaDTO pessoa, @PathParam("conta") ContaDTO conta, @PathParam("valor") int valor, @PathParam("opt") int opcao) {
        return null;
    }

    @GET
    @Path("{pessoa},{conta}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public ContaDTO consultaConta(@PathParam("pessoa") PessoaDTO pessoa, @PathParam("conta") ContaDTO conta) {
        return null;
    }

    @GET
    @Path("{conta}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public ContaDTO pesquisaConta(@PathParam("conta") ContaDTO conta) {
        return null;
    }

    @GET
    @Path("{contadto}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public PessoaDTO obtemPessoaPorConta(@PathParam("contadto") ContaDTO conta) {
        return null;
    }

    /**
     * PUT method for updating or creating an instance of PessoaRS
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public void novaPessoa(PessoaDTO content) {
        gestor.addPessoa(content);
    }

}
