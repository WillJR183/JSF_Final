/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf_final.controller;

import br.com.jsf_final.model.AreaModel;
import br.com.jsf_final.model.DisciplinaModel;
import br.com.jsf_final.model.ProfessorModel;
import br.com.jsf_final.repository.AreaRepository;
import br.com.jsf_final.repository.DisciplinaRepository;
import br.com.jsf_final.repository.ProfessorRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author junio
 */

@ManagedBean
@SessionScoped
public class DisciplinaController {
    
    private DisciplinaModel disciplinaModel;
    private DisciplinaRepository disciplinaRepository;
    private List<DisciplinaModel> listaDeDisciplinas;
    
    private AreaModel areaModel;
    private AreaRepository areaRepository;
    
    private ProfessorModel professorModel;
    private ProfessorRepository professorRepository;
   
    public DisciplinaController() {
        
        this.disciplinaModel = new DisciplinaModel();
        this.areaModel = new AreaModel();
        this.professorModel = new ProfessorModel();
        
        this.disciplinaRepository = new DisciplinaRepository();
        this.areaRepository = new AreaRepository();
        this.professorRepository = new ProfessorRepository();
        
        this.listaDeDisciplinas = new ArrayList<>();
    }

    public void salvar() {
        
        try {
            this.areaModel = this.areaRepository.buscarPorID(this.areaModel.getIdArea());
            this.professorModel = this.professorRepository.buscarPorID(this.professorModel.getIdpessoa());
            
            this.disciplinaModel.setArea(this.areaModel);
            this.disciplinaModel.setProfessor(professorModel);
            
            this.disciplinaRepository.salvar(this.disciplinaModel);
            this.disciplinaModel = new DisciplinaModel();
        } 
        catch (Exception e) {
        }
    }
     
    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public ProfessorRepository getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public AreaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(AreaModel areaModel) {
        this.areaModel = areaModel;
    }

    public AreaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
    
    public void buscarTodos() {
        this.listaDeDisciplinas = this.disciplinaRepository.buscarTodos();
    }

    public void buscarPorNome() {
        this.listaDeDisciplinas = this.disciplinaRepository.buscarPorNome(this.disciplinaModel.getNome());
    }

    public void excluirPorID(int idDisciplina) {
        this.disciplinaRepository.excluirPorID(idDisciplina);
    }

    public String editarPorID(int idDisciplina) throws IOException {
        this.disciplinaModel = this.disciplinaRepository.buscarPorID(idDisciplina);

        return "editarDisciplina.xhtml?faces-redirect=true";
    }

    public DisciplinaModel getDisciplinaModel() {
        return disciplinaModel;
    }

    public void setDisciplinaModel(DisciplinaModel disciplinaModel) {
        this.disciplinaModel = disciplinaModel;
    }

    public DisciplinaRepository getDisciplinaRepository() {
        return disciplinaRepository;
    }

    public void setDisciplinaRepository(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<DisciplinaModel> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }

    public void setListaDeDisciplinas(List<DisciplinaModel> listaDeDisciplinas) {
        this.listaDeDisciplinas = listaDeDisciplinas;
    }
    
}
