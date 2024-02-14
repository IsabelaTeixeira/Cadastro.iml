public class Usuario {
    private int codigo;
    private String nome;
    private String senha;
    private int telefone;

    public Usuario(int codigo, String nome, String senha, int telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
    }
    public Usuario (){
        this.codigo = 0;
        this.nome = "";
        this.senha = "";
        this.telefone = 0;
    }
    public Usuario (String nome, String senha){
        this.codigo = 0;
        this.nome = nome;
        this.senha = senha;
        this.telefone = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
