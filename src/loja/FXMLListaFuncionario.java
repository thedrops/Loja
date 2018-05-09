
package loja;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import loja.dao.FuncionarioDAO;


public class FXMLListaFuncionario implements Initializable {
    @FXML TableView tabela = new TableView<>();
        TableColumn colunaProntuario = new TableColumn<>("Prontuario");
        TableColumn colunaNome = new TableColumn<>("Nome");        
        TableColumn colunaCPF = new TableColumn<>("CPF");
        
     
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FuncionarioDAO funcionario = new FuncionarioDAO();
        colunaProntuario.setCellValueFactory(new PropertyValueFactory<>("prontuario"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        
        try {
            System.out.println(funcionario.pesquisa().get(2).getNome());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tabela.setItems(FXCollections.observableArrayList(funcionario.pesquisa()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabela.getColumns().addAll(colunaProntuario,colunaNome,colunaCPF);
    }    
    
}
