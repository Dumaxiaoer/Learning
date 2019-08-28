package com.yangcc.recursion;
// 迷宫
public class MiGoing {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int [] [] map =new int [8][7];
        // 使用1表示墙
        // 先把上下左右全部置为1
        for (int i =0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        // 左右置为空
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        // 设置相应的挡板
        map[3][1]=1;
        map[3][2]=1;

        // 输出地图
        System.out.println("当前地图情况");
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.printf(map[i][j]+"  ");
            }
            System.out.println();
        }
        // 使用递归回溯给小球招录
        //setWay(map,1,1);
        setWay2(map,1,1);
        // 输出新地图
        System.out.println("新地图情况");
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.printf(map[i][j]+"  ");
            }
            System.out.println();
        }

    }
    // 使用递归回溯来给小球找路

    /**
     *
     * @param map 表示地图
     * @param i 表示从哪个位置开始找
     * @param j   同j
     * @return  如果找到通路则返回true，否则返回false
     * 1.如果小球能到map[6][5]   则说明找到通路
     * 2.约定  当map[i][j] 为0时，表示该点还没走过，为1 表示墙， 2表示可以走  ，为3表示该位置已经走过，但走不通
     * 3.在走迷宫时，需要确定一个策略（方法），该方法为  下->右->上->左，如果该点走不通，再回溯
     */
    public static  boolean setWay(int [][] map,int i,int j){
        if (map[6][5]==2){  // 通路找到
            return  true;
        }else{
            // 当前点还没走过
            if (map[i][j]==0){
                // 按照策略走
                map[i][j]=2;// 假定该点可以走通
                // 继续探测
                if (setWay(map,i+1,j)){ // 向下走
                    return  true;
                }else if (setWay(map,i,j+1)){ // 向右走
                    return true;
                }else if (setWay(map,i-1,j)){ // 上
                    return true;
                }else if (setWay(map,i,j-1)){ //左
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j]=3;
                    return false;
                }
            }else{  // 不等于0  可能是 1  2 3
                return false;
            }
        }
    }
    // 改变策略，上  右  下  左
    public static  boolean setWay2(int [][] map,int i,int j){
        if (map[6][5]==2){  // 通路找到
            return  true;
        }else{
            // 当前点还没走过
            if (map[i][j]==0){
                // 按照策略走
                map[i][j]=2;// 假定该点可以走通
                // 继续探测
                if (setWay2(map,i-1,j)){ // 向上走
                    return  true;
                }else if (setWay2(map,i,j+1)){ // 向右走
                    return true;
                }else if (setWay2(map,i+1,j)){ // 下
                    return true;
                }else if (setWay2(map,i,j-1)){ //左
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j]=3;
                    return false;
                }
            }else{  // 不等于0  可能是 1  2 3
                return false;
            }
        }
    }


}
