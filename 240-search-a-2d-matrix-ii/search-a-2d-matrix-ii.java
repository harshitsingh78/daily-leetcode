class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start =0;
        int end = n-1;
        while(start<m && end >=0 ){
            if(matrix[start][end] == target){
                return true;
            }else if(matrix[start][end]< target){
                start++ ;
            }else if(matrix[start][end] > target){
                end-- ;
            }
        }
        return false;
    }
}