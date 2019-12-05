package Classes;

public class roc {

    public static int[][] calcule(int[][] mat,int[]tab,int[]tab2){
        for (int i = 0; i <5 ; i++) {

                mat[i][0]=0;

        }
        for (int i = 0; i <131 ; i++) {
                mat[0][i]=0;

        }
        for (int i = 1; i <5 ; i++) {
            for (int j = 1; j <131 ; j++) {

                if(tab2[i]>j){
                    mat[i][j]=mat[i-1][j];
                }else{
                    mat[i][j] = Math.max(mat[i][j-1],(mat[i-1][Math.abs(j-tab2[i])]+tab[i]));
                }


            }

        }
        return mat;
    }



    public static void main(String[] args) {
        int [][] mat = new int[5][131];
        int [] tab = new int[]{0,4,5,6,2};
        int [] tab2 = new int[]{0,33,49,60,32};
        calcule(mat,tab,tab2);
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <131 ; j++) {

                System.out.print(mat[i][j]+"  ");
            }
            System.out.print("\n");
        }

    }
}
