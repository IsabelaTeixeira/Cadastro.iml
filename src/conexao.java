import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {
    private String usuario = "root";
    private String senha = "12345678";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "db_a3";

    public Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd + "?useTimezone=true&serverTimezone=UTC", usuario, senha);
            System.out.println("Banco conectado com sucesso!!!!");
            return c;
        } catch (Exception e) {
            System.out.println("Banco não conectado!!!!");
            e.printStackTrace();
            return null;
        }
    }

}