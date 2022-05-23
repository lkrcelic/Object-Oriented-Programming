package second.laboratory.exam;

import java.util.Arrays;

class Blockchain {
	private Block[] blocks;
	private int size;

	private static int index = 0;

	public Blockchain(int maxBlocks) {
		blocks = new Block[maxBlocks];

	}

	public int add(Block newBlock) {
		blocks[index] = newBlock;
		if (index == 0) {
			blocks[index].setPrevHash(new byte[] { 0 });
		} else {
			blocks[index].setPrevHash(blocks[index - 1].hash(blocks[index - 1].getPrevhHash()));
		}
		index++;
		return index - 1;
	}

	public Block get(int index) {
		return blocks[index];
	}
//	public byte[] hash(byte[] prevHash) {
//        return new SHAHasher().hash(prevHash, this.transactions);
//    }

	public boolean isAltered(int blockindex, byte[] expectedHash) {

		for (int i = blockindex - 1; i > 0; i--) {
			if (Arrays.equals(expectedHash, blocks[i - 1].hash(blocks[i - 1].getPrevhHash())))
				expectedHash = blocks[i - 1].hash(blocks[i - 1].getPrevhHash());
			else
				return false;
		}
		if (Arrays.equals(expectedHash, blocks[1].hash(blocks[1].getPrevhHash()))) {
			return true;
		}
		return false;
	}
}
