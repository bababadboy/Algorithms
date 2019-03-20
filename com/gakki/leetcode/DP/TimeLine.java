package com.gakki.leetcode.DP;

/**
 * @author wangxiaobin
 */

public class TimeLine {
    private int N;
    private int[] prev;
    private Task[] tasks;

    public TimeLine(Task[] tasks) {
        N = tasks.length;
        // 初始化tasks数组
        this.tasks = new Task[N+1];
        this.tasks[0] = new Task(0,0,0,0);

        System.arraycopy(tasks,0,this.tasks,1,N);

        // prev 数组，存储每个任务的前驱任务
        prev = new int[N+1];
        for (int i = N; i > 0; i --) {
            for (int j = i - 1; j > 0 ; j --) {
                if (this.tasks[i].getStart() >= this.tasks[j].getEnd()){
                    prev[i] = j;
                    break;
                }
            }
        }
    }

    /**
     *  获得最大回报
      */
    public int getMaxVal(){
        return opt(N);
    }

    private int opt(int i) {
        if (i == 0){
            return 0;
        }
        int a = tasks[i].getValue()+opt(this.prev[i]);
        int b = opt(i-1);
        return Math.max(a,b);
    }

    /**
     * 根据Task.end降序排序
     */
    public void tastSortByTaskEnd(){

    }

    public int[] getPrev() {
        return prev;
    }


    public static void main(String[] args) {
        int nums = 8;
        Task[] tasks = new Task[nums];

        tasks[0] = new Task(1, 1,4,5);
        tasks[1] = new Task(2, 3,5,1);
        tasks[2] = new Task(3, 0,6,8);
        tasks[3] = new Task(4, 4,7,4);
        tasks[4] = new Task(5, 3,8,6);
        tasks[5] = new Task(6, 5,9,3);
        tasks[6] = new Task(7, 6,10,2);
        tasks[7] = new Task(8, 8,10,4);

        TimeLine tl= new TimeLine(tasks);

        System.out.println(tl.getMaxVal());
    }


}

/**
 * 任务
 */
class Task{

    private int id;
    private int start;
    private int end;
    private int during;
    private int value;

    public Task(int id, int start, int end,int value) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.value = value;
        if (start > end){
            throw new IllegalArgumentException();
        }
        this.during = this.end - this.start;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}