package loja.dao;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import loja.bean.Cliente;

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
    
    public boolean atualizarCliente(String id, String nome,String telefone){
        //criar sql com variáveis
        String sql = "Update cliente set nome = '"+nome+"', telefone = '"+telefone+"' where id = "+id;
        

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarCpf(int id, String cpf){
        //criar sql com variáveis
        String sql = "Update cliente set cpf = '"+cpf+"' where id = "+id;
        
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
    
    public ArrayList<Cliente> pesquisa(){

    
    String sql = "SELECT * FROM cliente"; 
    ArrayList<Cliente> lista = new ArrayList<>();
    conexao.conectar();

    try{
        

        ResultSet rs = conexao.pegarResultadoSQL(sql);

        

        while(rs.next()){
            Cliente cliente = new Cliente(); 
            
            cliente.setId(rs.getString("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setTelefone(rs.getString("telefone"));

            
            lista.add(cliente);

        }
        rs.close();

    }catch(SQLException s){
        s.getStackTrace();
    }
    return lista;
}
    
    
    
    
}
