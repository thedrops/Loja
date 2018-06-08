
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
import javafx.stage.Stage;



public class FXMLInicio implements Initializable{

    

    
    public void abrirListaCliente(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLListaCliente.fxml"));
         Stage stage = new Stage();
         Scene scene = new Scene(root, 600, 600);
         stage.setScene(scene);
         stage.show();
            
    }
     
    public void abrirListaFuncionario(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("FXMLListaFuncionario.fxml"));
         Stage stage = new Stage();
         Scene scene = new Scene(root, 600, 600);
         stage.setScene(scene);
         stage.show();
         
         
         
         
    }
      public void abrirListaProduto(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("FXMLListaProduto.fxml"));
         Stage stage = new Stage();
         Scene scene = new Scene(root, 600, 600);
         stage.setScene(scene);
         stage.show();
         
         
         
         
    }
    
    
   
    public void initialize(URL url, ResourceBundle rb) {
      
 
    }    
    
}

