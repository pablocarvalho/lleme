package exercicios.arquivos.controledeestoque;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Programa que simula um controle de produtos em um estoque. E possível abrir
 * um arquivo binário e acessar os registros diretamente na interface clicando
 * no menu cadastrar. A setas permitem navegar pelos registros. Os botões
 * cadastrar e deletar inserem e removem registros diretamente no arquivo. Os
 * registros não são armazenados em memória exceto o que é carregado para
 * exibição.
 *
 * @author Anselmo
 */
public class MainFrame extends JFrame implements ActionListener {

  private JMenuItem novoMenuItem;
  private JMenuItem sairMenuItem;
  private JMenuItem abrirMenuItem;
  private JMenuItem cadastrarMenuItem;
  private JMenu arquivoMenu;
  private JMenuBar menuBar;
  private CadastroFrame cadastroFrame;
  private ArquivoProdutosAcessoAleatorio arquivo = null;

  MainFrame() {
    super("Controle de Estoque");

    novoMenuItem = new JMenuItem("Novo");
    novoMenuItem.addActionListener(this);
    sairMenuItem = new JMenuItem("Sair");
    sairMenuItem.addActionListener(this);
    abrirMenuItem = new JMenuItem("Abrir");
    abrirMenuItem.addActionListener(this);
    cadastrarMenuItem = new JMenuItem("Cadastrar");
    cadastrarMenuItem.addActionListener(this);

    arquivoMenu = new JMenu("Arquivo");

    arquivoMenu.add(novoMenuItem);
    arquivoMenu.add(abrirMenuItem);
    arquivoMenu.add(cadastrarMenuItem);
    arquivoMenu.addSeparator();
    arquivoMenu.add(sairMenuItem);

    menuBar = new JMenuBar();

    menuBar.add(arquivoMenu);
    setJMenuBar(menuBar);

    cadastroFrame = new CadastroFrame(arquivo);


    setSize(512, 512);
    setVisible(true);

  }

  public static void main(String[] args) {
    MainFrame mainFrame = new MainFrame();
  }

  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == sairMenuItem) {
      if (arquivo != null)
        arquivo.close();
      System.exit(0);
    } else if (source == novoMenuItem) {
      if (arquivo != null) {
        arquivo.close();
        arquivo = null;
      }
      FileDialog fd = new FileDialog(this,
              "Especifique o nome do arquivo a ser criado...",
              FileDialog.SAVE);
      fd.show();

      String fileName = fd.getFile();
      if (fileName != null) {
        arquivo = new ArquivoProdutosAcessoAleatorio();
        arquivo.open(fileName, "rw");
        arquivo.criar();
        cadastroFrame.setArquivo(arquivo);
      }
    } else if (source == abrirMenuItem) {
      if (arquivo != null) {
        arquivo.close();
        arquivo = null;
      }
      FileDialog fd = new FileDialog(this,
              "Selecione o nome do arquivo a ser carregado...",
              FileDialog.LOAD);
      fd.show();

      String fileName = fd.getFile();
      if (fileName != null) {
        arquivo = new ArquivoProdutosAcessoAleatorio();
        arquivo.open(fileName, "rw");
        cadastroFrame.setArquivo(arquivo);
      }
    } else if (source == cadastrarMenuItem) {
      cadastroFrame.setVisible(true);
      cadastroFrame.updateData();
    }
  }
}
