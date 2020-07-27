package datastructor;


/*
稀疏数组的转换

 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] chess=createArra(9,9);
        chess[1][2]=1;
        chess[2][4]=2;
        printlnDoubleDimArr(chess);
        int[][] sparseArr=convertDoubleDimArrToSparseArr(chess);
        System.out.println();
        convertSparseArrToNormalArr(sparseArr);

    }

    // 将一个数组转换为稀疏数组
    public static int[][] convertDoubleDimArrToSparseArr(int[][] arr){
        int validateNum=getValidateNum(arr);
        int[][] sparseArr=createArra(validateNum+1,3);
        System.out.println("\n");
        sparseArr[0]=new int[]{arr.length,arr[0].length,validateNum};

        int sparseLineNo=1;
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                int number=arr[i][j];
                if(number!=0){
                    sparseArr[sparseLineNo]=new int[]{i,j,number};
                    sparseLineNo++;
                }
            }
        }
        printlnDoubleDimArr(sparseArr);
        return sparseArr;
    }

    //将稀疏数组转换为正常的数组
    public static int[][] convertSparseArrToNormalArr(int[][] sparseArr){
        int[][] arr=createArra(sparseArr[0][0],sparseArr[0][1]);
        for(int lineNo=1;lineNo<sparseArr.length;lineNo++){
            int rowNo=sparseArr[lineNo][0];
            int cloNo=sparseArr[lineNo][1];
            int number=sparseArr[lineNo][2];
            arr[rowNo][cloNo]=number;
        }
        printlnDoubleDimArr(arr);
        return arr;
    }


    // 获取非0数值的个数
    public static int getValidateNum(int[][] arr){
        int i=0;
        for (int[] line:arr){
            for(int n:line){
                if(n!=0){
                    i++;
                }
            }
        }
        return i;
    }


    // 创建一个二维数组
    public static int[][] createArra(int lineNum,int colNum){
        int[][] arr=new int[lineNum][colNum];
        return arr;
    }


    public static void printlnDoubleDimArr(int[][] chess){
        for(int[] line:chess){
            int j=0;
            for(int i:line){
                j++;
                if(j==line.length){
                    System.out.print(i);
                }else{
                    System.out.print(i+" ");
                }

            }
            System.out.println();
        }
    }


}
