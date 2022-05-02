package src.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import src.Model.Item;
import src.Model.Model;
import src.View.ManagerView;
import src.View.PopupSpawner;

public class ManagerController extends ClerkController{

        private ManagerView visao;

    public ManagerController(Model model, ManagerView managerView) {
        super(model, managerView);
        this.modelo = model;
        this.visao = managerView;
        
        popup = new PopupSpawner();
    }

    @Override
    public void initController()
    {
        visao.getGerarComandaButton().addActionListener(e -> gerarComanda());
        visao.getConsultarComandaButton().addActionListener(e -> consultarComanda());
        visao.getEncerrarComandaButton().addActionListener(e -> encerrarComanda());
        visao.getLimparComandaButton().addActionListener(e -> limparComanda());
        visao.getGerenciarEstoqueButton().addActionListener(e -> gerenciarEstoque());
        visao.getVisualizarRelatorioButton().addActionListener(e -> visualizarRelatorio());
        visao.getSalvarRelatorioButton().addActionListener(e -> salvarRelatorio());
        visao.getCarregarEstoqueButton().addActionListener(e -> carregarEstoqueDeArquivo());
        visao.getSalvarEstoqueButton().addActionListener(e -> salvarEstoque());

        
        visao.getAtualizarItemButton().addActionListener(e -> atualizarItem());
        visao.getGerenciarEstoqueOkButton().addActionListener(e -> salvar());
        visao.getGerenciarEstoqueCancelarButton().addActionListener(e -> cancelar());
    }

    private void visualizarRelatorio() {
        visao.relatorioFrame("Relatorios");
        String today = new SimpleDateFormat("yyyyMMdd'.txt'").format(new Date());
        String relatorioDia = new String();
        String relatorioMes = new String();
        BufferedReader input;
        for (final File fileEntry : new File("./Data/Relatorios").listFiles()) {
            String filename = fileEntry.getName();
            try {
                input = new BufferedReader(new FileReader(fileEntry));
                String currentLine;
                relatorioMes = relatorioMes + filename.replace(".txt", "\n\n") ;
        
                try {
                    while((currentLine = input.readLine()) != null)
                    {
                        relatorioMes = relatorioMes + currentLine + "\n";
                        if(filename.compareTo(today) == 0)
                        {
                            relatorioDia = relatorioDia + currentLine + "\n";
                        }
                    }
                    relatorioMes = relatorioMes + "\n";
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        
                try {
                    input.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                visao.getRelatorioDiarioTextArea().setText(relatorioDia);
                visao.getRelatorioMensalTextArea().setText(relatorioMes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void salvarRelatorio() {
        String filename = new SimpleDateFormat("yyyyMMdd'.txt'").format(new Date());
        modelo.LogComandas("./Data/Relatorios/"+ filename);
    }

    private void carregarEstoqueDeArquivo() {
        if(!modelo.getStockFromFile("./Data/Estoque/estoque.txt"))
        {
            popup.spawnErrorPopup("Arquivo nao encontrado.", visao.getFrame());
        }
    }

    private void salvarEstoque() {
        modelo.WriteStockToFile("./Data/Estoque/estoque.txt");
    }

    private void cancelar() {
        visao.getItemIdTextfield().setText("");
        visao.getItemNomeTextfield().setText("");
        visao.getItemValorTextfield().setText("");
        visao.getItemQtdTextfield().setText("");
        visao.getItemAlcoolicoTextfield().setText("");
    }

    private void salvar() {
        try
        {
            int ID = Integer.parseInt(visao.getItemIdTextfield().getText());
            String nome = visao.getItemNomeTextfield().getText();
            float valor = Float.parseFloat(visao.getItemValorTextfield().getText());
            int qtd = Integer.parseInt(visao.getItemQtdTextfield().getText());
            boolean alcoolico = Boolean.parseBoolean(visao.getItemAlcoolicoTextfield().getText());

            Item i = modelo.getStockItem(ID);
            
            if(i != null)
            {
                i.setNome(nome);
                i.setValor(valor);
                i.setQuantidade(qtd);
                i.setAlcoolico(alcoolico);
            }
            else
            {
                i = new Item(ID, nome, valor, qtd, alcoolico);
                modelo.addStockItem(i);
            }
            carregarEstoque();
            cancelar();
        }
        catch(NumberFormatException e)
        {
            popup.spawnErrorPopup("Item nao encontrado.", visao.getEstoqueFrame());
        }
    }

    private void atualizarItem() {
        try 
        {
            int ID = Integer.parseInt(visao.getItemIdTextfield().getText());
            Item item = modelo.getStockItem(ID);
            if(item != null)
            {
                visao.getItemNomeTextfield().setText(item.getNome());
                visao.getItemValorTextfield().setText("" + item.getValor());
                visao.getItemQtdTextfield().setText("" + item.getQuantidade());
                visao.getItemAlcoolicoTextfield().setText("" + item.isAlcoolico());
            }
            else
            {
                popup.spawnErrorPopup("Item nao encontrado.", visao.getEstoqueFrame());
            }
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
            popup.spawnErrorPopup("Informe um valor valido para o item.", visao.getEstoqueFrame());
        }
    }

    private void gerenciarEstoque() {

        carregarEstoque();
        visao.estoqueFrame("Gerenciar Estoque");

    }

    private void carregarEstoque()
    {
        String s = new String();
        for(Item item : modelo.getListaItens())
        {
            s = s + item.toString() + "\n";
        }

        visao.getEstoqueTextArea().setText(s);
    }

}
