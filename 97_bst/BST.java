/**
Team BrainForked: Gloria Lee, Jack Chen, Kevin Cheng
APCS pd08
HW97: Prune Your Tree
2022-05-11r
time spent: 1 hrs
 * class BST
 * v2:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
   * void insert( int )
   * Adds a new data element to tree.
   */
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()


  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~
  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null )
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  public String inOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += inOrderTravStr( currNode.getLeft() );
    retStr += " " + currNode.getValue();
    retStr += inOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String preOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += " " + currNode.getValue();
    retStr += preOrderTravStr( currNode.getLeft() );
    retStr += preOrderTravStr( currNode.getRight() );
    return retStr;
  }
  public String postOrderTravStr( TreeNode currNode ) {
    String retStr = "";
    if ( currNode == null )
      return retStr;
    retStr += postOrderTravStr( currNode.getLeft() );
    retStr += postOrderTravStr( currNode.getRight() );
    retStr += " " + currNode.getValue();
    return retStr;
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //~~~~~~~~~~~~~v~~MISC.HELPERS~~v~~~~~~~~~~~~~~~~~~~
  public boolean isLeaf( TreeNode node )
  {
    return ( node.getLeft() == null
             &&
             node.getRight() == null );
  }
  //~~~~~~~~~~~~~^~~MISC.HELPERS~~^~~~~~~~~~~~~~~~~~~~


  //overridden toString
  public String toString()
  {
    return
      " pre-order trav:" + preOrderTravStr( _root ) + '\n' +
      "  in-order trav:" + inOrderTravStr( _root ) + '\n' +
      "post-order trav:" + postOrderTravStr( _root ) + '\n' +
      "         height: " + height() + '\n' +
      "     num leaves: " + numLeaves() 
      ;
  }


  /**
   * TreeNode search(int)
   * returns pointer to node containing target,
   * or null if target not found
   */
  TreeNode search( int target )
  {
    return search( target, _root );
  }
  TreeNode search( int target, TreeNode currNode )
  {
    if ( currNode==null || currNode.getValue()==target )
      return currNode;
    else if ( target < currNode.getValue() )
      return search( target, currNode.getLeft() );
    else if ( target > currNode.getValue() )
      return search( target, currNode.getRight() );
    else
      return null; //to get past compiler
  }


  /**
   * int height()
   * returns height of this tree (length of longest leaf-to-root path)
   * eg: a 1-node tree has height 0
   */
  public int height()
  {
    return height( _root );
  }
  //recursive helper for height()
  public int height( TreeNode currNode )
  {
    if ( currNode==null ) //Q: Why cannot use .equals() ?
      return 0;
    if ( isLeaf(currNode) )
      return 0;
    else //height is 1 for this node + height of deepest subtree
      return 1 + Math.max( height(currNode.getLeft()),
                           height(currNode.getRight()) );
  }


  /**
   * int numLeaves()
   * returns number of leaves in tree
   */
  public int numLeaves()
  {
    return numLeaves( _root );
  }
  
  
  /*
  ALGORITHM
  - Base cases are a node with no children or one child
  - To remove a node with two children, traverse tree until
    the greatest node on the left subtree is found. 
    Replace the root node's value with that greatest value.
  - If said greatest node has a left child, replace that greatest node's value 
    with the child's value
  
  */
  
  public int numLeaves( TreeNode currNode ) {
    int foo = 0;
    if ( currNode == null )
      return 0;
    foo += numLeaves( currNode.getLeft() );
    if ( isLeaf(currNode) )
      foo++;
    foo += numLeaves( currNode.getRight() );
    return foo;
  }

public void remove(int target){
  if ( search(target) != null )
    remove(this.search(target));
  else
    System.out.println("Target not in tree");
}
public void remove(TreeNode node) {
  //Case where the node we're removing is a leaf, no children
  if ( node.getLeft() == null && node.getRight() == null )
    node = null;
  
  else {
    //back will represent front's parent
    TreeNode back = node; 
    //Case where there's no subtree on the left 
    if ( back.getLeft() == null ) {
      TreeNode front = back.getRight();
      //Walk front and back down to the node we want to replace "target" with
      while ( front.getLeft() != null ) {
        front = front.getLeft();
        back = back.getLeft();
      }
      //Replace target
      node.setValue( front.getValue() );
      //Shift the branch into what replaced target
      //(because the smallest of the right subtree would have no left subtree)
      //if there's no branch, replaces with null instead
      front = front.getRight();
      back.setLeft( front );
      front = null;
    }
    //mirrored for when there's a left subtree
    else {
      TreeNode front = back.getLeft();
      while ( front.getRight() != null ) {
        front = front.getRight();
        back = back.getRight();
      }
      node.setValue( front.getValue() );
      front = front.getRight();
      back.setRight( front );
    }
  }
  
}
// public void remove(int a){
//   remove(this.search(a));
// }
// public boolean remove(TreeNode node){
//   if ( node.getLeft() == null && node.getRight() == null ){
//     node = null;
//     return true;
//   } // no childs
//   else if(node.getLeft()==null && node.getRight() != null){
//     node = node.getRight();
//     return true;
//   else if(node.getRight() == null && node.getLeft() != null){
//     node = null.getLeft();
//     return true;
//   } // one child
//   else{
//     // while(node.getRight()!=null){
//     //   node = node.getRight();
//     // }
//     TreeNode theOG = node;
// 
//     node.setValue(node.getLeft());
//     return remove(node.getLeft());
//   }
// }

// public TreeNode findMin(Treenode node) {
//   if (node.getLeft() == null) {
//     return node; 
//   }
//   else {
//     return findMin(node.getLeft()); 
//     return findMin(node.getRight());
//   } 
// }

  //main method for testing
  public static void main( String[] args ) {

	BST arbol = new BST();

	System.out.println( "tree init'd: " + arbol );

	//inserting in this order will build a perfect tree
	arbol.insert( 3 );
	arbol.insert( 1 );
	arbol.insert( 0 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 4 );
	arbol.insert( 6 );
	/*
	*/

	//insering in this order will build a linked list to left
	/*
	arbol.insert( 6 );
	arbol.insert( 5 );
	arbol.insert( 3 );
	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 1 );
	arbol.insert( 0 );
	*/

	System.out.println( "tree after insertions:\n" + arbol );
	System.out.println();

	System.out.println();
	for( int i=-1; i<8; i++ ) {
	    System.out.println(" searching for "+i+": " + arbol.search(i) );    
	}

	System.out.println();
	System.out.println( arbol );

	arbol.remove(6);
	System.out.println();
	System.out.println( "remove 6 "+arbol );

	arbol.remove(5);
	System.out.println();
	System.out.println("remove 5 "+ arbol );

	arbol.remove(4);
	System.out.println();
	System.out.println("remove 4 "+ arbol );

	arbol.remove(3);
	System.out.println();
	System.out.println( "remove 3" + arbol );

	arbol.remove(2);
	System.out.println();
	System.out.println(  "remove 2" + arbol );

	arbol.remove(1);
	System.out.println();
	System.out.println( "remove 1" + arbol );

	arbol.remove(0);
	System.out.println();
	System.out.println( "remove 0" + arbol );
}

}//end class
