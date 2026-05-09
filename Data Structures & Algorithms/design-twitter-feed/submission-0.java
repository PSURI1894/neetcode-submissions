class Twitter {
    int time;
    HashMap<Integer, Set<Integer>> followMap;
    HashMap<Integer, List<int[]>> tweetMap;
    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);
        for (int followee : followMap.get(userId)) {
            List<int[]> tweets = tweetMap.getOrDefault( followee, new ArrayList<>());
            for (int i = tweets.size() - 1; i >= 0 && tweets.size() - i <= 10; i--) {
                maxHeap.offer(tweets.get(i));
            }
        }
        while (!maxHeap.isEmpty() && result.size() < 10) {
            result.add(maxHeap.poll()[1]);
        }
        return result;
    }
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followeeId != followerId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}