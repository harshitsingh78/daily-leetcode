class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 ){
            return false;
        }
        int num = x;
        int rev=0;
        while(num>0){
            int remm = num%10;
            rev= rev*10+remm;
            num=num/10;
        }

        return rev == x;
        
    }
}