package br.com.mariana.crud.web.controle;

import br.com.mariana.crud.web.dao.ClienteDAO;
import br.com.mariana.crud.web.util.Util;
import br.com.mariana.crudmodeljpa.modelo.Cliente;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named(value="clienteControle")
@ViewScoped
public class ClienteControle implements Serializable {
   
    @EJB
    private ClienteDAO<Cliente> dao;
    
    private Cliente obj;
    
    public ClienteControle() {
        
    }
    
    public String listar(){
        return "/cliente/listar?faces-redirect=true";
    }
    
    public void novo(){
        obj = new Cliente();
    }
    
    public void alterar(Object id){
        try {
            obj = dao.getObjectByID(id);
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
        
    public void excluir(Object id){
        try {
            obj = dao.getObjectByID(id);
            dao.remove(obj);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if (obj.getId() == null){
                dao.persist(obj);
            } else {
                dao.merge(obj);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    public ClienteDAO<Cliente> getDao() {
        return dao;
    }

    public void setDao(ClienteDAO<Cliente> dao) {
        this.dao = dao;
    }

    public Cliente getObj() {
        return obj;
    }

    public void setObj(Cliente obj) {
        this.obj = obj;
    }
    
}
