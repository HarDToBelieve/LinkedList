package CodingTasks;


//Stack implementation with Linked List
public class MyStack {
    public static void main (String[] args) {
        Object[] items = new Object[] {"xml", 1, 2, "java"};

        //Create a stack
        StackOperation stack = new StackOperation();


        for (Object i : items ) {
            stack.push(i);
        }

        stack.pop();


        System.out.println(stack.toString());

        System.out.println("The most recent item is: " + stack.peek());

    }
}

class StackOperation {
    Element head;
    Element previousHead;


    public StackOperation() {
        head = null;
    }

    public void push(Object i) {
        Element newObject = new Element(i);

        if (head == null) {
            head = newObject;
        }
        else {
           previousHead = head;
           head = newObject;
           head.setPointer(previousHead);
        }
    }

    public void pop() {
        head = previousHead;
    }


    public Element peek() {
        return head;
    }

    @Override
    public String toString() {
        String output = "";

        while (previousHead != null) {
            output += previousHead.getValue().toString() + " ";
            previousHead = previousHead.getPointer();
        }

        return output;
    }
}

