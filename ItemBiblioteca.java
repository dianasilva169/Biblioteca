
  public abstract class ItemBiblioteca {
    protected String titulo;
    protected String autor;
    protected int anoPublicacao;
    protected boolean disponivel;

    public ItemBiblioteca(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    public abstract void exibirDetalhes();

    @Override
    public String toString(){
        return String.format(
            "Titulo: %s\n" +
            "Autor: %s\n" +
            "Ano: %d\n" +
            "Disponível: %s\n",
            titulo, autor, anoPublicacao, (disponivel ? "Sim" : "Não"));
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println(titulo + " emprestado com sucesso!");
        } else {
            System.out.println(titulo + " já está emprestado.");
        }
    }

    public void devolver() {
        if(!disponivel){
            disponivel = true;
            System.out.println(titulo + " devolvido.");
        } else {
            System.out.println("Não foi emprestado.");
        }
    }
}
