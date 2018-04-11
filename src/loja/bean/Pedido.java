/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.bean;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author Professor
 */
public class Pedido {
    
    int id;
    double valor_total;
    Date data_compra;
    Funcionario funcionario;
    Cliente cliente;
    
    
    
}
