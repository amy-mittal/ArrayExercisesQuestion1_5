/********************************************************************
 * Programmer:	Amy Mittal
 * Class:       CS30S-002
 *
 * Assignment:      A1Q1
 * Program Name:    arrayExercisesQ1_5
 *
 * Description:     This program will prompt the user for the number 
 *                  of integers to be entered. The user will then 
 *                  print out the integers in their original and 
 *                  reverse orders.
 *
 * Input:           The numbers of integers to be entered, 
 *                  and the integers to be printed out in 
 *                  their original and reverse orders.
 *
 * Output:          The integers entered by the user in 
 *                  their original and reverse orders.
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 //import java.text.DecimalFormat;
 import java.io.*;

public class arrayExerciseQ1_5 {  // begin class
    
    public static void main(String[] args)throws IOException {  // begin main
    
    // ********* Declaration of Constants **********
    
    // ********** Declaration of Variables **********

        String strin;		// string data input from keyboard
        String strout;		// processed info string to be output
        String windowBanner = "";		// string to print banner to message dialogs

        String prompt;		// prompt for use in input dialogs

        String delim = "[ :]+";	// delimiter string for splitting input string
        String[] tokens;                        // string array for gathering input
        
        String tabSpace = "      ";	// six spaces
        String nl = System.lineSeparator();
        // new line character for file writing
        
        int[] list = new int[100];
//        int[] reverseList = new int[100];
        int actualLength = 0;   // actual length of the array
    	
    // ***** Create Objects *******
    
        //ConsoleReader console = new ConsoleReader(System.in);
        //DecimalFormat df1 = new DecimalFormat("##.###");
        
        //BufferedReader fin = new BufferedReader(new FileReader("demo1Data.txt"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("outFile.txt")));
    	
    // ********** Print Output Banner **********

        printBanner();              // call printBanner method
        fileBanner(fout);           // call fileBanner method
        windowBanner = bannerForWindow();
    	
    // ************************ Get Input **********************

        actualLength = loadList(list, delim);

    // ************************ Processing ***************************
        


    // ************************ Print Output ****************************
    
        System.out.println("Numbers in their original order:");
        printList(actualLength, list);
        
        System.out.println("\nNumbers in reverse order:");
        printReverseList(actualLength, list);
    
    // ******** closing message *********
        
        System.out.println("end of processing.");
        fout.println("end of proecessing");
        
    // ***** Close Streams *****
        
        //fin.close();                // close input buffer stream
        fout.close();               // close output stream
        
    }  // end main
    
    // ************************** static methods ***************************
    /***********************************************************
     *  Purpose:    print array to the console window in reverse order
     *  Interface:  int actualLength --> len: actual length of the list
     *              int[] reverseList --> base address of the array
     *  Returns:    no return
     ************************************************************/
    public static void printReverseList(int len, int[]list){
        for(int i = len -1; i >= 0; i--)
            System.out.println(list[i]);
    } // end printReverseList
    
    /***********************************************************
     *  Purpose:    print array to the console window
     *  Interface:  int actualLength --> len: actual length of the list
     *              int[] list --> base address of the array
     *  Returns:    no return
     ************************************************************/
    public static void printList(int len, int[]list){
        for(int i = 0; i < len; i++)
            System.out.println(list[i]);
        
    } // end printList
    
    /***********************************************************
     *  Purpose:    load an array from the keyboard
     *  Interface:  int[] list --> pointer to the bas address of the array
     *              String delim --> delimiter for split function
     *  Returns:    int len --> actual length of the array
     ************************************************************/
    public static int loadList(int[] list, String delim){
       int len = 0;
       String strin = "";
       
       strin = JOptionPane.showInputDialog("How many numbers do you want to enter?");
       int numberOfIntegersToBeInput = Integer.parseInt(strin);
       
       strin = JOptionPane.showInputDialog("Enter " + numberOfIntegersToBeInput + " integers");
       String[] tokens = strin.split(delim);
       
       len = tokens.length;     // get the acual number of elements in the list
       
       for(int i = 0; i < len; i++){
//           System.out.println(list);
           list[i] = Integer.parseInt(tokens[i]);
       } // end for int i = 0
       
       return len;
    } // end loadList
    
    /***********************************************************
     *  Purpose:    create a banner string
     *  Interface:  no parameters
     *  Returns:    String: bannerOut
     ************************************************************/
    public static String bannerForWindow(){
        String bannerOut = "";
        
        bannerOut = "*******************************************\n";
        bannerOut += "Name:		Amy Mittal\n";
        bannerOut += "Class:		CS30S-002\n";
        bannerOut += "Assignment:	Simple Static Methods Exercise\n";
        bannerOut += "*******************************************\n\n";
        
        return bannerOut;
    } // end bannerForWindow
    
    /***********************************************************
     *  Purpose:    print a banner to the output file
     *  Interface:  PrintWriter fout --> ft
     *  Returns:    no return
     ************************************************************/
    public static void fileBanner(PrintWriter ft){
        ft.println("*******************************************");
        ft.println("Name:		A. Mittal");
        ft.println("Class:		CS30S-002");
        ft.println("Assignment:	Simple Static Methods Exercise");
        ft.println("*******************************************");
    } // end fileBanner
    
    /***********************************************************
     *  Purpose:    print a banner to the console window
     *  Interface:  no parameters
     *  Returns:    no return
     ************************************************************/
    public static void printBanner(){
        System.out.println("*******************************************");
        System.out.println("Name:		A. Mittal");
        System.out.println("Class:		CS30S-002");
        System.out.println("Assignment:	Simple Static Methods Exercise");
        System.out.println("*******************************************");        
    } // end printBanner
}  // end class
