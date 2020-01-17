package CodingTasks;


//Queue implementation with Linked list

public class MyQueue  {
    public static void main(String[] args) {
        Object[] items = new Object[] {"xml", 1, 2, "java"};

        //Create a queue
        QueueOperations queue = new QueueOperations();


        for (Object i : items ) {
            queue.enqueue(i);
        }

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.toString());


    }


}

class QueueOperations {
    private int counter;
    Element head;
    Element tail;
    Element current;


    public QueueOperations () {
        counter = 0;
    }


    public void enqueue(Object i) {
        Element newItem = new Element(i);

        if (counter == 0) {
            head = newItem;
            tail = head;

        }
        else {
           tail.setPointer(newItem);
           tail = newItem;
        }

        counter++;
    }

    public void dequeue() {

        if (counter != 0) {

            head = head.getPointer();
            counter--;

        }

        else {
            System.out.println("Unable to remove items");
        }
    }

    @Override
    public String toString() {
        String output = "";
        current  =  head;
        while (current != null) {
            output += current.getValue().toString() + " ";
            current = current.getPointer();
        }

        return output;
    }
}
