package util;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

//classe onde o usuario pode inserir as informações que serao lidas pelo financiamento
public class InterfaceUsuario {

    public double valorImovelUsuario;
    public int prazoFinanciamentoUsuario;
    public double taxaJurosAnual;
    public double tamanhoDaArea;
    public double tamanhoTerreno;
    public int numeroVagasGaragem;
    public int numeroAndar;
    public String zona;
    public String tipoImovel;
    Scanner scanner = new Scanner(System.in);

    //função que le os dados inseridos e verifica sua validade por meio de loops e condicionais
    public InterfaceUsuario() {

//loops while com tratamento de erros para permitir que, caso o usuário erre, consiga escrever o valor correto.
        while (true) {
            System.out.print("Digite tipo de imóvel (casa, apartamento ou terreno (C, A ou T)) ");
            String tipoImovel = scanner.nextLine();
            //try englobando o trexo de código que possa ser identificado um erro
            try {
                if (!Objects.equals(tipoImovel, "C") && !Objects.equals(tipoImovel, "A") && !Objects.equals(tipoImovel, "TB")) {
                    //criação de uma exceção com mensagem personalizada para entendimento do usuário
                    throw new MyException("Opção inválida. (C, A ou T)");
                }
                //caso não ocorra nenhuma exceção a variável assume o valor e o loop termina
                this.tipoImovel = tipoImovel;
                break;
                // catch para apresentar a mensagem de erro caso ocorra a exceção
            }catch (MyException e){
                System.out.println(e.getMessage());
            }

        }

//***
        while (true) {
            System.out.print("Digite o valor do imovel: ");

            try {
            double valorSuposto = scanner.nextDouble();



            if (valorSuposto < 0){
                throw new MyException("O valor deve ser positivo.");
            }
                this.valorImovelUsuario = valorSuposto;
                break;
        }catch (MyException e){
                System.out.println(e.getMessage());
            }

            //***exceção para caso o usuário digite outros caracteres***

            catch (InputMismatchException e){
                System.out.println("Insira apenas números!");
                scanner.nextLine();
            }

        }

//***
        while (true) {
            System.out.print("Digite o prazo do financiamento (anos): ");
            try {
            int prazoSuposto = scanner.nextInt();

                if (prazoSuposto < 0) {
                    throw new MyException("O prazo deve ser positivo.");
                }
                this.prazoFinanciamentoUsuario = prazoSuposto;
                break;
            } catch (MyException e){
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e){
                System.out.println("Insira apenas números!");
                scanner.nextLine();
            }
            }

//***
        while (true) {
            System.out.print("Digite a taxa de juros anual: ");
            double taxaSuposta = 0;
            try {
            taxaSuposta = scanner.nextDouble();
// Um tratamento caso a taxa seja negativa
            if (taxaSuposta < 0) {
                throw new MyException("A taxa deve ser positiva.");
            }
        } catch (MyException e){
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e){
                System.out.println("Insira apenas números!");
                scanner.nextLine();
            }
// Outro tratamento caso a taxa seja um valor maior de 100
            try{
             if (taxaSuposta > 100) {
                 throw new MyException("A taxa é muito alta.");
             }
                this.taxaJurosAnual = taxaSuposta;
                break;
            } catch (MyException e){
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e){
                System.out.println("Insira apenas números!");
                scanner.nextLine();
            }

        }

// Pedir atributos específicos de casa
            if (Objects.equals(tipoImovel, "C")){
                while (true) {
                        System.out.print("Digite o tamanho da área construída: ");
                    try{
                        double tamanhoDaArea = scanner.nextDouble();

                        if (tamanhoDaArea < 0){
                            throw new MyException("A area deve ser positiva.");
                        }
                            this.tamanhoDaArea = tamanhoDaArea;
                            break;
                        }catch (MyException e){
                            System.out.println(e.getMessage());
                        }catch (InputMismatchException e){
                            System.out.println("Insira apenas números!");
                        scanner.nextLine();
                        }

                        }

                    while (true) {
                        System.out.print("Digite o tamanho do terreno: ");
                        try{
                        double tamanhoTerreno = scanner.nextDouble();

                        if (tamanhoTerreno < 0){
                            throw new MyException("o tamanho deve ser positivo.");
                        }
                            this.tamanhoTerreno = tamanhoTerreno;
                            break;
                        }catch (MyException e){
                            System.out.println(e.getMessage());
                        }catch (InputMismatchException e){
                            System.out.println("Insira apenas números!");
                            scanner.nextLine();
                        }

                    }}

// Pedir atributos específicos de apartamento.
                if (Objects.equals(tipoImovel, "A")){
                    while (true) {
                        System.out.print("Digite o número de vagas na garagem: ");
                        try {
                        int numeroVagasGaragem = scanner.nextInt();

                        if (numeroVagasGaragem < 0){
                            throw new MyException("O número deve ser positivo.");
                        }
                            this.numeroVagasGaragem = numeroVagasGaragem;
                            break;
                        }catch (MyException e){
                            System.out.println(e.getMessage());
                        }catch (InputMismatchException e){
                            System.out.println("Insira apenas números!");
                            scanner.nextLine();
                        }

                    }

                    while (true) {
                        System.out.print("Digite o número do andar: ");
                        try {
                        int numeroAndar = scanner.nextInt();

                            if (numeroAndar < 0) {
                                throw new MyException("O número deve ser positivo.");
                            }
                            this.numeroAndar = numeroAndar;
                            break;
                        }catch (MyException e){
                            System.out.println(e.getMessage());
                        }catch (InputMismatchException e){
                            System.out.println("Insira apenas números!");
                            scanner.nextLine();
                        }

                    }
 }

// Pedir atributos específicos de Terreno
                if (Objects.equals(tipoImovel, "TB")){
                    while (true) {

                        System.out.print("Digite o tipo de imóvel (Rural - R ou Urbano - U: ");
                        try{
                            String zona = scanner.nextLine();

                        if (Objects.equals(zona, "U") ){
                            zona = "Urbana";}
                        else if (Objects.equals(zona, "R")){
                            zona = "Rural";}
                        else{
                                throw new MyException("Valor inválido");
                        }
                            this.zona = zona;
                            break;
                        }catch (MyException e){
                            System.out.println(e.getMessage());
                        }

                        }
                    }
                }
                    }







































