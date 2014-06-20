
public class Stack <E> {

	private LinkedList <E> list;
	
	public <E> Stack(){
		
		list = new LinkedList();
		
	}
	
	public <E> Stack(String name){
		
		list = new LinkedList(name);
		
	}
	
	public void push(E item){
		
		list.insertAtFront(item);
		
	}
	
	public E pop(){
	
		E temp;
		
		temp = list.removeFromFront();
		
		return temp;
		
	}
	
	public int lengthIs(){
		
		int temp;
		
		temp = list.lengthIs();
		
		return temp;
		
	}
	
	public E peek(){
		
		E temp;
		
		temp = list.get(0);
		
		return temp;
		
	}
	
	public void print(){
		
		list.print();
		
	}
	
	public boolean isEmpty(){
		
		boolean temp;
		
		temp = list.isEmpty();
		
		return temp;
		
	}
	
}
