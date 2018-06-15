package loja.dao;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import loja.bean.Funcionario;

public class FuncionarioDAO {
        
    private final Conexao conexao;
    
    public FuncionarioDAO(){
        conexao=new Conexao();
        conexao.configurar();
    }
    
    public boolean deletar(String id){
        //criar sql com variáveis
        String sql= "delete from funcionario where prontuario="+id;
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarFuncionario(String nome,String salario,String cargo,String id){
        boolean b = true;
        
        if(b){
            if(!nome.equals(""))
                b &= atualizarNome(id,nome);
            if(!salario.equals(""))
                b &= atualizarSalario(id,salario);
            if(!cargo.equals(""))
                b &= atualizarCargo(id,cargo);
        }
        else
            b = false;
        return b;
    }
    public boolean inserir(String cpf,String nome, String datanasc,String salario,String cargo){
        
        //Criar a sql com variáveis
        String sql ="insert into funcionario(cpf,nome,dt_nasc,salario,cargo) values('" + cpf + "','"+ nome + "','" + datanasc + 
                "','" + salario + "','" + cargo +  "')";
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarNome(String id,String nome){
        //criar sql com variáveis
        String sql = "Update funcionario set nome = '"+nome+"' where prontuario = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarSalario(String id,String salario){
        //criar sql com variáveis
        String sql = "Update funcionario set salario = '"+ salario +"' where prontuario = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarCargo(String id,String cargo){
        //criar sql com variáveis
        String sql = "Update funcionario set cargo = '"+cargo+"' where prontuario = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
        public boolean atualizarDepartamento(String id,String departamento){
        //criar sql com variáveis
        String sql = "Update funcionario set departamento = '"+departamento+"' where id = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public  ArrayList<Funcionario> pesquisa() throws SQLException{

      String sql = "SELECT * FROM funcionario"; 
      ArrayList<Funcionario> lista = new ArrayList<>();
      conexao.conectar();

          try (ResultSet rs = conexao.pegarResultadoSQL(sql)) {
                            
              while(rs.next()){
                  Funcionario funcionario = new Funcionario();

                  funcionario.setProntuario(rs.getString("prontuario"));
                  funcionario.setNome(rs.getString("nome"));
                  funcionario.setCpf(rs.getString("cpf"));
                  funcionario.setSalario(rs.getString("salario"));
                  funcionario.setCargo(rs.getString("cargo"));


                  lista.add(funcionario);

              }
              rs.close();  
          }

      return lista;
  }
    
        public  String qtdFuncionario() throws SQLException{


      String sql = "SELECT LAST_INSERT_ID();"; 
      conexao.conectar();
      String Id = null;
         try (ResultSet rs = conexao.pegarResultadoSQL(sql)) {        
              while(rs.next()){
            
                  Id = rs.getString("LAST_INSERT_ID()");
                  
              }
              rs.close();  
          }
        

      return Id;
  }

}
