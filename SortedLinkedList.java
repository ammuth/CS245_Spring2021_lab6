
public class SortedLinkedList <T extends Comparable <T>> implements SortedList<T> {
    //public T[] sortedLinked;
    public int size=0;
    Node head = null;

    @Override
    public int size() {

        return size;
    }

    //public SortedLinkedList() {
    //    firstNode = null;
    //}



    @Override
    public boolean add(T item) {
        if (head == null) {
            head = new Node<>(item);
            ++size;
            return true;
        }
        Node<T> prev = head;
        Node<T> curr = head;
        // while the previous nodes next is not pointing at a null
        while (prev.data.compareTo(item) < 0) {
            curr = prev;
            if (curr.next == null) {
                Node new_node = new Node(item);
                prev.next = new_node;
                ++size;
                return true;
            }
            prev = prev.next;
        }
        Node<T> new_node = new Node(item);
        if (head==curr) {
            new_node.next=head;
            head = new_node;
            ++size;
            return true;
        }
        new_node.next = prev;
        curr.next=new_node;
        ++size;
        return true;


    }

    @Override
    public T remove(int item) {
        if (item == 0) {
            Node node = head;
            head = head.next;
            --size;
            return (T) node.data;
        } else {
            Node prev = head;
            for (int i = 0; i < item-1; i++) {
                prev = prev.next;
            }
            Node node = prev.next;
            prev.next = node.next;
            --size;
            return (T) node.data;
        }
    }



    @Override
    public T get(int item) throws Exception {
        Node curr = head;
        if (item < 0 || item >= size) {
            throw new Exception("Invalid position");
        }
        for (int i = 0; i < item; i++) {
            curr = curr.next;
        }
        return (T) curr.data;
    }


    public static void main(String[] args) throws Exception {
        SortedLinkedList s = new SortedLinkedList();
        s.add(45);
        s.add(1);
        s.add(76);

        s.toString();
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i) + " ");
            s.get(i).toString();
        }


    }




}