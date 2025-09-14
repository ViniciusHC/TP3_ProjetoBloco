public class Usuario {

    private String nome;
    private int cpf;
    private String email;
    private String senha;

    public Usuario(String nome, int cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public void fazerLogin (String email, String senha){
        if (email.equals(this.email)){
            System.out.println("Digite a Senha: ");
            verificarSenha(senha);
        }else {
            System.out.println("Usuário incorreto! Tente novamente");
        }

    }

    public void verificarSenha(String senha){
        if (senha.equals(this.senha)){
            System.out.println("Acesso Liberado");
        }else{
            System.out.println("Senha incorreta, tente novamente!");
        }
    }

}
