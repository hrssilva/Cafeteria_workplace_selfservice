package src.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import src.Model.Comanda;

public class TerminalClientView extends View{
    private boolean viewIsRunning;
    private Map<Integer, Boolean> flags;
    private Comanda comanda;
    private boolean error;
    private boolean critical;
    private String errorMsg;
    private int currentOperation;
    private String inputTxt;

    public TerminalClientView()
    {
        viewIsRunning = false;
        error = false;
        critical = false;
        errorMsg = new String();
        inputTxt = new String();
        comanda = new Comanda("", 0);
        currentOperation = ClientViewEnum.NOP.ordinal();
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
        final int INFORMAR = ClientViewEnum.INFORMAR_COMANDA.ordinal();
        final int NOP = ClientViewEnum.NOP.ordinal();
        inputTxt = new String();

        String output = new String();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

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
            System.out.println(output);

            flags.replace(VISUALIZAR, false);
            currentOperation = NOP;
        }
        else if(flags.get(INFORMAR))
        {
            output = String.format("Informe o numero da comanda:");
            System.out.println(output);

            
            try {
                inputTxt = input.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            flags.replace(INFORMAR, false);
            currentOperation = VISUALIZAR;
            System.out.println(currentOperation);
        }
        else
        {
            output = String.format("Escolha a operacao:\n%d - Visualizar Comanda\n%d - Encerrar Sessao", INFORMAR, ENCERRAR);
            System.out.println(output);

            
            //String in = input.nextLine();
            try {
                currentOperation = Integer.parseInt(input.readLine());
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
        }

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

    public int getOP()
    {
        return currentOperation;
    }

    public String getTextInput()
    {
        return inputTxt;
    }
    
}
