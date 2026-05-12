import java.util.ArrayList;

public class Faculdade {
    private ArrayList<Usuario> usuarios;

    public Faculdade() {
        this.usuarios = new ArrayList<Usuario>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario(Usuario usuario) {
        if (usuario != null) {
            this.usuarios.add(usuario);
        }
    }

    public void removeUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        if (nome == null) {
            return null;
        }

        for (Usuario u : this.usuarios) {
            if (u.getNome() != null && u.getNome().equalsIgnoreCase(nome)) {
                return u;
            }
        }

        return null;
    }
}