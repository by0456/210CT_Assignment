
public class ArrayQueue {

	private int maxSize;
	private Object [] entry;
	private int front;
	private int rear;
	public int count;

    public ArrayQueue(int size) {
		maxSize = size;
    	entry = new Object[maxSize];
    	count = 0; front = 0; rear = -1;
    }

	public ArrayQueue() {
		this(10);
	}

	public boolean empty() {
		return count <= 0;
	}

	public boolean full() {
		return count == maxSize;
	}

	public void enqueue( Object item ) throws QueueFullException {
		if (count < maxSize) {
			count++;
			if (rear < maxSize-1)
				rear++;
			else
				rear = 0;
			entry[rear] = item;
		} else
			throw new QueueFullException();
	}

	public Object dequeue() throws EmptyQueueException {
		if (count <= 0)
			throw new EmptyQueueException();
		count--;
		Object temp = entry[front];
		if (front < maxSize-1)
			front++;
		else
			front = 0;
		return temp;
	}

	public String toString() {
		String s = "front [ ";

		int index = front;
		for (int i = 0; i < count; i++) {
			s = s + entry[index] + " ";
			if (index < maxSize-1)
				index++;
			else
				index = 0;
		}

		s = s + "] rear";
		return s;

	}

} 

class EmptyQueueException extends RuntimeException {
	public EmptyQueueException () {
		super("Queue is empty");
	}
} 

class QueueFullException extends RuntimeException {
	public QueueFullException () {
		super("Queue is full");
	}
} 