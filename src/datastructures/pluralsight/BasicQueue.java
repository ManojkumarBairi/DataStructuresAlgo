package datastructures.pluralsight;

public class BasicQueue<X> {
  private X[] data;
  private int front;
  private int end;
  
  public BasicQueue() {
	  // data = (X[]) new Object[1000];
	  this(1000);
  }
  
  public BasicQueue(int size) {
	  data = (X[]) new Object[size];
	  this.front = -1;
	  this.end = -1;
  }
  
  public int size() {
	  if(front == -1 && end == -1) {
		  return 0;
	  }
	  //otherwise we add one get the inclusize substraction value rather than excluding
	  else {
		  return this.end - this.front+1;
	  }
  }
  
  public void enQueue(X item) {
	  //first see if the queue is full
	  if((end + 1) % data.length  == front) {
		  throw new IllegalStateException("The Queue is full");
	  } else if (size() == 0) {
		  //otherwise check to see if any items have been added
		  // to the queue yet
		  front++;
		  end++;
		  data[end] = item;
	  } else {
		  //otherwise add the item to the end of the queue
		  end++;
		  data[end] = item;
	  }
  }
  
  public X deQueue() {
	  X item = null;
	  // if the queue is empty we cannot dequeue anything
	  if(size() == 0) {
		  throw new IllegalStateException("Cant dequeue because teh queue is empty");
	  } else if (front == end){
		  // if this is the last time in queue then the queue needs to be reset to be empty
		  item = data[front];
		  data[front] = null;
		  front = -1;
		  end = -1;
		  
	  } else {
		  //otherwise grab the front of teh queue return it and adjust teh front prontier
		  item = data[front];
		  data[front] = null;
		  front++;
	  }
	  return item;
	  
  }
  
  public boolean contains(X item) {
	  boolean found = false;
	  //if the queue is empty return false;
	  if(size() == 0) {
		  return found;
	  }
	  for(int i=front; i <end; i++) {
		  if(data[i].equals(item)) {
			  found = true;
			  break;
		  }
	  }
	  return found;
  }
  
	 public X access(int position)
	 {
		 if(size() == 0 || position> size())
		 {
			 throw new IllegalArgumentException("NO items in the queue or the position is greater than the size of the queue");
		 }
		 int trueIndex =0;
		 for(int i = front;i< end ;i++)
		 {
			 if(trueIndex == position)
			 {
			 return data[i];
			 }
			 trueIndex++;
		 }
		 //if we didnt find the item throw an exception
		 throw new IllegalArgumentException("Could not get queue item at position " +position);
	 }

}
