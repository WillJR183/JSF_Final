/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf_final.repository;

import br.com.jsf_final.model.AlunoModel;
import br.com.jsf_final.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junio
 */

public class AlunoRepository extends Conexao{
    
    public void salvar(AlunoModel alunoModel){
        super.inicializa();
        //teste com clear
        super.getSess().clear();
        super.getSess().merge(alunoModel);
        super.executar();
    }
    
    public List<AlunoModel> buscarTodos(){
        List<AlunoModel> listaDeAlunos = new ArrayList<>();
        super.inicializa();
        listaDeAlunos = super.getSess().createQuery("from AlunoModel").list();
        super.executar();
        return listaDeAlunos;
    }
    
    public List<AlunoModel> buscarPorNome(String nome){
        List<AlunoModel> listaDeAlunos = new ArrayList<>();
        super.inicializa();
        listaDeAlunos = super.getSess().createQuery("from AlunoModel where UPPER(nome) like '%" + nome.toUpperCase() + "%'").list();
        super.executar();
        return listaDeAlunos;
    }
   
     public AlunoModel buscarPorID(long idPessoa){
        AlunoModel aluno = new AlunoModel();
        super.inicializa();
        aluno = (AlunoModel) super.getSess().get(AlunoModel.class, idPessoa);
        super.executar();
        return aluno;
    }
    
    public void excluirPorID(long idPessoa){
        super.inicializa();
        AlunoModel aluno = (AlunoModel) super.getSess().get(AlunoModel.class, idPessoa);
        super.getSess().delete(aluno);
        super.executar();
    }
    
}