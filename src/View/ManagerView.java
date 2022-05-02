package src.View;


import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class ManagerView extends ClerkView{
    

    private JFrame relatorioFrame;
    private JFrame estoqueFrame;
    private JLabel itemIdLabel;
    private JLabel itemNomeLabel;
    private JLabel itemValorLabel;
    private JLabel itemQtdLabel;
    private JLabel itemAlcoolicoLabel;
    private JLabel relatorioDiarioLabel;
    private JLabel relatorioMensalLabel;
    private JTextField itemIdTextfield;
    private JTextField itemNomeTextfield;
    private JTextField itemValorTextfield;
    private JTextField itemQtdTextfield;
    private JTextField itemAlcoolicoTextfield;
    private JTextArea estoqueTextArea;
    private JTextArea relatorioDiarioTextArea;
    private JTextArea relatorioMensalTextArea;
    private JScrollPane estoqueScroll;
    private JScrollPane relatorioDiarioScroll;
    private JScrollPane relatorioMensalScroll;
    private JButton gerenciarEstoqueButton;
    private JButton atualizarItemButton;
    private JButton gerenciarEstoqueOkButton;
    private JButton gerenciarEstoqueCancelarButton;
    private JButton salvarEstoqueButton;
    private JButton carregarEstoqueButton;
    private JButton visualizarRelatorioButton;
    private JButton salvarRelatorioButton;


    public ManagerView(String title) {
        super();
        /*
        comandaLabel = new JLabel("Comanda :");
        comandaTextfield = new JTextField();
        consultarComandaButton = new JButton("Consultar Comanda");
        gerarComandaButton = new JButton("Gerar Comanda");
        encerrarComandaButton = new JButton("Encerrar Comanda");
        limparComandaButton = new JButton("Limpar");
        */
        gerenciarEstoqueButton = new JButton("Gerenciar Estoque");
        salvarEstoqueButton = new JButton("Salvar Estoque");
        carregarEstoqueButton = new JButton("Carregar Estoque");
        visualizarRelatorioButton = new JButton("Vizualizar Relatorio");
        salvarRelatorioButton = new JButton("Salvar Relatorio");
        

        itemIdLabel = new JLabel("Numero do item: ");
        itemNomeLabel = new JLabel("Nome: ");
        itemValorLabel = new JLabel("Valor: ");
        itemQtdLabel = new JLabel("Quantidade: ");
        itemAlcoolicoLabel = new JLabel("Alcoolico: ");
        itemIdTextfield = new JTextField();
        itemNomeTextfield = new JTextField() ;
        itemValorTextfield = new JTextField();
        itemQtdTextfield = new JTextField();
        itemAlcoolicoTextfield = new JTextField();
        atualizarItemButton = new JButton("Atualizar Item");
        gerenciarEstoqueOkButton = new JButton("Salvar");
        gerenciarEstoqueCancelarButton = new JButton("Cancelar");

        estoqueTextArea = new JTextArea();
        estoqueTextArea.setEditable(false);
        estoqueScroll = new JScrollPane(estoqueTextArea);
        estoqueScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        relatorioDiarioLabel = new JLabel("Relatorio Diario:");
        relatorioMensalLabel = new JLabel("Relatorio Mensal:");

        relatorioDiarioTextArea = new JTextArea();
        relatorioDiarioTextArea.setEditable(false);
        relatorioMensalTextArea = new JTextArea();
        relatorioMensalTextArea.setEditable(false);
        relatorioDiarioScroll = new JScrollPane(relatorioDiarioTextArea);
        relatorioDiarioScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        relatorioMensalScroll = new JScrollPane(relatorioMensalTextArea);
        relatorioMensalScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 800);
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
                        .addComponent(gerenciarEstoqueButton)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(consultarComandaButton))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(encerrarComandaButton)))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(visualizarRelatorioButton))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(salvarRelatorioButton)))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(carregarEstoqueButton))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(salvarEstoqueButton))))
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
                        .addComponent(consultarComandaButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(salvarRelatorioButton)
                        .addComponent(visualizarRelatorioButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(carregarEstoqueButton)
                        .addComponent(salvarEstoqueButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(gerenciarEstoqueButton)));

        layout.linkSize(SwingConstants.HORIZONTAL, encerrarComandaButton, consultarComandaButton, 
                                                   salvarRelatorioButton, visualizarRelatorioButton, 
                                                   carregarEstoqueButton, salvarEstoqueButton);
        layout.linkSize(SwingConstants.VERTICAL, comandaLabel, comandaTextfield, limparComandaButton);

        frame.getContentPane().setLayout(layout);
        
        frame.setVisible(true);
    }

    public void estoqueFrame(String title)
    {
        estoqueFrame = new JFrame(title);
        estoqueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        estoqueFrame.setSize(800, 800);
        estoqueFrame.setLocationRelativeTo(frame);

        GroupLayout layout = new GroupLayout(estoqueFrame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(itemIdLabel)
                        .addComponent(itemNomeLabel)
                        .addComponent(itemValorLabel)
                        .addComponent(itemQtdLabel)
                        .addComponent(itemAlcoolicoLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(itemIdTextfield)
                        .addComponent(itemNomeTextfield)
                        .addComponent(itemValorTextfield)
                        .addComponent(itemQtdTextfield)
                        .addComponent(itemAlcoolicoTextfield)
                        .addComponent(estoqueScroll)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(gerenciarEstoqueOkButton))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(gerenciarEstoqueCancelarButton))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(atualizarItemButton)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(estoqueScroll))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(itemIdLabel)
                        .addComponent(itemIdTextfield)
                        .addComponent(atualizarItemButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(itemNomeLabel)
                        .addComponent(itemNomeTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(itemValorLabel)
                        .addComponent(itemValorTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(itemQtdLabel)
                        .addComponent(itemQtdTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(itemAlcoolicoLabel)
                        .addComponent(itemAlcoolicoTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(gerenciarEstoqueOkButton)
                        .addComponent(gerenciarEstoqueCancelarButton)));


        layout.linkSize(SwingConstants.HORIZONTAL, gerenciarEstoqueOkButton, gerenciarEstoqueCancelarButton);

        estoqueFrame.getContentPane().setLayout(layout);
        
        estoqueFrame.setVisible(true);
    }

    public void relatorioFrame(String title)
    {
        relatorioFrame = new JFrame(title);
        relatorioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        relatorioFrame.setSize(800, 800);
        relatorioFrame.setLocationRelativeTo(frame);

        GroupLayout layout = new GroupLayout(relatorioFrame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(relatorioDiarioLabel)
                        .addComponent(relatorioDiarioScroll))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(relatorioMensalLabel)
                        .addComponent(relatorioMensalScroll)));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(relatorioDiarioLabel)
                        .addComponent(relatorioMensalLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(relatorioDiarioScroll)
                        .addComponent(relatorioMensalScroll)));

        

        relatorioFrame.getContentPane().setLayout(layout);
        
        relatorioFrame.setVisible(true);
    }

    public JFrame getEstoqueFrame() {
        return estoqueFrame;
    }

    public void setEstoqueFrame(JFrame estoqueFrame) {
        this.estoqueFrame = estoqueFrame;
    }

    public JLabel getItemIdLabel() {
        return itemIdLabel;
    }

    public void setItemIdLabel(JLabel itemIdLabel) {
        this.itemIdLabel = itemIdLabel;
    }

    public JLabel getItemNomeLabel() {
        return itemNomeLabel;
    }

    public void setItemNomeLabel(JLabel itemNomeLabel) {
        this.itemNomeLabel = itemNomeLabel;
    }

    public JLabel getItemValorLabel() {
        return itemValorLabel;
    }

    public void setItemValorLabel(JLabel itemValorLabel) {
        this.itemValorLabel = itemValorLabel;
    }

    public JLabel getItemQtdLabel() {
        return itemQtdLabel;
    }

    public void setItemQtdLabel(JLabel itemQtdLabel) {
        this.itemQtdLabel = itemQtdLabel;
    }

    public JLabel getItemAlcoolicoLabel() {
        return itemAlcoolicoLabel;
    }

    public void setItemAlcoolicoLabel(JLabel itemAlcoolicoLabel) {
        this.itemAlcoolicoLabel = itemAlcoolicoLabel;
    }

    public JTextField getItemIdTextfield() {
        return itemIdTextfield;
    }

    public void setItemIdTextfield(JTextField itemIdTextfield) {
        this.itemIdTextfield = itemIdTextfield;
    }

    public JTextField getItemNomeTextfield() {
        return itemNomeTextfield;
    }

    public void setItemNomeTextfield(JTextField itemNomeTextfield) {
        this.itemNomeTextfield = itemNomeTextfield;
    }

    public JTextField getItemValorTextfield() {
        return itemValorTextfield;
    }

    public void setItemValorTextfield(JTextField itemValorTextfield) {
        this.itemValorTextfield = itemValorTextfield;
    }

    public JTextField getItemQtdTextfield() {
        return itemQtdTextfield;
    }

    public void setItemQtdTextfield(JTextField itemQtdTextfield) {
        this.itemQtdTextfield = itemQtdTextfield;
    }

    public JTextField getItemAlcoolicoTextfield() {
        return itemAlcoolicoTextfield;
    }

    public void setItemAlcoolicoTextfield(JTextField itemAlcoolicoTextfield) {
        this.itemAlcoolicoTextfield = itemAlcoolicoTextfield;
    }

    public JTextArea getEstoqueTextArea() {
        return estoqueTextArea;
    }

    public void setEstoqueTextArea(JTextArea estoqueTextArea) {
        this.estoqueTextArea = estoqueTextArea;
    }

    public JScrollPane getScroll() {
        return estoqueScroll;
    }

    public void setScroll(JScrollPane estoqueScroll) {
        this.estoqueScroll = estoqueScroll;
    }

    public JButton getGerenciarEstoqueButton() {
        return gerenciarEstoqueButton;
    }

    public void setGerenciarEstoqueButton(JButton gerenciarEstoqueButton) {
        this.gerenciarEstoqueButton = gerenciarEstoqueButton;
    }

    public JButton getAtualizarItemButton() {
        return atualizarItemButton;
    }

    public void setAtualizarItemButton(JButton atualizarItemButton) {
        this.atualizarItemButton = atualizarItemButton;
    }

    public JButton getGerenciarEstoqueOkButton() {
        return gerenciarEstoqueOkButton;
    }

    public void setGerenciarEstoqueOkButton(JButton gerenciarEstoqueOkButton) {
        this.gerenciarEstoqueOkButton = gerenciarEstoqueOkButton;
    }

    public JButton getGerenciarEstoqueCancelarButton() {
        return gerenciarEstoqueCancelarButton;
    }

    public void setGerenciarEstoqueCancelarButton(JButton gerenciarEstoqueCancelarButton) {
        this.gerenciarEstoqueCancelarButton = gerenciarEstoqueCancelarButton;
    }

    public JButton getSalvarEstoqueButton() {
        return salvarEstoqueButton;
    }

    public void setSalvarEstoqueButton(JButton salvarEstoqueButton) {
        this.salvarEstoqueButton = salvarEstoqueButton;
    }

    public JButton getCarregarEstoqueButton() {
        return carregarEstoqueButton;
    }

    public void setCarregarEstoqueButton(JButton carregarEstoqueButton) {
        this.carregarEstoqueButton = carregarEstoqueButton;
    }

    public JButton getVisualizarRelatorioButton() {
        return visualizarRelatorioButton;
    }

    public void setVisualizarRelatorioButton(JButton visualizarRelatorioButton) {
        this.visualizarRelatorioButton = visualizarRelatorioButton;
    }

    public JButton getSalvarRelatorioButton() {
        return salvarRelatorioButton;
    }

    public void setSalvarRelatorioButton(JButton salvarRelatorioButton) {
        this.salvarRelatorioButton = salvarRelatorioButton;
    }

    public JFrame getRelatorioFrame() {
        return relatorioFrame;
    }

    public void setRelatorioFrame(JFrame relatorioFrame) {
        this.relatorioFrame = relatorioFrame;
    }

    public JLabel getRelatorioDiarioLabel() {
        return relatorioDiarioLabel;
    }

    public void setRelatorioDiarioLabel(JLabel relatorioDiarioLabel) {
        this.relatorioDiarioLabel = relatorioDiarioLabel;
    }

    public JLabel getRelatorioMensalLabel() {
        return relatorioMensalLabel;
    }

    public void setRelatorioMensalLabel(JLabel relatorioMensalLabel) {
        this.relatorioMensalLabel = relatorioMensalLabel;
    }

    public JTextArea getRelatorioDiarioTextArea() {
        return relatorioDiarioTextArea;
    }

    public void setRelatorioDiarioTextArea(JTextArea relatorioDiarioTextArea) {
        this.relatorioDiarioTextArea = relatorioDiarioTextArea;
    }

    public JTextArea getRelatorioMensalTextArea() {
        return relatorioMensalTextArea;
    }

    public void setRelatorioMensalTextArea(JTextArea relatorioMensalTextArea) {
        this.relatorioMensalTextArea = relatorioMensalTextArea;
    }

    
    
}
