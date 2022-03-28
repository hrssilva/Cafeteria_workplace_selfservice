package src.View;

import java.util.HashMap;
import java.util.Map;

import src.Model.Comanda;

public class TerminalClientView extends View{
    private boolean viewIsRunning;
    private Map<Integer, Boolean> flags;
    private Comanda comanda;
    private boolean error;
    private boolean critical;
    private String errorMsg;

    public TerminalClientView()
    {
        viewIsRunning = false;
        error = false;
        critical = false;
        errorMsg = new String();
        comanda = new Comanda("", 0);
        flags = new HashMap<Integer, Boolean>();
        for (ClientViewEnum e : ClientViewEnum.values())
        {
            flags.put(e.ordinal(), false);
        }
    }

    public  void Start()
    {
        viewIsRunning = true;
    }


    public boolean Render()
    {
        final int ENCERRAR = ClientViewEnum.ENCERRAR_SESSAO.ordinal();
        final int VISUALIZAR = ClientViewEnum.VISUZLIZAR_COMANDA.ordinal();

        String output = new String();

        if(error)
        {
            output = errorMsg;
            if(critical)
            {
                viewIsRunning = false;
            }
        }
        else if(flags.get(ENCERRAR))
        {
            viewIsRunning = false;
            flags.replace(ENCERRAR, false);
            return false;
        }
        else if(flags.get(VISUALIZAR))
        {
            output = String.format("Comanda: %s", comanda.toString());
            flags.replace(VISUALIZAR, false);
        }
        else
        {
            output = String.format("Escolha a operacao:\n%d - Visualizar Comanda\n%d - Encerrar Sessao", 
                                    ClientViewEnum.VISUZLIZAR_COMANDA.ordinal(), ClientViewEnum.ENCERRAR_SESSAO.ordinal());
        }
        
        System.out.println(output);

        return true;
    }

    public void WriteToTerminal(String text)
    {
        System.out.println(text);
    }

    public void WriteToScreen(String text)
    {
        WriteToTerminal(text);
    }

    public boolean isViewRunning()
    {
        return viewIsRunning;
    }

    public  void setFlags(Map<Integer, Boolean> map)
    {
        flags = map;
    }

    public Map<Integer, Boolean> getFlags()
    {
        return flags;
    }

    public void setFlag(Integer key, Boolean value)
    {
        flags.replace(key, value);
    }

    public Boolean getFlag(Integer key)
    {
        return flags.get(key);
    }

    public Boolean isFlag(Integer key)
    {
        return flags.containsKey(key);
    }

    public void setComanda(Comanda comanda)
    {
        this.comanda = comanda;
    }

    public void ErrorMessage(String msg, boolean isCritical)
    {
        error = true;
        critical = isCritical;
        errorMsg = msg;
    }

    public void clearError()
    {
        error = false;
        critical = false;
    }

    public int getActor()
    {
        return CLIENTE;
    }
    
}
