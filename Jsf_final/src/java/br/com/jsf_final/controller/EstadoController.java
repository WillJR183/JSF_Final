/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf_final.controller;

import br.com.jsf_final.model.EstadoModel;
import br.com.jsf_final.repository.EstadoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author junio
 */

@ManagedBean
@ViewScoped
public class EstadoController {
    
    private EstadoModel estadoModel;
    private EstadoRepository estadoRepository;
    private List<EstadoModel> listaDeEstados;
    
    public EstadoController(){
        
        this.estadoModel = new EstadoModel();
        this.estadoRepository = new EstadoRepository();
        this.listaDeEstados =  new ArrayList<>();
    }
    
    public void buscarTodos(){
        this.listaDeEstados = this.estadoRepository.buscarTodos();
    }

    public EstadoModel getEstadoModel() {
        return estadoModel;
    }

    public void setEstadoModel(EstadoModel estadoModel) {
        this.estadoModel = estadoModel;
    }

    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<EstadoModel> getListaDeEstados() {
        return listaDeEstados;
    }

    public void setListaDeEstados(List<EstadoModel> listaDeEstados) {
        this.listaDeEstados = listaDeEstados;
    }
    
}
