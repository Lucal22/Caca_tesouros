import java.util.ArrayList;

public class Jogador {
    private Tabuleiro tabuleiro;
    private ArrayList<Integer[]> jogadas;
    private ArrayList<Integer[]> PosicaoTesouros;
    private int pontos;
    private int pçsAmarelas;
    private int pçsVerdes;
    private int pçsVermelhas;

    Jogador(){
        this.tabuleiro = new Tabuleiro();
        this.jogadas = new ArrayList<>();
        this.PosicaoTesouros = new ArrayList<>();
        this.pontos = 0;
        this.pçsAmarelas =3;
        this.pçsVerdes = 3;
        this.pçsVermelhas = 2;
    }

    
    public void posicionarTesouro(int linha, int coluna, String cor){
        if(cor.equalsIgnoreCase("amarelo")){
            this.tabuleiro.setVetByIndex(linha,coluna,4);
            this.pçsAmarelas --;
        }else if(cor.equalsIgnoreCase("verde")){
            this.tabuleiro.setVetByIndex(linha,coluna,6);
            this.pçsVerdes --;
        }else if(cor.equalsIgnoreCase("vermelho")){
            this.tabuleiro.setVetByIndex(linha,coluna,10);
            this.pçsVermelhas --;
        }
    }

    public ArrayList<Integer[]> getJogadas(){
        return this.jogadas;
    }
    public int getPontos(){
        return this.pontos;
    }
    public ArrayList<Integer[]> getPosicaoTesouros(){
        return this.PosicaoTesouros;
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
    public int getPosicao(int l, int c){
        return this.tabuleiro.getVetByIndex(l,c);
    }
    public void setPontos(int p){
        this.pontos += p;
    }

    public void addJogada(Integer[] j){
        this.jogadas.add(j);
    }
    public void addPosicaoTesouros(Integer[] j){
        this.PosicaoTesouros.add(j);
    }

}