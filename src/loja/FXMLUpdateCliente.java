
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
import loja.dao.ClienteDAO;
import loja.dao.EnderecoDAO;


public class FXMLUpdateCliente implements Initializable {
    //Dados Cliente
    
    @FXML private TextField nome;
    @FXML private TextField telefone;
      
    //Dados endereco
    
    @FXML private TextField estado;
    @FXML private TextField cidade;
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField bairro;
    @FXML private TextField cep;
    
      // Update
    
      private static String nomeDado;
      private static String telefoneDado;
      private static String id;
      
    public static void setId(String idDado) {
        id = idDado;
    }  
    public static void setNome(String nome) {
        nomeDado = nome;
      }
    public static void setTelefone(String telefone) {
        telefoneDado = telefone;
      }

 
    //Function botão
    public void alterar(ActionEvent event){
        
        ClienteDAO cliente = new ClienteDAO();
        boolean b = cliente.atualizarCliente(nome.getText(),telefone.getText(),id);

        EnderecoDAO enderecoDAO = new EnderecoDAO();
        
        boolean c  = enderecoDAO.atualizarEndereco(id,estado.getText(),cidade.getText(),
            rua.getText(),numero.getText(),bairro.getText(),cep.getText());
        
        boolean verificarCampos = (nome.getText().equals("")  && telefone.getText().equals("")
                && numero.getText().equals("") && estado.getText().equals("") && cidade.getText().equals("") &&
                rua.getText().equals("") && bairro.getText().equals("") && cep.getText().equals(""));
        
        if(verificarCampos){
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Atualização de cliente");
            dialogoInfo.setHeaderText("Nenhuma alteração para realizar!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
        else if(b && c){
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Atualização de cliente");
            dialogoInfo.setHeaderText("Úsuario atualizado com sucesso!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
        }
        else{
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastro de Cliente");
            dialogoInfo.setHeaderText("Erro ao atualizar cliente!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
         }
             

    }

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nome.setText(nomeDado);
        telefone.setText(telefoneDado);
    
    } 
      
    
}
