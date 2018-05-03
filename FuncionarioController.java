package loja;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import loja.bean.Endereco;
import loja.bean.Funcionario;
import loja.dao.EnderecoFuncDAO;
import loja.dao.FuncionarioDAO;

/**
 *
 * @author a170060x
 */
public class FuncionarioController implements Initializable {
    
   
    //Dados Funcionario
    @FXML private TextField cpf;
    @FXML private TextField nome;
    @FXML private TextField datanasc;
    @FXML private TextField salario;
    @FXML private TextField cargo;
    @FXML private TextField id;
    
    //Dados endereco
    
    @FXML private TextField estado;
    @FXML private TextField cidade;
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField bairro;
    @FXML private TextField cep;
    
    //Function botão
    
    
    public void cadastrar(ActionEvent event){
        //Cadastrar funcionario
        Funcionario funcionario = new Funcionario();
        funcionario.setCpf(cpf.getText());
        funcionario.setNome(nome.getText());
        funcionario.setDatanasc(datanasc.getText());
        funcionario.setSalario(Double.parseDouble(salario.getText()));
        funcionario.setCargo(Integer.parseInt(cargo.getText()));
     

        FuncionarioDAO dao = new FuncionarioDAO(); 
        boolean b = dao.inserir(funcionario.getCpf(),funcionario.getNome(),funcionario.getDatanasc(),funcionario.getSalario(),funcionario.getCargo(),id.getText());

        
        //cadastrar Endereço
        Endereco endereco = new Endereco(estado.getText(),cidade.getText(),rua.getText(),
        numero.getText(),bairro.getText(),cep.getText());
        EnderecoFuncDAO enderecoDAO = new EnderecoFuncDAO();

         boolean c  = enderecoDAO.inserir(endereco.getEstado(),endereco.getCidade(),
            endereco.getRua(),endereco.getNumero(),endereco.getBairro(),endereco.getCep(),id.getText());
        if(b && c){System.out.println("Cadastrado");}
        else{System.out.println("Erro no cadastro");}
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
