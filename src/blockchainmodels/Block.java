package blockchainmodels;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Block implements Comparable<Block>{
	
	private String previousHash;
	private String timestamp;
	private PatientTransaction patientTransaction;
	private int nonce;
	private String hash;

	/**
	 * @return the previousHash
	 */
	public String getPreviousHash() {
		return previousHash;
	}

	/**
	 * @param previousHash the previousHash to set
	 */
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the transactions
	 */
	public PatientTransaction getTransactions() {
		return patientTransaction;
	}

	/**
	 * @param patientTransaction the transactions to set
	 */
	public void setTransactions(PatientTransaction patientTransaction) {
		this.patientTransaction = patientTransaction;
	}

	/**
	 * @return the nonce
	 */
	public int getNonce() {
		return nonce;
	}

	/**
	 * @param nonce the nonce to set
	 */
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @param timestamp
	 * @param patientTransaction
	 * @param previousHash
	 */
	public Block(PatientTransaction patientTransaction, String previousHash) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		this.previousHash = previousHash;
	    this.timestamp = dtf.format(now);;
	    this.patientTransaction = patientTransaction;
	    this.nonce = 0;
	    this.hash = this.calculateHash();
	}

	/**
	   * Returns the SHA256 of this block (by processing all the data stored
	   * inside this block)
	   *
	   * @returns {string}
	   */
	public String calculateHash() {
		return Secrecy.getHashedCode(this.previousHash + this.timestamp + 
				(this.patientTransaction.toString()) + this.nonce);
	}
	
	/**
	 * Starts the mining process on the block. It changes the 'nonce' until the hash
	 * of the block starts with enough zeros (= difficulty)
	 *
	 * @param {number} difficulty
	 */
	 /**
	 * @param difficulty
	 */
	public void mineBlock(int difficulty) {
		/*
		 * while (this.hash.substring(0, difficulty) != Array(difficulty + 1).join('0'))
		 * { this.nonce++; } this.hash = this.calculateHash();
		 */
	     String prefixString = new String(new char[difficulty]).replace('\0', '0');
	     while (!this.hash.substring(0, difficulty).equals(prefixString)) {
	         nonce++;
	         this.hash = calculateHash();
	     }
	     System.out.println("Block mined: " + this.hash);
     }

	@Override
	public int compareTo(Block block) {
		// TODO Auto-generated method stub
		return this.hash.compareTo(block.calculateHash());
	}
}
