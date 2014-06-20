import java.lang.*;

public class LinkedList <E> {

	private ListNode <E> firstNode;
	
	private ListNode <E> lastNode;
	
	private int numElements;
	
	private String name;
	





	public LinkedList(){
		
		firstNode = null;
		
		lastNode = null;
		
		numElements = 0;
		
		name = "list";
		
	}
	
	
	public LinkedList(String listname){
		
		firstNode = null;
		
		lastNode = null;
		
		numElements = 0;
		
		name = listname;
		
	}
	
	
	public void insertAtFront(E item){
		
		ListNode <E> current = new ListNode(item);
		
		if(numElements == 0){
			
		firstNode = current;
		
		lastNode = firstNode;
		
		numElements ++;
		
		}
		else{
		
		current.setNext(firstNode);
		
		firstNode = current;
		
		numElements ++;
		
		}
		
	}
	
	public void insertAtBack(E item){
		
		ListNode <E> current = new ListNode(item);

		if(numElements == 0){
		
			lastNode = current;
			
			firstNode = lastNode;
			
			numElements ++;
			
		}
		else{

			lastNode.setNext(current);
		
			lastNode = current;
		
			numElements ++;
			
		}
		
	}
	
	
	public E removeFromFront() throws EmptyListException{
		
		E temp = null;

		if(numElements == 0){
			new EmptyListException(name);
		}
		
		if(numElements == 1){
			
			temp = firstNode.getData();
			
			firstNode = null;
			
			lastNode = null;
			
			numElements --;
			
		}
		
		if(numElements >= 2){			
			
			temp = firstNode.getData();

			firstNode = firstNode.getNext();
				
			numElements --;
			
		}		
		
		return temp;
	}
	
	public E removeFromBack() throws EmptyListException{
		
		E temp = null;
		
		if(numElements ==0){
			throw new EmptyListException(name);
		}
		
		if(numElements ==1){
			temp = lastNode.getData();
			
			firstNode = null;
			
			lastNode = null;
				
			numElements --;
			}
			
		
		
		if( numElements >= 2){
			
			temp = lastNode.getData();
			
			ListNode <E> current = firstNode;
			
			while(current.getNext().getNext() != null){
				
				current = current.getNext();
				
			}
			
			current.setNext(null);
			
			numElements --;
			
		}
		
		return temp;

	}

	
	public E remove(int index) throws EmptyListException, IndexOutOfBoundsException{
		

		
		int count = 1;
		
		ListNode <E> current = firstNode;
		
		
		if(numElements == 0){
			
			throw new EmptyListException(name);			
		}
		
		if(index < 0 ||index > numElements-1){
			throw new IndexOutOfBoundsException(name);
		}
		
		
		
		E temp = firstNode.getData();
		
		while(count != index && index != 0){
			
			current = current.getNext();
			
			count++;
			
		}
		
		
		
		if(numElements >= 2 && index != 0 && index !=  numElements - 1){
		
			temp = current.getNext().getData();
			
			current.setNext(current.getNext().getNext());
			
			numElements --;
			
			
		}
		
		if(index == 0){
			temp = removeFromFront();
		}
		
		if(index == numElements - 1){
			temp = removeFromBack();
		}
		
		return temp;
		
	}//End remove function
	
	public E get(int index) throws EmptyListException, IndexOutOfBoundsException{

		
		ListNode <E> current = firstNode;
		
		
		int count = 0;
		
		if(numElements == 0){
			
			throw new EmptyListException(name);
			
		}
		
		if(index < 0 ||index > numElements-1){
			
			throw new IndexOutOfBoundsException(name);
			
		}
		
		
		
		for (int i = 0 ; i < index; i++){
			
			current = current.getNext();
			
		}
		
		
		return current.getData();
		
		
	} // end get function
	
	public boolean findAndRemove(E item) throws EmptyListException{ 
		
		ListNode <E> current = firstNode;

		int count = 0;
		
		if(numElements == 0){
			
			throw new EmptyListException(name);			
		}
		
		while(current.getData() != item){
			
			current = current.getNext();
			
			count++;
						
			if(count == numElements){
				return false;
			}
			
		}
		
		remove(count);
		
		return true;
		
	} //end findAndRemove function
	

	public int findItem(E item){ 
		
		int temp;
		
		ListNode <E> current = firstNode;

		int count = 0;

		while(current.getData() != item){
			
			current = current.getNext();
			
			count++;		
			
			if( count == numElements){
							
				return -1;
			}
			
		}
		
		return count;
		
		
	}//end findItem function
	
	
	public int lengthIs(){
		
		return numElements;
		
	}//end lengthIs function
	
	
	public void clear(){
		
		numElements = 0;
		
		lastNode = firstNode = null;
		
	}
	
	public void print(){
		
		ListNode <E> current = firstNode;
		
		if(isEmpty()){
			
			System.out.printf("\n" + name +"\n");
			
		}
		else{
			
			System.out.printf("The list " + name + "is: " );
			
			for(int x = 0; x < numElements; x++){
				
				System.out.print(current.getData() + " ");
				
				current = current.getNext();
			}
			
			System.out.println();
			
		}
		
		
	}
	
	public boolean isEmpty(){
		
		if(numElements == 0){
			return true;
		}
		else{
			return false;
		}
	}//end isEmpty function
	
	
	
}
	

