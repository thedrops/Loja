/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import loja.dao.ProdutoDAO;

/**
 * FXML Controller class
 *
 * @author Paulo Henrique
 */
public class FXMLUpdateProduto implements Initializable {
    private static String idDado;
    private static  String tipoDado;
    private static  String precoDado;
    private static  String tamanhoDado;
    private static  String corDado;
    private static  String marcaDado;
    private static  String fornecedorDado; 

    public static void setId(String id) {
        idDado = id;
    }

    public static void setTipo(String tipo) {
        tipoDado = tipo;
    }

    public static void setPreco(String preco) {
        precoDado = preco;
    }

    public static void setTamanho(String tamanho) {
        tamanhoDado = tamanho;
    }

    public static void setCor(String cor) {
        corDado = cor;
    }

    public static void setMarca(String marca) {
        marcaDado = marca;
    }

    public static void setFornecedor(String fornecedor) {
        fornecedorDado = fornecedor;
    }

  
    
    @FXML private TextField tipo;
    @FXML private TextField preco;
    @FXML private TextField tamanho;;
    @FXML private TextField cor;
    @FXML private TextField marca;
    @FXML private TextField fornecedor;
    @FXML private TextField id;
    
    public void alterar(ActionEvent event){
        
        ProdutoDAO produto = new ProdutoDAO();
       boolean b = produto.atualizarProduto(Integer.parseInt(id.getText()) , tamanho.getText() , 
               Double.parseDouble(preco.getText()) , tipo.getText() ,
               cor.getText() , marca.getText() , fornecedor.getText() );
       
         if(b){System.out.println("Inserido com Sucesso");}
         
         else{System.out.println("Erro !!");}  
        
        
        
        
     
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
   
        tipo.setText(tipoDado);
        preco.setText(precoDado);
        tamanho.setText(tamanhoDado);
        cor.setText(corDado);
        marca.setText(marcaDado);
        fornecedor.setText(fornecedorDado);
        id.setText(idDado);
       
       
       
    }  
    
}