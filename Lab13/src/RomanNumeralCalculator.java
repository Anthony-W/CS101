import java.util.Scanner;

public class RomanNumeralCalculator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int num;

        do
        {
            System.out.println("Please enter an integer from 1 to 5999. Enter a negative number to exit.");
            System.out.print("-> ");
            num = input.nextInt();

            if (num <= 0) System.exit(0);

            if (num < 6000)
            {
                String roman = "";

                while (num >= 1000)
                {
                    roman += "M";
                    num -= 1000;
                }

                switch (num / 100)
                {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        break;
                    case 4:
                        roman += "CD";
                        num -= 400;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        roman += "D";
                        num -= 500;
                        break;
                    case 9:
                        roman += "CM";
                        num -= 900;
                        break;
                    default:
                        System.err.println("There is a problem with the hundreds place.");
                        
                }
                
                
                while (num >= 100)
                {
                    roman += "C";
                    num -= 100;
                }
                
                switch (num / 10)
                {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        break;
                    case 4:
                        roman += "XL";
                        num -= 40;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        roman += "L";
                        num -= 50;
                        break;
                    case 9:
                        roman += "XC";
                        num -= 90;
                        break;
                    default:
                        System.err.println("There is a problem with the tens place.");
                }

                while (num >= 10)
                {
                    roman += "X";
                    num -= 10;
                }

                switch (num)
                {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        break;
                    case 4:
                        roman += "IV";
                        num -= 4;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        roman += "V";
                        num -= 5;
                        break;
                    case 9:
                        roman += "IX";
                        num -= 9;
                        break;

                    default:
                        System.err.println("There is a problem with the units place.");
                }

                while (num > 0)
                {
                    roman += "I";
                    num--;
                }

                System.out.println(roman);
            }
        }
        while (num < 5999);
    }
}
