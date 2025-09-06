package br.univille;

public class No {
    private int valor;
    private int altura = 0;
    private No pai;
    private No filhoDireito;
    private No filhoEsquerdo;
    
    public No(int valor) {
        this.valor = valor;
        this.pai = null;
        this.filhoDireito = null;
        this.filhoEsquerdo = null;
    }

    public int getFatorBalanceamento() {
        int alturaDireito = 0;
        int alturaEsquerdo = 0;
        if (filhoDireito != null) {
            alturaDireito = filhoDireito.getAltura();   
        }
        if (filhoEsquerdo != null) {
            alturaEsquerdo = filhoEsquerdo.getAltura();
        }
        
        return alturaEsquerdo - alturaDireito;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }
}
