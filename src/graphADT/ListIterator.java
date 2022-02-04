package graphADT;


import java.util.Iterator;

public class ListIterator<T extends Comparable<T>> implements Iterator<T> {

	private Node<T> current;
	public ListIterator(Node<T> current) {
		this.current = current;
	}

	@Override
	public boolean hasNext() {
		 return current != null;
	}

	@Override
	public T next() {
		 if(hasNext()) {
             T item = current.getElement();
             current = current.getNext();
             return item;
         }
         return null;
	}

}
