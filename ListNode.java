
public class ListNode <E> {

	private E data;
	
	private ListNode<E> nextNode;
	
	public ListNode(E d){
		
		data = d;
		
		nextNode = null;
		
	}
	
	public ListNode(E d, ListNode<E> node){
		
		data = d;
		
		nextNode = null;
		
		
	}
	
	
	public void setData(E d){
		
		data = d;
		
	}
	
	
	public E getData(){
		
		return data;
		
	}
	
	
	public void setNext(ListNode<E> next){
		
		nextNode = next;
		
		
	}
	
	public ListNode <E> getNext(){
		
		return nextNode;
		
	}
	
	
}
