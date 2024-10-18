package gabrielfigueiredo;

import java.util.Objects;

public class Moeda {
    private String codigo;
    private String nome;
    private String local;

    public Moeda() {
    }

    public Moeda(String codigo, String nome, String local) {
        this.codigo = codigo;
        this.nome = nome;
        this.local = local;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getLocal() {
        return local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moeda moeda = (Moeda) o;
        return Objects.equals(codigo, moeda.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
                "Nome: " + nome + "\n" +
                "País: " + local;
    }
}
