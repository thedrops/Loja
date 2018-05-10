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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import loja.bean.Cliente;
import loja.bean.Endereco;
import loja.bean.Funcionario;
import loja.dao.ClienteDAO;
import loja.dao.EnderecoDAO;
import loja.dao.EnderecoFuncDAO;
import loja.dao.FuncionarioDAO;

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
        boolean b = false;
        boolean c = false;
        
        boolean verificacaoCampos = (cpf.getText().equals("") || nome.getText().equals("") ||
                numero.getText().equals("") || estado.getText().equals("") || cidade.getText().equals("") ||
                rua.getText().equals("") || bairro.getText().equals("") || cep.getText().equals(""));
        
        
    if(!verificacaoCampos){
            Cliente cliente = new Cliente();
            cliente.setCpf(cpf.getText());
            cliente.setNome(nome.getText());
            cliente.setTelefone(telefone.getText());
            cliente.setId(id.getText());

    
            Endereco endereco = new Endereco(estado.getText(),cidade.getText(),rua.getText(),
            numero.getText(),bairro.getText(),cep.getText());
          
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            ClienteDAO dao = new ClienteDAO(); 
            
            b = dao.inserir(cliente.getNome(),cliente.getCpf(),cliente.getTelefone());
            c  = enderecoDAO.inserir(endereco.getEstado(),endereco.getCidade(),
                endereco.getRua(),endereco.getNumero(),endereco.getBairro(),endereco.getCep(),id.getText());
        }
        
        if(verificacaoCampos){
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro de cliente");
            dialogoInfo.setHeaderText("Campo em falta!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
       else if(b && c){
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro de Cliente");
            dialogoInfo.setHeaderText("Cliente cadastrado com sucesso!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
        else{
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro de Cliente");
            dialogoInfo.setHeaderText("Erro ao cadastrar Cliente!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
    
    
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
