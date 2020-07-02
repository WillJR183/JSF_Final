/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf_final.controller;

import br.com.jsf_final.model.CidadeModel;
import br.com.jsf_final.repository.CidadeRepository;
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
public class CidadeController {
    
    private CidadeModel cidadeModel;
    private CidadeRepository cidadeRepository;
    private List<CidadeModel> listaDeCidades;
    
    public CidadeController(){
        
        this.cidadeModel = new CidadeModel();
        this.cidadeRepository = new CidadeRepository();
        this.listaDeCidades =  new ArrayList<>();
    }
   
    public void buscarTodos() {
        this.listaDeCidades = cidadeRepository.buscarTodos();
    }
    
    public CidadeModel getCidadeModel() {
        return cidadeModel;
    }

    public void setCidadeModel(CidadeModel cidadeModel) {
        this.cidadeModel = cidadeModel;
    }

    public CidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    public void setCidadeRepository(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public List<CidadeModel> getListaDeCidades() {
        return listaDeCidades;
    }

    public void setListaDeCidades(List<CidadeModel> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }
    
}
