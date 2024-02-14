import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

    public class Menu extends JFrame {

        private Container container;
        private  JMenuBar jmnubarra;
        private JMenu mnuarquivo, mnusaida;
        private JMenuItem mnuisair,mnuiCadastroDespesa,
                mnuiCadastroReceita,mnuiExCadastroDespesa,
                mnuiExCadastroReceita,mnuiPerfil,mnuiCadastroUsuario;

        public Menu() {

            getContentPane().setBackground(new Color (152, 95, 232));
            inicializarComponentes();
            definirEventos();
        }

        private void inicializarComponentes(){

            setTitle("Menu");
            setBounds(0,0,600,500);
            container = getContentPane();
            jmnubarra = new JMenuBar();
            mnuarquivo = new JMenu("Cadastros");
            mnusaida = new JMenu("Saida");
            mnuisair = new JMenuItem("Sair");
            mnuisair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
            mnuiCadastroDespesa = new JMenuItem("Cadastro de despesa");
            mnuiCadastroReceita = new JMenuItem("Cadastro de receita");
            mnuiCadastroUsuario = new JMenuItem("Cadastro de usuário");
            mnuiExCadastroDespesa = new JMenuItem("Extrato de despesas");
            mnuiExCadastroReceita = new JMenuItem("Extrato de receitas");
            mnuiPerfil = new JMenuItem("Perfil");

            mnuarquivo.add(mnuiPerfil);
            mnuarquivo.add(mnuiCadastroUsuario);
            mnuarquivo.add(mnuiCadastroDespesa);
            mnuarquivo.add(mnuiCadastroReceita);
            mnuarquivo.add(mnuiExCadastroDespesa);
            mnuarquivo.add(mnuiExCadastroReceita);
            mnusaida.add(mnuisair);
            jmnubarra.add(mnusaida);
            jmnubarra.add(mnuarquivo);
            setJMenuBar(jmnubarra);
        }

        private void definirEventos() {
            mnuisair.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

                    mnuiCadastroUsuario.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            new FrontUsuario().show();
                        }
                    });


    }
            }




