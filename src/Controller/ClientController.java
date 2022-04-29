package src.Controller;

import javax.swing.JOptionPane;

import src.Model.Comanda;
import src.Model.Item;
import src.Model.Model;
import src.View.ClientView;

// Aglomerado das funcionalidades do controlador para o cliente
public class ClientController {
    /*
        -> Lidar com input do usuario (recebido pela view) utilizando os metodos da Model
        -> Selecionar e organizar a View, assim como repassar as resolucoes da Model para ela

        Se utilizarmos padrao de observador ver slide 24 de VideoAula-08 - Projeto Arquitetural - Padrões Arquiteturais
    */
    private Model modelo;
    private ClientView visao;
    

    public ClientController(Model model, ClientView view)
    {
        modelo = model;
        visao = view;
        initView();
    }

    public void initView() 
    {
        visao.getComandaTextfield().setText("");
        visao.getItemTextfield().setText("");
    }

    public void initController() 
    {
        visao.getConsultarComandaButton().addActionListener(e -> consultarComanda());
        visao.getAdicionarItemButton().addActionListener(e -> adicionarItem());
    }

    private void consultarComanda() 
    {
        Comanda c = modelo.getComandaAtiva(visao.getComandaTextfield().getText());
        if(c != null)
        {
            String[] s = c.toString().split(":");
            String id = s[0], list = s[1];
            list = list.replace("},", "\n").replace("{","").replace(";","");

            JOptionPane.showMessageDialog(null, "Comanda : " + id + "\n[id,nome,valor,qtd]\n" + list, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Comanda invalida, por favor verifique e tente novamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarItem()
    {
        Item i = modelo.getStockItem(Integer.parseInt(visao.getItemTextfield().getText()));
        Comanda c = modelo.getComandaAtiva(visao.getComandaTextfield().getText());
        if(c != null)
        {
            if(i == null)
            {
                JOptionPane.showMessageDialog(null, "Numero de item não existe, por favor verifique e tente novamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else if (i.getQuantidade() == 0)
            {
                JOptionPane.showMessageDialog(null, "Infelizmente o item nao esta em estoque.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else if (i.isAlcoolico() && !c.isLegalAge())
            {
                JOptionPane.showMessageDialog(null, "Este item so pode ser comprado por maiores de idade", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                c.AdicionarItem(i);
                i.MudarQuantidade(-1);

                JOptionPane.showMessageDialog(null, "Comanda : " + c.getID() + "\n" + "Item \"" + i.getNome() + "\" adicionado!" , "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Comanda invalida, por favor verifique e tente novamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
