class StockSpanner {

    Stack<int[]> stack;  

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int days=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            days+=stack.pop()[1];
        }
        stack.push(new int[]{price, days});
        return days; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */