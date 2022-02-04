package Entitymodels;

import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import blockchainmodels.Block;
import blockchainmodels.Blockchain;
import blockchainmodels.PatientTransaction;
import graphADT.Graph;
import graphADT.SinglyLinkedList;

public class Utility {

	private static Blockchain blockch;
	/**
	 * Read File
	 * @param FileName
	 * @return an singlylinked list of Hospitals
	 */
	public static SinglyLinkedList<HealthCenter> readFile(String FileName, int diff)
	{
		SinglyLinkedList<HealthCenter> itemlist = new SinglyLinkedList<HealthCenter>();
		InputStream filestream = FileReader.class.getResourceAsStream("/././././" + FileName);
		if (filestream == null) System.out.println("File not found");
		Scanner sc ;
		try {
			sc = new Scanner(filestream);
			//int counter = 0;
			while(sc.hasNextLine())
			{
				String newItem = sc.nextLine();
				StringTokenizer myTokens = new StringTokenizer(newItem, "\t");
				String hospID = "";
				String hospName = "";
				String hospSpec = "";
				while(myTokens.hasMoreTokens())
				{
					// Name # Description # Code
					hospID = myTokens.nextToken();
					hospName = myTokens.nextToken();
					System.out.println(hospName);
					hospSpec = myTokens.nextToken();
					System.out.println(hospSpec);
					blockch = new Blockchain(diff);
					Utility.getPatientBlocks(hospID + "Patients.txt");
					HealthCenter theitem = new HealthCenter(hospID, hospName, hospSpec, blockch);
					itemlist.insert(theitem);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemlist;
	}
	
	private static ArrayList<Block> getPatientBlocks(String filename){
		ArrayList<Block> blockchain = new ArrayList<Block>();
		InputStream filestream = FileReader.class.getResourceAsStream("/././././" + filename);
		if (filestream == null) System.out.println("File not found");
		Scanner sc ;
		try {
			sc = new Scanner(filestream);
			//int counter = 0;
			while(sc.hasNextLine())
			{
				//counter++;
				String newItem = sc.nextLine();
				StringTokenizer myTokens = new StringTokenizer(newItem, "\t");
				while(myTokens.hasMoreTokens())
				{
					String patID = myTokens.nextToken();
					String patName = myTokens.nextToken();
					String dr = myTokens.nextToken();
					String disease = myTokens.nextToken();
					String payment = myTokens.nextToken();
					System.out.println(payment);
					String medicine = myTokens.nextToken();
					System.out.println(medicine);

					PatientTransaction pt = new PatientTransaction(patID, payment, patName, dr, disease, medicine);
					Block newBlock = new Block(pt, blockch.getLatestBlock().getHash());
					blockch.addBlock(newBlock);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return blockchain;
	}
	
	public static String createHospPartnership(Graph<HealthCenter> hospGraph, 
			String hospCode1, String hospCode2) {
		String isPartner = "";
		
		HealthCenter hos1 = null;
		HealthCenter hos2 = null;
		if(hospGraph != null) {
			for(HealthCenter h : hospGraph.getAllVertices()) {
				if(h.getHospID().equals(hospCode1)) hos1 = h;
				else if(h.getHospID().equals(hospCode2)) hos2 = h;
			}
			if(hospCode1.equals(hospCode2)) {
				isPartner += "A Hospital cannot be partner to itself!";
			}else {
				addEdgeHosp(hospGraph, hos1, hos2);
			}	
		}
		
		return isPartner;
	}
	
	public static String removeHospPartnership(Graph<HealthCenter> hospGraph, 
			String hospCode1, String hospCode2) {
		String isPartner = "";
		
		HealthCenter hos1 = null;
		HealthCenter hos2 = null;
		if(hospGraph != null) {
			for(HealthCenter h : hospGraph.getAllVertices()) {
				if(h.getHospID().equals(hospCode1)) hos1 = h;
				else if(h.getHospID().equals(hospCode2)) hos2 = h;
			}
			if(hospCode1.equals(hospCode2)) {
				isPartner += "A Hospital cannot be partner to itself!";
			}else {
				removeEdgeHosp(hospGraph, hos1, hos2);
			}	
		}
		
		return isPartner;
	}
	
	/**
	 * this method creates the graph with its vertices and edges
	 * 
	 */
	public static Graph<HealthCenter> CreateGaph(String filename, int diff) {
		Graph<HealthCenter>hospGraph = new Graph<HealthCenter>();
		SinglyLinkedList<HealthCenter> hosps = new SinglyLinkedList<HealthCenter>();
		
		hosps = Utility.readFile(filename, diff);
		
		for(HealthCenter h : hosps) {
			hospGraph.addVertex(h);
		}
		return hospGraph;
	}
	
	/**
	 * removing the relationship between 2 health center in the graph
	 * @param h1
	 * @param h2
	 */
	public static String removeEdgeHosp(Graph<HealthCenter> hospGraph, 
			HealthCenter h1, HealthCenter h2) {
		String strRet = "";
		if(hospGraph.isAdjacent(h1, h2)) {
			hospGraph.removeEdge(h1, h2);
			strRet += h1.getHospName()+"("+h1.getHospID()+") and "+
					h1.getHospName()+"("+h1.getHospID()+") are no longer partners!";
		}
		return strRet;
	}
	
	
	
	/**
	 * Adding a relationship between 2 health center in the graph
	 * @param h1
	 * @param h2
	 */
	public static String addEdgeHosp(Graph<HealthCenter> hospGraph, HealthCenter h1, HealthCenter h2) {
		String strRet = "";
		if(!hospGraph.isAdjacent(h1, h2)) {
			hospGraph.addEdge(h1, h2);
			strRet += h1.getHospName()+"("+h1.getHospID()+") and "+
					h2.getHospName()+"("+h2.getHospID()+") are now partners!";
		} else {
			strRet += h1.getHospName()+"("+h1.getHospID()+") and "+
					h2.getHospName()+"("+h2.getHospID()+") are already in a partnership!";
		}
		return strRet;
	}
	
	/**
	 * this method displays detail of a particular hospital
	 * @param hosCode
	 */
	public static String viewInsight(Graph<HealthCenter> hospGraph, String hosCode) {
		HealthCenter targetHosp = null;
		String strRet = "";
		for(HealthCenter c : hospGraph.getAllVertices()) {
			String Code = c.getHospID();
			if(Code.equals(hosCode)) {
				targetHosp = c;
			}
		}
		
		if(targetHosp.getHospID().equals(hosCode)) {
			strRet += (targetHosp.toString());
			strRet += ("\n");
			strRet += ("Partners: ");
			//Display list of partners for a specific country.
			for(HealthCenter n : hospGraph.getNeighbors(targetHosp)) {
				strRet += ("\t"+n.getHospName()+"("+n.getHospID()+") \n");
			}
			strRet += ("\n");
			strRet += ("Potential Partners: \n");
			for(HealthCenter n : hospGraph.getNeighbors(targetHosp)) {
				//Display list of potential partners for a specific country(Partners of partner).
				for(HealthCenter p : hospGraph.getNeighbors(n)) {
					//Exclude current country and its partners.
					if(p.compareTo(targetHosp) != 0 ) {
						if(!hospGraph.isAdjacent(p, targetHosp)) {
							strRet += ("\t"+p.getHospName()+"("+p.getHospID()+") \n");
						}
					}
				}
			}
			strRet += ("\n\n");
		}else {
			strRet += hosCode+" was not found in the current region.";
		}
		
		return strRet;
	}
	
	/**
	 * Displaying vertices from the graph 
	 */
	public static String displayHealthGraphVertices(Graph<HealthCenter> hospGraph) {
		String strRet = "";

		strRet += ("\t Current Region: Johannesburg \n\n");
		for(HealthCenter h : hospGraph.getAllVertices()) {
			
			strRet += ("Hospital: " + h.getHospName() + "Code: " + h.getHospID() + "\n"
			+ "Speciality Care: " + h.getSpecialityCare() + "\n");
			strRet += ("Neighbors: \n");
			//Display list on neighbors.
			ArrayList<String> neighbouringHosp = new ArrayList<>();
			for(HealthCenter hos : hospGraph.getNeighbors(h)) {
				neighbouringHosp.add(hos.toString());
			}
			for(String specHos : neighbouringHosp) {
				strRet += ("\t"+specHos+"\n");
			}
			strRet += ("\n");
			
			strRet += ("Partners: ");
			//Display list of partners
			for(HealthCenter n : hospGraph.getNeighbors(h)) {
				strRet += ("\t"+n.getHospName()+"("+n.getHospID()+") -"+n.getSpecialityCare()+"\n");
			}
			strRet += ("\n\n");
		}
		return strRet;
	}
}
