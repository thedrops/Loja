package loja.dao;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import loja.bean.Endereco;

public class EnderecoFuncDAO {
    
    private final Conexao conexao;
    
    public EnderecoFuncDAO(){
        conexao=new Conexao();
        conexao.configurar();
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
       public boolean atualizarEstado(String estado,String id){
        String sql = "Update endereco_funcionario set estado = '"+estado+"' where id_funcionario = "+id;

        //conectar com banco de dados
        conexao.conectar();
        
        //enviar sql para banco de dados
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar erro ou Ok
        return b;
       }
       
        public boolean atualizarCidade(String cidade,String id){
            String sql = "Update endereco_funcionario set cidade = '"+cidade+"' where id_funcionario = "+id;

            //conectar com banco de dados
            conexao.conectar();

            //enviar sql para banco de dados
            boolean b = conexao.executarComandosSQL(sql);

            //retornar erro ou Ok
            return b;
        }
        
        public boolean atualizarRua(String rua,String id){
            String sql = "Update endereco_funcionario set rua = '"+rua+"' where id_funcionario = "+id;

            //conectar com banco de dados
            conexao.conectar();

            //enviar sql para banco de dados
            boolean b = conexao.executarComandosSQL(sql);

            //retornar erro ou Ok
            return b;
        }
        
        public boolean atualizarNumero(String numero,String id){
            String sql = "Update endereco_funcionario set numero = '"+numero+"' where id_funcionario = "+id;

            //conectar com banco de dados
            conexao.conectar();

            //enviar sql para banco de dados
            boolean b = conexao.executarComandosSQL(sql);

            //retornar erro ou Ok
            return b;
       }
        
        public boolean atualizarBairro(String bairro,String id){
            String sql = "Update endereco_funcionario set bairro = '"+bairro+"' where id_funcionario = "+id;

            //conectar com banco de dados
            conexao.conectar();

            //enviar sql para banco de dados
            boolean b = conexao.executarComandosSQL(sql);

            //retornar erro ou Ok
            return b;
       }
       
        public boolean atualizarCEP(String cep,String id){
            String sql = "Update endereco_funcionario set cep = '"+cep+"' where id_funcionario = "+id;

            //conectar com banco de dados
            conexao.conectar();

            //enviar sql para banco de dados
            boolean b = conexao.executarComandosSQL(sql);

            //retornar erro ou Ok
            return b;
        }
        
        public boolean atualizarEndereco(String id, String estado,String cidade,String rua,String numero,String bairro,String cep){
            boolean b = true; 
            
            if(b){
            if(!estado.equals("")){
                b &= atualizarEstado(estado,id);
                }
                if(!cidade.equals("")){
                    b &= atualizarCidade(cidade,id);
                }
                if(!rua.equals("")){
                    b &= atualizarRua(rua,id);
                }
                if(!numero.equals("")){
                    b &= atualizarNumero(numero,id);
                }
                if(!bairro.equals("")){
                    b &= atualizarBairro(bairro,id);
                }
                if(!cep.equals("")){
                    b &= atualizarCEP(cep,id);
                }
            }
            else{
                b = false;
            }
            return b;
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
    
}