package src.View;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PopupSpawner {

    private JFrame popup;
    private JLabel popupLabel;
    private JTextField popupTextfield;
    private JButton button1; // Ok or Yes
    private JButton button2; // No

    public PopupSpawner()
    {
        popupLabel = new JLabel();
        popupTextfield = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        popupLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void initInputPopup(String title, String message, JFrame parent)
    {
        popup = new JFrame(title);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setLocationRelativeTo(parent);

        popupLabel.setText(message);
        popupTextfield.setText("");
        button1.setText("OK");

        GroupLayout layout = new GroupLayout(popup.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(popupLabel)
                        .addComponent(popupTextfield)
                        .addComponent(button1)));
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(popupLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(popupTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(button1)));

        layout.linkSize(SwingConstants.VERTICAL, popupTextfield, button1);

        popupTextfield.setText("");

        popup.getContentPane().setLayout(layout);
        popup.pack();
        popup.setVisible(true);
    }

    public void initYesNoPopup(String title, String message, JFrame parent)
    {
        popup = new JFrame(title);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setLocationRelativeTo(parent);

        popupLabel.setText(message);
        button1.setText("Sim");
        button2.setText("Nao");

        GroupLayout layout = new GroupLayout(popup.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(popupLabel)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(button1))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(button2)))));
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(popupLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2)));

        layout.linkSize(SwingConstants.HORIZONTAL, button1, button2);

        popupTextfield.setText("");

        popup.getContentPane().setLayout(layout);
        popup.pack();
        popup.setVisible(true);
    }

    public JFrame getPopup()
    {
        return popup;
    }

    public void setPopup(JFrame popup)
    {
        this.popup = popup;
    }

    public JButton getPopupOkButton() 
    {
        return button1;
    }

    public void setPopupOkButton(JButton popupOkButton) 
    {
        this.button1 = popupOkButton;
    }

    public JButton getPopupYesButton() 
    {
        return button1;
    }

    public void setPopupYesButton(JButton popupYesButton) 
    {
        this.button1 = popupYesButton;
    }

    public JButton getPopupNoButton() 
    {
        return button2;
    }

    public void setPopuNokButton(JButton popupNoButton) 
    {
        this.button1 = popupNoButton;
    }

    public JTextField getPopupTextfield() 
    {
        return popupTextfield;
    }

    public void setPopupTextfield(JTextField popupTextfield) 
    {
        this.popupTextfield = popupTextfield;
    }

    public void spawnInfoPopup(String message, JFrame parent)
    {
        JOptionPane.showMessageDialog(parent, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public void spawnWarnPopup(String message, JFrame parent)
    {
        JOptionPane.showMessageDialog(parent, message, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public void spawnErrorPopup(String message, JFrame parent)
    {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void resetPopupButtons()
    {
        for (java.awt.event.ActionListener a : button1.getActionListeners())
        {
            button1.removeActionListener(a);
        }

        for (java.awt.event.ActionListener a : button2.getActionListeners())
        {
            button2.removeActionListener(a);
        }
    }
}
