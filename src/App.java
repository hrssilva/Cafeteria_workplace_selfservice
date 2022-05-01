package src;

import src.Model.Comanda;
import src.Model.Item;
import src.Model.Model;
import src.View.ClientView;
import src.View.ClerkView;
import src.View.ManagerView;
import src.Controller.ClientController;
import src.Controller.ClerkController;
import src.Controller.ManagerController;

import src.Controller.TestController;
import src.View.TestView;
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
        ClientView clientView = new ClientView("Cliente");
        ManagerView managerView = new ManagerView("Gerente");
        //TestView view2 = new TestView("Atendente");
        //TestView view3 = new TestView("Gerente");
        ClientController clientController = new ClientController(model, clientView);
        ManagerController managerController = new ManagerController(model, managerView);
        //TestController controller2 = new TestController(model, view2);
        //TestController controller3 = new TestController(model, view3);
        
        Item item0 = new Item(0, "agua", 2.49f, 1, false);
        Item item1 = new Item(1, "salgado", 8.99f, 1, false);
        Item item2 = new Item(0, "agua", 2.49f, 1, false);

        String ID = model.CriarComanda(16);
        Comanda comanda = model.getComandaAtiva(ID);
        comanda.AdicionarItem(item0);
        comanda.AdicionarItem(item1);
        comanda.AdicionarItem(item2);

        //model.AtualizarComandaAtiva(ID, comanda);

        model.addStockItem(item0);
        model.addStockItem(item1);
        model.addStockItem(item2);
        model.WriteStockToFile("./stock.txt");
        model.LogComandas("./comandas.txt");
        // Apenas para proposito de teste
        System.out.println(ID); 

        clientController.initController();
        //controller2.initController();
        //controller3.initController();
        
    }

}
