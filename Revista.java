
import java.util.Arrays;
import java.util.List;

public class Revista extends ItemBiblioteca {
    private int edicao;
    private String mesPublicacao;

    public Revista(String titulo, String autor, int anoPublicacao, int edicao, String mesPublicacao) {
        super(titulo, autor, anoPublicacao);
        this.edicao = edicao;
        if(validarMes(mesPublicacao)){
            this.mesPublicacao = mesPublicacao;
        }
    }

    private boolean validarMes(String mes){
        List<String> meses = Arrays.asList("janeiro", "fevereiro", 
        "março", "abril", "maio", "junho", "julho",
        "agosto", "setembro", "outubro", "novembro", "dezembro");

        if(!meses.contains(mes.toLowerCase())){
            System.out.println("Mês inválido.");
            return false;
        }
        if(mes.isBlank() || mes.isEmpty()){
            System.out.println("Mês inválido.");
            return false;
        }
        return true;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("\n--- REVISTA ---");
        System.out.println(super.toString());
        System.out.println("Edição: " + edicao);
        System.out.println("Mês: " + mesPublicacao);
    }
}
