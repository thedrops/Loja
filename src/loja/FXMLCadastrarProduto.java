
package loja;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import loja.bean.Produto;
import loja.dao.ProdutoDAO;


public class FXMLCadastrarProduto implements Initializable {

    @FXML private TextField tipo;
    @FXML private TextField preco;
    @FXML private TextField tamanho;;
    @FXML private TextField cor;
    @FXML private TextField marca;
    @FXML private TextField id;
    @FXML private TextField fornecedor;
   
    
    //Function botão  
    public void cadastrarProduto(ActionEvent event){
    //Cadastrar Produto
        
    double converte = Double.parseDouble(preco.getText());
    Produto produto = new Produto();
    produto.setTipo(tipo.getText());
    produto.setPreco(converte);
    produto.setTamanho(tamanho.getText());
    produto.setCor(cor.getText());
    produto.setMarca(marca.getText());
    produto.setFornecedor(fornecedor.getText());
    produto.setId(Integer.parseInt(id.getText()));
    ProdutoDAO dao = new ProdutoDAO(); 
    boolean b = dao.inserir(produto.getTipo(),produto.getPreco(),produto.getTamanho(),produto.getCor(),produto.getMarca(),produto.getId(), produto.getFornecedor());
    if(b){System.out.println("Inserido com Sucesso");}
    else{System.out.println("Erro !!");}
        
          
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
