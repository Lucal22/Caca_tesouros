import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Jogo j = new Jogo();
        posicionaPecas(j,in);
        iniciaJogo(j, in);
    }

    public static void posicionaPecas(Jogo j, Scanner in){
        int l,c;
        String cor;
        for(int i =0; i<8;i++){
            boolean j1Jogou,j2Jogou;
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
    public static void iniciaJogo(Jogo j, Scanner in){
        int l,c;
        for(int i = 1; i<=20;i++){
            boolean j1Jogou,j2Jogou;
            System.out.println("RODADA: "+i);
            do{
                System.out.println("Jogador 1:");
                System.out.println("Digite a linha que quer atacar (0 a 9):");
                l = in.nextInt();
                System.out.println("\nDigite a coluna que quer atacar (0 a 9):");
                c = in.nextInt();
                j1Jogou = j.atacar(l,c,0,1);
            }while (!j1Jogou);
            do{
                System.out.println("\nJogador 2:");
                System.out.println("Digite a linha em que quer esconder o tesouro (0 a 9):");
                l = in.nextInt();
                System.out.println("\nDigite a coluna em que quer esconder o tesouro (0 a 9):");
                c = in.nextInt();
                j2Jogou = j.atacar(l,c,1,0);
            }while (!j2Jogou);
            if(j.getJogadores().getFirst().getPontos()>=20){
                System.out.println("Jogador 1 encontrou todos os tesouros.");
                System.out.println("Resultado:");
                System.out.println("Jogador 1: "+j.getJogadores().getFirst().getPontos()+" Jogador 2: "+j.getJogadores().getLast().getPontos());
                return;
            }else if(j.getJogadores().getLast().getPontos()>=20){
                System.out.println("Jogador 2 encontrou todos os tesouros.");
                System.out.println("Resultado:");
                System.out.println("Jogador 1: "+j.getJogadores().getFirst().getPontos()+" Jogador 2: "+j.getJogadores().getLast().getPontos());

                return;
            }
        }
        System.out.println("\nFim de jogo.");
        if(j.getJogadores().getFirst().getPontos()>j.getJogadores().getLast().getPontos()){
            System.out.println("Após 20 rodadas, o vencedor é: ");
            System.out.println("Jogador 1, com um total de: "+j.getJogadores().getFirst().getPontos()+" pontos.");
        }else if(j.getJogadores().getLast().getPontos()>j.getJogadores().getFirst().getPontos()){
            System.out.println("Após 20 rodadas, o vencedor é: ");
            System.out.println("Jogador 2, com um total de: "+j.getJogadores().getLast().getPontos()+" pontos.");
        }else{
            System.out.println("O jogo terminou empatado, com ambos jogadores terminando com: "+ j.getJogadores().getFirst().getPontos());
        }
    }
}