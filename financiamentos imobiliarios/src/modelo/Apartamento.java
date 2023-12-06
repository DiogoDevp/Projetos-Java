package modelo;

import java.io.Serial;

// subclasse de apartamento
public class Apartamento extends Financiamento{

    @Serial
    private static final long serialVersionUID = 1L;

    private final int numeroVagasGaragem;
    private final int numeroAndar;
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    // pagamento mensal baseado no sistema Price.
    @Override
    public double PagamentoMensal() {
        double valor = getValorImovel();
        int meses = getPrazoFinanciamento() * 12;
        //obter o percentual da taxa de juros mensal
        double taxaMensal = (getTaxaJurosAnual()/12);
        return ((valor * taxaMensal) * (Math.pow(taxaMensal + 1, meses))/Math.pow(1 + taxaMensal, meses - 1));
    }

    @Override
    public void DadosFinanciamento() {
        System.out.println("***Apartamento***\nO valor do imóvel sera de: " + this.getValorImovel() + "\nO valor do financiamento sera de: " + PagamentoMensal() + "\nO número do andar é: " + this.getNumeroAndar() + "\nO número de vagas na garagem é: " + this.getNumeroVagasGaragem());
    }
}
