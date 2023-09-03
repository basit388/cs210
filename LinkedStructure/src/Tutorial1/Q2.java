package Tutorial1;
import java.util.Scanner;
public class Q2 
{
    public static void main(String [] str)
    {
        //check size of prompt
        if(str.length<6)
        {   
            System.out.println("Error; use proper prompt");
            return;
        }
        //Scanner scanner = new Scanner(System.in);

        //reading input from console command prompt
     
        Node O1 = new Node();
        Node O2 = new Node();
        Node O3 = new Node();
        int age1, age2, age3;
        String name1, name2, name3;
        
        /*
        s[0] should have age1
        s[1] should have name1
        .
        .
        */
        
        age1 = Integer.parseInt(str[0]);
        name1 = str[1];
        age2 = Integer.parseInt(str[2]);
        name2 = str[3];
        age3 = Integer.parseInt(str[4]);
        name3 = str[5];
                
        O1.setAge(age1);
        O1.setName(name1);
        O2.setAge(age2);
        O2.setName(name2);
        O3.setAge(age3);
        O3.setName(name3);        

        System.out.println("O1 memory address: " + O1);
        System.out.println("O1 - Age: " + O1.getAge() + ", Name: " + O1.getName());

        System.out.println("O2 memory address: " + O2);
        System.out.println("O2 - Age: " + O2.getAge() + ", Name: " + O2.getName());

        System.out.println("O3 memory address: " + O3);
        System.out.println("O3 - Age: " + O3.getAge() + ", Name: " + O3.getName());
    }
}