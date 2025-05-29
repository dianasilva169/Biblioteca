import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Revista");
            System.out.println("3. Listar Itens");
            System.out.println("4. Emprestar Item");
            System.out.println("5. Devolver Item");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String tituloLivro = scanner.nextLine();

                    String autorLivro;
                    do{
                        System.out.print("Autor: ");
                        autorLivro = scanner.nextLine();
                    } while (validarAutor(autorLivro) == false);

                    int anoLivro;
                    do {
                        System.out.print("Ano: ");
                        anoLivro = scanner.nextInt();
                    } while (anoLivro > 2025);

                    int paginas;
                    do { 
                        System.out.print("Páginas: ");
                        paginas = scanner.nextInt();
                    } while (paginas <= 0);
                    
                    scanner.nextLine();
                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();
                    biblioteca.adicionarItem(new Livro(tituloLivro, autorLivro, anoLivro, paginas, genero));
                    System.out.println("Livro cadastrado!");
                    break;

                case 2:
                    System.out.print("Título: ");
                    String tituloRevista = scanner.nextLine();

                    String editor;
                    do {
                        System.out.print("Editor: ");
                        editor = scanner.nextLine();
                    } while (validarAutor(editor) == false);

                    int anoRevista;
                    do {
                        System.out.print("Ano: ");
                        anoRevista = scanner.nextInt();
                    } while (anoRevista > 2025);

                    int edicao;
                    do {
                        System.out.print("Edição: ");
                        edicao = scanner.nextInt();
                    } while (edicao < 0);
                    scanner.nextLine();

                    String mes;
                    do{
                        System.out.print("Mês: ");
                        mes = scanner.nextLine();
                    } while (validarMes(mes) == false);
                    
                    biblioteca.adicionarItem(new Revista(tituloRevista, editor, anoRevista, edicao, mes));
                    System.out.println("Revista cadastrada!");
                    break;

                case 3:
                    biblioteca.listarItens();
                    break;

                case 4:
                    System.out.print("Título para empréstimo: ");
                    String tituloEmprestimo = scanner.nextLine();
                    ItemBiblioteca item = encontrarItem(tituloEmprestimo, biblioteca);
                    if(item != null){
                        item.emprestar();
                    }
                    break;

                case 5:
                    System.out.print("Título para devolução: ");
                    String tituloDevolucao = scanner.nextLine();
                    ItemBiblioteca itemDev = encontrarItem(tituloDevolucao, biblioteca);
                    if(itemDev != null){
                        itemDev.devolver();
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static ItemBiblioteca encontrarItem(String titulo, Biblioteca biblioteca){
        ItemBiblioteca item = biblioteca.buscarItem(titulo); 
        if (item != null) {
            return item;
        } else {
            System.out.println("Item não encontrado!");
            return null;
        }
    }

    private static boolean validarMes(String mes){
        List<String> meses = Arrays.asList("janeiro", "fevereiro", 
        "março", "abril", "maio", "junho", "julho",
        "agosto", "setembro", "outubro", "novembro", "dezembro");

        if(!meses.contains(mes.toLowerCase())){
            System.out.println("Mês inválido.");
            return false;
        }
        return true;
    }

    private static boolean validarAutor(String autor){
        if(autor.isBlank()){ // null
            System.out.println("Nome de autor inválido.");
            return false;
        }
        if(autor.isEmpty()){ // ""
            System.out.println("Nome de autor inválido. Vazio.");
            return false;
        }
        return true; // "a"
    }
}

