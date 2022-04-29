package src.View;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClientView {
    private JFrame frame;
    private JLabel comandaLabel;
    private JLabel itemLabel;
    private JTextField comandaTextfield;
    private JTextField itemTextfield;
    private JButton consultarComandaButton;
    private JButton adicionarItemButton;
    private JButton hello;
    private JButton bye;

    public ClientView(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        
        comandaLabel = new JLabel("Comanda :");
        itemLabel = new JLabel("Numero Item :");
        comandaTextfield = new JTextField();
        itemTextfield = new JTextField();
        consultarComandaButton = new JButton("Consultar comanda");
        adicionarItemButton = new JButton("Adicionar item");
        hello = new JButton("Hello!");
        bye = new JButton("Bye!"); // Add UI element to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(comandaLabel)
                        .addComponent(itemLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(comandaTextfield)
                        .addComponent(itemTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(consultarComandaButton)
                        .addComponent(adicionarItemButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comandaLabel)
                        .addComponent(comandaTextfield)
                        .addComponent(consultarComandaButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(itemLabel)
                        .addComponent(itemTextfield)
                        .addComponent(adicionarItemButton)));
        layout.linkSize(SwingConstants.HORIZONTAL, consultarComandaButton, adicionarItemButton);
        frame.getContentPane().setLayout(layout);

        frame.setVisible(true); 
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getComandaLabel() {
        return comandaLabel;
    }

    public void setComandaLabel(JLabel comandaLabel) {
        this.comandaLabel = comandaLabel;
    }

    public JLabel getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(JLabel itemLabel) {
        this.itemLabel = itemLabel;
    }

    public JTextField getComandaTextfield() {
        return comandaTextfield;
    }

    public void setComandaTextfield(JTextField comandaTextfield) {
        this.comandaTextfield = comandaTextfield;
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

    public JButton getHello() {
        return hello;
    }

    public void setHello(JButton hello) {
        this.hello = hello;
    }

    public JButton getBye() {
        return bye;
    }

    public void setBye(JButton bye) {
        this.bye = bye;
    }
}
