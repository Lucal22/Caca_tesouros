import java.util.ArrayList;

public class Jogo {
    private ArrayList<Jogador> jogadores;
    private ArrayList<String> cores = new ArrayList<>();

    // Construtor da classe Jogo que já inicia os dois objetos jogadores e os adiciona em uma collection
    Jogo(){
        this.jogadores = new ArrayList<>();
        this.jogadores.add(new Jogador());
        this.jogadores.add(new Jogador());
        this.cores.add("amarelo");
        this.cores.add("verde");
        this.cores.add("vermelho");
    }

    // Get dos jogadores
    public ArrayList<Jogador> getJogadores() {
        return this.jogadores;
    }

    // Faz validação dos valores passados pelo jogador
    private boolean validaValores(int l, int c, ArrayList<Integer[]> j){
        if(l<0 || c<0 || l>9 || c>9){ // Checa se os valores estão dentro do range do vetor
            System.out.println("Valores inválidos");
            return false;
        }
        for (Integer[] par : j) { // Checa se os valores já foram passados anteriormente
            if (par[0] == l && par[1] == c) {
                System.out.println("Posição já utilizada");
                return false;
            }
        }
        return true;
    }

    // Faz a validação das cores passadas pelos jogadores
    private boolean validaCores(int id, String cor){
        if(cores.contains(cor.toLowerCase())){ // Checa se as cores são válidas (Verde, Amarelo ou Vermelho)
            if(cor.equalsIgnoreCase("amarelo")
                    && this.jogadores.get(id).getPçsAmarelas()<1){  // Checa se há peças restantes da cor para serem posicionadas
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

    // Posiciona a peça nas posicoes passadas pelo jogador
    public boolean posicionaPeca(int l, int c,int id, String cor){
        if(validaValores(l,c,this.jogadores.get(id).getPosicaoTesouros())){
            if(validaCores(id, cor)){
                this.jogadores.get(id).posicionarTesouro(l,c,cor);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    // Ataca o tabuleiro do adversário nas posições definidas pelo jogador do ataque
    public boolean atacar(int l, int c, int a, int d){
        if(validaValores(l,c,this.jogadores.get(a).getJogadas())){
            if(this.jogadores.get(a).getJogadas().contains(new Integer[]{l,c})){
                System.out.println("Posição já informada");
                return false;
            }else{
                this.jogadores.get(a).atacar(new Integer[]{l,c},this.jogadores.get(d).getPosicao(l,c));
                return true;
            }
        }else{
            return false;
        }

    }
}
