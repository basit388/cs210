/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial1;
    
public class Q1 {
    public static void main(String[] str) {
        if (str.length < 3) 
        {
            System.out.println("Please provide 3 integer values as command-line arguments.");
            return;
        }

        int value1 = Integer.parseInt(str[0]);
        int value2 = Integer.parseInt(str[1]);
        int value3 = Integer.parseInt(str[2]);

        System.out.println("Value 1: " + value1 + " | Memory Address: " 
                + System.identityHashCode(value1));
        System.out.println("Value 2: " + value2 + " | Memory Address: " 
                + System.identityHashCode(value2));
        System.out.println("Value 3: " + value3 + " | Memory Address: " 
                + System.identityHashCode(value3));
    }
}

