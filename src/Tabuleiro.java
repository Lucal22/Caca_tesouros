public class Tabuleiro {
    private int[][] vet;

    Tabuleiro(){
        this.vet = new int[10][10];
        for(int i = 0; i<this.vet.length;i++){
            this.vet[i] = new int[10];
            for(int j = 0; j<this.vet[i].length;j++){
                this.vet[i][j] = 0;
            }
        }
    }
    public int getVetByIndex(int l, int c){
        return this.vet[l][c];
    }
    public void setVetByIndex(int l, int c, int v){
        this.vet[l][c] = v;
    }
}
