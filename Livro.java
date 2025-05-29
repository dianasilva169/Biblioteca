public class Livro extends ItemBiblioteca {
    private int numPaginas;
    private String genero;

    public Livro(String titulo, String autor, int anoPublicacao, int numPaginas, String genero) {
        super(titulo, autor, anoPublicacao);
        this.numPaginas = numPaginas;
        this.genero = genero;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n--- LIVRO ---");
        System.out.println(super.toString());
        System.out.println("Páginas: " + numPaginas);
        System.out.println("Gênero: " + genero);
    }
}
