package blockchainmodels;

import java.util.ArrayList;


public class Blockchain {
	
	public static PatientTransaction patientTransaction = null;
	private ArrayList<Block> blockchain;
	/**
	 * @return the blockchain
	 */
	public ArrayList<Block> getBlockchain() {
		return blockchain;
	}


	/**
	 * @param blockchain the blockchain to set
	 */
	public void setBlockchain(ArrayList<Block> blockchain) {
		this.blockchain = blockchain;
	}

	private int difficulty;
	
	/*
	 * public Blockchain(ArrayList<Block> blockchain, int difficulty) {
	 * this.blockchain = blockchain; this.setDifficulty(difficulty); }
	 */
	//constructor
	public Blockchain(int diff) {
	    this.setDifficulty(diff);
		this.blockchain = new ArrayList<>();
		this.blockchain.add(this.createGenesisBlock());
	}
	
	
	//creating genesis block
	private Block createGenesisBlock() {
	    return new Block(new PatientTransaction("1", "genesis", "genesisName", "genesisDr",
	    		"genesisDis", "genesisPres"), "0");
	}
	

   /**
    * Returns the latest block on our chain. Useful when you want to create a
    * new Block and you need the hash of the previous Block.
    * @returns {Block[]}
    */
	public Block getLatestBlock() {
	    return blockchain.get(blockchain.size() - 1);
	}
	
	/**
	 * verifying the validity of the block chain
	 * @param blockchain
	 * @param difficulty
	 * @return
	 */
	public static Boolean isChainValid(ArrayList<Block> blockchain, int difficulty) {
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop through block chain to check hashes:
		for(int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.getHash().equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.getHash().equals(currentBlock.getPreviousHash()) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			//check if hash is solved
			if(!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
	
	public void addBlock(Block newBlock) {
		newBlock.mineBlock(difficulty);
		blockchain.add(newBlock);
	}

	/**
	 * @return the difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String strRet = "";
		int blockCount = 0;
		for (Block block : blockchain) {
			blockCount++;
			PatientTransaction trans = block.getTransactions();
			strRet += "Block: " + blockCount + " Hash: " + block.getHash() + "\nPrevious Hash: "
			+ block.getPreviousHash() + "\nNonce: " + block.getNonce() + " Time stamp: " +
			block.getTimestamp() + "\n";
			strRet += "PatientID: " + trans.getPatientID() + " Name: " + trans.getPatFullName() + 
					" AssistingDoctor: " + trans.getPatientsDoct() + "\n" +
					"Disease: " + trans.getPatDisease() + " Payment: " + trans.getPatientInsuranceAmount() 
					+ " Prescibtion: " + trans.getPatPrescription() + "\n";
		}
		return strRet;
	}
}
