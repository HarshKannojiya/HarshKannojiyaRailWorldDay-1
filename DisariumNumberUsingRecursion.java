import java.io.*;
class DisariumNumberUsingRecursion{
    private int num;
    private int size;
    public DisariumNumberUsingRecursion(int n){
        num = n;
        size = 0;
    }



    void countDigit(){
        for(int i = num; i != 0; i /= 10)
            size++;
    }
    public int sumOfDigits(int n, int p){
        if(n < 10)
            return (int)Math.pow(n, p);
        else{
            int t = (int)Math.pow(n % 10, p);
            return t + sumOfDigits(n / 10, --p);
        }
    }



    public void check(){
        if(num == sumOfDigits(num, size))
            System.out.println(num + " is a Disarium Number.");
        else
            System.out.println(num + " is not a Disarium Number.");
    }
    public static void main(String args[])
            throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.print("Number: ");
        int n = Integer.parseInt(br.readLine());
        DisariumNumberUsingRecursion obj = new DisariumNumberUsingRecursion(n);
        obj.countDigit();
        obj.check();
    }
}


