package src.View;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClerkView {
    private JFrame frame;
    private JLabel comandaLabel;
    private JTextField comandaTextfield;
    private JButton consultarComandaButton;
    private JButton gerarComandaButton;
    private JButton encerrarComandaButton;
    private JButton limparComandaButton;


    public ClerkView(String title)
    {
        comandaLabel = new JLabel("Comanda :");
        comandaTextfield = new JTextField();
        consultarComandaButton = new JButton("Consultar Comanda");
        gerarComandaButton = new JButton("Gerar Comanda");
        encerrarComandaButton = new JButton("Encerrar Comanda");
        limparComandaButton = new JButton("Limpar");
        
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(comandaLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(gerarComandaButton)
                        .addComponent(comandaTextfield)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(consultarComandaButton))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(encerrarComandaButton))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(limparComandaButton)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(gerarComandaButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comandaLabel)
                        .addComponent(limparComandaButton)
                        .addComponent(comandaTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(encerrarComandaButton)
                        .addComponent(consultarComandaButton)));

        layout.linkSize(SwingConstants.HORIZONTAL, encerrarComandaButton, consultarComandaButton);
        layout.linkSize(SwingConstants.VERTICAL, comandaLabel, comandaTextfield, limparComandaButton);

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

    public JTextField getComandaTextfield() {
        return comandaTextfield;
    }

    public void setComandaTextfield(JTextField comandaTextfield) {
        this.comandaTextfield = comandaTextfield;
    }

    public JButton getConsultarComandaButton() {
        return consultarComandaButton;
    }

    public void setConsultarComandaButton(JButton consultarComandaButton) {
        this.consultarComandaButton = consultarComandaButton;
    }

    public JButton getGerarComandaButton() {
        return gerarComandaButton;
    }

    public void setGerarComandaButton(JButton gerarComandaButton) {
        this.gerarComandaButton = gerarComandaButton;
    }

    public JButton getEncerrarComandaButton() {
        return encerrarComandaButton;
    }

    public void setEncerrarComandaButton(JButton encerrarComandaButton) {
        this.encerrarComandaButton = encerrarComandaButton;
    }

    public JButton getLimparComandaButton() {
        return limparComandaButton;
    }

    public void setLimparComandaButton(JButton limparComandaButton) {
        this.limparComandaButton = limparComandaButton;
    }
    
}

