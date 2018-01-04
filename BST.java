//Ian Riaf
//March 29th
//BST Tree Class
//Program 4
//The Program will implament a binary search tree
//using linked nodes

public class BST{
        private Node root;

        public BST(){ 
                root=null;
        }


        public void insert(Node p){// calling the function 
		//of insert r
                if(root == null){
                        root = p;
                }
                else{
                        insertr(root, p);
                }
        }
	//recusive function for insert
        public void insertr(Node t, Node p){ 
		//insert method will return the node t as p will
		//serve as the pointer.
		//p will be given a certain location
		
		
                if (p.getKey()<t.getKey()){
			
                        if(t.getLeft()==null){
				
                                t.setLeft(p);//setting the child with p
                        }
                        else{
                                insertr(t.getLeft(),p); 
                        }
                }
                else{ 
                        if (t.getRight()==null){ 
                                t.setRight(p);
                        }
                        else{
				
                                insertr(t.getRight(),p);//only instance left
				//can be to set right
                        }
                }

        }

        public void traverse(){ //traverse method will print T
		//in the order
                traverser(root);
                System.out.println();
        }
	//recursive function for traverse 
        public void traverser(Node t){
                if (t!=null){//if Node t is equal to something then find 
			//the left using the key then print out the key value
			
                        traverser(t.getLeft());
                        System.out.print(t.getKey());
                        traverser(t.getRight());

                }
                else{
                        System.out.print(" "); //if it is nothing then print empty string
                }

        }


        public Node search(int key){ //calling searchr recursive function
                return searchr(root, key);
        }
	//recursive function for search
        public Node searchr(Node t,int key){
                if (t==null){ 
                        return null;
                }
                else if(key==t.getKey()){
                        return t;
                }
                else if(key<t.getKey()){// if the key value is less than
			//what is in node t
                        return searchr(t.getLeft(),key);//call search to find
			//the value to the left 
                }
                else{//must be greater 
                        return searchr(t.getRight(),key);
                }

        }

        public void delete(Node x){//delete method will
		//return the node pointed by the pointer to the tree itself
                if (x==root){
                        root=deleter(x);
                }
                else{
                        deleter2(root,x);
                }
        }
	//recursive function for delete 
        public Node deleter(Node x){ //instnace if there are no children 
                if (x.getLeft()== null && x.getRight()==null){
                        return null;
                }
                else if(x.getRight()==null){ //if right is = to nothing
			//set the left one as null then return it
                        Node temp =x.getLeft();
                        x.setLeft(null);
                        return temp;
                }
                else if(x.getLeft()==null){ //same idea but for the right
                        Node temp =x.getRight();
                        x.setRight(null);
                        return temp;
                }
                else{//find the sucsessor that we will call from sucsesor function
                        Node s =successor(x);
                        delete(s); //call to delete
			
                        s.setLeft(x.getLeft());
                        s.setRight(x.getRight());
			
                        x.setLeft(null);
			
                        x.setRight(null);
                        return s;
                }
        }
        

        public void deleter2(Node w,Node x){//if the Node has children
                if(x==w.getLeft()){
			//reusivly call deleter on node X if we are to the left or right
                        w.setLeft(deleter(x));
                }
                else if (x==w.getRight()){ //if we are to the right delete Node x
			//larger
                        w.setRight(deleter(x)); 
                }
                else if(x.getKey()<w.getKey()){// if we are to the left 
			//smaller
                        deleter2(w.getLeft(),x);
                }
                else{
                        deleter2(w.getRight(),x);
                }
        }
	

        public Node successor(Node sr){ //method to find the sucessor 
		//for the child node
		
                Node temp=sr.getRight();//go right once
		
                while(temp.getLeft()!=null){//then keep going left until 
			//there is an end
			
                        temp=temp.getLeft();
                }
                return temp;
        }
	
	   public void printTree() {
                printTree2(root);
                System.out.println();
        }
	public boolean isEmptyTree(){//method to check if the tree is empty
		
                return root == null;
        }

	
	//code provided for method to print the tree
        private void printTree2(Node tree) {
                if (tree != null) {
                System.out.print(tree.getKey() + " ");
            if (tree.getLeft() != null)
                        System.out.print("Left: " + tree.getLeft().getKey() + " ");
            else
                System.out.print("Left: null ");
            if (tree.getRight() != null)
                        System.out.println("Right: " + tree.getRight().getKey() + " ");
            else
                System.out.println("Right: null ");
                printTree2(tree.getLeft());
                printTree2(tree.getRight());
                }
        }
}

