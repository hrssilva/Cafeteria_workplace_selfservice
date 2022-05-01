package src.Controller;

import src.Model.Comanda;
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

    public void initController()
    {
        visao.getGerarComandaButton().addActionListener(e -> gerarComanda());
        visao.getConsultarComandaButton().addActionListener(e -> consultarComanda());
        visao.getEncerrarComandaButton().addActionListener(e -> encerrarComanda());
        visao.getLimparComandaButton().addActionListener(e -> limparComanda());
    }

    private void limparComanda() {
       visao.getComandaTextfield().setText("");
    }

    private void gerarComanda()
    {
        popup.initInputPopup("Criar comanda - Informar idade", "Por favor informe a idade do cliente:",visao.getFrame());
        popup.getPopupOkButton().addActionListener(e -> popupOkGerarComanda());
    }

    private void consultarComanda()
    {
        Comanda c = modelo.getComandaAtiva(visao.getComandaTextfield().getText());
        if(c != null) 
        {
            String[] s = c.toString().split(":");
            String id = s[0], list = s[1];
            list = list.replace("},", "\n").replace("{","").replace(";","");

            popup.spawnInfoPopup("Comanda : " + id + "\n[id,nome,valor,qtd]\n" + list, visao.getFrame());
        }
        else
        {
            popup.spawnErrorPopup("Comanda invalida, por favor verifique e tente novamente.", visao.getFrame());
        }
    }

    private void encerrarComanda()
    {
        String ID = visao.getComandaTextfield().getText();
        Comanda c = modelo.getComandaAtiva(ID);
        if(c != null)
        {
            String[] s = c.toString().split(":");
            String id = s[0], list = s[1];
            list = list.replace("},", "\n").replace("{","").replace(";","");
            popup.spawnInfoPopup("Comanda : " + id + "\n[id,nome,valor,qtd]\n" + list, visao.getFrame());
            modelo.DesativarComanda(ID);
            popup.spawnInfoPopup("Comanda " + ID + " encerrada", visao.getFrame());
        }
        else
        {
            popup.spawnErrorPopup("Comanda " + ID + " nao esta ativa!", visao.getFrame());
        }
    }

    private void popupOkGerarComanda()
    {
        try 
        {
            int idade = Integer.parseInt(popup.getPopupTextfield().getText());

            String id = modelo.CriarComanda(idade);

            popup.getPopup().dispose();

            popup.spawnInfoPopup("Comanda " + id + " gerada.", visao.getFrame());
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
            popup.spawnErrorPopup("Informe um valor valido para idade", popup.getPopup());
        }
    }
}
