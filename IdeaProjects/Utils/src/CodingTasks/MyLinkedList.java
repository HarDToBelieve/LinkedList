package CodingTasks;

import java.util.Scanner;

public class MyLinkedList {
      public static void main(String[] args) {
          Object[] list = new Object[]{"java", 1, 2, 4, "xml"};

          LinkedListOperation linkedList = new LinkedListOperation();

          if (list.length >= 2) linkedList.head(list[0],list[1]);

          for (int i = 1; i < list.length; i++) {
              linkedList.append(list[i]);

          }

          //Print the linked list
          System.out.println("Print the linked list " + linkedList.toString());


          // User enter an item to insert into the list
          Scanner input = new Scanner(System.in);
          System.out.print("Insert one more item to the list: ");
          Object newItem =  input.nextLine();

          System.out.print("Enter a number to set the item's location in the list: ");
          int location  = input.nextInt();

          // Insert into the linked list
          if (location < linkedList.length())  {

              linkedList.insert(location, newItem);
              System.out.println("Updated linked list: " + linkedList.toString());

          }
          else {
              System.out.println("Out of the list");
          }

          //User enters item that they want to delete
          System.out.print("Delete: ");
          Object deletedItem = input.next();

          linkedList.delete(deletedItem);
          System.out.println("Updated linked list: " + linkedList.toString()); 



      }
}

class LinkedListOperation {
    private int counter;
    private Element currentObject;
    private Element nextObject;
    private Element head;

    public LinkedListOperation() {
        counter = 0;
        head =  null;
    }

    public void append(Object item) {
        Element newObject = new Element(item);
        nextObject.setPointer(newObject);
        nextObject = newObject;
        counter ++;

    }

    public void insert(int location, Object item) {
        Element newObject = new Element(item);


        currentObject = head;

        for (int i = 0; i < counter - 1; i++) {
            currentObject = currentObject.getPointer();
            if (i  == location - 1) break;
        }

        newObject.setPointer(currentObject.getPointer());

        currentObject.setPointer(newObject);

        counter++;


    }

    public void head(Object item, Object nextItem) {
         currentObject = new Element(item);
         nextObject = new Element(nextItem);
         currentObject.setPointer(nextObject);

         counter++;

         //Keep the first Element in the head attribute for looping through the list when inserting new Element
         head = currentObject;


    }

    public void delete(Object deletedItem) {
         currentObject = head;
         if(!head.getValue().equals(deletedItem)) {
             for (int i = 0; i < counter - 1; i++) {

                 if (currentObject.getPointer().getValue().equals(deletedItem)) break;
                 currentObject = currentObject.getPointer();

             }

             if (!currentObject.getPointer().getValue().equals(deletedItem)) System.out.println("Item is not in the list");

         }

         currentObject.setPointer(currentObject.getPointer().getPointer());

         counter--;



    }

    public int length () {
        return counter;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Element {
    private Object value;
    private Element pointer;

    public Element(Object value) {
       this.value = value;
       pointer = null;
    }

    public Element(Object value, Element pointer) {
       this.value = value;
       this.pointer = pointer;

    }

    public Element getPointer() {
        return pointer;
    }

    public void setPointer(Element pointer) {
        this.pointer = pointer;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}














































































































