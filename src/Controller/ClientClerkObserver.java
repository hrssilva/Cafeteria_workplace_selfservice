package src.Controller;

import src.View.ClientView;
import src.View.ClerkView;
import src.View.PopupSpawner;

import src.Model.Model;

/* 
    Classe necessária para a comunicação entre o cliente e o atendente.
    Eg.
    Cliente Solicita Comanda
            |
            v
    Atendente Notificado
            |
            v
    Atendente Gera Comanda
*/
public class ClientClerkObserver {
    private ClientView clientView;
    private ClerkView clerkView;
    private PopupSpawner popup;
    private Model modelo;

    public ClientClerkObserver(Model modelo, ClientView clientView, ClerkView clerkView)
    {
        this.clientView = clientView;
        this.clerkView = clerkView;
        this.modelo = modelo;
        popup = new PopupSpawner();

        clientView.getSolicitarComanda().addActionListener(e -> notifyClerkSolicitarComanda());
    }
    
    
    private void notifyClerkSolicitarComanda()
    {
        popup.resetPopupButtons();
        popup.getPopupYesButton().addActionListener(e -> replyYesClient());
        popup.getPopupNoButton().addActionListener(e -> replyNoClient());
        popup.initYesNoPopup("Solicitacao de Comanda", "Solicitacao de comanda recebida.\nGerar comanda?", clerkView.getFrame());
    }
    
    private void replyYesClient()
    {
        popup.resetPopupButtons();
        popup.initInputPopup("Criar comanda - Informar idade", "Por favor informe sua idade:",clientView.getStartFrame());
        popup.getPopupOkButton().addActionListener(e -> popupOkGerarComanda());
    }

    private void replyNoClient()
    {
        popup.spawnErrorPopup("Solicitacao negada.", clientView.getStartFrame());
    }

    private void popupOkGerarComanda()
    {
        int idade = Integer.parseInt(popup.getPopupTextfield().getText());

        String id = modelo.CriarComanda(idade);

        popup.getPopup().dispose();

        popup.spawnInfoPopup("Comanda : " + id, clientView.getStartFrame());
    }
    
}
