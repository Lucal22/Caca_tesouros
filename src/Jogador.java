import java.util.ArrayList;

public class Jogador {
    private Tabuleiro tabuleiro;
    private ArrayList<Integer[]> jogadas;
    private ArrayList<Integer[]> posicaoTesouros;
    private int[] peças = {6,10,4,6,4,10,6,4};
    private int contador,pontos,pçsAmarelas,pçsVerdes,pçsVermelhas;

    // Constructor do jogador
    Jogador(){
        this.tabuleiro = new Tabuleiro();
        this.jogadas = new ArrayList<>();
        this.posicaoTesouros = new ArrayList<>();
        this.contador = 0;
        this.pontos = 0;
        this.pçsAmarelas =3;
        this.pçsVerdes = 3;
        this.pçsVermelhas = 2;
    }

    // Metodo de posicionar tesouro sem informar a cor
    public void posicionarTesouro(int linha, int coluna){
        if(contador<this.peças.length){ //Checa se ainda existem peças a serem posicionadas
            // Posiciona o valor de acordo com a ordem determinada no vetor peças
            this.tabuleiro.setVetByIndex(linha,coluna,this.peças[this.contador]);
            this.contador++;
        }else{
            System.out.println("Todas as peças foram posicionadas");
        }

    }

    // Metodo de posicionar tesouro com a cor sendo informada
    public void posicionarTesouro(int linha, int coluna, String cor){
        if(cor.equalsIgnoreCase("amarelo")){
            this.tabuleiro.setVetByIndex(linha,coluna,4); // Posiciona o valor da peça na casa indicada
            this.pçsAmarelas --; // Diminui o número de pçs restantes da cor específica a serem posicionadas
        }else if(cor.equalsIgnoreCase("verde")){
            this.tabuleiro.setVetByIndex(linha,coluna,6);
            this.pçsVerdes --;
        }else if(cor.equalsIgnoreCase("vermelho")){
            this.tabuleiro.setVetByIndex(linha,coluna,10);
            this.pçsVermelhas --;
        }
        this.posicaoTesouros.add(new Integer[]{linha,coluna});
    }

    // Metodo de atacar que adiciona a jogada feita pelo jogador e atualiza sua pontuação
    public void atacar(Integer[] j,int p){
        this.jogadas.add(j);
        this.pontos += p;
    }

    // Getters das variáveis da classe Jogador
    public ArrayList<Integer[]> getJogadas(){
        return this.jogadas;
    }
    public ArrayList<Integer[]> getPosicaoTesouros(){
        return this.posicaoTesouros;
    }
    public int getPosicao(int linha, int coluna){
        return this.tabuleiro.getVetByIndex(linha,coluna);
    }
    public int getPontos(){
        return this.pontos;
    }
    public int getPçsAmarelas(){
        return this.pçsAmarelas;
    }
    public int getPçsVerdes(){
        return this.pçsVerdes;
    }
    public int getPçsVermelhas(){
        return this.pçsVermelhas;
    }

}