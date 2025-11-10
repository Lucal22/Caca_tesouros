public class Tabuleiro {
    private int[][] vetor;

    // Constructor do Tabuleiro que atribui em todas as suas casas o valor 0.
    Tabuleiro(){
        this.vetor = new int[10][10];
        for(int i = 0; i<this.vetor.length;i++){
            this.vetor[i] = new int[10];
            for(int j = 0; j<this.vetor[i].length;j++){
                this.vetor[i][j] = 0;
            }
        }
    }
    // Retorna um valor de uma casa específica do vetor.
    public int getVetByIndex(int linha, int coluna){
        return this.vetor[linha][coluna];
    }
    // Seta o valor de uma casa específica do veto.
    public void setVetByIndex(int linha, int coluna, int valor){
        this.vetor[linha][coluna] = valor;
    }
}
