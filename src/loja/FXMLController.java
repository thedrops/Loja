package loja;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import loja.bean.Cliente;
import loja.dao.ClienteDAO;
public class FXMLController implements Initializable {

    //Dados Cliente
    
    @FXML private TextField nome;
    @FXML private TextField cpf;
    @FXML private TextField telefone;
    
    //Dados endereco
    
    @FXML private TextField estado;
    @FXML private TextField cidade;
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField bairro;
    @FXML private TextField cep;
    
    //Function botão
    
    
    public void cadastrar(ActionEvent event){
        //Cadastrar cliente
    Cliente cliente = new Cliente();
    cliente.setNome(nome.getText());
    cliente.setCpf(cpf.getText());
    cliente.setTelefone(telefone.getText());
    ClienteDAO dao = new ClienteDAO(); 
    boolean b = dao.inserir(cliente.getNome(),cliente.getCpf(),cliente.getTelefone());
        
        
        
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
