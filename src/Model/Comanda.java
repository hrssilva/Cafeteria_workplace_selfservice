package src.Model;

import java.util.LinkedList;
import java.util.List;

// Classe que representa uma comanda
public class Comanda {

    private static final int IDSize = 4;
    private final float valorWifiHora = 5;
    private String ID;
    private List<Item> itens;
    private int idadeCliente; // Necessario para compra de bebidas alcoolicas
    //Temporizadores em minutos
    private float wifiTimer = 0;
    private float elapsedMinutes = 0;
    private final float millisToMinutes = 1000 * 60;
    private boolean isTimerPaused = true;

    public Comanda(String ID, int idade)
    {
        this.ID = ID;
        this.idadeCliente = idade;
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

    public boolean AdicionarItem(Item item)
    {
        boolean add=true;

        if(item.isAlcoolico() && idadeCliente < 18)
        {
            return false;
        }

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

        return true;
    }
    
    public void startWifiTimer()
    {
        isTimerPaused = false;
        wifiTimer = System.currentTimeMillis()/millisToMinutes;
    }
    
    public float stopWifiTimer()
    {
        isTimerPaused = true;
        elapsedMinutes = elapsedMinutes + (System.currentTimeMillis()/millisToMinutes - wifiTimer);
        return elapsedMinutes;
    }
    
    public float getElapsedMinutes()
    {
        return elapsedMinutes;
    }
    
    public float checkElapsedMinutes()
    {
        if(isTimerPaused)
        {
            return elapsedMinutes;
        }
        return elapsedMinutes + (System.currentTimeMillis()/millisToMinutes - wifiTimer);
    }

    public float getTotal()
    {
        float total = 0;
        float horasDescontadas = 0;
        float elapsedHours = elapsedMinutes/60;
        for (Item item : itens)
        {
            total = total + (item.getValor() * item.getQuantidade());
        }

        horasDescontadas = (float)Math.floor(total/10);
        if(elapsedHours <= horasDescontadas)
        {
            return total;
        }
        return total + (elapsedMinutes/60 - horasDescontadas) * valorWifiHora;
    }

    public String toString()
    {
        String s = new String();
        s = s + String.format("%s:", ID);
        for (Item item : itens)
        {
            s = s + String.format("{%s},", item.toString());
        }

        s = s + String.format("WIFI_MINUTOS=%f,TOTAL=%f;", elapsedMinutes, this.getTotal());

        return s;
    }
}
