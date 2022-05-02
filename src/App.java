package src;

import src.Model.Model;
import src.View.ClientView;
import src.View.ClerkView;
import src.View.ManagerView;
import src.Controller.ClientController;
import src.Controller.ClerkController;
import src.Controller.ClientClerkObserver;
import src.Controller.ManagerController;
public class App {
    
    public static void main(String args[])
    {
        Model model = new Model();
        ClientView clientView = new ClientView("Cliente");
        ClerkView clerkView = new ClerkView("Atendente");
        ManagerView managerView = new ManagerView("Gerente");
        
        ClientController clientController = new ClientController(model, clientView);
        ManagerController managerController = new ManagerController(model, managerView);
        ClerkController clerkController = new ClerkController(model, clerkView);
        ClientClerkObserver clientClerkObserver = new ClientClerkObserver(model, clientView, clerkView);
        

        clientController.initController();
        clerkController.initController();
        clientClerkObserver.initController();
        managerController.initController();
        
    }

}
