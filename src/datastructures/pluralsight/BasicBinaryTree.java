package datastructures.pluralsight;

public class BasicBinaryTree<X extends Comparable<X>> {
private Node root;
private int size;

public BasicBinaryTree()
{
	root = null;
}
public int size()
{
	return size;
}

public void add(X item) {
	Node node = new Node(item);
	
	//If this is the first item in the tree, set it as root
	if(root == null) {
		this.root = node;
		System.out.println("Set root : "+ node.getItem());
		size++;
	} else
	{//otheriwse we need to insert the item into the tree using the binary tree insert algorithm
		insert(this.root, node);
	}
}

public boolean contains(X item)
{
	Node currentNode = getNode(item);
	if(currentNode == null)//didnt find it
	{
		return false;
	} else
	{
		return true;
	}
}

public boolean delete(X item) {
	boolean deleted = false;
	//make sure the root isnt null meaning the tree is empty
	if(this.root == null)
	{
		return false;
	}
	//find the node to delete
	Node currentNode = getNode(item);
	
	if(currentNode != null)
	{
		//if the node to delete doesnt have any children, just delete it
		if(currentNode.getLeft() == null && currentNode.getRight() == null)
		{
			unlink(currentNode, null);
			deleted =true;
		}
		//if te node to be deleted has only right child, remove it in the hierarchy
		else if(currentNode.getLeft() == null && currentNode.getRight() != null)
		{
			unlink(currentNode, currentNode.getRight());
			deleted =true;
		}	//if te node to be deleted has only left child, remove it in the hierarchy
		else if(currentNode.getLeft() != null && currentNode.getRight() == null)
		{
			unlink(currentNode, currentNode.getLeft());
			deleted =true;
		}
		//the node has both children, do a node swap to delete
		else
		{
			//you can swap out the nodewith the rightmost leaf nodeon the left side
			Node child= currentNode.getLeft();
			while(child.getLeft() != null && child.getRight() != null)
			{
				child = child.getRight();
			}
			
			//we have the right most leaf node, We can repalce the current nodewith thisnode
			//remove the leaf ndoe from its current position
			child.getParent().setRight(null);
			
			child.setLeft(currentNode.getLeft());
			child.setRight(currentNode.getRight());
			
			unlink(currentNode, child);
			deleted =true;
		}
	}
	
	if(deleted)	{
		this.size--;
	}
	
	return deleted;
}

private void unlink(Node currentNode, Node newNode)
{
	//If this is the root node, we replace that a little differnety
	if(currentNode == this.root)
	{
		newNode.setLeft(currentNode.getLeft());
		newNode.setRight(currentNode.getRight());
		this.root = newNode;
	} else if (currentNode.getParent().getRight() == currentNode)
	{
		currentNode.getParent().setRight(newNode);
	} else
	{
		currentNode.getParent().setLeft(newNode);
	}
}
private Node getNode(X item)
{
	Node currentNode = this.root;
	while(currentNode != null)
	{
		int value = item.compareTo(currentNode.getItem());
		//see if the ndoe is a match
		if(value == 0)
		{
			return currentNode;
		} 
		else if(value < 0)///if less than zero go to left sze
		{
		  currentNode = currentNode.getLeft();
		}
		else//otherwise go to right side
		{
			 currentNode = currentNode.getRight();
		}
	}
	return null;
}
private void insert(Node parent, Node child) {
	//if teh child is less than the parent, it goes on the left
	if(child.getItem().compareTo(parent.getItem()) < 0)
	{
		//if the left node is null then we have found our spot
		if(parent.getLeft() == null)
		{
			parent.setLeft(child);
			child.setParent(parent);
			size++;
		} else //otheriwse we need to call insert again for the left or right recusion
		{
			insert(parent.getLeft(), child);
		}
		
	} else if(child.getItem().compareTo(parent.getItem()) > 0)
	{
		//if the right node is null then we have found our spot
		if(parent.getRight() == null)
		{
			parent.setRight(child);
			child.setParent(parent);
			size++;
		} else //otheriwse we need to call insert again for the left or right recusion
		{
			insert(parent.getRight(), child);
		}
	}
	//f the parent and child are equal we dont have to do anything
	//data ina a binary tree is assumed to be unique adn teh value already exists in the tree
}

	private class Node
	{
		private Node left;
		private Node right;
		private Node parent;
		private X item;
		
		public Node(X item) {
			this.item = item;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
		}
		public X getItem() {
			return item;
		}
		public void setItem(X item) {
			this.item = item;
		}

	}
}
