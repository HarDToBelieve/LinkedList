package CodingTasks;


public class MyLinkedList {
    private static String[] array;
    private static Element e;
    



    public static void main (String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.init(array);



    }

    public MyLinkedList() {
        array = new String[] {"Java", "XML", "JS", "C++"};


    }



    public void init (String[] array) {


        for (int i = 0; i<=array.length; i++) {
              if (i == 0) {
                e = head(array[i], array[i+1]);
              }

              else if (i == array.length-1) {
                  elementAtn(array[i], null);
                  break;
              }

              else {
                  elementAtn(array[i], array[i+1]);
              }
        }
    }

    public Element head (String firstElement, String secondElement) {
      Element head = new Element();
      head.setValue(firstElement);
      head.setPointer(new Element(secondElement));
      return head;

    }

    public Element elementAtn (String element, String nextElement) {
       Element n = new Element();
       n.setValue(element);
       n.setPointer(new Element(nextElement));
       return n;

    }

    class Element {
        String value;
        String nextValue;
        Element pointer;

        public Element() {
            value = "";
            pointer = new Element(nextValue);


        }

        public Element(String nextValue) {
           this.nextValue = nextValue;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setPointer(Element pointer) {
            this.pointer = pointer;
        }

        public Element getPointer() {
            return pointer;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    }

















