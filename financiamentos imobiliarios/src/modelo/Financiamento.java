package modelo;

import java.io.*;
import java.util.ArrayList;

//classe que detem as formulas e metodos para calcular o financiamento
public abstract class Financiamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final double valorImovel;
    private final int prazoFinanciamento;
    private final double taxaJurosAnual;

    //método construtor do financiamento
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento * 12;
        this.taxaJurosAnual = taxaJurosAnual / 100;
    }

    // metodos para retornar os atributos do financiamento de forma segura
    public double getValorImovel(){
        return valorImovel;
    }

    public int getPrazoFinanciamento(){
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return taxaJurosAnual;
    }

    // formulas do financiamento que retornam informações importantes
    public double PagamentoMensal(){
        return (valorImovel / prazoFinanciamento) * (1 + (taxaJurosAnual / 12));
    }

    public double PagamentoTotal(){
        return PagamentoMensal() * (prazoFinanciamento * 12);
    }

    public void DadosFinanciamento(){

    }
}


