package loja.dao;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import loja.bean.Endereco;

public class EnderecoDAO {
    
    private final Conexao conexao;
    
    public EnderecoDAO(){
        conexao=new Conexao();
        conexao.configurar();
    }

    
    public boolean inserir(String estado, String cidade,String rua,String numero, String bairro, String cep,String id_cliente){
        
        conexao.conectar();

        String sql ="insert into endereco_cliente(estado,cidade,rua,numero,bairro,cep,id_cliente) values('"+estado+"','"+cidade+"'"+ ",'"+rua+"'"+ ",'"+numero+"'"+ ",'"+bairro+"'"+ ",'"+numero+"'"+ ",'"+id_cliente+"')";

        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarEndereco(String id, String estado,String cidade,String rua,String numero,String bairro,String cep){
        //criar sql com variáveis
        String sql = "Update endereco_cliente set estado = '"+estado+"', cidade='"+cidade+"',"
                + "rua='"+rua+"', numero='"+numero+"', bairro='"+bairro+"', cep='"+cep+"' where id_cliente = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean deletar(int id){
        
        //criar sql com variáveis
        String sql= "delete from cliente where id="+String.valueOf(id);
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public  ArrayList<Endereco> pesquisa(String id) throws SQLException{

      String sql = "SELECT * FROM endereco_funcionario WHERE id_funcionario = " + id; 
      ArrayList<Endereco> lista = new ArrayList<>();
      conexao.conectar();

          try (ResultSet rs = conexao.pegarResultadoSQL(sql)) {
                            
              while(rs.next()){
                  Endereco endereco = new Endereco(rs.getString("estado"),rs.getString("cidade"),rs.getString("rua"),rs.getString("numero"),
                  rs.getString("bairro"),rs.getString("cep"));



                  lista.add(endereco);

              }
              rs.close();  
          }
        System.out.println(lista.get(0));
      return lista;
  }
    
    
    
}

