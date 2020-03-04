package com.github.mf.datastructure;

/**
 * 稀疏数组(棋盘存盘、恢复)
 */
public class SparseArrayTest {
    public static void main(String[] args) {
        //1:创建原始数组 11*11，0表示没有棋子，1表示黑子，2表示蓝子
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][4] = 2;

        System.out.println("原始二维数组为：");
        //输出原始二维数组
        for(int[] row:chessArray1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //----------------------------------------------------------
        //2:将二维数组转换为稀疏数组
        //遍历得到非0数据的个数
        int sum = 0;
        for(int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if(chessArray1[i][j]!=0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int sparseArray[][]= new int[sum+1][3];
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        //遍历二维数组，将非0的值存放到sparseArray中
        //count记录是第几个非0数据
        int count = 0 ;
        for(int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if(chessArray1[i][j]!=0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        //System.out.println("sparseArray.length:"+sparseArray.length);
        //输出稀疏数组
        System.out.println("------------------------------------------");
        System.out.println("得到稀疏数组为：");
        for (int i=0;i<sparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }


        System.out.println("+++++++++++++++++++++++++++++++++++稀疏数组恢复为非稀疏+++++++++++++++++++++++++++++++++++");

        //解析稀疏数组内容
        for(int i=0;i<sum+1;i++){
            for(int j=0;j<3;j++){
                System.out.printf("%d\t",sparseArray[i][j]);
            }
            System.out.println();
        }


        System.out.println("新建空二维数组输出：");
        int  chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        //输出新建的空二维数组
        for(int[] row:chessArray2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        for(int i=1;i<sparseArray.length;i++){
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("------------------恢复后的二维数组------------------");
        //输出恢复后的二维数组
        for(int[] row:chessArray2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}