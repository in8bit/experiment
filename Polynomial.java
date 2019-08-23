
/**
 * @author Nidhi Shah
 * CIS 2353
 * Summer 2019
 * prof: John Baugh
 */
public class Polynomial {

    private Node firstNode = null;
    private int nodeCount = 0;

    public Polynomial() {
        firstNode = null;
    }

    public Polynomial(String poly) {
        createMonomialNodes(poly);
    }//end Constructor with one argument

    public Polynomial addPolynomials(Polynomial firstPoly, Polynomial secondPoly) {

        Node walkerA = firstPoly.firstNode;
        Node walkerB = secondPoly.firstNode;
        String newMonomial;
        String result_poly = null;
        int newcoeffcient = 0;
        while (walkerA != null && walkerB != null) {

            if (walkerA.exponent == walkerB.exponent) {
                newcoeffcient = (walkerA.coeffcient + walkerB.coeffcient);
                int expo = walkerA.exponent;
                String newcoef = Integer.toString(newcoeffcient);
                String newexpo = Integer.toString(expo);
                newMonomial = newcoef + "x^" + newexpo;
                if (result_poly == null) {
                    result_poly = newMonomial;
                }//first time when the result_poly will be null, it will be assigned newMonomial.
                result_poly = result_poly.concat(newMonomial);
                walkerA = walkerA.next;
                walkerB = walkerB.next;
            }//addition when exponents are same
            else if (walkerA.exponent > walkerB.exponent) {
                int expo = walkerA.exponent;
                newcoeffcient = walkerA.coeffcient;
                String newcoef = Integer.toString(newcoeffcient);
                String newexpo = Integer.toString(expo);
                newMonomial = newcoef + "x^" + newexpo;
                result_poly = result_poly.concat(newMonomial);
                walkerA = walkerA.next;
            }//end exponenta>exponentB
            else if (walkerB.exponent > walkerA.exponent) {
                int expo = walkerB.exponent;
                newcoeffcient = walkerB.coeffcient;
                String newcoef = Integer.toString(newcoeffcient);
                String newexpo = Integer.toString(expo);
                newMonomial = newcoef + "x^" + newexpo;
                result_poly = result_poly.concat(newMonomial);
                walkerB = walkerB.next;
            }//end exponenta<exponentB

        }//end of while running till both polynomials have nodes.
        while (walkerA != null) {
            int expo = walkerA.exponent;
            /* if (walkerA.exponent == 0) {
                newMonomial = Integer.toString(newcoeffcient);
                } else {*/
            newcoeffcient = walkerA.coeffcient;
            String newcoef = Integer.toString(newcoeffcient);
            String newexpo = Integer.toString(expo);
            newMonomial = newcoef + "x^" + newexpo;
            result_poly = result_poly.concat(newMonomial);
            walkerA = walkerA.next;
        }
        while (walkerB != null) {
            int expo = walkerB.exponent;
            /* if (walkerB.exponent == 0) {
                newMonomial = Integer.toString(newcoeffcient);
                } else {*/
            newcoeffcient = walkerB.coeffcient;
            String newcoef = Integer.toString(newcoeffcient);
            String newexpo = Integer.toString(expo);
            newMonomial = newcoef + "x^" + newexpo;
            result_poly = result_poly.concat(newMonomial);
            walkerB = walkerB.next;

        }
        Polynomial result = new Polynomial(result_poly);
        return result;

    }//end addPolynomials

    public void createMonomialNodes(String p) {
        String coef;
        String exp;
        int coeffcient = 0;
        int exponent = 0;
        String[] monomialArray;

        //creating an array of monomials
        String[] monomial = p.split("\\+");

        for (int i = 0; i < monomial.length; i++) {
            //getting each monomial from the array
            String mono = monomial[i];
            //has both "x" and "^"
            if (mono.contains("x") && mono.contains("^")) {
                monomialArray = mono.split("x");
                coef = monomialArray[0];
                coeffcient = Integer.parseInt(coef);
                String s2 = monomialArray[1];
                exp = s2.substring(1);
                exponent = Integer.parseInt(exp);
            }//end if checking has both "x" and "^"
            //case constant.
            else if (!mono.contains("x") && !mono.contains("^")) {
                coeffcient = Integer.parseInt(mono);
                exponent = 0;
            }//end case constant
            //case abcx
            else if (mono.contains("x") && mono.length() > 1 && !mono.contains("^")) {
                monomialArray = mono.split("x");
                coef = monomialArray[0];
                coeffcient = Integer.parseInt(coef);
                exponent = 1;
            }//end case abcx
            addNode(coeffcient, exponent);
            nodeCount++;
        }//end for loop that gets one monomial from array of monomials
    }

    public void addNode(int coeffcient, int exponent) {

        Node newNode = new Node(coeffcient, exponent, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            //walk down the chain until you're at end
            //add the new node to the end
            Node previous = null;
            Node walker = firstNode;
            while (walker != null) {
                previous = walker;
                walker = walker.next;
            }//end while
            if (previous != null) {
                previous.next = newNode;
            }
        }//end if-else
    }//end add node

    public void print() {
        Node walker = firstNode;
        while (walker != null) {
            System.out.println(walker);
            walker = walker.next;
        }//end while
    }//end print

    public boolean isEmpty() {
        return firstNode == null;
    }//end isEmpty

    private class Node {

        private int exponent;
        private int coeffcient;
        private Node next;

        public Node(int exponent,
                int coeffcient,
                Node next) {
            this.next = next;
            this.exponent = exponent;
            this.coeffcient = coeffcient;
        }//end node constructor

    }//end node private class

}//end class-polynomial
