package src.Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Aglomerado das funcionalidades do modelo
public class Model {
    /*
        Se utilizarmos padrao de observador ver slide 24 de VideoAula-08 - Projeto Arquitetural - Padrões Arquiteturais
    */
    private Map<String, Comanda> comandasAtivas;
    private Map<String, Comanda> comandasInativas;
    private Map<Integer, Item> stock;
    private final String stringNumerica = "0123456789";

    public Model()
    {
        comandasAtivas = new HashMap<String, Comanda>();
        comandasInativas = new HashMap<String, Comanda>();
        stock = new HashMap<Integer, Item>();
    }

    public String CriarComanda(int idade)
    {
        int n = Comanda.getTamanhoID();
        int index;
        String ID;
        
        do 
        {    
            StringBuilder IDBuilder = new StringBuilder();

            for (int i = 0; i < n; i++)
            {
                index = (int)(Math.random()*stringNumerica.length());
                IDBuilder.append(stringNumerica.charAt(index));
            }
            
            ID = IDBuilder.toString();
    
        } while(comandasAtivas.containsKey(ID) || comandasInativas.containsKey(ID));

        Comanda comanda = new Comanda(ID, idade);
        
        comandasAtivas.put(ID, comanda);

        return ID;

    }

    public String DesativarComanda(String ID)
    {
        if (comandasAtivas.containsKey(ID))
        {
            Comanda comanda = comandasAtivas.remove(ID);
            comandasInativas.put(ID, comanda);
            return ID;
        }
        return null;
    }


    public Comanda getComandaAtiva(String ID)
    {
        return comandasAtivas.get(ID);
    }

    public Comanda AtualizarComandaAtiva(String ID, Comanda comanda)
    {
        return comandasAtivas.replace(ID, comanda);
    }

    public List<Comanda> getListaComandas()
    {
        List<Comanda> lista = new LinkedList<Comanda>();

        lista.addAll(comandasAtivas.values());
        lista.addAll(comandasInativas.values());

        return lista;
    }

    public List<Item> getListaItens()
    {
        List<Item> lista = new LinkedList<Item>();

        lista.addAll(stock.values());

        return lista;
    }

    public boolean getStockFromFile(String filename)
    {
        BufferedReader input;
        try {
            input = new BufferedReader(new FileReader(filename));
            String currentLine;
    
            try {
                while((currentLine = input.readLine()) != null)
                {
                    Item item = new Item().fromString(currentLine);
                    stock.put(item.getID(), item);
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
    
            try {
                input.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }

    public Item getStockItem(int ID)
    {
        return stock.get(ID);
    }

    public void addStockItem(Item item)
    {
        if (stock.containsKey(item.getID()))
        {
            stock.get(item.getID()).MudarQuantidade(item.getQuantidade());
        }
        else
        {
            stock.put(item.getID(), item);
        }
    }

    public void removeStockItem(Item item)
    {
        stock.remove(item.getID());
    }

    public void changeStockItem(Item item)
    {
        stock.replace(item.getID(), item);
    }

    public void WriteStockToFile(String filename)
    {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(filename));
            for (Item item : stock.values())
            {
                output.write(item.toString());
                output.newLine();
            }

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        };

    }

    public void LogComandas(String filename)
    {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(filename));
            for (Comanda item : getListaComandas())
            {
                output.write(item.toString());
                output.newLine();
            }

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        };

    }
}