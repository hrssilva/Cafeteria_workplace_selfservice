package src.Model;

import java.util.HashMap;
import java.util.Map;

//TODO: Ainda deve ser adicionada a logica relacionada a utilizacao do wifi
// Aglomerado das funcionalidades do modelo
public class Model {
    /*
        Se utilizarmos padrao de observador ver slide 24 de VideoAula-08 - Projeto Arquitetural - Padrões Arquiteturais
    */
    private Map<String, Comanda> comandasAtivas;
    private Map<String, Comanda> comandasInativas;
    private final String stringNumerica = "0123456789";

    public Model()
    {
        comandasAtivas = new HashMap<String, Comanda>();
        comandasInativas = new HashMap<String, Comanda>();
    }

    public String CriarComanda()
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

        Comanda comanda = new Comanda(ID);
        
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
        return "";
    }


    public Comanda getComandaAtiva(String ID)
    {
        return comandasAtivas.get(ID);
    }

}