
package loja.dao;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import loja.bean.Produto;

public class ProdutoDAO {
     private final Conexao conexao;
     
     public ProdutoDAO(){
    
         conexao=new Conexao();
         conexao.configurar();

    }
     
    public boolean inserir(String tipo, Double preco, String tamanho, String cor, String marca, int id, String fornecedor){
    
        String sql="insert into produto(tipo,preco,tamanho,cor,marca,id) "
                + "VALUES('"+tipo+"','"+preco+"','"+tamanho+"','"+cor+"','"+marca+"','"+id+"','"+fornecedor+"' )" ;
        
        //conectar com banco de dados
        conexao.conectar();
        
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    } 
    public boolean atualizarPreco(int id, Double preco){
        //criar sql com variáveis
        String sql = "Update produto set preco = '"+preco+"' where id = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    public boolean atualizarTamanho(int id, String tamanho){
        //criar sql com variáveis
        String sql = "Update produto set tamanho = '"+tamanho+"' where id = "+id;
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
     public boolean atualizarProduto(int id, String tamanho, Double preco, String tipo, String cor, String marca, String fornecedor){
        //criar sql com variáveis
        String sql = "Update produto set "
                + "tamanho = '"+tamanho+"',preco = '"+preco+"', tipo = '"+tipo+"', cor = '"+cor+"',marca ='"+marca+"',fornecedor = '"+fornecedor+"' where id = "+id;
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    public boolean deletar(int id){
        
        //criar sql com variáveis
        String sql= "delete from produto where id="+String.valueOf(id);
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
     public  ArrayList<Produto> pesquisa() throws SQLException{

      String sql = "SELECT * FROM Produto"; 
      ArrayList<Produto> lista = new ArrayList<>();
      conexao.conectar();

          try (ResultSet rs = conexao.pegarResultadoSQL(sql)) {
                            
              while(rs.next()){
                  Produto produto = new Produto();

                  produto.setTipo(rs.getString("Tipo"));
                  produto.setPreco(rs.getDouble("Preco"));
                  produto.setCor(rs.getString("Cor"));
                  produto.setTamanho(rs.getString("Tamanho"));
                  produto.setMarca(rs.getString("Marca"));
                  produto.setFornecedor(rs.getString("Fornecedor"));

                  lista.add(produto);

              }
              rs.close();  
          }

      return lista;
  }
}
