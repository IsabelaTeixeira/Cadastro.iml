import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JTextField txtlogin;
    private JPasswordField Jsenha;
    private JLabel lbllogin,lblsenha,lblloginn;
    private JButton btnentrar,btncadastrar;
    private JButton btncancelar;
    private static Login janela;

    private Font fonte = new Font("Ebrima", Font.BOLD, 15);
    private Font fontee = new Font("Ebrima", Font.BOLD, 13);

    public Login()
    {
        getContentPane().setBackground(new Color (152, 95, 232));
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes(){

        UIManager.put("Label.font", fonte);
        setTitle("Controle de Gastos");
        setBounds(0,0,460,250);
        setLayout(null);
        txtlogin = new JTextField(10);
        Jsenha = new JPasswordField(8);
        lblloginn = new JLabel ("Login:");
        lbllogin = new JLabel("Usuário:");
        lblsenha = new JLabel("Senha ");
        btnentrar = new JButton("Logar");
        btncancelar = new JButton("Cancelar");
        btncadastrar = new JButton("Cadastrar");

        //posições e tamanhos dos componentes.
        lblloginn.setBounds (210,10,80,25);
        txtlogin.setBounds(250,50,80,25);
        lbllogin.setBounds(150,50,80,25);
        Jsenha.setBounds(250,95,80,25);
        lblsenha.setBounds(150,95,80,25);
        btnentrar.setBounds(240,140,100,25);
        btnentrar.setFont(fontee);

        btncadastrar.setBounds(140,140,100,25);
        btncadastrar.setFont(fontee);

        add(lblloginn);
        add(lbllogin);
        add(txtlogin);
        add(lblsenha);
        add(Jsenha);
        add(btnentrar);
        add(btncadastrar);

    }

    private void definirEventos(){

        btnentrar.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt ){

                String nome = txtlogin.getText();
                //pega a senha do usuário
                String senha = new String(Jsenha.getPassword());

                try{
                    //verifica se o usuário é válido
                    Usuario usuario = new Usuario(nome,senha);
                    DAO dao = new DAO();

                    if(dao.existe(usuario)){
                        JOptionPane.showMessageDialog(null,"Bem vindo, " + usuario.getNome() + "!");
                        new Menu().show();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Usuário inválido.");
                    }
                }catch(Exception e){
                    // Não é necessário essa parte
                    JOptionPane.showMessageDialog(null,"Problemas técnicos");
                }
            }
        });

        btncadastrar.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                new FrontUsuario().show();
            }
        });


    }

    public static void main (String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                janela = new Login();
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                janela.setLocation((tela.width - janela.getSize().width)/2 ,
                        (tela.height - janela.getSize().height) / 2);
                janela.setVisible(true);
            }
        });
    }
}

