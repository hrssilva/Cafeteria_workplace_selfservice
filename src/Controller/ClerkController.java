package src.Controller;

import src.Model.Comanda;
import src.Model.Item;
import src.Model.Model;
import src.View.ClerkView;
import src.View.PopupSpawner;
public class ClerkController {

    private Model modelo;
    private ClerkView visao;
    private PopupSpawner popup;
    

    public ClerkController(Model model, ClerkView view)
    {
        modelo = model;
        visao = view;
        popup = new PopupSpawner();
    }
    
}
