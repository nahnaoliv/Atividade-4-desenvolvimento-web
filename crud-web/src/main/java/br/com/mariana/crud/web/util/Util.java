package br.com.mariana.crud.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {
    public static String getMensagemErro(Exception e){
        while (e.getCause() != null){
            e = (Exception) e.getCause();
        }
        String retorno = e.getMessage();
        if (retorno.contains("viola restrição de chave estrangeira")){
            retorno = "Registro não pode ser removido por possuir referências  " + 
                    "em outras partes do sistema";
        } else if (retorno.contains("duplicate key value violates unique constraint")){
            retorno = "Nome de usário já existe no banco de dados!";
        }
        return retorno;
    }
    
    public static void mensagemInformacao(String textoMensagem){
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, textoMensagem, "");
        contexto.addMessage(null, msg);
    }
    
    public static void mensagemErro(String textoMensagem){
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, textoMensagem, "");
        contexto.addMessage(null, msg);
    }    
    
}
