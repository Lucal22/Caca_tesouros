import java.util.ArrayList;

public class Jogo {
    private ArrayList<Jogador> jogadores;
    private ArrayList<String> cores = new ArrayList<>();

    Jogo(){
        this.jogadores = new ArrayList<>();
        this.jogadores.add(new Jogador());
        this.jogadores.add(new Jogador());
        this.cores.add("amarelo");
        this.cores.add("verde");
        this.cores.add("vermelho");
    }

    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }

    private boolean validaValores(int l, int c, ArrayList<Integer[]> j){
        if(l<0 || c<0){
            System.out.println("Valores inválidos");
            return false;
        }for (Integer[] par : j) {
            if (par[0] == l && par[1] == c) {
                System.out.println("Posição já utilizada");
                return false;
            }
        }
        return true;
    }
    private boolean validaCores(int id, String cor){
        if(cores.contains(cor.toLowerCase())){
            if(cor.equalsIgnoreCase("amarelo") && this.jogadores.get(id).getPçsAmarelas()<1){
                System.out.println("Sem peças amarelas restantes");
                return false;
            }else if(cor.equalsIgnoreCase("verde") && this.jogadores.get(id).getPçsVerdes()<1){
                System.out.println("Sem peças verdes restantes");
                return false;
            }else if(cor.equalsIgnoreCase("vermelho")&& this.jogadores.get(id).getPçsVermelhas()<1){
                System.out.println("Sem peças vermelhas restantes");
                return false;
            }
            return true;
        }else{
            System.out.println("Cor inválida");
            return false;
        }
        }

    public boolean posicionaPeca(int l, int c,int id, String cor){
        if(validaValores(l,c,this.jogadores.get(id).getPosicaoTesouros())){
            if(validaCores(id, cor)){
                this.jogadores.get(id).posicionarTesouro(l,c,cor);
                this.jogadores.get(id).addPosicaoTesouros(new Integer[]{l,c});
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean atacar(int l, int c, int a, int d){
        if(validaValores(l,c,this.jogadores.get(a).getJogadas())){
            if(this.jogadores.get(a).getJogadas().contains(new Integer[]{l,c})){
                System.out.println("Posição já informada");
                return false;
            }else{
                this.jogadores.get(a).addJogada(new Integer[]{l,c});
                this.jogadores.get(a).setPontos(this.jogadores.get(d).getPosicao(l,c));
                return true;
            }
        }else{
            return false;
        }

    }
}
