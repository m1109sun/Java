// Practice1
// ArrayList를 이용한 데크 구현

import java.util.ArrayList;

class MyDeque1 {
    ArrayList list;

    MyDeque1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addFirst(int data) {
        this.list.add(0, data);
    }

    public void addLast(int data) {
        this.list.add(data);
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = (int)this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = (int)this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public void printDeque() {
        System.out.println(this.list);
    }
}

// Practice2
// 배열을 이용한 기본 데크 직접 구현

class MyDeque2 {
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque2(int size) {
        this.arr = new int[size + 1]; // 원형 큐처럼 하는거라 size + 1
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public boolean isFull() {
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void addFirst(int data) {
        if (this.isFull()) {
            System.out.println("Deque is Full!");
            return;
        }

        this.arr[this.front] = data;
        this.front = (this.front - 1 + this.arr.length) % this.arr.length;
    }

    public void addLast(int data){
        if (this.isFull()) {
            System.out.println("Deque is Full!");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer removeFirst() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast() {
        if (this.isEmpty()) {
            System.out.println("Deque is empty!");
            return null;
        }

        int data = this.arr[this.rear];
        this.rear = (this.rear - 1 + this.arr.length) % this.arr.length;
        return data;
    }

    public void printDeque() {
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}