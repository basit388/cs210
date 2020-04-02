
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

//Basit Qureshi
//April 2, 2020
//CS210


public class Sorts 
{
    public static int [] A;
    public static void main(String [] args)throws IOException
    {
        //[0] InputFileName
        //[1] Sorting algorithm - only allowed values are 0, 1, 2, 3, 4, 5; other than this is Arrays.sort
        //[2] Order - 0 for ascending, 1 for descending
        //[3] OutputFileName
        
        if(args.length!=4)
        {
            System.out.println("Error: Valid input format is:");
            System.out.println("Java -jar Sorts.jar <InputFileName> <Sorting algorithm> <Order> <OutputFileName>");
            System.out.println("InputFileName - AAAAAAAA.txt");
            System.out.println("Sorting Algorithm, accepted values are 0 to 5");
            System.out.println("Order: 0-ascending, 1-descending");
            System.out.println("OutputFileName - AAAAAAAA.txt");
            System.out.println("Try again\n\n");
            return;
        }
        
        //To print the content of args
        /*
        for(int i=0;i<args.length;i++)
            System.out.println(i + " " +args[i]);
        */
        
        //read from inputfile and populate array A
        int [] A = readFile(args[0]);
        
        boolean order = true; // by default 0 - ascending order
        if (Integer.parseInt(args[2])==1) order = false;
        
        //print(A); print to verify input
        
        //call the sort method
        callSort(Integer.parseInt(args[1]), A, order); //true means ascending order; false means descending order
        
        //print(A); print to verify output
        
        //write to file
        writeFile(args[3]);
        
        System.out.println("Quitting...\n\n");
        System.out.println("\n2020 (c) Basit Qureshi\n");
    }
    
    public static int [] readFile(String FileName)throws IOException
    {
        System.out.println("Opening and reading file: " + FileName);
        File F = new File(FileName);
        int c =0;
        Scanner Count = new Scanner(F);
        int [] temp = new int [100000000];
        

        //read from file and write to the array A         
        while(Count.hasNext()){
            temp[c++]=Count.nextInt();
        }
        
        A = new int [c];
        for(int i=0;i<c;i++)
        {
            A[i] = temp [i];
        }
        
        System.out.println("Completed reading file: " + FileName);
        //return new int [] {2,1,5,2,1,6,2,7,1};
        return A;
    }
    
    public static void writeFile(String FileName)throws IOException
    {
        System.out.println("Starting writing to file: " + FileName);
        
        //write to file
        FileWriter fw = new FileWriter(FileName);
	BufferedWriter bw = new BufferedWriter(fw);
	
        for(int i=0;i<A.length;i++)
            bw.write(""+ A[i] + "\n");
        
        bw.close();
        System.out.println("Completed writing file: " + FileName);
        return;        
        
    }   
    
    public static void print(int [] A)
    {
        for(int i=0;i<A.length;i++)
            System.out.print(A[i] + ", ");
        
        System.out.println();
    }
    
    public static void callSort(int i, int [] A, boolean order)
    {
        long t1 ;
        System.out.println("+++++++++++++++++++++++++++++++++++");
        switch(i)
        {
            case 0: //bubble sort
                System.out.println("Initiating Bubble sort");
                t1 = System.nanoTime();
                new BubbleSort().sort(A,order);
                break;
            case 1: //insertion sort
                System.out.println("Initiating Insertion sort");
                t1 = System.nanoTime();
                new InsertionSort().sort(A,order);
                break;
            case 2: //selection sort
                System.out.println("Initiating Selection sort");
                t1 = System.nanoTime();
                new SelectionSort().sort(A,order);
                break;
            case 3: // heap sort
                System.out.println("Initiating Heap sort");
                t1 = System.nanoTime();
                new HeapSort().sort(A,order);     
                break;
            case 4: // merge sort
                System.out.println("Initiating Merge sort");
                t1 = System.nanoTime();
                new MergeSort().sort(A,order);
                break;
            case 5: // quick sort
                System.out.println("Initiating Quick sort");
                t1 = System.nanoTime();
                new QuickSort().sort(A,order);
                break;
            default: // default sort!
                System.out.println("Initiating Arrays.sort");
                t1 = System.nanoTime();

                Arrays.sort(A);

        }
        
        long t2 = System.nanoTime();
        double time = (t2-t1) / 1000000.0;
        System.out.println("Sort completed in: " + time + " seconds");
        System.out.println("+++++++++++++++++++++++++++++++++++");
        
    }
}
