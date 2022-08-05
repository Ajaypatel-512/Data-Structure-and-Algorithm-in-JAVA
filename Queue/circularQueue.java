package Queue;

public class circularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public circularQueue(){
        this(DEFAULT_SIZE);
    }

    public circularQueue(int size){
        this.data = new int[size];
    }

    public boolean insert(int item) throws Exception{
        if(isFull()){
            throw new Exception("Queue is full!");
        }
        data[end++] = item;
        end = end%data.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty!");
        }
        int removed = data[front++];
        front = front%data.length;
        size--;
        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty!");
        }
        return data[front];
    }

    public void display(){
        int i = front;
        if(isEmpty()){
            System.out.println("empty");
            return;
        }
        do{
            System.out.print(data[i] + " -> ");
            i++;
            i%=data.length;
        }while (i != end);
        System.out.println("END");
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
