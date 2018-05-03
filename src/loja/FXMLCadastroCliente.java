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
public class FXMLCadastroCliente implements Initializable {
    
   
    //Dados Cliente
    
    @FXML private TextField nome;
    @FXML private TextField telefone;
    @FXML private TextField id;
    @FXML private TextField cpf;
    
    //Dados endereco
    
    @FXML private TextField estado;
    @FXML private TextField cidade;
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField bairro;
    @FXML private TextField cep;
    
    //Function botão
    
    
    public void cadastrarCliente(ActionEvent event){
        //Cadastrar cliente
    Cliente cliente = new Cliente();
    cliente.setNome(nome.getText());
    cliente.setTelefone(telefone.getText());
    cliente.setCpf(cpf.getText());
    ClienteDAO dao = new ClienteDAO(); 
    boolean b = dao.inserir(cliente.getNome(),cliente.getCpf(),cliente.getTelefone());
    if(!b){System.out.println("Erro criação de cliente");}

        
        //cadastrar Endereço
    Endereco endereco = new Endereco(estado.getText(),cidade.getText(),rua.getText(),
    numero.getText(),bairro.getText(),cep.getText());
    EnderecoDAO enderecoDAO = new EnderecoDAO();
    
    boolean c  = enderecoDAO.inserir(endereco.getEstado(),endereco.getCidade(),
            endereco.getRua(),endereco.getNumero(),endereco.getBairro(),endereco.getCep(),id.getText());
    if(!c)System.out.println("Erro criação endereço");
    
    if(b && c )
        System.out.println("Cliente Cadastrado com Sucesso!");
        
    }
    
    public void cancelar(ActionEvent event){
        //zerar cliente
    nome.setText("");
    telefone.setText("");
    id.setText("");
    cpf.setText("");
    
    //Zerar endereco
    estado.setText("");
    cidade.setText("");
    rua.setText("");
    numero.setText("");
    bairro.setText("");
    cep.setText("");
    
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
