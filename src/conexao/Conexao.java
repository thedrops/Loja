
package conexao;

public class Conexao extends ConexaoAbstract {

    @Override
    public void configurar() {
        this.port = PORT_MYSQL;
        this.className= CLASSNAME_MYSQL;
        this.setConexao(MYSQL, "loja", "localhost");
        this.setLogin("root", "root");        
    }

}