import java.io.IOException;
import java.util.Scanner;

        public class Main {

            public static class No {
                public String elemento_armazenado;
                public No proximo_no;
                public No anterior_no;

                public No(String dado) {
                    this.elemento_armazenado = dado;
                    this.proximo_no = null;
                    this.anterior_no = null;
                }
            }

            public static class ListaOrdenadaTamanho {
                public int contador;
                public No primeiro_no;
                public No ultimo_no;


                public ListaOrdenadaTamanho() {
                    this.contador = 0;
                    this.primeiro_no = null;
                    this.ultimo_no = null;
                }

                public void adicionar_Nomes(String nome) {
                    No novo = new No(nome);

                    if (primeiro_no == null) {
                        primeiro_no = novo;
                        ultimo_no = novo;
                    }
                    else if (novo.elemento_armazenado.length() < primeiro_no.elemento_armazenado.length()) {
                        novo.proximo_no = primeiro_no;
                        primeiro_no.anterior_no = novo;
                        primeiro_no = novo;
                        primeiro_no.anterior_no = ultimo_no;
                    }
                    else if (novo.elemento_armazenado.length() > ultimo_no.elemento_armazenado.length()) {
                        ultimo_no.proximo_no = novo;
                        novo.anterior_no = ultimo_no;
                        ultimo_no = novo;
                        ultimo_no.proximo_no = primeiro_no;
                    }
                    else {
                        No anterior = null;
                        No aux = primeiro_no;

                        while (aux != null && novo.elemento_armazenado.length() > aux.elemento_armazenado.length()) {
                            anterior = aux;
                            aux = aux.proximo_no;
                        }

                        anterior.proximo_no = novo;
                        novo.anterior_no = anterior;
                        novo.proximo_no = aux;
                        aux.anterior_no = novo;
                    }
                    contador++;
                }

                public boolean ver_Nomes(String nome) {
                    No aux = primeiro_no;
                    for (int i = 0; i < contador; i++) {
                        if (nome.length() == aux.elemento_armazenado.length()) {
                            return true;
                        }
                        aux = aux.proximo_no;
                    }
                    return false;
                }

                public void mostrar_Nomes() {
                    No aux = primeiro_no;

                    for (int i = 0; i < contador; i++) {
                        if (aux == ultimo_no) {
                            System.out.print(aux.elemento_armazenado);
                        }
                        else {
                            System.out.print(aux.elemento_armazenado + ", ");
                        }
                        aux = aux.proximo_no;
                    }
                    System.out.println();
                }
            }




            public static class No2 {
                public No2 proximo_no;
                public No2 anterior_no;
                public ListaOrdenadaTamanho elemento_armazenado;

                public No2(ListaOrdenadaTamanho nome2) {
                    this.proximo_no = null;
                    this.anterior_no = null;
                    this.elemento_armazenado = nome2;
                }
            }

            public static  class ListaDuplaEncadeada {
                public No2 primeiro_no;
                public No2 ultimo_no;
                public int contador;

                public ListaDuplaEncadeada() {
                    this.primeiro_no = null;
                    this.ultimo_no = null;
                    this.contador = 0;
                }

                public void adicionar_NomeDupla(ListaOrdenadaTamanho nome2) {
                    No2 novo2 = new No2(nome2);

                    if (primeiro_no == null) {
                        primeiro_no = novo2;
                        ultimo_no = novo2;
                    }
                    else {
                        ultimo_no.proximo_no = novo2;
                        ultimo_no = novo2;
                    }
                    contador++;
                }

                public boolean ver_NomeDupla(String nome, ListaOrdenadaTamanho nomes) {
                    No aux = nomes.primeiro_no;
                    while (aux != null) {
                        if (nome.length() == aux.elemento_armazenado.length()) {
                            return true;
                        }
                        aux = aux.proximo_no;
                    }
                    return false;
                }
                public ListaOrdenadaTamanho ver_NaPosicao(int posicao) {
                    No2 aux = primeiro_no;
                    for (int i = 0; i < posicao; i++) {
                        aux = aux.proximo_no;
                    }
                    return aux.elemento_armazenado;
                }
                public int tamanho_Dupla() {
                    return contador;
                }
                public void mostrar_Dupla() {
                    No2 aux = primeiro_no;
                    while (aux != null) {
                        aux.elemento_armazenado.mostrar_Nomes();
                        aux = aux.proximo_no;
                    }
                }
            }
            public static void main(String[] args) throws IOException {
                ListaOrdenadaTamanho nomes1 = new ListaOrdenadaTamanho();
                ListaDuplaEncadeada lista1 = new ListaDuplaEncadeada();
                Scanner entrada = new Scanner(System.in);
                int n = entrada.nextInt();
                lista1.adicionar_NomeDupla(nomes1);
                for (int i = 0; i < n; i++) {
                    String nome = entrada.next();
                    boolean condicao = false;
                    for (int j = 0; j < lista1.tamanho_Dupla(); j++) {
                        ListaOrdenadaTamanho lista2 = lista1.ver_NaPosicao(j);
                        if (!lista2.ver_Nomes(nome)) {
                            condicao = true;
                            lista2.adicionar_Nomes(nome);
                            break;
                        }
                    }
                    if (!condicao) {
                        ListaOrdenadaTamanho Lista3 = new ListaOrdenadaTamanho();
                        lista1.adicionar_NomeDupla(Lista3);
                        Lista3.adicionar_Nomes(nome);

                    }
                }
                lista1.mostrar_Dupla();
            }

        }
