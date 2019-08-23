import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Nidhi Shah
 * CIS 2353
 * Summer 2019
 * prof: John Baugh
 */
public class testPolynomial {
    public static void main(String[] args) {
        Polynomial ans_poly = null;
        File theFile = new File("Polynomials.txt");
        ArrayList<Polynomial> polynomialList = new ArrayList<>();
        int choice=0;
        Scanner input = new Scanner(System.in);
        try {
            Scanner infile = new Scanner(theFile);
            while (infile.hasNext()) {
                //printing out the array list with the index.  
                Polynomial p = new Polynomial(infile.nextLine());
                polynomialList.add(p);
               
            }//end while copying the file to create polynomial objects
            infile.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found, Please check and re-run.");
        }//end try-catch
        
        while (choice != -1){
        System.out.println("List of Polynomials: ");
        for(int i =0;i<polynomialList.size(); i++) {
            Polynomial polys = polynomialList.get(i);
            System.out.println(i +": " + polys);  
        }
        System.out.println();
        System.out.println("Which do you wish to add? Press -1 to exit.");
        choice =input.nextInt();
        while (choice<-1 /*||choice>polynomialList.size()*/ ){
            System.out.println("Invalid entry.Kindly enter any two numbers of the corrosponding polynomilas displayed.");
            choice =input.nextInt(); 
        }//index out of boud check with while for second choice.
        String str_choice = Integer.toString(choice);
        char poly1 = str_choice.charAt(0);
        char poly2 = str_choice.charAt(1);
        int poly_1 =Character.getNumericValue(poly1);
        int poly_2 =Character.getNumericValue(poly2);
           
        //check with which index matches with the chocie entered
        Polynomial polynomial1=null;
        Polynomial polynomial2=null;
        
        for(int i=0; i<polynomialList.size();i++) {
            polynomial1 = polynomialList.get(poly_1);
            polynomial2 = polynomialList.get(poly_2);
        }
       Polynomial temp =ans_poly.addPolynomials(polynomial1, polynomial2);
       polynomialList.add(temp);
        }//end while
    }//end main

}//end testPolynomial
