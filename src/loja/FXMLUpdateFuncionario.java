package loja;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import loja.dao.EnderecoFuncDAO;
import loja.dao.FuncionarioDAO;


public class FXMLUpdateFuncionario implements Initializable {
      private static String nomeDado;
      private static String salarioDado;
      private static String cargoDado;
      private static String id;
      
      public static void setNome(String nome) {
        nomeDado = nome;
      }
      
      public static void setSalario(String salario) {
        salarioDado = salario;
      }
      
      public static void setCargo(String cargo) {
        cargoDado = cargo;
      }
      public static void setId(String id) {
        id = id;
      }
   
    //Dados Funcionario
    @FXML  private TextField nome;
    @FXML  private TextField salario;
    @FXML  private TextField cargo;
 
    
    //Dados endereco
    
    @FXML private TextField estado;
    @FXML private TextField cidade;
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField bairro;
    @FXML private TextField cep;
    
    //Function botão
    
    
    public void alterar(ActionEvent event){
        
        FuncionarioDAO funcionario = new FuncionarioDAO();
        boolean b = funcionario.atualizarFuncionario(nome.getText(),salario.getText(),cargo.getText(),id);

        EnderecoFuncDAO enderecoDAO = new EnderecoFuncDAO();
        
        boolean c  = enderecoDAO.atualizarEndereco(id,estado.getText(),cidade.getText(),
            rua.getText(),numero.getText(),bairro.getText(),cep.getText());
        
        boolean verificarCampos = (nome.getText().equals("")  && salario.getText().equals("") &&
                cargo.getText().equals("") && numero.getText().equals("") && estado.getText().equals("") && cidade.getText().equals("") &&
                rua.getText().equals("") && bairro.getText().equals("") && cep.getText().equals(""));
        
        if(verificarCampos){
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Atualização de funcionário");
            dialogoInfo.setHeaderText("Nenhuma alteração para realizar!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
        else if(b && c){
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Atualização de funcionário");
            dialogoInfo.setHeaderText("Úsuario atualizado com sucesso!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
        else{
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro de funcionário");
            dialogoInfo.setHeaderText("Erro ao atualizar funcionário!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
         }
             

    }
    
 
    
    public void deletar(ActionEvent event){
          FuncionarioDAO funcionario = new FuncionarioDAO();
          boolean c = funcionario.deletar(id);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
 
        nome.setText(nomeDado);
        salario.setText(salarioDado);
        cargo.setText(cargoDado);
        
        /* mostrar dados nos campos      
            FuncionarioDAO funcionario = new FuncionarioDAO();
            
            
            
        try {
            nome.setText(funcionario.pesquisa().get(0).getNome());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLUpdateFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }  
    
}

