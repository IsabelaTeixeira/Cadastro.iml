import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FrontUsuario extends JFrame {
    private JButton B1, B2, B3,B4,B5,B6;
    private JTextField Tx1, Tx2, Tx3,Tx4;
    private JLabel L1, L2,L3,L4,L5;
    Usuario usuario = new Usuario();
    conexao conn = new conexao();
    usuarioDao usuarioBD;

    public FrontUsuario()
    {
        getContentPane().setBackground(new Color (152, 95, 232));
        inicializarComponentes();
        definirEventos();
    }
    private void inicializarComponentes()
    {
        setLocation(100, 50);
        setTitle("Cadastro usuário");
        setSize(600, 500);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        B1 =new JButton("Incluir");
        B1.setSize(80, 40);
        B1.setLocation(30,420);
        B1.setMnemonic(KeyEvent.VK_I);

        B2 =new JButton("Alterar");
        B2.setSize(80, 40);
        B2.setLocation(140,420);
        B2.setMnemonic(KeyEvent.VK_A);

        B3 =new JButton("Consultar");
        B3.setSize(90,40);
        B3.setLocation(250,420);
        B3.setMnemonic(KeyEvent.VK_C);

        B4 = new JButton("Excluir");
        B4.setSize(80, 40);
        B4.setLocation(370, 420);
        B4.setMnemonic(KeyEvent.VK_E);

        B5 = new JButton("Sair");
        B5.setSize(80, 40);
        B5.setLocation(480, 420);
        B5.setMnemonic(KeyEvent.VK_S);

        B6 = new JButton("TODOS");
        B6.setSize(90, 50);
        B6.setLocation(380, 120);
        B6.setMnemonic(KeyEvent.VK_T);

        getContentPane().add(B1);
        getContentPane().add(B2);
        getContentPane().add(B3);
        getContentPane().add(B4);
        getContentPane().add(B5);
        getContentPane().add(B6);

        Tx1 = new JTextField();
        this.Tx1 = Tx1;
        Tx1.setBounds(190, 130, 150, 30);

        Tx2 = new JTextField();
        this.Tx2 = Tx2;
        Tx2.setBounds(190, 180, 150, 30);

        Tx3 = new JTextField();
        this.Tx3 = Tx3;
        Tx3.setBounds(190, 230, 150, 30);

        Tx4 = new JTextField();
        this.Tx4 = Tx4;
        Tx4.setBounds(190, 280, 150, 30);

        getContentPane().add(Tx1);
        getContentPane().add(Tx2);
        getContentPane().add(Tx3);
        getContentPane().add(Tx4);

        L1 =new JLabel("Cadastro de Usuario", JLabel.CENTER);
        L1.setFont(new Font("Gabriola",Font.BOLD,14));
        L1.setBounds(130,60,300,40);

        L2 =new JLabel("Codigo:",JLabel.RIGHT);
        L2.setFont(new Font("Gabriola",Font.BOLD,15));
        L2.setBounds(70,130,100,30);

        L3 =new JLabel("Nome:",JLabel.RIGHT);
        L3.setFont(new Font("Gabriola",Font.BOLD,15));
        L3.setBounds(70,180,100,30);

        L4 =new JLabel("Senha:",JLabel.RIGHT);
        L4.setFont(new Font("Gabriola",Font.BOLD,15));
        L4.setBounds(70,230,100,30);

        L5 =new JLabel("Telefone:",JLabel.RIGHT);
        L5.setFont(new Font("Gabriola",Font.BOLD,15));
        L5.setBounds(70,280,100,30);

        getContentPane().setLayout(null);
        getContentPane().add(L1);
        getContentPane().add(L2);
        getContentPane().add(L3);
        getContentPane().add(L4);
        getContentPane().add(L5);

    }
    private void definirEventos() {

        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usuario.setCodigo(Integer.parseInt(Tx1.getText()));
                usuario.setNome(Tx2.getText());
                usuario.setSenha(Tx3.getText());
                usuario.setTelefone(Integer.parseInt(Tx4.getText()));

                usuarioBD = new usuarioDao();
                usuarioBD.insert(usuario);

                // limpar campos
                Tx1.setText("");
                Tx2.setText("");
                Tx3.setText("");
                Tx4.setText("");
            }
        });
        //Incluir usuario
        // Altera o usuario
        B2.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     if ((usuario.getNome() == "") || (usuario.getCodigo() == 0)) {
                                         JOptionPane.showMessageDialog(null, "Primeiro consulte o Usuário");
                                     } else {
                                         usuarioBD = new usuarioDao();
                                         usuario.setNome(Tx2.getText());
                                         usuario.setSenha(Tx3.getText());
                                         usuario.setTelefone(Integer.parseInt(Tx4.getText()));
                                         usuarioBD.update(usuario);


                                         // limpar campos
                                         Tx1.setText("");
                                         Tx2.setText("");
                                         Tx3.setText("");
                                         Tx4.setText("");
                                     }
                                 }
                             }
        );
        //Consulta usuario
        B3.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     if (Tx1.getText() == "") {
                                         JOptionPane.showMessageDialog(null, "Digitar o código do Usuario para consultar");
                                     } else {
                                         usuarioBD = new usuarioDao();
                                         usuario.setCodigo(Integer.parseInt(Tx1.getText()));
                                         usuarioBD.consulta(usuario);
                                         Tx2.setText(usuario.getNome());
                                         Tx3.setText(usuario.getSenha());
                                         Tx4.setText(""+usuario.getTelefone());

                                     }
                                 }
                             }
        );
        // Exclui o usuario
        B4.addActionListener(new ActionListener() {
                                 public void actionPerformed(ActionEvent e) {
                                     if ((Tx2.getText() == "") || (usuario.getCodigo() == 0)) {
                                         JOptionPane.showMessageDialog(null, "Primeiro consulte o Usuário");
                                     } else {
                                         usuarioBD = new usuarioDao();
                                         usuario.setCodigo(Integer.parseInt(Tx1.getText()));
                                         usuarioBD.delete(Integer.parseInt(Tx1.getText()));
                                         usuario.setTelefone(Integer.parseInt(Tx4.getText()));

                                         Tx1.setText("");
                                         Tx2.setText("");
                                         Tx3.setText("");
                                         Tx4.setText("");
                                     }
                                 }
                             }
        );

        B5.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        B6.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e){
                usuarioBD = new usuarioDao();
                ArrayList dados = usuarioBD.listaUsuario();
                Lista Fx = new Lista(dados);
                Fx. show();
            }

         });

    }

    // Lista todos os usuário

    public static void main(String arg[])
    {
        new FrontUsuario().show();
    }

}
