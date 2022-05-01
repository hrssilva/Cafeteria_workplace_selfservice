package src.Controller;


import src.Model.Comanda;
import src.Model.Item;
import src.Model.Model;
import src.View.ClientView;
import src.View.PopupSpawner;

// Aglomerado das funcionalidades do controlador para o cliente
public class ClientController {
    /*
        -> Lidar com input do usuario (recebido pela view) utilizando os metodos da Model
        -> Selecionar e organizar a View, assim como repassar as resolucoes da Model para ela

        Se utilizarmos padrao de observador ver slide 24 de VideoAula-08 - Projeto Arquitetural - Padrões Arquiteturais
    */
    private Model modelo;
    private ClientView visao;
    private PopupSpawner popup;
    

    public ClientController(Model model, ClientView view)
    {
        modelo = model;
        visao = view;
        popup = new PopupSpawner();
    }

    public void initController() 
    {
        visao.getLoginButton().addActionListener(e -> login());
        visao.getConsultarComandaButton().addActionListener(e -> consultarComanda());
        visao.getAdicionarItemButton().addActionListener(e -> adicionarItem());
        visao.getLogoutButton().addActionListener(e -> logout());
    }

    private void login()
    {
        String id = visao.getComandaTextfield().getText();
        Comanda c = modelo.getComandaAtiva(id);
        if(c != null)
        {
            visao.getComandaTextfield().setText("");
            visao.mainFrame("Comanda - " + id, id);
        }
        else
        {
            popup.spawnErrorPopup("Comanda invalida, por favor verifique e tente novamente.", visao.getStartFrame());
        }
    }

    private void logout() 
    {
        visao.getFrame().dispose();
    }

    private void consultarComanda() 
    {
        Comanda c = modelo.getComandaAtiva(visao.getIdLabel().getText());
        if(c != null) // De acordo com a organizacao atual, esse teste deve ser desnecessario
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

    private void adicionarItem()
    {
        Item i = modelo.getStockItem(Integer.parseInt(visao.getItemTextfield().getText()));
        Comanda c = modelo.getComandaAtiva(visao.getIdLabel().getText());
        if(c != null) // De acordo com a organizacao atual, esse teste deve ser desnecessario
        {
            if(i == null)
            {
                popup.spawnErrorPopup("Numero de item não existe, por favor verifique e tente novamente.", visao.getFrame());
            }
            else if (i.getQuantidade() == 0)
            {
                popup.spawnWarnPopup("Infelizmente o item nao esta em estoque.", visao.getFrame());
            }
            else if (i.isAlcoolico() && !c.isLegalAge())
            {
                popup.spawnWarnPopup("Este item so pode ser comprado por maiores de idade.", visao.getFrame());
            }
            else
            {
                c.AdicionarItem(i);
                i.MudarQuantidade(-1);

                popup.spawnInfoPopup("Comanda : " + c.getID() + "\n" + "Item \"" + i.getNome() + "\" adicionado!", visao.getFrame());
            }
        }
        else
        {
            popup.spawnErrorPopup("Comanda invalida, por favor verifique e tente novamente.", visao.getFrame());
        }
    }

}
