
package loja;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import loja.bean.Cliente;
import loja.dao.ClienteDAO;
import loja.dao.EnderecoDAO;


public class FXMLListaCliente implements Initializable {
    @FXML TableView tabela = new TableView<>(); 
        TableColumn colunaId = new TableColumn<>("Id");
        TableColumn colunaNome = new TableColumn<>("Nome");        
        TableColumn colunaCPF = new TableColumn<>("CPF");
        TableColumn colunaTelefone = new TableColumn<>("Telefone");
        Cliente dados;
      
     
        
     public void alterar(ActionEvent event) throws IOException, SQLException{
         dados =  (Cliente) tabela.getSelectionModel().getSelectedItem();
         FXMLUpdateCliente.setId(dados.getId());
         FXMLUpdateCliente.setNome(dados.getNome());
         FXMLUpdateCliente.setTelefone(dados.getTelefone());
         
         
         EnderecoDAO endereco = new EnderecoDAO();
         
         FXMLUpdateCliente.setEstado(endereco.pesquisa(dados.getId()).get(0).getEstado());
         FXMLUpdateCliente.setCidade(endereco.pesquisa(dados.getId()).get(0).getCidade());
         FXMLUpdateCliente.setRua(endereco.pesquisa(dados.getId()).get(0).getRua());
         FXMLUpdateCliente.setBairro(endereco.pesquisa(dados.getId()).get(0).getBairro());
         FXMLUpdateCliente.setNumero(endereco.pesquisa(dados.getId()).get(0).getNumero());
         FXMLUpdateCliente.setCep(endereco.pesquisa(dados.getId()).get(0).getCep());
         
     
         Parent root = FXMLLoader.load(getClass().getResource("FXMLUpdateCliente.fxml"));
         Stage stage = new Stage();
         Scene scene = new Scene(root, 600, 600);
         stage.setScene(scene);
         stage.show();
         
         stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent we) {

                    ClienteDAO cliente = new ClienteDAO();
                    try {
                        tabela.getItems().setAll(FXCollections.observableArrayList(cliente.pesquisa()));
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLListaCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
         
         
         
         
         
         
     }
    
      public void cadastrar(ActionEvent event) throws IOException{
           Parent root = FXMLLoader.load(getClass().getResource("FXMLCadastroCliente.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent we) {

                    ClienteDAO cliente = new ClienteDAO();
                    try {
                        tabela.getItems().setAll(FXCollections.observableArrayList(cliente.pesquisa()));
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLListaCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
     }
     
    public void deletar(ActionEvent event){
          ClienteDAO cliente = new ClienteDAO();
          dados =  (Cliente) tabela.getSelectionModel().getSelectedItem();
          boolean c = cliente.deletar(dados.getId());
          int selectedIndex = tabela.getSelectionModel().getSelectedIndex();
          if(c){
            tabela.getItems().remove(selectedIndex);
            
          }else{
              Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Atualização de funcionário");
            dialogoInfo.setHeaderText("Erro ao deletar!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
          }
          
          
          
          
          
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
            Logger.getLogger(FXMLListaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabela.getColumns().addAll(colunaId,colunaNome,colunaCPF,colunaTelefone);
 
    }    
    
}
