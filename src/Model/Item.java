package src.Model;


// Classe que representa um item no estoque ou na comanda
public class Item {
    private int ID;
    private String nome;
    private float valor;
    private int quantidade;
    private boolean alcoolico;


    public Item(int ID, String nome, float valor, int quantidade, boolean alcoolico)
    {
        this.ID = ID;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.alcoolico = alcoolico;
    }

    public Item()
    {
        this.ID = -1;
        this.nome = new String();
        this.valor = -1;
        this.quantidade = -1;
        this.alcoolico = false;
    }

    public Item(Item another)
    {
        this.ID = another.ID;
        this.nome = another.nome;
        this.valor = another.valor;
        this.quantidade = another.quantidade;
        this.alcoolico = another.alcoolico;
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

    public boolean isAlcoolico()
    {
        return alcoolico;
    }

    public String toString()
    {
        return String.format("%d,%s,%.2f,%d", ID, nome, valor, quantidade);
    }

    public Item fromString(String itemString)
    {
        String[] stringList = itemString.split(",");

        ID = Integer.parseInt(stringList[0]);
        nome = stringList[1];
        valor = Float.parseFloat(stringList[2]);
        quantidade = Integer.parseInt(stringList[3]);

        return this;
    }

}
