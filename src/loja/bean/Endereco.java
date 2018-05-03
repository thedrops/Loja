package loja.bean;

public class Endereco {
    String estado;
    String cidade;
    String rua;
    String numero;
    String bairro;
    String cep;
    
    public Endereco(String estado,String cidade,String rua,String numero,String bairro,String cep){
        this.bairro=bairro;
        this.cep=cep;
        this.cidade=cidade;
        this.estado=estado;
        this.numero=numero;
        this.rua=rua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
}
