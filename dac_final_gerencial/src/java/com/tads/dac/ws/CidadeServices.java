/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads.dac.ws;

import com.tads.dac.beans.Cidade;
import com.tads.dac.facade.CidadeFacade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("/cidade")
public class CidadeServices {

    @Context
    private UriInfo context;

    public CidadeServices() {
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<Cidade> getCidade() {
        return CidadeFacade.listCidades();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("{id}")
    public List<Cidade> getCidadeByEstado(@PathParam("id") int id) {
       return CidadeFacade.getCidadesByEstado(id);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/id/{id}")
    public Cidade getCidadeById(@PathParam("id") int id) {
       return CidadeFacade.getCidadeById(id);
    }
}
