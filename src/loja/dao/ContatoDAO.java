package loja.dao;

import conexao.Conexao;

public class ContatoDAO {
    
    private final Conexao conexao;
    
    public ContatoDAO(){
        conexao=new Conexao();
        conexao.configurar();
    }
    
    public boolean inserir(String nome, String telefone,String email){
        
        //Criar a sql com variáveis
        String sql ="insert into contato(nome,telefone,email) values('"+nome+"','"+telefone+"'"+ ",'"+email+"')";

        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
    }
    
    
    
}
