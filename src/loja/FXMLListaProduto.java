
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
import loja.bean.Produto;


import loja.dao.ProdutoDAO;
 
public class FXMLListaProduto implements Initializable {
    @FXML TableView tabela = new TableView<>(); 
        TableColumn colunaTipo = new TableColumn<>("Tipo");
        TableColumn colunaCor = new TableColumn<>("Cor");        
        TableColumn colunaPreco  = new TableColumn<>("Preco");
       Produto dados;
    
    
    
    //Function botão  
       public void cadastrar(ActionEvent event) throws IOException{
           Parent root = FXMLLoader.load(getClass().getResource("FXMLCadastrarProduto.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent we) {

                    ProdutoDAO produto = new ProdutoDAO();
                    try {
                        tabela.getItems().setAll(FXCollections.observableArrayList(produto.pesquisa()));
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLListaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });     
           
            
     }
        public void deletar(ActionEvent event){
          ProdutoDAO produto = new ProdutoDAO();
          dados =  (Produto) tabela.getSelectionModel().getSelectedItem();
          boolean c = produto.deletar(dados.getId());
          int selectedIndex = tabela.getSelectionModel().getSelectedIndex();
          
       
          
          if(c)
           tabela.getItems().remove(selectedIndex);
          else{
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Exclusão de Produto");
            dialogoInfo.setHeaderText("Erro ao excluir Produto!");
            dialogoInfo.setContentText("");
            dialogoInfo.showAndWait();
          }
          
    }
         public void alterar(ActionEvent event) throws IOException, SQLException{
       
           dados =  (Produto) tabela.getSelectionModel().getSelectedItem();
         
           
         FXMLUpdateProduto.setTipo(dados.getTipo());
         FXMLUpdateProduto.setPreco(Double.toString(dados.getPreco()));
         FXMLUpdateProduto.setTamanho(dados.getTamanho());
         FXMLUpdateProduto.setId(Integer.toString(dados.getId()));
         FXMLUpdateProduto.setCor(dados.getCor());
         FXMLUpdateProduto.setMarca(dados.getMarca());
         FXMLUpdateProduto.setFornecedor(dados.getFornecedor());
         
            Parent root = FXMLLoader.load(getClass().getResource("FXMLUpdateProduto.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();
          
      
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent we) {

                           ProdutoDAO produto = new ProdutoDAO();
                    try {
                        tabela.getItems().setAll(FXCollections.observableArrayList(produto.pesquisa()));
                    } catch (SQLException ex) {
                        Logger.getLogger(FXMLListaProduto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });        
      
     }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ProdutoDAO produto = new ProdutoDAO();
            colunaTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
            colunaCor.setCellValueFactory(new PropertyValueFactory<>("Cor"));
            colunaPreco.setCellValueFactory(new PropertyValueFactory<>("Preço"));
            
            
            tabela.setItems(FXCollections.observableArrayList(produto.pesquisa()));
            
            tabela.getColumns().addAll(colunaTipo,colunaCor,colunaPreco);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListaProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
 
    }    
    
    
}
