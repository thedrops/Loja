/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import loja.bean.Contato;
import loja.dao.ContatoDAO;


/**
 *
 * @author a170060x
 */
public class FXMLCadastroContato implements Initializable {
    
   
    //Dados Contato
    
    @FXML private TextField nome;
    @FXML private TextField telefone;
    @FXML private TextField email;
    
    
    //Function botão
    
    public void cadastrarContato(ActionEvent event){
        //Cadastrar cliente
    Contato contato = new Contato(nome.getText(),telefone.getText(),email.getText());
    ContatoDAO dao = new ContatoDAO(); 
    boolean b = dao.inserir(contato.getNome(),contato.getTelefone(),contato.getEmail());
    if(!b){System.out.println("Erro criação de contato");}else{System.out.println("Contato Cadastrado com Sucesso!");}
 
    }
    
    public void cancelar(ActionEvent event){
        //Cadastrar cliente
    nome.setText("");
    telefone.setText("");
    email.setText("");
    
 
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
