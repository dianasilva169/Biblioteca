import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<ItemBiblioteca> acervo;

    public Biblioteca() {
        acervo = new ArrayList<>();
    }

    public void adicionarItem(ItemBiblioteca item) {
        if(item == null){
            return;
        }
        acervo.add(item);
    }

    public void removerItem(String titulo) {
        acervo.removeIf(item -> item.titulo.equalsIgnoreCase(titulo));
    }

    public void listarItens() {
        acervo.forEach(item -> item.exibirDetalhes());
    }

    public ItemBiblioteca buscarItem(String titulo) {
        return acervo.stream()
                .filter(item -> item.titulo.equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }
}