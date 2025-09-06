package br.univille;

public class Arvore {
    No no;
    No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }
    
    public void adicionar(int valor) {
        no = adicionar(valor, raiz, null);
        raiz = no;
    }

    public No adicionar(int valor, No atual, No pai) {
        if (atual == null) {
            no = new No(valor);
            no.setPai(pai);
            no.setAltura(1);
            return no;
        }

        if (valor > atual.getValor()) {
            No novo = adicionar(valor, atual.getFilhoDireito(), atual);
            atual.setFilhoDireito(novo);
        }

        if (valor < atual.getValor()) {
            No novo = adicionar(valor, atual.getFilhoEsquerdo(), atual);
            atual.setFilhoEsquerdo(novo);
        }

        atual.setAltura(calcularAltura(atual));
        return balancear(atual);
    }

    public No balancear(No atual) {
        No balanceado = atual;
        int fatorBalanceamento = atual.getFatorBalanceamento();
        
        if (fatorBalanceamento < -1) {
            if (atual.getValor() > atual.getFilhoDireito().getValor()) {
                balanceado = rotacaoEsquerda(atual);
            } else {
                rotacaoDireita(atual.getFilhoDireito());
                balanceado = rotacaoEsquerda(atual);
            }
        } else if (fatorBalanceamento > 1) {
            if (atual.getValor() < atual.getFilhoEsquerdo().getValor()) {
                balanceado = rotacaoDireita(atual);
            } else {
                rotacaoEsquerda(atual.getFilhoEsquerdo());
                balanceado = rotacaoDireita(atual);
            }
        }

        return balanceado;
    }

    public No rotacaoDireita(No desbalanceado) {
        if (desbalanceado.getFilhoEsquerdo() == null) {
            return desbalanceado;
        }

        No filhoEsquerdo = desbalanceado.getFilhoEsquerdo();
        No filhoEsquerdoDireito = filhoEsquerdo.getFilhoDireito();
        filhoEsquerdo.setPai(desbalanceado.getPai());

        if (desbalanceado.getPai() != null) {
            if (desbalanceado.getPai().getFilhoDireito() == desbalanceado) {
                desbalanceado.getPai().setFilhoDireito(filhoEsquerdo);
            } else {
                desbalanceado.getPai().setFilhoEsquerdo(filhoEsquerdo);
            }
        }

        desbalanceado.setPai(filhoEsquerdo);
        filhoEsquerdo.setFilhoDireito(desbalanceado);
        desbalanceado.setFilhoEsquerdo(filhoEsquerdoDireito);

        if (filhoEsquerdoDireito != null) {
            filhoEsquerdoDireito.setPai(desbalanceado);
        }

        return filhoEsquerdo;
    }

    public No rotacaoEsquerda(No desbalanceado) {
        if (desbalanceado.getFilhoDireito() == null) {
            return desbalanceado;
        }

        No filhoDireito = desbalanceado.getFilhoDireito();
        No filhoDireitoEsquerdo = filhoDireito.getFilhoEsquerdo();
        filhoDireito.setPai(desbalanceado.getPai());

        if (desbalanceado.getPai() != null) {
            if (desbalanceado.getPai().getFilhoEsquerdo() == desbalanceado) {
                desbalanceado.getPai().setFilhoEsquerdo(filhoDireito);
            } else {
                desbalanceado.getPai().setFilhoDireito(filhoDireito);
            }
        }

        desbalanceado.setPai(filhoDireito);
        filhoDireito.setFilhoEsquerdo(desbalanceado);
        desbalanceado.setFilhoDireito(filhoDireitoEsquerdo);

        if (filhoDireitoEsquerdo != null) {
            filhoDireitoEsquerdo.setPai(desbalanceado);
        }

        return filhoDireito;
    }

    public int calcularAltura(No atual) {
        int alturaEsquerdo = 0;
        int alturaDireito = 0;

        if (atual.getFilhoEsquerdo() != null) {
            alturaEsquerdo = atual.getFilhoEsquerdo().getAltura();
        }

        if (atual.getFilhoDireito() != null) {
            alturaDireito = atual.getFilhoDireito().getAltura();
        }

        return Math.max(alturaEsquerdo, alturaDireito) + 1;
    }

    public void imprimir() {
        imprimir(raiz, "");
    }

    private void imprimir(No no, String vazio) {
        if (no != null) {
            imprimir(no.getFilhoDireito(), vazio + "    ");

            System.out.println(vazio + "    " + no.getValor());

            imprimir(no.getFilhoEsquerdo(), vazio + "    ");
        }
    }
}
