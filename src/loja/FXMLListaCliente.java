
package loja;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.table.DefaultTableModel;
import loja.bean.Cliente;
import loja.bean.Endereco;
import loja.dao.ClienteDAO;
import loja.dao.EnderecoDAO;


public class FXMLListaCliente implements Initializable {
    
   
    //Dados Cliente
    
    @FXML private TextField nome;
    @FXML private TextField telefone;
    @FXML private TextField id;
    @FXML private TextField cpf;
    @FXML private TableView table;
    
    public void listarCliente(){
       ClienteDAO dao = new ClienteDAO();
       ArrayList<Cliente> lista = dao.pesquisa();
       DefaultTableModel model;
       model = (DefaultTableModel) table.getUserData();
       
       
       
       Object[] row = new Object[4];
       for (int i = 0; i < lista.size(); i++) {
         row[0] = lista.get(i).getId();
         row[1] = lista.get(i).getNome();
         row[2] = lista.get(i).getCpf();
         row[3] = lista.get(i).getTelefone();
          System.out.println(lista.get(i).getId());
       }
       
       model.addRow(row);
       
    }
 
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
