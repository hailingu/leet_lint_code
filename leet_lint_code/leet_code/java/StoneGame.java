class StoneGame {
    public boolean stoneGame(int[] piles) {
        int[] scoreBoard = new int[2];
        Map<String, Integer> memo = new HashMap<>();
        simulate(piles, 0, 0, piles.length -1, scoreBoard, memo);
        return scoreBoard[0] > scoreBoard[1];
    }
    
    int simulate(int[] piles, int order, int left, int right, int[] socreBoard, Map<String, Integer> memo) {
        if (left > right) {
            return -1;
        }
        
        int key = left * 10000 + right * 10 + order; 
        
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        if (order == 0) {
            socreBoard[0] += Math.max(simulate(piles, 1, left + 1, right, socreBoard, memo) + piles[left], simulate(piles, 1, left, right - 1, socreBoard, memo) + piles[right]);
            memo.put(key, socreBoard[0]);
            return socreBoard[0];
        } else {
            socreBoard[1] += Math.max(simulate(piles, 0, left + 1, right, socreBoard, memo) + piles[left], simulate(piles, 0, left, right - 1, socreBoard, memo) + piles[right]);
            memo.put(key, socreBoard[1]);
            return socreBoard[1];
        }
    }
}