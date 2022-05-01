package src.View;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ManagerView{
    private JFrame startFrame;
    private JLabel comandaLabel;
    private JTextField comandaTextfield;
    private JButton solicitarComanda;
    private JButton loginButton;


    private JFrame frame;
    private JLabel itemLabel;
    private JLabel idLabel;
    private JTextField itemTextfield;
    private JButton consultarComandaButton;
    private JButton adicionarItemButton;
    private JButton logoutButton;
    

    private JFrame inputPopup;
    private JLabel popupLabel;
    private JTextField popupTextfield;
    private JButton popupOkButton;

    public ManagerView(String title) {
        startFrame = new JFrame(title);
        startFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        startFrame.setSize(500, 500);
        startFrame.setLocationRelativeTo(null);
        
        comandaLabel = new JLabel("Comanda :");
        comandaTextfield = new JTextField();
        solicitarComanda = new JButton("Solicitar comanda");
        loginButton = new JButton("Entrar");

        GroupLayout layout = new GroupLayout(startFrame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(comandaLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(comandaTextfield)
                        .addComponent(solicitarComanda))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(loginButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(solicitarComanda))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comandaLabel)
                        .addComponent(comandaTextfield)
                        .addComponent(loginButton)));
        layout.linkSize(SwingConstants.VERTICAL, comandaTextfield, loginButton);

        startFrame.getContentPane().setLayout(layout);
        startFrame.setVisible(true);
    }

    public void mainFrame(String title, String ID)
    {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        
        idLabel = new JLabel(ID);
        itemLabel = new JLabel("Numero Item :");
        itemTextfield = new JTextField();
        consultarComandaButton = new JButton("Consultar comanda");
        adicionarItemButton = new JButton("Adicionar item");
        logoutButton = new JButton("Sair");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(comandaLabel)
                        .addComponent(itemLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(idLabel)
                        .addComponent(itemTextfield)
                        .addComponent(logoutButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(consultarComandaButton)
                        .addComponent(adicionarItemButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comandaLabel)
                        .addComponent(idLabel)
                        .addComponent(consultarComandaButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(itemLabel)
                        .addComponent(itemTextfield)
                        .addComponent(adicionarItemButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(logoutButton)));

        layout.linkSize(SwingConstants.HORIZONTAL, consultarComandaButton, adicionarItemButton);

        frame.getContentPane().setLayout(layout);
        frame.setVisible(true);
    }

    public void popup(String title, String message)
    {
        inputPopup = new JFrame(title);
        inputPopup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inputPopup.setSize(250, 250);
        inputPopup.setLocationRelativeTo(frame);

        popupLabel = new JLabel(message);
        popupTextfield = new JTextField();
        popupOkButton = new JButton("OK");

        GroupLayout layout = new GroupLayout(inputPopup.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(popupLabel)
                        .addComponent(popupTextfield)
                        .addComponent(popupOkButton)));
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(popupLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(popupTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(popupOkButton)));

        layout.linkSize(SwingConstants.VERTICAL, popupTextfield, popupOkButton);

        popupTextfield.setText("");

        inputPopup.getContentPane().setLayout(layout);
        inputPopup.setVisible(true);
    }


    public JFrame getStartFrame() {
        return startFrame;
    }
    public void setStartFrame(JFrame startFrame) {
        this.startFrame = startFrame;
    }
    public JLabel getComandaLabel() {
        return comandaLabel;
    }
    public void setComandaLabel(JLabel comandaLabel) {
        this.comandaLabel = comandaLabel;
    }
    public JTextField getComandaTextfield() {
        return comandaTextfield;
    }
    public void setComandaTextfield(JTextField comandaTextfield) {
        this.comandaTextfield = comandaTextfield;
    }
    public JButton getSolicitarComanda() {
        return solicitarComanda;
    }
    public void setSolicitarComanda(JButton solicitarComanda) {
        this.solicitarComanda = solicitarComanda;
    }
    public JButton getLoginButton() {
        return loginButton;
    }
    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }
    


    public JFrame getFrame() {
        return frame;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public JLabel getIdLabel() {
        return idLabel;
    }
    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }
    public JLabel getItemLabel() {
        return itemLabel;
    }
    public void setItemLabel(JLabel itemLabel) {
        this.itemLabel = itemLabel;
    }
    public JTextField getItemTextfield() {
        return itemTextfield;
    }
    public void setItemTextfield(JTextField itemTextfield) {
        this.itemTextfield = itemTextfield;
    }
    public JButton getConsultarComandaButton() {
        return consultarComandaButton;
    }
    public void setConsultarComandaButton(JButton consultarComandaButton) {
        this.consultarComandaButton = consultarComandaButton;
    }
    public JButton getAdicionarItemButton() {
        return adicionarItemButton;
    }
    public void setAdicionarItemButton(JButton adicionarItemButton) {
        this.adicionarItemButton = adicionarItemButton;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }
    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }



    public JFrame getPopup()
    {
        return inputPopup;
    }
    public void setPopup(JFrame popup)
    {
        this.inputPopup = popup;
    }
    public JButton getPopupOk() {
        return popupOkButton;
    }
    public void setPopupOk(JButton popupOkButton) {
        this.popupOkButton = popupOkButton;
    }
    public JTextField getPopupTextfield() {
        return popupTextfield;
    }
    public void setPopupTextfield(JTextField popupTextfield) {
        this.popupTextfield = popupTextfield;
    }

}
