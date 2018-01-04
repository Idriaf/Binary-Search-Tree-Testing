//Program 1
//Ian Riaf
//Febuary 28th
//Data Structures

//Node 

public class Node {

        private String name; //declare variable types
        private int ssn; //int because ssn is a number
        private Node next;
        private Node left;
        private Node right;

        public Node(String name0, int ssn0){
    //declaring new varaibles to be refernced later on
                name = name0;
                ssn = ssn0;
        }
        public void setnext(Node newNode){ // returns the innital node title
                next= newNode;

        }
        public String getName(){
                return name; //method to get the name
        }
        public int getSSN(){
                return ssn; //method to get the full ssn  within the node
        }

        public void setName(String name0){ // method to return the name
                name=name0;
        }

        public void setSSN(int ssn0){ //method to return the ssn
                ssn=ssn0;
        }

        public Node getRight(){
            return right;
        }
        public Node getLeft(){
            return left;
        }

        public void setRight(Node x){
            right=x;

        }
        public void setLeft(Node x){

            left=x;
        }



        public int getKey(){
                return (ssn%10000); //to find the last four digets of the SSN 5 by 10000
        }

        public void setNext(Node node0){
                next = node0; //set the next Node that will be returned
        }

        public Node getNext(){
                return next; //moves on to the next Node within the series of nodes
        }

}
