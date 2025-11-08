public class Tabuleiro {
    private int[][] vet;

    // Constructor do Tabuleiro que atribui em todas as suas casas o valor 0.
    Tabuleiro(){
        this.vet = new int[10][10];
        for(int i = 0; i<this.vet.length;i++){
            this.vet[i] = new int[10];
            for(int j = 0; j<this.vet[i].length;j++){
                this.vet[i][j] = 0;
            }
        }
    }
    // Retorna um valor de uma casa específica do vetor.
    public int getVetByIndex(int l, int c){
        return this.vet[l][c];
    }
    // Seta o valor de uma casa específica do veto.
    public void setVetByIndex(int l, int c, int v){
        this.vet[l][c] = v;
    }
}
