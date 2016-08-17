package exercicios.arquivos.controledeestoque;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anselmo
 */
public class CadastroFrame extends JFrame implements ActionListener {

  private JLabel nomeProdutoLabel;
  private JTextField nomeProdutoText;
  private JLabel codigoProdutoLabel;
  private JTextField codigoProdutoText;
  private JLabel precoProdutoLabel;
  private JTextField precoProdutoText;
  private JLabel quantidadeLabel;
  private JTextField quantidadeText;
  private JLabel numeroItemLabel;
  private JLabel numeroItem;
  private JPanel painel;
  private JButton avancarButton;
  private JButton recuarButton;
  private JButton deletarButton;
  private JButton cadastrarButton;
  private JPanel painelBotoes;
  ArquivoProdutosAcessoAleatorio arquivo;
  RegistroProdutoArquivoAcessoAleatorio registro;
  int prodPos;

  CadastroFrame(ArquivoProdutosAcessoAleatorio arquivo) {
    super("Cadastro de produtos");
    this.arquivo = arquivo;

    nomeProdutoLabel = new JLabel("Número produto:", SwingConstants.RIGHT);
    nomeProdutoText = new JTextField(15);
    codigoProdutoLabel = new JLabel("Código do produto:", SwingConstants.RIGHT);
    codigoProdutoText = new JTextField();
    precoProdutoLabel = new JLabel("Preço do produto:", SwingConstants.RIGHT);
    precoProdutoText = new JTextField();
    quantidadeLabel = new JLabel("Quantidade:", SwingConstants.RIGHT);
    quantidadeText = new JTextField();
    numeroItemLabel = new JLabel("Numero do item:", SwingConstants.RIGHT);
    numeroItem = new JLabel();
    painel = new JPanel();
    painel.setLayout(new GridLayout(5, 2));
    painel.add(nomeProdutoLabel);
    painel.add(nomeProdutoText);
    painel.add(codigoProdutoLabel);
    painel.add(codigoProdutoText);
    painel.add(precoProdutoLabel);
    painel.add(precoProdutoText);
    painel.add(quantidadeLabel);
    painel.add(quantidadeText);
    painel.add(numeroItemLabel);
    painel.add(numeroItem);

    avancarButton = new JButton(">>");
    avancarButton.addActionListener(this);
    recuarButton = new JButton("<<");
    recuarButton.addActionListener(this);
    deletarButton = new JButton("Deletar");
    deletarButton.addActionListener(this);
    cadastrarButton = new JButton("Cadastrar");
    cadastrarButton.addActionListener(this);
    painelBotoes = new JPanel();
    painelBotoes.setLayout(new GridLayout(4, 1));
    painelBotoes.add(cadastrarButton);
    painelBotoes.add(deletarButton);
    painelBotoes.add(avancarButton);
    painelBotoes.add(recuarButton);

    setLayout(new BorderLayout());
    add(painel, BorderLayout.EAST);
    add(painelBotoes, BorderLayout.WEST);

    this.setLocation(40, 100);

    prodPos = 1;
    registro = new RegistroProdutoArquivoAcessoAleatorio();

    pack();
  }

  public void setArquivo(ArquivoProdutosAcessoAleatorio arquivo) {
    prodPos = 1;
    this.arquivo = arquivo;
    registro.read(arquivo.getFile(), prodPos - 1);
  }

  public void updateData() {
    numeroItem.setText(String.valueOf(prodPos));
    nomeProdutoText.setText(registro.getNome());
    codigoProdutoText.setText(String.valueOf(registro.getCodigo()));
    precoProdutoText.setText(String.valueOf(registro.getPreco()));
    quantidadeText.setText(String.valueOf(registro.getQuantidade()));
  }

  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();

    if (source == cadastrarButton) {

      registro.setNome(nomeProdutoText.getText());
      registro.setCodigo(Integer.parseInt(codigoProdutoText.getText()));
      registro.setPreco(Double.parseDouble(precoProdutoText.getText()));
      registro.setQuantidade(Integer.parseInt(quantidadeText.getText()));
      arquivo.write(registro, prodPos - 1);
    } else if (source == deletarButton) {
      registro.setNome("não cadastrado ");
      registro.setCodigo(0);
      registro.setPreco(0.0);
      registro.setQuantidade(0);
      arquivo.write(registro, prodPos - 1);
      updateData();

    } else if (source == avancarButton) {
      if (prodPos < arquivo.TAMARQUIVO)
        prodPos++;
      arquivo.read(registro, prodPos - 1);
      updateData();
    } else {
      if (prodPos > 1)
        prodPos--;
      arquivo.read(registro, prodPos - 1);
      updateData();
    }
  }
}
