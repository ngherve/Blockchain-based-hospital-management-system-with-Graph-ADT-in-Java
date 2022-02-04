package graphADT;

/**
 * @param <T>
 */
public interface IList<T> {
		public void insert(T data);
		public void remove(T data);
		public void traverseList();
		public int size();
}
