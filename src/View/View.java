package src.View;

import java.util.Map;

import src.Model.Comanda;

// Classe abstrata para as visoes
public abstract class View {

    public final static int CLIENTE=1, ATENDENTE=2, GERENTE=3;

    public abstract void Start();

    public abstract boolean Render();

    public abstract void WriteToTerminal(String tex);

    public abstract void WriteToScreen(String tex);

    public abstract boolean isViewRunning();

    public abstract void setFlags(Map<Integer, Boolean> map);

    public abstract Map<Integer, Boolean> getFlags();

    public abstract void setFlag(Integer key, Boolean value);

    public abstract Boolean getFlag(Integer key);

    public abstract Boolean isFlag(Integer key);

    public abstract void setComanda(Comanda comanda);

    public abstract void ErrorMessage(String msg, boolean isCritical);

    public abstract void clearError();

    public abstract int getActor();

    public abstract int getOP();

    public abstract String getTextInput();
}
