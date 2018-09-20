/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.model.negocio;

import com.alunos.agendamentopetshop.interfaces.InterfaceAgendamento;
import com.alunos.agendamentopetshop.model.entidades.Agendamento;
import com.alunos.agendamentopetshop.repositorio.implementacao.RepositorioAgendamentoImplDB;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class NegocioAgendamento implements InterfaceAgendamento<Agendamento> {

    private RepositorioAgendamentoImplDB repositorioAgendamento;
    private Agendamento agendamento;

    public NegocioAgendamento() {
        repositorioAgendamento = new RepositorioAgendamentoImplDB();
    }

    @Override
    public void salvar(Agendamento e) throws Exception {

        if (e == null) {
            throw new Exception("ERRO!!!!!");
        } else {
                 repositorioAgendamento.salvar(e);
            }
        }
 

    @Override
    public Agendamento buscar(Integer codigo) {
        if (codigo == null) {
            return null;
        } else {
            agendamento = repositorioAgendamento.buscar(codigo);
            if (agendamento == null) {
                return null;
            } else {
                return agendamento;
            }
        }
    }

    @Override
    public void editar(Agendamento e) throws Exception {
        if(e == null){
            throw new Exception("Erro!");
        }else{
           
                repositorioAgendamento.editar(e);
            }
    }

    @Override
    public void deletar(Agendamento e) throws Exception {
                if(e == null){
            throw new Exception("Erro!");
        }else{
            agendamento = repositorioAgendamento.buscar(e.getId());
            if(agendamento == null){
                throw new Exception("Erro!");
            }else{
                repositorioAgendamento.deletar(e);
            }
        }
    }

    @Override
    public List<Agendamento> listar() {
        List lista = repositorioAgendamento.listar();
        if (lista == null) {
            return null;
        } else {
            return lista;
        }
    }

}
