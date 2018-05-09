
package loja;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import loja.bean.Funcionario;
import loja.dao.FuncionarioDAO;


public class FXMLListaFuncionario implements Initializable {
    @FXML TableView tabela = new TableView<>(); 
        TableColumn colunaProntuario = new TableColumn<>("Prontuario");
        TableColumn colunaNome = new TableColumn<>("Nome");        
        TableColumn colunaCPF = new TableColumn<>("CPF");
       Funcionario dados;
      
     
      
     public void alterar(ActionEvent event) throws IOException{
       
         dados =  (Funcionario) tabela.getSelectionModel().getSelectedItem();
         
         FXMLUpdateFuncionario.setNome(dados.getNome());
         FXMLUpdateFuncionario.setSalario(dados.getSalario());
         FXMLUpdateFuncionario.setCargo(dados.getCargo());
            
         Parent root = FXMLLoader.load(getClass().getResource("FXMLUpdateFuncionario.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();

           System.out.println(dados.getNome());
           
 

          
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FuncionarioDAO funcionario = new FuncionarioDAO();
        colunaProntuario.setCellValueFactory(new PropertyValueFactory<>("prontuario"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        
        try {
            tabela.setItems(FXCollections.observableArrayList(funcionario.pesquisa()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabela.getColumns().addAll(colunaProntuario,colunaNome,colunaCPF);
 
    }    
    
}
