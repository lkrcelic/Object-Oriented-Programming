package second.laboratory.exam;

 class Block {
	private byte[] prevHash;
	private String[] transactions;
	private int size;
	private Hasher hasher;
	
	private static int index = 0;
	
	public Block(int maxTransaczions) {
		transactions = new String[maxTransaczions];
	}
	
	public Block(int maxTransactions, Hasher hasher) {
		size = maxTransactions;
		this.hasher = hasher;
	}
	 
	public int add(String transaction) {
		transactions[index] = transaction;
		index++;
		return index - 1;
	}
	
	public void remove(int index) {
		if(index >= transactions.length)
			return;
		for(int i = index; i < transactions.length - 1; i++) {
			transactions[i] = transactions[i+1];
		}
	}
	
	public void setPrevHash(byte[] prevHash) {
		this.prevHash = prevHash;
	}
	
	
	public byte[] getPrevhHash() {
		return prevHash;
	}
	
	public byte[] hash(byte[] prevHash) {
        return new SHAHasher().hash(prevHash, this.transactions);
    }
	
}
