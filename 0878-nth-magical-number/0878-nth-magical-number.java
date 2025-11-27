class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int A = a;
        int B = b;
        long mod = (long)(Math.pow(10,9)+7);
        
        // first  magicalNumber is min(a,b)
        // second magicalNumber is 2*min(a,b)..
        //..
        //..
        // so on , nth magical number uper limit is n*min(a,b)
        // answer lies between [min(a,b)  ,  n*min(a,b)]

        long start = Math.min(a,b);  //not required long type casting because ("2 <= a, b <= 4 * 104")
        long end =(long) n * Math.min(a,b);

        //GCD(gretest common divisor)
        while (B > 0) {
            int tmp = A;
            A = B;
            B = tmp % B;
        }

        //LCM ( a*b = GCD(a,b) * LCM(a,b))
        long lcm = (a*b)/A;

        long mid;
        // normal Binary Search
        while(start<end){
            mid = start + (end - start)/2;

            //no. of element divisible by a or b = (divide by a) + (divide by b) - (divide by both)
            //no. of element divisible by a or b = mid/a + mid/b - mid/lcm(a,b)
            if(mid/a + mid/b - mid/lcm >= n)end = mid;  

            else start = mid+1;
        }
        return (int)(start % mod);
    }
}