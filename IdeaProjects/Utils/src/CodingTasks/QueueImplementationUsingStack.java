package CodingTasks;



public class QueueImplementationUsingStack {

    public static void main (String[] args) {
        Object[] items = new Object[] {"xml", 1, 2, "java"};

        Queue queue = new Queue();

        for (Object i : items) {
            queue.enqueue(i);
        }

        queue.dequeue();

        queue.peek();
    }
}

class Queue {
    StackOperation stack;
    StackOperation secondStack;


    public Queue() {
        stack = new StackOperation();
        secondStack = new StackOperation();
    }

    public void enqueue(Object i) {
        if(!stack.isEmpty()) {
            stack.push(i);
        }
        else {
           while(stack.counter > 0) {
               secondStack.push(stack.peek());
               stack.pop();
           }

           stack.push(i);

           while (secondStack.counter > 0) {
               stack.push(secondStack.peek());
               secondStack.pop();
           }
        }

    }

    public void dequeue() {
        if (!stack.isEmpty())
        stack.pop();
    }

    public void peek() {
       stack.peek();
    }
}
