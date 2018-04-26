package loja.dao;

import conexao.Conexao;

public class EnderecoDAO {
    
    private final Conexao conexao;
    
    public EnderecoDAO(){
        conexao=new Conexao();
        conexao.configurar();
    }

    
    public boolean inserir(String estado, String cidade,String rua,String numero, String bairro, String cep){
        
        //Criar a sql com variáveis
        String sql ="insert into cliente(estado,cidade,rua,numero,bairro,cep)"
                + " values('"+estado+"','"+cidade+"'"+ ",'"+rua+"','"
                + ""+numero+"','"+bairro+"'"+ ",'"+cep+"')";

        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    public boolean atualizarNome(int id, String nome){
        //criar sql com variáveis
        String sql = "Update cliente set nome = '"+nome+"' where id = "+id;

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
    
    
    
}

