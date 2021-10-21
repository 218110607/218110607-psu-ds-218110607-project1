
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author farias
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
         System.out.println("number 1 :");
        String numberstr1=input.nextLine();
         System.out.println("number 2");
        String numberstr2=input.nextLine();
        BigInt number1= new BigInt(numberstr1);
        BigInt number2= new BigInt(numberstr2);
       
        BigInt number3= number1.add(number2);
       
        BigInt number4= number1.subtract(number2);
        
        int isbigger= number1.compare(number2);

        System.out.println("number1 : "+number1);
        System.out.println("number1 : "+number2);
        System.out.println("add result: "+number3);
        System.out.println("Subtract result : "+number4);
        System.out.println("Compare : "+isbigger);
       
    }
    
}
