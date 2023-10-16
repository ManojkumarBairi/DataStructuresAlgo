package datastructures.stack.reversestring;

public class StackX {
private int maxSize;  //size of stack array
private long[] stackArray;
private int top;    //top of stack

public StackX(int s) {
	maxSize = s; // set array size
	stackArray = new long[maxSize]; //create array
	top = -1;   // no items yet
}

public void push (long j) { // put item on top of stack
	stackArray[++top] = j;  // increment top, insert item
}

public long pop() {   // take item from teh top of stack
	return stackArray[top--];  // access item, decrement top
}

public long peek() {   // peek top of stack
	return stackArray[top];
}
public boolean isEmpty() {   // true if stack is empty
	return (top == -1);
}

public boolean isFull() {   // true if satck is full
	return (top == maxSize -1);
}
}
