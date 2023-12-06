package main;

//importar para utilizar os métodos de outros pacotes
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import modelo.Financiamento;
import util.InterfaceUsuario;
import util.MyException;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

//classe onde o fluxo do programa ocorre
public class Main {

    // Metodo ler os financiamentos do array e gravar no arquivo
    public static void gravarFinanciamentos(ArrayList<Financiamento> financiamentos) throws IOException {

        ObjectOutputStream outputStream = new ObjectOutputStream (new FileOutputStream("financiamentos.txt"));

        try {
            for (Object finan : financiamentos) {
                outputStream.writeObject(finan);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        try {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //Método para ler financiamentos e atualizar o array
    public static void recuperarFinanciamentos(ArrayList<Financiamento> financiamentos) throws IOException {
        ObjectInputStream inputStream = null;
        try{
            inputStream = new ObjectInputStream(new FileInputStream("financiamentos.txt"));
            Object finan = null;
            while ((finan = inputStream.readObject()) != null) {
                if (finan instanceof Casa){
                    financiamentos.add((Casa) finan);
                }
                else if (finan instanceof Apartamento){
                    financiamentos.add((Apartamento) finan);
                }
                else if (finan instanceof Terreno){
                    financiamentos.add((Terreno) finan);
                }
            }
        } catch (EOFException ex){
            System.out.println("Chegou ao final do arquivo.");
        } catch (ClassNotFoundException | IOException ex){
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                    System.out.println("Financiamentos encotrados com sucesso!");
                }
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InputMismatchException, IOException {



//loop do menu principal:
        while (true) {

            //Adicionar os financiamentos á uma lista de objetos da classe financiamento.
            ArrayList<Financiamento> financiamentos = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Selecione a opção\n\n (1) Adicionar financiamento \n (2) Listar financiamentos gravados \n (3) Excluir financiamentos \n (4) Sair \n");

            int opcao = 0;
            try {
                opcao = scanner.nextInt();
                if (opcao < 1 || opcao > 4) {
                    throw new MyException("Selecione de 1 à 4");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Digite apenas números");
            }

            //4 financiamentos padrões.
            Financiamento Financiamento1 = new Casa(500000, 20, 13, 370, 300);

            Financiamento Financiamento2 = new Casa(200000, 10, 10, 100, 100);

            Financiamento Financiamento3 = new Apartamento(200000, 10, 10, 1, 2);

            Financiamento Financiamento4 = new Terreno(200000, 10, 10, "Urbana");


            //Atualizar o array com os financiamentos antigos
            recuperarFinanciamentos(financiamentos);

            // caso o array não tenha nenhum financiamento ja gravado então são salvos os financiamentos padrões
            if (financiamentos.size() == 0) {
                financiamentos.add(Financiamento1);
                financiamentos.add(Financiamento2);
                financiamentos.add(Financiamento3);
                financiamentos.add(Financiamento4);
            }

// Escolhida a opção 1 (adicionar financiamento):
            if (opcao == 1) {
                InterfaceUsuario interfacex = new InterfaceUsuario();
                Financiamento finan = null;
                if (Objects.equals(interfacex.tipoImovel, "C")) {
                    finan = new Casa(interfacex.valorImovelUsuario, interfacex.prazoFinanciamentoUsuario, interfacex.taxaJurosAnual, interfacex.tamanhoDaArea, interfacex.tamanhoTerreno);
                }
                if (Objects.equals(interfacex.tipoImovel, "A")) {
                    finan = new Apartamento(interfacex.valorImovelUsuario, interfacex.prazoFinanciamentoUsuario, interfacex.taxaJurosAnual, interfacex.numeroVagasGaragem, interfacex.numeroAndar);
                }
                if (Objects.equals(interfacex.tipoImovel, "R")) {
                    finan = new Terreno(interfacex.valorImovelUsuario, interfacex.prazoFinanciamentoUsuario, interfacex.taxaJurosAnual, interfacex.zona);
                }


                // adiciona o financiamento no array
                financiamentos.add(finan);

                //Grava o financiamento no arquivo externo
                gravarFinanciamentos(financiamentos);
            }

// Escolhida a opção 2 (listar financiamentos):
            if (opcao == 2) {
                //contador para enumerar os financiamentos e valor total para somar os valores.
                int contador = 0;
                int valorTotal = 0;

                // listar os financiamentos
                try{

                    if (financiamentos.size() == 0){
                        throw new MyException("Não há financiamentos gravados");
                    }

                for (Financiamento financiamento : financiamentos) {
                    System.out.printf("\n===========\n financiamento " + contador + " ");
                    financiamento.DadosFinanciamento();
                    contador++;
                    valorTotal += financiamento.PagamentoTotal();
                }


                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("\n=====");
                System.out.printf("\nO valor total de todos os financiamentos sera de: " + valorTotal + " R$");
            }

// Caso escolhida a opção 3 (excluir financiamento)
            if (opcao == 3) {
                financiamentos.clear();
                // regravar o array
                    gravarFinanciamentos(financiamentos);
            }

// caso escolhida a opção 4 (Sair) o loop é encerrado.
            if (opcao == 4) {
                break;
            }
        }
    }
}

