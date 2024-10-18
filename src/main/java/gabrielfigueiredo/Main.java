package gabrielfigueiredo;

import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Moedas moedas = new Moedas();
        Conversor conversor = new Conversor();
        HashSet<Moeda> moedasDisponiveis = moedas.getListaMoedas();
        Scanner scanner = new Scanner(System.in);
        int opcao = 1;

        System.out.println("Feito por Gabriel de Figueiredo");
        System.out.println("Bem-vindo ao conversor de moedas");

            while (opcao == 1) {
                try {
                    moedas.imprimeListaMoedas();
                    System.out.println("Digite o código da moeda base: ");
                    String codigoPrimeiraMoeda = scanner.nextLine().toUpperCase();
                    Moeda primeiraMoeda = moedas.encontraMoeda(codigoPrimeiraMoeda);

                    System.out.println("Digite o código da moeda para converter: ");
                    String codigoSegundaMoeda = scanner.nextLine().toUpperCase();
                    Moeda segundaMoeda = moedas.encontraMoeda(codigoSegundaMoeda);

                    Double fatorDeConversao = conversor.convertePar(primeiraMoeda, segundaMoeda);

                    System.out.println("Digite o montante para converter: ");
                    Double montante = scanner.nextDouble();

                    Double valorConvertido = montante * fatorDeConversao;

                    System.out.println("--------------------------------");
                    System.out.println("1 [" + codigoPrimeiraMoeda + "]" + " equivale a " + fatorDeConversao + " [" + codigoSegundaMoeda + "]");
                    System.out.println("Valor " + montante +
                            "[" + codigoPrimeiraMoeda + "] " +
                            "corresponde ao valor final de => " + valorConvertido +
                            " [" + codigoSegundaMoeda + "]");
                    System.out.println("--------------------------------");
                    System.out.println("Deseja fazer outra conversão?");
                    System.out.println("Se sim, digite 1.");
                    System.out.println(" Se não digite 0.");
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                } catch (IOException e) {
                    System.out.println("Opção invalida. Aperte enter para tentar novamente.");
                    scanner.nextLine();
                } catch (NullPointerException e) {
                    System.out.println("Opção invalida. Aperte enter para tentar novamente.");
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Opção invalida. Aperte enter para tentar novamente.");
                    scanner.nextLine();
                }
            }

        }
    }
