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
    Element top;
    int counter;
    Element topElement;

    public StackOperation() {
        top = null;
        counter = 0;
    }

    public void push(Object i) {
        Element newObject = new Element(i);
        newObject.setPointer(top);
        top = newObject;
        counter++;

    }


    public void pop() {

        top = top.getPointer();
        counter--;

    }


    public Object peek() {
        if (!isEmpty()) {

           return top.getValue().toString();

        }
        return null;
    }

    public Boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public String toString() {
        String output = "";

        while (top != null) {
            output += top.getValue().toString() + " ";
            top = top.getPointer();
        }

        return output;
    }
}
