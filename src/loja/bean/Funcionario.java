
package loja.bean;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

public class Funcionario {
    int prontuario;
    String cpf;
    String nome;
    Date datanasc;
    double salario;
    int cargo;
    Departamento departamento;
    Endereco endereco;
}
