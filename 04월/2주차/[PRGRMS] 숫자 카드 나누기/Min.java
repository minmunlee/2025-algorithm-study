class Min {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = arrayA[0];
        int b = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++){
            a = gcd(a, arrayA[i]);
        }
        for(int i = 1; i < arrayB.length; i++){
            b = gcd(b, arrayB[i]);
        }
        
        if(!isDiv(a, arrayB)){
            answer = Math.max(a, answer);
        }
        
        if(!isDiv(b, arrayA)){
            answer = Math.max(b, answer);
        }

        return answer;
    }
    
    public static int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }
        return gcd(b, a % b);
    }
    
    public static boolean isDiv(int a, int[] arr){
        for(int n : arr){
            if(n % a == 0) return true;
        }
        return false;
    }
}