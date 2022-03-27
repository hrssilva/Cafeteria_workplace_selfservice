package src.Model;

// Classe que representa um item no estoque ou na comanda
public class Item {
    private int ID;
    private String nome;
    private float valor;
    private int quantidade;


    public Item(int ID, String nome, float valor, int quantidade)
    {
        this.ID = ID;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }


    public int getID()
    {
        return ID;
    }

    public String getNome()
    {
        return nome;
    }

    public float getValor()
    {
        return valor;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public int MudarQuantidade(int diferenca)
    {
        if (diferenca < -quantidade)
        {
            return -1;
        }

        quantidade = quantidade + diferenca;

        return quantidade;
    }

    
}
