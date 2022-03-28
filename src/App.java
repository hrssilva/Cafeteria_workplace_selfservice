package src;

import src.Controller.Controller;
import src.Model.Comanda;
import src.Model.Item;
import src.Model.Model;
import src.View.TerminalClientView;
import src.View.View;

public class App {
    
    public static void main(String args[])
    {
        /*
            Exemplo do caso de uso "Visualizar comanda" em terminal.
            Isso eh apenas um exemplo basico para o funcionamento da model,
            a model nao deve ser chamada diretamente.

            1 modelo, visao e controle serao inicializados.
            ----- APENAS PARA TESTE-------
            1 comanda sera criada.
            3 itens serao inicializados e adicionados a comanda.
            A comanda sera atualizada no modelo
            ------------------------------
            A execucao seguira o fluxo normal, mas a logica do modelo nao sera atualizada.
        */
        Model model = new Model();
        View view = new TerminalClientView();
        Controller controller = new Controller(model, view);
        
        Item item0 = new Item(0, "agua", 2.49f, 1, false);
        Item item1 = new Item(1, "salgado", 8.99f, 1, false);
        Item item2 = new Item(0, "agua", 2.49f, 1, false);

        String ID = model.CriarComanda(16);
        Comanda comanda = model.getComandaAtiva(ID);
        comanda.AdicionarItem(item0);
        comanda.AdicionarItem(item1);
        comanda.AdicionarItem(item2);

        model.AtualizarComandaAtiva(ID, comanda);

        // Apenas para proposito de teste
        System.out.println(ID); 

        controller.StartView();

        while(controller.ViewIsRunning())
        {
            controller.UpdateView();
        }
        
    }

}
