package src.Controller;

import src.View.ClientView;
import src.View.ClerkView;
import src.View.PopupSpawner;
import src.Model.Comanda;
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
    }
    
    public void initController() 
    {
        clientView.getSolicitarComanda().addActionListener(e -> notifyClerkSolicitarComanda());
        clientView.getSolicitarEncerramento().addActionListener(e -> notifyClerkSolicitarEncerramento());
    }
    
    private void notifyClerkSolicitarComanda()
    {
        popup.resetPopupButtons();
        popup.getPopupYesButton().addActionListener(e -> replyYesClientComanda());
        popup.getPopupNoButton().addActionListener(e -> replyNoClientComanda());
        popup.initYesNoPopup("Solicitacao de Comanda", "Solicitacao de comanda recebida. Gerar comanda?", clerkView.getFrame());
        popup.spawnInfoPopup("Aguarde aprovacao pelo atendente.", clientView.getFrame());
    }

    private void notifyClerkSolicitarEncerramento()
    {
        String ID = clientView.getIdLabel().getText();
        Comanda c = modelo.getComandaAtiva(ID);
        if(c != null)
        {
            popup.resetPopupButtons();
            popup.getPopupYesButton().addActionListener(e -> replyYesClientEncerramento());
            popup.getPopupNoButton().addActionListener(e -> replyNoClientEncerramento());
            popup.spawnInfoPopup("Aguarde aprovacao pelo atendente.", clientView.getMainFrame());
            
           
            
            String[] s = c.toString().split(":");
            String id = s[0], list = s[1];
            list = list.replace("},", "\n").replace("{","").replace(";","");
            popup.spawnInfoPopup("Comanda : " + id + "\n[id,nome,valor,qtd]\n" + list, clerkView.getFrame());
            
            popup.initYesNoPopup("Solicitacao de Encerramento", "Solicitacao de Encerramento recebida. Encerrar comanda?", clerkView.getFrame());
        }
        else
        {
            popup.spawnErrorPopup("Comanda " + ID + " nao esta ativa!", clientView.getMainFrame());
        }
    }
    
    private void replyYesClientComanda()
    {
        popup.getPopup().dispose();
        popup.resetPopupButtons();
        popup.initInputPopup("Criar comanda - Informar idade", "Por favor informe sua idade:",clientView.getFrame());
        popup.getPopupOkButton().addActionListener(e -> popupOkGerarComanda());
    }

    private void replyNoClientComanda()
    {
        popup.getPopup().dispose();
        popup.spawnErrorPopup("Solicitacao negada.", clientView.getMainFrame());
    }

    private void replyYesClientEncerramento()
    {
        popup.getPopup().dispose();
        popup.resetPopupButtons();
        String ID = clientView.getIdLabel().getText();
        if(modelo.DesativarComanda(ID) != null)
        {
            popup.spawnInfoPopup("Comanda " + ID + " encerrada", clerkView.getFrame());
            popup.spawnInfoPopup("Comanda " + ID + " encerrada", clientView.getMainFrame());
        }
    }
    

    private void replyNoClientEncerramento()
    {
        popup.getPopup().dispose();
        popup.spawnErrorPopup("Solicitacao negada.", clientView.getMainFrame());
    }

    private void popupOkGerarComanda()
    {
        try 
        {
            int idade = Integer.parseInt(popup.getPopupTextfield().getText());

            String id = modelo.CriarComanda(idade);

            popup.getPopup().dispose();

            popup.spawnInfoPopup("Comanda : " + id, clientView.getFrame());
            popup.spawnInfoPopup("Comanda " + id + " gerada.", clerkView.getFrame());
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
            popup.spawnErrorPopup("Informe um valor valido para idade", popup.getPopup());
        }
    }
    
}
