package src.View;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClientView {
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
    private JButton solicitarEncerramento;


    public ClientView(String title) {
        // StartFrame components
        comandaLabel = new JLabel("Comanda :");
        comandaTextfield = new JTextField();
        solicitarComanda = new JButton("Solicitar Comanda");
        loginButton = new JButton("Entrar");

        // MainFrame components
        idLabel = new JLabel();
        itemLabel = new JLabel("Numero Item :");
        itemTextfield = new JTextField();
        consultarComandaButton = new JButton("Consultar Comanda");
        adicionarItemButton = new JButton("Adicionar Item");
        logoutButton = new JButton("Sair");
        solicitarEncerramento = new JButton("Solicitar Encerramento");



        startFrame = new JFrame(title);
        startFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        startFrame.setSize(500, 500);
        startFrame.setLocationRelativeTo(null);

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
        frame.setLocationRelativeTo(startFrame);

        idLabel.setText(ID);
        itemTextfield.setText("");

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
                        .addComponent(solicitarEncerramento)
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
                        .addComponent(logoutButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(solicitarEncerramento)));

        layout.linkSize(SwingConstants.HORIZONTAL, consultarComandaButton, adicionarItemButton);

        frame.getContentPane().setLayout(layout);
        frame.setVisible(true);
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
    public JButton getSolicitarEncerramento() {
        return solicitarEncerramento;
    }
    public void setSolicitarEncerramento(JButton solicitarEncerramento) {
        this.solicitarEncerramento = solicitarEncerramento;
    }

}   