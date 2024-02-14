import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Lista extends JFrame {

    JLabel L2;
    DefaultListModel lista;
    JList itens;
    JPanel P1;
    private Font fontee = new Font("Ebrima", Font.BOLD, 15);

    public Lista(ArrayList<Usuario> dados) {
        // Altera o titulo da pagina
        setTitle("Lista");
        L2 = new JLabel("Usuários Cadastrados");
        setDefaultCloseOperation(Lista.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color (152, 95, 232));

        setVisible(true);
        setResizable(false);
        setSize(300, 500);

        L2.setSize(300, 20);
        L2.setLocation(60, 20);
        L2.setFont(fontee);
        L2.setForeground(Color.black);
        // Acrescenta o objeto lista de seleção
        lista = new DefaultListModel();

        for (int i = 0; i < dados.size(); i++) {
            int codigo = dados.get(i).getCodigo();
            String nome = dados.get(i).getNome();
            lista.addElement(codigo + "-" + nome);
        }
        itens = new JList(lista);
        itens.setSize(100, 300);
        itens.setLocation(5, 10);
        itens.setBackground(new Color(152, 95, 232));

        P1 = new JPanel();
        P1.setBounds(70, 50, 150, 330);
        P1.setBackground(new Color(152, 95, 232));
        P1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        P1.setLayout(null);
        P1.add(itens);


        getContentPane().setLayout(null);
        getContentPane().add(L2);
        getContentPane().add(P1);

    }
}