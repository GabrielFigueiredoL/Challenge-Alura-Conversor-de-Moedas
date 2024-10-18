package gabrielfigueiredo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Moedas {
    private HashSet<Moeda> listaMoedas = new HashSet<>();

    private void lerMoedasDisponiveis() {
        try (Scanner scanner = new Scanner(new File("moedasDisponiveis.csv"))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] valores = linha.split(",");
                listaMoedas.add(new Moeda(valores[0], valores[1], valores[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        }
    }

    public HashSet<Moeda> getListaMoedas() {
        lerMoedasDisponiveis();
        return listaMoedas;
    }

    public void imprimeListaMoedas() {
        HashSet<Moeda> listaMoedas = getListaMoedas();
        for (Moeda moeda : listaMoedas) {
            System.out.println(moeda);
            System.out.println("--------------------------------");
        }
    }

    public Moeda encontraMoeda(String codigoMoeda) {
        lerMoedasDisponiveis();
        for (Moeda moeda : listaMoedas) {
            if (moeda.getCodigo().equals(codigoMoeda)) {
                return moeda;
            }
        }

        return null;
    }
}
