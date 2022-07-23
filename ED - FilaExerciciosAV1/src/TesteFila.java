public class TesteFila {
    public static void main(String[] args) {
        Fila fila1= new Fila(4);
        fila1.Enfileirar_Fila(1);
        fila1.Enfileirar_Fila(2);
        fila1.Enfileirar_Fila(3);
        fila1.Enfileirar_Fila(4);
        fila1.Ver_Fila();
        fila1 = fila1.inverterFilaUsandoFila();
        fila1.Ver_Fila();
    }
}
