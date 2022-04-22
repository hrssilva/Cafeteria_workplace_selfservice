package src.Controller;

import java.util.Map;

import src.Model.Comanda;
import src.Model.Model;
import src.View.View;

// Aglomerado das funcionalidades do controlador
public class Controller {
    /*
        -> Lidar com input do usuario (recebido pela view) utilizando os metodos da Model
        -> Selecionar e organizar a View, assim como repassar as resolucoes da Model para ela

        Se utilizarmos padrao de observador ver slide 24 de VideoAula-08 - Projeto Arquitetural - Padrões Arquiteturais
    */
    private Model modelo;
    private View visao;
    private Map<Integer, Boolean> flags;

    public Controller(Model model, View view)
    {
        modelo = model;
        visao = view;
        flags = view.getFlags();
    }

    public void StartView()
    {
        visao.Start();
    }

    public void UpdateView()
    {
        visao.clearError();
        visao.Render();

        String in = visao.getTextInput();
        int op = visao.getOP();
        

        VisualizarComanda(in);

        if (visao.isFlag(op))
        {
            visao.setFlag(op, true);
        }
        else
        {
            visao.ErrorMessage("Opcao invalida!", false);
        }

    }

    public void UpdateModel()
    {
        /*
            Logica de atualizacao da model a partir do input da view
        */
        switch (visao.getActor())
        {
            case View.CLIENTE: // Usar enumerador para View de cliente
                break;
            case View.ATENDENTE: // Usar enumerador para View de atendente
                break;
            case View.GERENTE: // Usar enumerador para View de gerente
                break;
            default:
        }
    }

    public boolean VisualizarComanda(String ID)
    {
        Comanda comanda;
        
        if((comanda = modelo.getComandaAtiva(ID)) != null)
        {
            visao.setComanda(comanda);
            return true;
        }
        return false;
    }

    public boolean ViewIsRunning()
    {
        return visao.isViewRunning();
    }
}