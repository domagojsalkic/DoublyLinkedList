package hr.vsite.java;


public class DoublyLinkedList {
    /**
     * Klasa čvor koja sadrži element data, sljedeći čvor i prethodni čvor.
     */
        class Node {
            Object data;
            Node next;
            Node prev;

            Node() {
                this.prev = null;
                this.next = null;
            }

            Node(Object data) {
                this.next = null;
                this.data = data;
                this.prev = null;
            }
        }

        Node head = new Node();
        Node tail = new Node();

    /**
     * Dodaje element na kraj liste poput Stack-a.
     * @param new_data element
     */
    void push(Object new_data) {
            Node new_node = new Node(new_data);
            if (head.next != null) {
                new_node.prev = tail.prev;
                new_node.next = tail;
                tail.prev = new_node;
                new_node.prev.next = new_node;
            } else {
                head.next = new_node;
                new_node.prev = head;
                tail.prev = new_node;
                new_node.next = tail;
            }
        }

    /**
     * Dohvaća element na poslijednjem mjestu u listi, ali vrijednost ostaje u listi.
     * @return element
     */
        Object peek() {
            if (tail.prev != null)
                return tail.prev.data;
            return -1;
        }

    /**
     * Dohvaća element sa početka liste, element se briše iz liste.
     * @return element
     */
       Object pop() {
            Node pop_node;
            if (tail.prev != null) {
                pop_node = tail.prev;
                Node last_node;
                last_node = pop_node.prev;
                last_node.next = tail;
                tail.prev = last_node;
                return pop_node.data;
            }
            return -1;
        }

    /**
     * Dodaje element na kraj liste poput Que-a.
     * @param new_data element
     */
        void offer(Object new_data) {
            Node new_node = new Node(new_data);
            if (head.next != null) {
                new_node.prev = tail.prev;
                new_node.next = tail;
                tail.prev = new_node;
                new_node.prev.next = new_node;
            } else {
                head.next = new_node;
                new_node.prev = head;
                tail.prev = new_node;
                new_node.next = tail;
            }
        }

    /**
     * Dohvaća element sa početka liste i briše ga.
     * @return element, ukoliko ne postoji element vraća -1
     */
        Object poll() {
            Node poll_node;
            if (head.next != null) {
                poll_node = head.next;
                Node next_node;
                next_node = poll_node.next;
                head.next = next_node;
                next_node.prev = head;
                return poll_node.data;
            }
            return -1;
        }

    /**
     * Dohvaća element sa početka liste, ali ostaje u listi.
     * @return element, ukoliko ne postoji element vraća -1
     */
        Object element() {
            if (head.next != null) {
                return head.next.data;
            }
            return -1;
        }

    /**
     * Broj elemenata u listi.
     * @return broj elemenata
     */
        int size() {
            if (head.next != null) {
                Node temp = head;
                int i = 0;
                while (temp.next != tail) {
                    ++i;
                    temp = temp.next;
                }
                return i;
            }
            return 0;
        }

    /**
     * Provjerava je li lista prazna.
     * @return true ako je prazna, false ako ima elemenata
     */
        boolean isEmpty() {
            if ((head.next == null && tail.prev == null) || head.next == tail)
                return true;
            return false;
        }

    /**
     * Provjerava sadrži li lista elemente.
     * @return true ako sadrži barem jedan element, false ako ne sadrži
     */
        boolean contains() {
            if ((head.next == null && tail.prev == null) || head.next == tail)
                return false;
            return true;
        }

    /**
     * Formatira string sa vrijednostima iz liste.
     * @return string sa vrijednostima liste, ukoliko je prazna ispisuje List is empty.
     */
        public String toString() {
            if ((head.next == null && tail.prev == null) || head.next != tail) {
                Node temp_node = head.next;
                String s = "";
                while (temp_node.next != null) {
                    s += temp_node.data.toString() + " ";
                    temp_node = temp_node.next;
                }
                return s;
            }
            return "List is empty";
        }

        
    public static void main(String[] args) {
            DoublyLinkedList dll = new DoublyLinkedList();
            System.out.println(dll.isEmpty());
            System.out.println(dll.contains());
            dll.push(2);
            dll.push(3);
            System.out.println(dll.contains());
            dll.offer(2);
            dll.push(5);
            System.out.println(dll.toString());
            System.out.println(dll.size());
            System.out.println(dll.pop());
            System.out.println(dll.poll());
            System.out.println(dll.toString());
            System.out.println(dll.isEmpty());
            System.out.println(dll.contains());
            System.out.println(dll.pop());
            System.out.println(dll.poll());
            System.out.println(dll.isEmpty());
            System.out.println(dll.contains());
            System.out.println(dll.toString());
            dll.push(2);
            System.out.println(dll.toString());
    }

}
