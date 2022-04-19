package br.com.mariana.crud.web.dao;

import br.com.mariana.crudmodeljpa.modelo.Cliente;
import java.io.Serializable;
import javax.ejb.Stateful;


@Stateful
public class ClienteDAO<TIPO> extends DAOGenerico<Cliente> implements Serializable {
    public ClienteDAO(){
        super();
        classePersistente = Cliente.class;
    }
    
}
