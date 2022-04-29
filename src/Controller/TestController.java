package src.Controller;


import javax.swing.JOptionPane;

import src.Model.Comanda;
import src.Model.Model;
import src.View.TestView;

// Aglomerado das funcionalidades do controlador
public class TestController {
    /*
        -> Lidar com input do usuario (recebido pela view) utilizando os metodos da Model
        -> Selecionar e organizar a View, assim como repassar as resolucoes da Model para ela

        Se utilizarmos padrao de observador ver slide 24 de VideoAula-08 - Projeto Arquitetural - Padrões Arquiteturais
    */
    private Model modelo;
    private TestView visao;
    

    public TestController(Model model, TestView view)
    {
        modelo = model;
        visao = view;
        initView();
    }

    public void initView() {
        visao.getFirstnameTextfield().setText("Comanda:");
        visao.getLastnameTextfield().setText("nada");
       } 
    public void initController() {
        visao.getFirstnameSaveButton().addActionListener(e -> saveFirstname());
        visao.getLastnameSaveButton().addActionListener(e -> saveFirstname());
        visao.getHello().addActionListener(e -> sayHello());
        visao.getBye().addActionListener(e -> sayBye());
       } 
    private void saveFirstname() {
        Comanda c = modelo.getComandaAtiva(visao.getFirstnameTextfield().getText());
        JOptionPane.showMessageDialog(null, "Comanda : " + c.toString(), "Info", JOptionPane.INFORMATION_MESSAGE);
       } 
    private void sayHello() {
        JOptionPane.showMessageDialog(null, "Hello "  + " ", "Info", JOptionPane.INFORMATION_MESSAGE);
       } 
    private void sayBye() {
        System.exit(0);
       }
}