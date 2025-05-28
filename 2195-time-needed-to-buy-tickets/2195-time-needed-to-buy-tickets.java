class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
       Queue<Integer> q = new LinkedList<>();

       for(int i=0;i<tickets.length;i++)    q.add(i);

       int counter=0;
       while(!q.isEmpty())
       {
        counter++;
        int front=q.poll();

        if(tickets[front]>= 1)     tickets[front]--;

        if(k==front && tickets[front]==0)   break;

        if(k!=front && tickets[front]==0)    continue;

        q.add(front);
       }

       return counter;
}}