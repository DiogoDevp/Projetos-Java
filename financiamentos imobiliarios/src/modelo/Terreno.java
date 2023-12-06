package modelo;

import java.io.Serial;

// subclasse de Financiamento
public class Terreno extends Financiamento{

    @Serial
    private static final long serialVersionUID = 1L;

    private final String zona;
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    @Override
    public double PagamentoMensal() {
        return super.PagamentoMensal() * 1.02;
    }

    @Override
    public void DadosFinanciamento() {
        System.out.println("***Terreno***\nO valor do imóvel sera de: " + this.getValorImovel() + "\nO valor do financiamento sera de: " + PagamentoMensal() + "\nO terreno esta localizado na zona: " + this.getZona());
    }
}


