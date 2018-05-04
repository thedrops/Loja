/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.bean;

/**
 *
 * @author a170060x
 */
public class Cliente {
    String id;
    String nome;
    String telefone;
    int endereco;
    String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /* Exemplo de criação para o banco
    
        Cliente cliente = new Cliente();
        cliente.setNome("José");
        cliente.setCpf("1234");
        ClienteDAO dao = new ClienteDAO();
        
        boolean b = dao.inserir(cliente.getNome(),cliente.getCpf());
    */
    
}
