package datastructures.pluralsight;

public class BasicLinkedList<X> {
  private Node first;
  private Node last;
  private int nodeCount;
  
  public BasicLinkedList() {
	  first = null;
	  last = null;
	  nodeCount=0;
  }
  
	public void add(X item)
	{//this condition means we are adding something for the first time
		if(first == null)
		{
			first =new Node(item);
			last = first;
			
		}//otherwise grab the last node and update the value
		else
		{
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;	
		}
		nodeCount++;
	}
	
	public X remove()
	{
		if(first == null)
		{
			//throw error list is mepty
			throw new IllegalStateException("The linkedlist is empty and there are no items to remove");

		} //now update the first pointer and return the old first
		X  nodeItem = first.getNodeItem();
		first = first.getNextNode();
		nodeCount--;
		return nodeItem;	
	}
	public int size()
	{
		return nodeCount;
	}

	public void insert(X item, int position)
	{
		if(size() < position)
		{
			throw new IllegalStateException("The linkedlist is smaller than the position");
		}
		Node currentNode = first;
		//starting at 1 beacuse we are already on the first node
		for(int i=1; i< position && currentNode!=null;i++)
		{
			currentNode =currentNode.getNextNode();
		}
		//severs the link chain and reconnects with the new node
		Node newNode = new Node(item);
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
	}
	
	public X removeAt(int position)
	{
		if(first == null)
		{
			//throw error list is mepty
			throw new IllegalStateException("The linkedlist is empty and there are no items to remove");
		}
		Node currentNode =first;
		Node prevNode = first;
		//starting at 1 beacuse we are already on the first node
		for(int i=1; i< position && currentNode!=null;i++)
		{
			prevNode= currentNode;
			currentNode =currentNode.getNextNode();
		}
		//now update the pointers and return the item;
		X nodeItem = currentNode.getNodeItem();
		prevNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return nodeItem;
	}

	public X get(int position)
	{
			if(first == null)
			{
				//throw error list is mepty
				throw new IllegalStateException("The linkedlist is empty and there are no items to get");
			}
			Node currentNode = first;
			for(int i =1; i<size() && currentNode != null; i++)
			{
				if(i == position)
				{
					return currentNode.getNodeItem();
				}
				currentNode = currentNode.getNextNode();
			}
			//if we didnt find then return null
			return null;
	}
		public int find(X item)
		{
			if(first == null)
			{
				//throw error list is mepty
				throw new IllegalStateException("The linkedlist is empty and there are no items to find");
			}
			Node currentNode = first;
			for(int i =1; i<size() && currentNode != null; i++)
			{
				if(currentNode.getNodeItem().equals(item))
				{
					return i;
				}
				currentNode = currentNode.getNextNode();
			}
			//if we didnt find then return -1
			return -1;
		}
		
		//useful for pretty print
		public String toString()
		{
			StringBuffer contents= new StringBuffer();
			Node currNode = first;
			while(currNode != null)
			{
				contents.append(currNode.getNodeItem());
				currNode = currNode.getNextNode();
				
				if(currNode != null)
				{
					contents.append(" , ");
				}
			}
			return contents.toString();
		}

	
  private class Node  {
	  private Node nextNode;
	  private X nodeItem;
	  
	  public Node(X item) {
		  this.nextNode = null;
		  this.nodeItem = item;
		  
	  }
	  
	  public void setNextNode(Node nextNode) {
		  this.nextNode = nextNode;
	  }
	  
	  public Node getNextNode()
	  {
		  return nextNode;
	  }
	  
	  public X getNodeItem() {
		  return nodeItem;
	  }
  }
  
  
  
}
