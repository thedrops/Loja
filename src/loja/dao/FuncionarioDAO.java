package loja.dao;

import conexao.Conexao;
import java.util.Date;
import loja.bean.Departamento;

public class FuncionarioDAO {
        
    private final Conexao conexao;
    
    public FuncionarioDAO(){
        conexao=new Conexao();
        conexao.configurar();
    }
    
    public boolean inserir(String cpf,String nome, String datanasc,double salario,int cargo,String id){
        
        //Criar a sql com variáveis
        String sql ="insert into funcionario(cpf,nome,dt_nasc,salario,cargo,prontuario) values('" + cpf + "','"+ nome + "','" + datanasc + 
                "','" + salario + "','" + cargo + "','" + id +  "')";
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarNome(int id,String nome){
        //criar sql com variáveis
        String sql = "Update funcionario set nome = '"+nome+"' where id = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarSalario(int id,double salario){
        //criar sql com variáveis
        String sql = "Update funcionario set salario = '"+ salario +"' where id = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarCargo(int id,int cargo){
        //criar sql com variáveis
        String sql = "Update funcionario set cargo = '"+cargo+"' where id = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
        public boolean atualizarDepartamento(int id,Departamento departamento){
        //criar sql com variáveis
        String sql = "Update funcionario set departamento = '"+departamento+"' where id = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }


}
