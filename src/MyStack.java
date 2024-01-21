// Practice1
// ArrayList를 이용한 스택 구현

import java.util.ArrayList;

class MyStack1 {
    ArrayList list;

    MyStack1() {
        this.list = new ArrayList();
    }

    public boolean isEmpty() {
        if (this.list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        this.list.add(data);
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = (int)this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = (int)this.list.get(this.list.size() - 1);
        return data;
    }

    public void printStack() {
        System.out.println(this.list);
    }
}


// Practice2
// 배열을 이용한 기본 스택 직접 구현

class MyStack2 {
    int[] arr;
    int top = -1; // bottom, top이 있음. bottom은 제일 밑에 있는 애, top은 제일 위에 있는 애

    MyStack2(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.top == this.arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        if (this.isFull()) {
            System.out.println("Stack is full!");
            return;
        }

        this.top += 1;
        this.arr[this.top] = data;
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int data = this.arr[this.top];
        this.top -= 1;
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        return this.arr[this.top];
    }

    public void printStack() {
        for (int i = 0; i < this.top + 1; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}