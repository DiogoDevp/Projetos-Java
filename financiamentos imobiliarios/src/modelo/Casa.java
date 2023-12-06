package modelo;

import java.io.Serial;

// subclasse de financiamento.
public class Casa extends Financiamento{

    @Serial
    private static final long serialVersionUID = 1L;
    private final double tamanhoDaArea;
    private final double tamanhoTerreno;
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoDaArea, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoDaArea = tamanhoDaArea;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double getTamanhoDaArea() {
        return tamanhoDaArea;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    //incrementar uma taxa de 80 por mês no pagamento total.
    @Override
    public double PagamentoMensal() {
        return super.PagamentoMensal() + 80;
    }

    @Override
    public void DadosFinanciamento() {
        System.out.println("***Casa***\nO valor do imóvel sera de: " + this.getValorImovel() + "\nO valor do financiamento sera de: " + PagamentoMensal() + "\nA área da casa sera de: " + this.getTamanhoDaArea() + "\nA área do terreno sera de: " + this.getTamanhoTerreno());
    }
}
