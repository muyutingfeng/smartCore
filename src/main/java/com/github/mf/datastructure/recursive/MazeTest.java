package com.github.mf.datastructure.recursive;

public class MazeTest {
    public static void main(String[] args) {
        //构建迷宫数组
        int[][] maze = new int[8][7];

        //左右被置为1做墙
        for (int row = 0; row < 8; row++) {
            maze[row][0] = 1;
            maze[row][6] = 1;
        }

        //上下被置为1做墙
        for (int col = 0; col < 7; col++) {
            maze[0][col] = 1;
            maze[7][col] = 1;
        }


        //设置挡板
        maze[3][1] = 1;
        maze[3][2] = 1;

        System.out.println("当前迷宫地图为：");
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print(maze[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("------------------------------------");

        //findway(maze, 1, 1);
        findway2(maze, 1, 1);
        System.out.println("寻路迷宫地图为：");
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print(maze[row][col] + " ");
            }
            System.out.println();
        }

    }


    //使用递归回溯来给小球找路
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发 (1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明通路找到.
    //4. 约定: 当 map[i][j] 为 0 表示该点没有走过 当为 1 表示墙 ; 2 表示通路可以走 ; 3 表示该点已经走过，但是走不通
    //5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
    public static boolean findway(int[][] mazeMap, int row, int col) {
        if (mazeMap[6][5] == 2) {
            return true;
        } else {
            if (mazeMap[row][col] == 0) {
                mazeMap[row][col] = 2;
                if (findway(mazeMap, row + 1, col)) {
                    return true;
                } else if (findway(mazeMap, row, col + 1)) {
                    return true;
                } else if (findway(mazeMap, row - 1, col)) {
                    return true;
                } else if (findway(mazeMap, row, col - 1)) {
                    return true;
                } else {
                    mazeMap[row][col] = 3;
                    return false;
                }

            } else {
                return false;
            }
        }
    }


    //通过修改寻路策略来测试路径差异(上->右->下->左)
    public static boolean findway2(int[][] mazeMap, int row, int col) {
        if (mazeMap[6][5] == 2) {
            return true;
        } else {
            if (mazeMap[row][col] == 0) {
                mazeMap[row][col] = 2;
                if (findway2(mazeMap, row - 1, col)) {
                    return true;
                } else if (findway2(mazeMap, row, col + 1)) {
                    return true;
                } else if (findway2(mazeMap, row + 1, col)) {
                    return true;
                } else if (findway2(mazeMap, row, col - 1)) {
                    return true;
                } else {
                    mazeMap[row][col] = 3;
                    return false;
                }

            } else {
                return false;
            }
        }
    }
}


