import java.util.Stack;
public class stack {
    public static class customstack {
        protected int[] data;
        private static final int DEFAULT_SIZE = 10;
        int ptr=-1;

        public customstack() {
            this(DEFAULT_SIZE);
        }

        public customstack(int size) {
            this.data = new int[size];
        }
        public boolean isfull(){
            return ptr==data.length-1;
        }
        public boolean isempty(){
            return ptr==-1;
        }
        public boolean push(int item){
            if(isfull()){
                System.out.println("stack is full");
                return false;
            }
            ptr++;
            data[ptr]=item;
            return true;
        }
        public int pop(){
            if (isempty()){
                System.out.println("stack is empty");
            }
            int removed=data[ptr];
            ptr--;
            return removed;

        }
        public int peek(){
            if (isempty()){
                System.out.println("stack is empty");
            }
            return data[ptr];
        }
    }
        public static void main(String[] args) {
           customstack stack= new customstack(5);
            stack.push(3);
            stack.push(2);
            stack.push(1);
            stack.push(0);
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
              // System.out.println(stack.pop());

        }
    }

