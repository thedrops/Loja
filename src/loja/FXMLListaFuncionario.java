
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
import loja.bean.Funcionario;
import loja.dao.EnderecoFuncDAO;
import loja.dao.FuncionarioDAO;


public class FXMLListaFuncionario implements Initializable {
    @FXML TableView tabela = new TableView<>(); 
        TableColumn colunaProntuario = new TableColumn<>("Prontuario");
        TableColumn colunaNome = new TableColumn<>("Nome");        
        TableColumn colunaCPF = new TableColumn<>("CPF");
       Funcionario dados;
      
    
     public void cadastrar(ActionEvent event) throws IOException{
           Parent root = FXMLLoader.load(getClass().getResource("FXMLCadastroFuncionario.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent we) {

                    FuncionarioDAO funcionario = new FuncionarioDAO();
                    try {
                        tabela.getItems().setAll(FXCollections.observableArrayList(funcionario.pesquisa()));
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLListaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });     
           
            
     }
     
    public void deletar(ActionEvent event){
          FuncionarioDAO funcionario = new FuncionarioDAO();
          dados =  (Funcionario) tabela.getSelectionModel().getSelectedItem();
          boolean c = funcionario.deletar(dados.getProntuario());
          int selectedIndex = tabela.getSelectionModel().getSelectedIndex();
          
       
          
          if(c)
           tabela.getItems().remove(selectedIndex);
          else{
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Exclusão de funcionário");
            dialogoInfo.setHeaderText("Erro ao excluir funcionário!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
          }
          
    }
    
     public void alterar(ActionEvent event) throws IOException, SQLException{
       
           dados =  (Funcionario) tabela.getSelectionModel().getSelectedItem();
         
         FXMLUpdateFuncionario.setNome(dados.getNome());
         FXMLUpdateFuncionario.setSalario(dados.getSalario());
         FXMLUpdateFuncionario.setCargo(dados.getCargo());
         FXMLUpdateFuncionario.setId(dados.getProntuario());
         
         EnderecoFuncDAO endereco = new EnderecoFuncDAO();
         FXMLUpdateFuncionario.setEstado(endereco.pesquisa(dados.getProntuario()).get(0).getEstado());
         FXMLUpdateFuncionario.setCidade(endereco.pesquisa(dados.getProntuario()).get(0).getCidade());
         FXMLUpdateFuncionario.setRua(endereco.pesquisa(dados.getProntuario()).get(0).getRua());
         FXMLUpdateFuncionario.setBairro(endereco.pesquisa(dados.getProntuario()).get(0).getBairro());
         FXMLUpdateFuncionario.setNumero(endereco.pesquisa(dados.getProntuario()).get(0).getNumero());
         FXMLUpdateFuncionario.setCep(endereco.pesquisa(dados.getProntuario()).get(0).getCep());
         
            Parent root = FXMLLoader.load(getClass().getResource("FXMLUpdateFuncionario.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();
          
      
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent we) {

                           FuncionarioDAO funcionario = new FuncionarioDAO();
                    try {
                        tabela.getItems().setAll(FXCollections.observableArrayList(funcionario.pesquisa()));
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLListaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });        
      
     }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            FuncionarioDAO funcionario = new FuncionarioDAO();
            colunaProntuario.setCellValueFactory(new PropertyValueFactory<>("prontuario"));
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
            
            
            tabela.setItems(FXCollections.observableArrayList(funcionario.pesquisa()));
            
            tabela.getColumns().addAll(colunaProntuario,colunaNome,colunaCPF);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
 
    }    
    
}
