
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
import loja.bean.Cliente;
import loja.dao.ClienteDAO;

public class FXMLListaCliente implements Initializable {
    @FXML TableView tabela = new TableView<>(); 
        TableColumn colunaId = new TableColumn<>("Id");
        TableColumn colunaNome = new TableColumn<>("Nome");        
        TableColumn colunaCPF = new TableColumn<>("CPF");
        TableColumn colunaTelefone = new TableColumn<>("Telefone");
       Cliente dados;
      
     
      
     public void alterar(ActionEvent event) throws IOException{
       
         dados =  (Cliente) tabela.getSelectionModel().getSelectedItem();
         
         FXMLUpdateCliente.setNome(dados.getNome());
         FXMLUpdateCliente.setTelefone(dados.getTelefone());
            
         Parent root = FXMLLoader.load(getClass().getResource("FXMLUpdateCliente.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();

           System.out.println(dados.getNome());
           
 

          
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClienteDAO cliente = new ClienteDAO();
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        try {
            tabela.setItems(FXCollections.observableArrayList(cliente.pesquisa()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabela.getColumns().addAll(colunaId,colunaNome,colunaCPF,colunaTelefone);
 
    }    
    
}
