package loja;


import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
    @FXML private DatePicker datanasc;
    @FXML private TextField salario;
    @FXML private  ChoiceBox cargo;
    
    //Dados endereco
    
    @FXML private TextField estado;
    @FXML private TextField cidade;
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField bairro;
    @FXML private TextField cep;
    
    //Function botão
    
    
    public void cadastrar(ActionEvent event) throws SQLException{
        //Cadastrar funcionario
        boolean b = false;
        boolean c = false;
        
        boolean verificacaoCampos = (cpf.getText().equals("") || nome.getText().equals("") || datanasc == null || salario.getText().equals("") ||
                cargo.getValue().equals("") || numero.getText().equals("") || estado.getText().equals("") || cidade.getText().equals("") ||
                rua.getText().equals("") || bairro.getText().equals("") || cep.getText().equals(""));
        
        if(!verificacaoCampos){
            //formatação da data e salario
            String data = datanasc.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            //insere dados 
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(cpf.getText());
            funcionario.setNome(nome.getText());
            funcionario.setDatanasc(data);
            funcionario.setSalario((salario.getText().replaceAll(",", ".")));
            funcionario.setCargo((String) cargo.getValue());
           
            Endereco endereco = new Endereco(estado.getText(),cidade.getText(),rua.getText(),
            numero.getText(),bairro.getText(),cep.getText());
          
            EnderecoFuncDAO enderecoDAO = new EnderecoFuncDAO();
            FuncionarioDAO dao = new FuncionarioDAO(); 
            
            b = dao.inserir(funcionario.getCpf(),funcionario.getNome(),funcionario.getDatanasc(),funcionario.getSalario(),funcionario.getCargo());
            String id_funcionario = dao.qtdFuncionario();
            c  = enderecoDAO.inserir(endereco.getEstado(),endereco.getCidade(),
                endereco.getRua(),endereco.getNumero(),endereco.getBairro(),endereco.getCep(),id_funcionario);
        }
         if(verificacaoCampos){
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
        datanasc.setValue(null);
        salario.setText(null);
        cargo.setValue(null);
        
        estado.setText(null);
        cidade.setText(null);
        rua.setText(null);
        numero.setText(null);
        bairro.setText(null);
        cep.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            cargo.getItems().addAll(
                "Vendedor",
                "Gerente",
                "Atendente",
                "Estoquista"
            ); 
    }    
    
}