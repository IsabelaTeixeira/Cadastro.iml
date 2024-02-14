import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class usuarioDao {
    public void insert(Usuario usuario) {
        String sql =   "INSERT INTO tb_usuario (id,nome,senha,telefone) VALUES ("
                + usuario.getCodigo() + ",'"
                + usuario.getNome() + "','"
                + usuario.getSenha() + "',"
                + usuario.getTelefone() + ")";

        System.out.println(sql);
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
            ps.close();
            c.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erros na Transação");
            e.printStackTrace();
        }
    }
    //Alterar um usuario
    public void update(Usuario usuario) {
        String sql =   "UPDATE  tb_usuario SET nome=\"" + usuario.getNome()+ "\",senha=\""
                + usuario.getSenha()+ "\",telefone=\"" + usuario.getTelefone() +  "\" WHERE id=" + usuario.getCodigo();
        System.out.println(sql);
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso");
            ps.close();
            c.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erros na alteração");
            e.printStackTrace();
        }
    }
    //Excluir um usuario
    public void delete(int usuario) {
        String sql =   "DELETE FROM tb_usuario WHERE id=" + usuario;
        System.out.println(sql);
        try {
            Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso");
            ps.close();
            c.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro");
            e.printStackTrace();
        }
    }
    // Consultar um Usuario
    public void consulta(Usuario usuario) {
        String sql =   "SELECT * from tb_usuario where id=" + usuario.getCodigo();
        System.out.println(sql);

        try {  Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso");

            while (rs.next()){
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getInt("telefone"));
            }
            ps.close();
            c.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erros na Transação");
            e.printStackTrace();
        }
    }
    public ArrayList listaUsuario(){
        ArrayList<Usuario> dados = new ArrayList();
        String sql = "SELECT * FROM tb_usuario";

        try { Connection c = ConexaoDB.obtemConexao();
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            rs = ps.executeQuery();
            while (rs.next())
            {   Usuario usuario = new Usuario();

                usuario.setCodigo(Integer.parseInt(rs.getString("id")));
                usuario.setNome(rs.getString("nome"));
                usuario.setCodigo(rs.getInt("id"));
                usuario.setTelefone(rs.getInt("telefone"));
                System.out.println(usuario.getNome());

                dados.add(usuario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return dados;
    }
}
