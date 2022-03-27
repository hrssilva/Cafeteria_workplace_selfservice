package src.Model;

import java.util.LinkedList;
import java.util.List;

// Classe que representa uma comanda
public class Comanda {

    private static final int IDSize = 4;
    private String ID;
    private List<Item> itens;

    Comanda(String ID)
    {
        this.ID = ID;
        itens = new LinkedList<Item>();
    }

    public static int getTamanhoID()
    {
        return IDSize;
    }

    public String getID()
    {
        return ID;
    }

    public void AdicionarItem(Item item)
    {
        boolean add=true;
        for (int i=0; i < itens.size(); i++)
        {
            Item current = itens.get(i);
            if (current.getID() == item.getID())
            {
                add = false;
                current.MudarQuantidade(item.getQuantidade());
                itens.set(i, current);
                break;
            }
        }

        if(add)
        {
            itens.add(item);
        }
    }

    public String toString()
    {
        String s = new String();
        float total = 0;
        s = s + String.format("%s:", ID);
        for (Item item : itens)
        {
            
            s = s + String.format("{%d,%s,%f,%d},", item.getID(), item.getNome(), item.getValor(), item.getQuantidade());
            total = total + (item.getValor() * item.getQuantidade());
        }

        s = s + String.format("TOTAL=%f", total);

        return s;
    }
}
