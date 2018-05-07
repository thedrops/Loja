package loja;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import loja.bean.Endereco;
import loja.bean.Funcionario;
import loja.dao.EnderecoFuncDAO;
import loja.dao.FuncionarioDAO;

/**
 *
 * @author a170060x
 */
public class FXMLCadastroFuncionario implements Initializable {
    
   
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
        boolean b = false;
        boolean c = false;
        
        boolean verificacaoCampos = (cpf.getText().equals("") && nome.getText().equals("") && datanasc == null && salario.getText().equals("") &&
                cargo.getText().equals("") && numero.getText().equals("") && estado.getText().equals("") && cidade.getText().equals("") &&
                rua.getText().equals("") && bairro.getText().equals("") && cep.getText().equals(""));
 
        if(verificacaoCampos){
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(cpf.getText());
            funcionario.setNome(nome.getText());
            funcionario.setDatanasc(datanasc.getText());
            funcionario.setSalario(Double.parseDouble(salario.getText()));
            funcionario.setCargo(Integer.parseInt(cargo.getText()));

    
            Endereco endereco = new Endereco(estado.getText(),cidade.getText(),rua.getText(),
            numero.getText(),bairro.getText(),cep.getText());
            
            EnderecoFuncDAO enderecoDAO = new EnderecoFuncDAO();
            FuncionarioDAO dao = new FuncionarioDAO(); 
            
            b = dao.inserir(funcionario.getCpf(),funcionario.getNome(),funcionario.getDatanasc(),funcionario.getSalario(),funcionario.getCargo(),id.getText());
            c  = enderecoDAO.inserir(endereco.getEstado(),endereco.getCidade(),
                endereco.getRua(),endereco.getNumero(),endereco.getBairro(),endereco.getCep(),id.getText());
        }
        if(!verificacaoCampos){
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro de funcionário");
            dialogoInfo.setHeaderText("Campo em falta!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
       else if(b && c){
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro de funcionário");
            dialogoInfo.setHeaderText("Úsuario cadastrado com sucesso!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
        else{
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro de funcionário");
            dialogoInfo.setHeaderText("Erro ao cadastrar funcionário!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
        
    }
    
    public void cancelar(ActionEvent event){
        nome.setText(null);
        cpf.setText(null);
        datanasc.setText(null);
        salario.setText(null);
        cargo.setText(null);
        
        estado.setText(null);
        cidade.setText(null);
        rua.setText(null);
        numero.setText(null);
        bairro.setText(null);
        cep.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
