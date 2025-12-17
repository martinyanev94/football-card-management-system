public UserProfile findById(String userId) {
    int shardNumber = getShardNumber(userId);
    
    return shardDatabase[shardNumber].findUserProfileById(userId);
}

private int getShardNumber(String userId) {
    // Simple modulo operation to decide the shard
    return Integer.parseInt(userId) % numberOfShards;
}
