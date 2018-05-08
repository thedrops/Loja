package loja.dao;

import conexao.Conexao;

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


}
