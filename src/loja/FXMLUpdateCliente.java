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
import loja.bean.Cliente;
import loja.bean.Endereco;
import loja.dao.ClienteDAO;
import loja.dao.EnderecoDAO;

/**
 *
 * @author a170060x
 */
public class FXMLUpdateCliente implements Initializable {
    
   
    //Dados Cliente
    
    @FXML private TextField nome;
    @FXML private TextField telefone;
    @FXML private TextField id;
    
    //Dados endereco
    
    @FXML private TextField estado;
    @FXML private TextField cidade;
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField bairro;
    @FXML private TextField cep;
    
    //Function botão
    
    
    public void atualizarCliente(ActionEvent event){
        //Atualizar cliente
    Cliente cliente = new Cliente();
    cliente.setNome(nome.getText());
    cliente.setTelefone(telefone.getText());
    ClienteDAO dao = new ClienteDAO(); 
    boolean b = dao.atualizarCliente(id.getText(),cliente.getNome(),cliente.getTelefone());
    if(!b){System.out.println("Erro na atualização do cliente");}
        
        //Atualizar Endereço
    Endereco endereco = new Endereco(estado.getText(),cidade.getText(),rua.getText(),
    numero.getText(),bairro.getText(),cep.getText());
    EnderecoDAO enderecoDAO = new EnderecoDAO();
    
    boolean c  = enderecoDAO.atualizarEndereco(id.getText(),endereco.getEstado(),endereco.getCidade(),
            endereco.getRua(),endereco.getNumero(),endereco.getBairro(),endereco.getCep());
    if(!c)System.out.println("Erro na atualização do endereco");
        
    if(b && c )System.out.println("Cliente atualizado com Sucesso!");
    }
    
    public void deletarCliente(ActionEvent event){
    
    ClienteDAO cliente = new ClienteDAO();
    boolean d = cliente.deletar(id.getText());
    if(d)
            System.out.println("Cliente Deletado com sucesso!");
    else
            System.out.println("Erro na exclusão do cliente");
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
