public interface SortedList<T extends Comparable<T>> {
   
   public boolean add(T j);
   public int size();
   public T remove(int pos);
   public T get(int pos) throws Exception;

}