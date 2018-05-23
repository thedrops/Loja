package loja;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import loja.dao.EnderecoFuncDAO;
import loja.dao.FuncionarioDAO;


public class FXMLUpdateFuncionario implements Initializable {
      private static String nomeDado;
      private static String salarioDado;
      private static String cargoDado;
      private static String id;
      private static String estadoDado;
      private static String cidadeDado;
      private static String ruaDado;
      private static String numeroDado;
      private static String bairroDado;
      private static String cepDado;
      
      
      public static void setNome(String nome) {
        nomeDado = nome;
      }
      
      public static void setSalario(String salario) {
        salarioDado = salario;
      }
      
     public static void setCargo(String cargo) {
        cargoDado = cargo;
      }
      public static void setId(String prontuario) {
        id = prontuario;
      }
      
     public static void setEstado(String estado) {
          estadoDado = estado;
      }
     
    public static void setCidade(String cidade) {
        cidadeDado = cidade;
    }
    
    public static void setRua(String rua) {
        ruaDado = rua;
    }
    
    public static void setNumero(String numero) {
        numeroDado = numero;
    }
    public static void setBairro(String bairro) {
        bairroDado = bairro;
    }

    public static void setCep(String cep) {
        cepDado = cep;
    }
      
    //Dados Funcionario
    @FXML  private TextField nome;
    @FXML  private TextField salario;
    @FXML  private ChoiceBox cargo;
 
    
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
        boolean b = funcionario.atualizarFuncionario(nome.getText(),salario.getText().replaceAll(",","."),(String)cargo.getValue(),id);

        EnderecoFuncDAO enderecoDAO = new EnderecoFuncDAO();
        
        boolean c  = enderecoDAO.atualizarEndereco(id,estado.getText(),cidade.getText(),
            rua.getText(),numero.getText(),bairro.getText(),cep.getText());
        
        boolean verificarCampos = (nome.getText().equals("")  && salario.getText().equals("") &&
                cargo.getValue().equals("") && numero.getText().equals("") && estado.getText().equals("") && cidade.getText().equals("") &&
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
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            cargo.getItems().addAll(
                "Vendedor",
                "Gerente",
                "Atendente",
                "Estoquista"
            );
 
        nome.setText(nomeDado);
        salario.setText(salarioDado);
        cargo.setValue(cargoDado);
        estado.setText(estadoDado);
        cidade.setText(cidadeDado);
        rua.setText(ruaDado);
        numero.setText(numeroDado);
        bairro.setText(bairroDado);
        cep.setText(cepDado);
       
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

