public class ElementoArvore {
    // Tipo Nó Arvore
    NoArvore elemento_Arvore;
    ElementoArvore proximo_No;

    public ElementoArvore(NoArvore valor) {
        this.elemento_Arvore = valor;
        this.proximo_No = null;
    }
}
