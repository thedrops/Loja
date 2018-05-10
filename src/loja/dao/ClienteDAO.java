package loja.dao;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import loja.bean.Cliente;
import loja.bean.Funcionario;

public class ClienteDAO {
    
    private final Conexao conexao;
    
    public ClienteDAO(){
        conexao=new Conexao();
        conexao.configurar();
    }

    
    public boolean inserir(String nome, String cpf,String telefone){
        
        //Criar a sql com variáveis
        String sql ="insert into cliente(nome,cpf,telefone) values('"+nome+"','"+cpf+"'"+ ",'"+telefone+"')";

        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarCliente(String nome,String telefone,String id){
        boolean b = true;
        
        if(b){
            if(!nome.equals(""))
                b &= atualizarNome(id,nome);
            if(!telefone.equals(""))
                b &= atualizarTelefone(id,telefone);
        }
        else
            b = false;
        return b;
    }
    
    public boolean atualizarNome(String id,String nome){
        //criar sql com variáveis
        String sql = "Update cliente set nome = '"+nome+"' where prontuario = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarTelefone(String id,String telefone){
        //criar sql com variáveis
        String sql = "Update cliente set telefone = '"+telefone+"' where prontuario = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
 
    public boolean deletar(String id){
        
        //criar sql com variáveis
        String sql= "delete from cliente where id="+id;
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public  ArrayList<Cliente> pesquisa() throws SQLException{


      String sql = "SELECT * FROM cliente"; 
      ArrayList<Cliente> lista = new ArrayList<>();
      conexao.conectar();



          try (ResultSet rs = conexao.pegarResultadoSQL(sql)) {        
              while(rs.next()){
                  Cliente cliente = new Cliente();

                  cliente.setId(rs.getString(1));
                  cliente.setNome(rs.getString("nome"));
                  cliente.setCpf(rs.getString("cpf"));
                  cliente.setTelefone(rs.getString("telefone"));


                  lista.add(cliente);

              }
              rs.close();  
          }

      return lista;
  }

    
    
    
}
