/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jsf_final.repository;

import br.com.jsf_final.model.PessoaModel;
import br.com.jsf_final.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junio
 */

public class UsuarioRepository extends Conexao {
    
    public List<PessoaModel> buscar(String login){
        List<PessoaModel> listaDePessoas = new ArrayList<PessoaModel>();
        super.inicializa();
        listaDePessoas = super.getSess().createQuery("from PessoaModel where login = '"+login+"'").list();
        super.executar();
        return listaDePessoas;
    }
     
}
