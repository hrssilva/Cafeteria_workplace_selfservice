package src;

import src.Model.Comanda;
import src.Model.Item;
import src.Model.Model;

public class App {
    
    public static void main(String args[])
    {
        /*
            Exemplo do caso de uso "Visualizar comanda" em terminal.
            Isso eh apenas um exemplo basico para o funcionamento da model,
            a model nao deve ser chamada diretamente.

            1 modelo sera inicializado.
            1 comanda sera criada.
            3 itens serao inicializados e adicionados a comanda.
            A comanda sera impressa no terminal.

            TODO: Ainda deve ser adicionada a logica relacionada a utilizacao do wifi
            
        */
        Model model = new Model();
        Item item0 = new Item(0, "agua", 2.49f, 1);
        Item item1 = new Item(1, "salgado", 8.99f, 1);
        Item item2 = new Item(0, "agua", 2.49f, 1);

        String ID = model.CriarComanda();
        Comanda comanda = model.getComandaAtiva(ID);
        comanda.AdicionarItem(item0);
        comanda.AdicionarItem(item1);
        comanda.AdicionarItem(item2);
        System.out.println(comanda.toString());
    }

}
