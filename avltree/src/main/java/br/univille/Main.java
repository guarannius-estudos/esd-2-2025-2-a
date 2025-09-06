package br.univille;

public class Main {
    public static void main(String[] args) {
        Arvore arvore;
        No no;
        
        System.out.println("ÁRVORE 1");

        no = new No(40);
        arvore = new Arvore(no);

        arvore.adicionar(20);
        arvore.adicionar(60);
        arvore.adicionar(10);
        arvore.adicionar(30);
        arvore.adicionar(25);
        arvore.imprimir();

        System.out.println("");
        System.out.println("ÁRVORE 2");
        
        no = new No(60);
        arvore = new Arvore(no);

        arvore.adicionar(40);
        arvore.adicionar(80);
        arvore.adicionar(35);
        arvore.adicionar(50);
        arvore.adicionar(90);
        arvore.adicionar(20);
        arvore.adicionar(38);
        arvore.adicionar(37);
        arvore.imprimir();

        System.out.println("");
        System.out.println("ÁRVORE 3");

        no = new No(30);
        arvore = new Arvore(no);

        arvore.adicionar(20);
        arvore.adicionar(10);
        arvore.adicionar(25);
        arvore.adicionar(40);
        arvore.adicionar(50);
        arvore.adicionar(5);
        arvore.adicionar(35);
        arvore.adicionar(45);
        arvore.imprimir();
    }
}
