public class ElementoArvoreAVL {
    // Tipo Nó Arvore
    NoArvoreAVL elemento_Arvore;
    ElementoArvoreAVL proximo_No;

    public ElementoArvoreAVL(NoArvoreAVL valor) {
        this.elemento_Arvore = valor;
        this.proximo_No = null;
    }
}
