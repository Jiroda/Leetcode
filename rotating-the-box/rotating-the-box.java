//T:O(m*n)
//S:O(m*n)
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        //move the boxes to the right assuming the gravity is action to the right
        for(int i=0; i<m; i++){
            int empty = n-1;
            for(int j=n-1; j>=0;j--){
                if(box[i][j]=='*'){
                    empty = j-1;
                }
                if(box[i][j]=='#'){
                    box[i][j]='.';
                    box[i][empty] = '#';
                    empty--;
                }
            }
        }
        //transpose the matrix
        char[][] box2 = new char[n][m];
        for(int i=0; i<m; i++){
            for(int j=n-1; j>=0;j--){
                box2[j][m-1-i]= box[i][j];
            }
        }
        return box2;
    }
}