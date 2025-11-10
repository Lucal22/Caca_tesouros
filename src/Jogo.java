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
    private boolean validaValores(int linha, int coluna, ArrayList<Integer[]> j){
        if(linha<0 || coluna<0 || linha>9 || coluna>9){ // Checa se os valores estão dentro do range do vetor
            System.out.println("Valores inválidos");
            return false;
        }
        for (Integer[] par : j) { // Checa se os valores já foram passados anteriormente
            if (par[0] == linha && par[1] == coluna) {
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

    // Posiciona a peça nas posicoes passadas pelo jogador com cor
    public boolean posicionaPeca(int linha, int coluna,int id, String cor){
        if(validaValores(linha,coluna,this.jogadores.get(id).getPosicaoTesouros())){
            if(validaCores(id, cor)){
                this.jogadores.get(id).posicionarTesouro(linha,coluna,cor);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    // Posiciona a peça nas posicoes passadas pelo jogador sem cor
    public boolean posicionaPeca(int linha, int coluna,int id){
        if(validaValores(linha,coluna,this.jogadores.get(id).getPosicaoTesouros())){
            this.jogadores.get(id).posicionarTesouro(linha,coluna);
            return true;
        }else{
            return false;
        }
    }

    // Ataca o tabuleiro do adversário nas posições definidas pelo jogador do ataque
    public boolean atacar(int linha, int coluna, int atacante, int defensor){
        if(validaValores(linha,coluna,this.jogadores.get(atacante).getJogadas())){
            if(this.jogadores.get(atacante).getJogadas().contains(new Integer[]{linha,coluna})){
                System.out.println("Posição já informada");
                return false;
            }else{
                this.jogadores.get(atacante).atacar(new Integer[]{linha,coluna},this.jogadores.get(defensor).getPosicao(linha,coluna));
                return true;
            }
        }else{
            return false;
        }

    }
}
