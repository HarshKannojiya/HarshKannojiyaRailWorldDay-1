import java.io.*;
public class ArmstrongNumberUsingRecursion {
    int power(int x, long y)
    {
        if (y == 0)
            return 1;
        if (y % 2 == 0)
            return power(x, y / 2) * power(x, y / 2);
        return x * power(x, y / 2) * power(x, y / 2);
    }


    int cal(int x, int dig)
    {
        if (x == 0)
            return 0;

        int num = x % 10;

        return cal(x / 10, dig) + power(num, dig);
    }


    int cal_digits(int x)
    {
        int dig = 0;

        while (x != 0) {
            dig++;
            x = x / 10;
        }

        return dig;
    }


    public boolean isArmstrong(int x)
    {
        int dig = cal_digits(x);

        if (dig <= 1)
            return true;

        int res = cal(x, dig);

        return res == x;
    }
}


class Armstrong {

    public static void main(String[] args)
    {
        ArmstrongNumberUsingRecursion ob = new ArmstrongNumberUsingRecursion();

        int x = 153;
        System.out.println(x + " : " + ob.isArmstrong(x));

        x = 125;
        System.out.println(x + " : " + ob.isArmstrong(x));
    }
}
