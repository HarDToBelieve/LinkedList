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

        stack.push("python");


        System.out.println(stack.toString());

        System.out.println("The most recent item is: " + stack.peek());

    }
}

class StackOperation {
    Element topElement;
    int counter;


    public StackOperation() {
        topElement = null;
        counter = 0;
    }

    public void push(Object i) {
        Element newObject = new Element(i);
        newObject.setPointer(topElement);
        topElement = newObject;
        counter++;

    }


    public void pop() {

        topElement = topElement.getPointer();
        counter--;

    }


    public Object peek() {
        if (!isEmpty()) {

           return topElement.getValue();

        }
        return null;
    }

    public Boolean isEmpty() {
        return counter == 0;
    }



    @Override
    public String toString() {
        String output = "";
        Element temp = topElement;

        while (temp != null) {
            output += temp.getValue().toString() + " ";
            temp = temp.getPointer();
        }

        return output;
    }
}
