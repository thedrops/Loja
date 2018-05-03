package loja.dao;

import conexao.Conexao;
import java.sql.ResultSet;

public class EnderecoFuncDAO {
    
    private final Conexao conexao;
    
    public EnderecoFuncDAO(){
        conexao=new Conexao();
        conexao.configurar();
    }

    
    public boolean inserir(String estado, String cidade,String rua,String numero, String bairro, String cep,String prontuario){
        
        conexao.conectar();
        
      String sql ="insert into endereco_funcionario(estado,cidade,rua,numero,bairro,cep,id_funcionario) values("
              + "'"+estado+"','"+cidade+"'"+ ",'"+rua+"'"+ ",'"+numero+"'"+ ",'"+bairro+"'"+ ",'"+numero+"'"+ ",'"+prontuario+"')";

        
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarNome(int id, String nome){
        //criar sql com variáveis
        String sql = "Update funcionario set nome = '"+nome+"' where id = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarCpf(int id, String cpf){
        //criar sql com variáveis
        String sql = "Update funcionario set cpf = '"+cpf+"' where id = "+id;
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean deletar(int id){
        
        //criar sql com variáveis
        String sql= "delete from funcionario where id="+String.valueOf(id);
        
        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    
    
}

