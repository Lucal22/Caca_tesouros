import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Jogo j = new Jogo();
        posicionaPecas(j,in);
        ataques(j, in);
    }

    // Metodo para ambos os jogadores fazerem o posicionamento das peças
    public static void posicionaPecas(Jogo j, Scanner in){
        int l,c;
        String cor;
        // Cada jogador posiciona uma peça por vez, portanto o loop se repete por 8 vezes até que todas sejam posicionadas.
        for(int i =1; i<=8;i++){
            boolean j1Jogou,j2Jogou;
            // O jogador só sai do loop quando a variavel boolean for true, ou seja, quando os valores informados forem válidos
            do{
                System.out.println("Jogador 1:");
                System.out.println("Digite a linha em que quer esconder o tesouro (0 a 9):");
                l = in.nextInt();
                System.out.println("\nDigite a coluna em que quer esconder o tesouro (0 a 9):");
                c = in.nextInt();
                in.nextLine();
                System.out.println("\nDigite a cor do tesouro que deseja esconder:");
                System.out.println("Verdes restantes: "+j.getJogadores().getFirst().getPçsVerdes());
                System.out.println("Vermelhas restantes: "+j.getJogadores().getFirst().getPçsVermelhas());
                System.out.println("Amarelas restantes: "+j.getJogadores().getFirst().getPçsAmarelas());
                cor = in.nextLine();
                j1Jogou = j.posicionaPeca(l,c,0,cor);
            }while (!j1Jogou);
            do{
                System.out.println("\nJogador 2:");
                System.out.println("Digite a linha em que quer esconder o tesouro (0 a 9):");
                l = in.nextInt();
                System.out.println("\nDigite a coluna em que quer esconder o tesouro (0 a 9):");
                c = in.nextInt();
                in.nextLine();
                System.out.println("\nDigite a cor do tesouro que deseja esconder (Verde, Vermelho, Amarelo):");
                System.out.println("Verdes restantes: "+j.getJogadores().getLast().getPçsVerdes());
                System.out.println("Vermelhas restantes: "+j.getJogadores().getLast().getPçsVermelhas());
                System.out.println("Amarelas restantes: "+j.getJogadores().getLast().getPçsAmarelas());
                cor = in.nextLine();
                j2Jogou = j.posicionaPeca(l,c,1,cor);
            }while (!j2Jogou);

        }
    }

    // Metodo que inicia as rodadas de ataque
    public static void ataques(Jogo j, Scanner in){
        int l,c;

        // O jogo pode ter no máximo 20 rodadas, portanto o loop se repete por até 20 vezes.
        for(int i = 1; i<=20;i++){
            boolean j1Jogou,j2Jogou;
            // Informa a rodada em que o jogo se encontra
            System.out.println("RODADA: "+i);
            // O jogador só sai do loop quando a variavel boolean for true, ou seja, quando os valores informados forem válidos
            do{
                System.out.println("Jogador 1:");
                System.out.println("Digite a linha que quer atacar (0 a 9):");
                l = in.nextInt();
                System.out.println("\nDigite a coluna que quer atacar (0 a 9):");
                c = in.nextInt();
                j1Jogou = j.atacar(l,c,0,1);
            }while (!j1Jogou);

            // Checa se o jogador já conseguiu alcançar os 20 pontos
            if(j.getJogadores().getFirst().getPontos()>=20){
                System.out.println("Jogador 1 é o vencedor.");
                System.out.println("Resultado:");
                System.out.println("Jogador 1: "+j.getJogadores().getFirst().getPontos()+" Jogador 2: "+j.getJogadores().getLast().getPontos());
                // Caso tenha alcançado, sai do metodo e o jogo se encerra
                return;
            }
            do{
                System.out.println("\nJogador 2:");
                System.out.println("Digite a linha que quer atacar (0 a 9):");
                l = in.nextInt();
                System.out.println("\nDigite a linha que quer atacar (0 a 9):");
                c = in.nextInt();
                j2Jogou = j.atacar(l,c,1,0);
            }while (!j2Jogou);

            if(j.getJogadores().getLast().getPontos()>=20){
                System.out.println("Jogador 2 é o vencedor.");
                System.out.println("Resultado:");
                System.out.println("Jogador 1: "+j.getJogadores().getFirst().getPontos()+" Jogador 2: "+j.getJogadores().getLast().getPontos());

                return;
            }
        }
        // Sai do loop no fim das 20 rodadas
        System.out.println("\nFim de jogo.");

        // Checa qual jogador teve a maior pontuação
        if(j.getJogadores().getFirst().getPontos()>j.getJogadores().getLast().getPontos()){
            System.out.println("Após 20 rodadas, o vencedor é: ");
            System.out.println("Jogador 1, com um total de: "+j.getJogadores().getFirst().getPontos()+" pontos.");
        }else if(j.getJogadores().getLast().getPontos()>j.getJogadores().getFirst().getPontos()){
            System.out.println("Após 20 rodadas, o vencedor é: ");
            System.out.println("Jogador 2, com um total de: "+j.getJogadores().getLast().getPontos()+" pontos.");
        }else{ // Envia mensagem de empate caso não haja diferença de pontuação entre os jogadores
            System.out.println("O jogo terminou empatado, com ambos jogadores terminando com: "+ j.getJogadores().getFirst().getPontos());
        }
    }
}