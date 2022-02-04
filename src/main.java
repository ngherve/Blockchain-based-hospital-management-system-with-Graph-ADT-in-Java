

/**
 * @author Herve
 *
 */

import Entitymodels.HealthCenter;
import Entitymodels.Utility;
import blockchainmodels.Block;
import blockchainmodels.Blockchain;
import blockchainmodels.PatientTransaction;
import graphADT.Graph;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
 
public class main extends Application implements EventHandler<ActionEvent>{
	
	private Button btnAddHosp;
	private Button btnDisplayGraph;
	private TextArea txtarea;
	private Button btnDeleteHosp;
	private Button btnViewInsight;
	private Button btnRemovePartnership;
	private Button btnCreatePartnership;
	//private Button btnRemoveBlock;
	private Button btnTransferPatientRecord;
	private Button btnAddPatient;
	private Button btnsetDifficulty;
	private int difficulty = 2;
	private Graph<HealthCenter> hospGraph = null;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Electronic Health Record Management System based Blockchain and Graph ADT");
    
        GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
        
		btnAddHosp = new Button(); 
		btnAddHosp.setText("Add Health center"); 
		btnAddHosp.setOnAction(this);
		btnAddHosp.setAlignment(Pos.CENTER);
		btnAddHosp.setMinSize(350, 50);
		GridPane.setConstraints(btnAddHosp, 0, 0);
		grid.getChildren().add(btnAddHosp);
		  
		btnDisplayGraph = new Button();
		btnDisplayGraph.setText("Display Health Center Graph");
		btnDisplayGraph.setOnAction(this);
		btnDisplayGraph.setAlignment(Pos.CENTER);
		btnDisplayGraph.setMinSize(350, 50);
		GridPane.setConstraints(btnDisplayGraph, 0, 1);
		grid.getChildren().add(btnDisplayGraph);
		
		btnDeleteHosp = new Button();
		btnDeleteHosp.setText("Delete Health Center");
		btnDeleteHosp.setOnAction(this);
		btnDeleteHosp.setAlignment(Pos.CENTER);
		btnDeleteHosp.setMinSize(350, 50);
		GridPane.setConstraints(btnDeleteHosp, 0, 2);
		grid.getChildren().add(btnDeleteHosp);
		
		btnViewInsight = new Button();
		btnViewInsight.setText("Display View Health Center Insight");
		btnViewInsight.setOnAction(this);
		btnViewInsight.setAlignment(Pos.CENTER);
		btnViewInsight.setMinSize(350, 50);
		GridPane.setConstraints(btnViewInsight, 1, 0);
		grid.getChildren().add(btnViewInsight);
		
		btnCreatePartnership = new Button();
		btnCreatePartnership.setText("Link Health care centers");
		btnCreatePartnership.setOnAction(this);
		btnCreatePartnership.setAlignment(Pos.CENTER);
		btnCreatePartnership.setMinSize(350, 50);
		GridPane.setConstraints(btnCreatePartnership, 1, 1);
		grid.getChildren().add(btnCreatePartnership);
		
		btnRemovePartnership = new Button();
		btnRemovePartnership.setText("UnLink Health care centers");
		btnRemovePartnership.setOnAction(this);
		btnRemovePartnership.setAlignment(Pos.CENTER);
		btnRemovePartnership.setMinSize(350, 50);
		GridPane.setConstraints(btnRemovePartnership, 1, 2);
		grid.getChildren().add(btnRemovePartnership);
		
		/*
		 * btnRemoveBlock = new Button();
		 * btnRemoveBlock.setText("Delete Patient Block");
		 * btnRemoveBlock.setOnAction(this); btnRemoveBlock.setAlignment(Pos.CENTER);
		 * btnRemoveBlock.setMinSize(350, 50); GridPane.setConstraints(btnRemoveBlock,
		 * 1, 3); grid.getChildren().add(btnRemoveBlock);
		 */
		
		btnTransferPatientRecord = new Button();
		btnTransferPatientRecord.setText("Transfer Patient Record");
		btnTransferPatientRecord.setOnAction(this);
		btnTransferPatientRecord.setAlignment(Pos.CENTER);
		btnTransferPatientRecord.setMinSize(350, 50);
		GridPane.setConstraints(btnTransferPatientRecord, 0, 3);
		grid.getChildren().add(btnTransferPatientRecord);
		
		btnsetDifficulty = new Button();
		btnsetDifficulty.setText("Set difficulty of Block mining");
		btnsetDifficulty.setOnAction(this);
		btnsetDifficulty.setAlignment(Pos.CENTER);
		btnsetDifficulty.setMinSize(350, 50);
		GridPane.setConstraints(btnsetDifficulty, 0, 4);
		grid.getChildren().add(btnsetDifficulty);
		
		btnAddPatient = new Button();
		btnAddPatient.setText("Add Patient Block");
		btnAddPatient.setOnAction(this);
		btnAddPatient.setAlignment(Pos.CENTER);
		btnAddPatient.setMinSize(350, 50);
		GridPane.setConstraints(btnAddPatient, 1, 3);
		grid.getChildren().add(btnAddPatient);
		 
		//lblstart 
		Label lblStart = new Label("Welcome to the Patient record management with blockchain");
		lblStart.setAlignment(Pos.CENTER);
		lblStart.setPadding(new Insets(20, 20, 20, 200));
	
		
		txtarea = new TextArea(); 
		txtarea.setPromptText("");
		txtarea.setEditable(false); 
		txtarea.setPrefRowCount(30);
		txtarea.setPadding(new Insets(20, 20, 20, 20));

		//setting scene and pane
        VBox box = new VBox();
        box.getChildren().add(lblStart);
        box.getChildren().add(txtarea);
        box.getChildren().add(grid);
        Scene scene = new Scene(box, 800, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == btnAddHosp) {
			Stage subWindow = new Stage();
			
			subWindow.initModality(Modality.APPLICATION_MODAL);
			subWindow.setTitle("Add a Hospital");
			subWindow.setMinWidth(400);
			
			Label lblName = new Label();
			lblName.setText("Add a new Hospital to Graph");
	
			//Defining the Last Name text field
			final TextField txtCode = new TextField();
			txtCode.setPromptText("Enter the Hospital Code");
			final TextField txtCode2 = new TextField();
			txtCode2.setPromptText("Enter the Hospital Name");
			final TextField txtCode3 = new TextField();
			txtCode3.setPromptText("Enter the Hospital Speciality Care");
			//Defining the Submit button
			Button submit = new Button("Submit");
			submit.setMinSize(350, 50);
			submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			    public void handle(ActionEvent e) {
			        if ((txtCode.getText() != null && !txtCode.getText().isEmpty())) {
			        	if(hospGraph != null) {
			        		String hcode = txtCode.getText();
							HealthCenter hos = null;
							for(HealthCenter h : hospGraph.getAllVertices()) {
								if(h.getHospID().equals(hcode)) hos = h;
							}
							if(hos!=null)
								txtarea.setText("The Hospital already exists!!!");
							else {
								hos = new HealthCenter(txtCode.getText(), txtCode2.getText(),
										txtCode3.getText(), new Blockchain(difficulty));
								hospGraph.addVertex(hos);
								txtarea.setText(hos.getHospName()+"("+hos.getHospID()+") "
										+ "has been successfully Added!! \n\n" + 
										Utility.viewInsight(hospGraph, txtCode.getText()));
							}
						}
			            subWindow.close();
			        } 
			     }
			 });
			//adding to scene
			VBox layout = new VBox(10);
			layout.getChildren().addAll(lblName, txtCode, txtCode2, txtCode3, submit);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			subWindow.setScene(scene);
			subWindow.showAndWait();
		}
		else if(event.getSource() == btnDisplayGraph) {
			if(hospGraph == null)
				hospGraph = Utility.CreateGaph("HospitalFile.txt", difficulty);
	    	txtarea.setText(Utility.displayHealthGraphVertices(hospGraph));
		} else if(event.getSource() == btnCreatePartnership) {
			Stage subWindow = new Stage();
			
			subWindow.initModality(Modality.APPLICATION_MODAL);
			subWindow.setTitle("Create Hospital Partnership");
			subWindow.setMinWidth(400);
			
			Label lblName = new Label();
			lblName.setText("Create Hospital Partnership");
			lblName.setPadding(new Insets(20, 20, 20, 20));
	
			//Defining the Last Name text field
			final TextField txtCode = new TextField();
			txtCode.setPromptText("Enter the Hospital Code 1");
			txtCode.setPadding(new Insets(20, 20, 20, 20));

			final TextField txtCode2 = new TextField();
			txtCode2.setPromptText("Enter the Hospital Code 2");
			txtCode2.setPadding(new Insets(20, 20, 20, 20));

			//Defining the Submit button
			Button submit = new Button("Submit");
			submit.setPadding(new Insets(20, 20, 20, 20));
			submit.setMinSize(350, 50);
			submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			    public void handle(ActionEvent e) {
			        if ((txtCode.getText() != null && !txtCode.getText().isEmpty())) {
						txtarea.setText(Utility.createHospPartnership(hospGraph, txtCode.getText(),
								txtCode2.getText()) + "Partnership between (" + txtCode.getText() +
								") and (" + txtCode2.getText() + ") has been successfully created!!\n\n" +
								Utility.displayHealthGraphVertices(hospGraph));
			            subWindow.close();
			        } 
			     }
			 });
			//adding to scene
			VBox layout = new VBox(10);
			layout.getChildren().addAll(lblName, txtCode, txtCode2, submit);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			subWindow.setScene(scene);
			subWindow.showAndWait();
		} else if(event.getSource() == btnDeleteHosp) {
			Stage subWindow = new Stage();
			
			subWindow.initModality(Modality.APPLICATION_MODAL);
			subWindow.setTitle("Delete a Hospital");
			subWindow.setMinWidth(400);
			
			Label lblName = new Label();
			lblName.setText("Delete a Hospital");
			lblName.setPadding(new Insets(20, 20, 20, 20));
	
			//Defining the Last Name text field
			final TextField txtCode = new TextField();
			txtCode.setPromptText("Enter the Hospital Code");
			txtCode.setPadding(new Insets(20, 20, 20, 20));

			//Defining the Submit button
			Button submit = new Button("Submit");
			submit.setPadding(new Insets(20, 20, 20, 20));
			submit.setMinSize(350, 50);
			submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			    public void handle(ActionEvent e) {
			        if ((txtCode.getText() != null && !txtCode.getText().isEmpty())) {
			        	if(hospGraph != null) {
			        		String hcode = txtCode.getText();
							HealthCenter hos = null;
							for(HealthCenter h : hospGraph.getAllVertices()) {
								if(h.getHospID().equals(hcode)) hos = h;
							}
							hospGraph.removeVertex(hos);
							txtarea.setText(hos.getHospName()+"("+hos.getHospID()+") "
									+ "has been successfully removed! \n\n" + 
									Utility.displayHealthGraphVertices(hospGraph));
						}
			            subWindow.close();
			        } 
			     }
			 });
			//adding to scene
			VBox layout = new VBox(10);
			layout.getChildren().addAll(lblName, txtCode, submit);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			subWindow.setScene(scene);
			subWindow.showAndWait();
		} else if(event.getSource() == btnViewInsight) {
			Stage subWindow = new Stage();
			
			subWindow.initModality(Modality.APPLICATION_MODAL);
			subWindow.setTitle("Hospital Insight");
			subWindow.setMinWidth(400);
			
			Label lblName = new Label();
			lblName.setText("View Hospital Insight");
			lblName.setPadding(new Insets(20, 20, 20, 20));
	
			//Defining the Last Name text field
			final TextField txtCode = new TextField();
			txtCode.setPromptText("Enter the Hospital Code");
			txtCode.setPadding(new Insets(20, 20, 20, 20));
			//Defining the Submit button
			Button submit = new Button("Submit");
			submit.setMinSize(350, 50);

			submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			    public void handle(ActionEvent e) {
			        if ((txtCode.getText() != null && !txtCode.getText().isEmpty())) {
						txtarea.setText(Utility.viewInsight(hospGraph, txtCode.getText()));
			            subWindow.close();
			        } 
			     }
			 });
			//adding to scene
			VBox layout = new VBox(10);
			layout.getChildren().addAll(lblName, txtCode, submit);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			subWindow.setScene(scene);
			subWindow.showAndWait();
		} else if(event.getSource() == btnRemovePartnership) {
			Stage subWindow = new Stage();
			
			subWindow.initModality(Modality.APPLICATION_MODAL);
			subWindow.setTitle("Remove Hospital Partnership");
			subWindow.setMinWidth(400);
			
			Label lblName = new Label();
			lblName.setText("Remove Hospital Partnership");
			lblName.setPadding(new Insets(20, 20, 20, 20));
	
			//Defining the Last Name text field
			final TextField txtCode = new TextField();
			txtCode.setPromptText("Enter the Hospital Code 1");
			txtCode.setPadding(new Insets(20, 20, 20, 20));
			final TextField txtCode2 = new TextField();
			txtCode2.setPromptText("Enter the Hospital Code 2");
			txtCode2.setPadding(new Insets(20, 20, 20, 20));

			//Defining the Submit button
			Button submit = new Button("Submit");
			submit.setPadding(new Insets(20, 20, 20, 20));
			submit.setMinSize(350, 50);
			submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			    public void handle(ActionEvent e) {
			        if ((txtCode.getText() != null && !txtCode.getText().isEmpty())) {
						txtarea.setText(Utility.removeHospPartnership(hospGraph, txtCode.getText(),
								txtCode2.getText()) + "Partnership between (" + txtCode.getText() +
								") and (" + txtCode2.getText() + ") has been successfully removed!!\n\n" +
										Utility.displayHealthGraphVertices(hospGraph));
			            subWindow.close();
			        } 
			     }
			 });
			//adding to scene
			VBox layout = new VBox(10);
			layout.getChildren().addAll(lblName, txtCode, txtCode2, submit);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			subWindow.setScene(scene);
			subWindow.showAndWait();
		} else if(event.getSource() == btnAddPatient) {
			Stage subWindow = new Stage();
			
			subWindow.initModality(Modality.APPLICATION_MODAL);
			subWindow.setTitle("New Patient to Blockchain");
			subWindow.setMinWidth(400);
			
			Label lblName = new Label();
			lblName.setText("Add a new Patient to Blockchain");
	
			//Defining the Last Name text field
			final TextField txtCod = new TextField();
			txtCod.setPromptText("Enter the Hospital Code");
			final TextField txtCode = new TextField();
			txtCode.setPromptText("Enter the patient Code");
			final TextField txtCode2 = new TextField();
			txtCode2.setPromptText("Enter the patient Name");
			final TextField txtCode3 = new TextField();
			txtCode3.setPromptText("Enter doctor assisting");
			final TextField txtCode4 = new TextField();
			txtCode4.setPromptText("Enter patient's disease");
			final TextField txtCode5 = new TextField();
			txtCode5.setPromptText("Enter payment method");
			final TextField txtCode6 = new TextField();
			txtCode6.setPromptText("Enter prescribed medicine");
			//Defining the Submit button
			Button submit = new Button("Submit");
			submit.setMinSize(350, 50);
			submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			    public void handle(ActionEvent e) {
			        if ((txtCode.getText() != null && !txtCode.getText().isEmpty())) {
			        	if(hospGraph != null) {
			        		String hcode = txtCod.getText();
							HealthCenter hos = null;
							for(HealthCenter h : hospGraph.getAllVertices()) {
								if(h.getHospID().equals(hcode)) hos = h;
							}
							if(hos==null)
								txtarea.setText("Error hospital code!!!");
							else {
								Block b = new Block(new PatientTransaction(txtCode.getText(), 
										txtCode4.getText(), txtCode2.getText(), txtCode3.getText(),
										txtCode5.getText(), txtCode6.getText()), 
										hos.getHospTransactions().getLatestBlock().getHash());
								for(HealthCenter h : hospGraph.getAllVertices()) {
									if(h.getHospID().equals(hcode)) {
										h.getHospTransactions().addBlock(b);
									}
								}
								txtarea.setText(txtCode2.getText()+"("+txtCode3.getText()+") "
										+ "has been successfully Added to the " + txtCod.getText() + 
										"hospital records!! \n\n" + 
										Utility.viewInsight(hospGraph, txtCod.getText()));
							}
						}
			            subWindow.close();
			        } 
			     }
			 });
			//adding to scene
			VBox layout = new VBox(10);
			layout.getChildren().addAll(lblName, txtCod, txtCode, txtCode2, txtCode3, 
										txtCode4, txtCode5, txtCode6, submit);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			subWindow.setScene(scene);
			subWindow.showAndWait();
		} else if(event.getSource() == btnsetDifficulty) {
			Stage subWindow = new Stage();
			
			subWindow.initModality(Modality.APPLICATION_MODAL);
			subWindow.setTitle("Mining difficulty");
			subWindow.setMinWidth(400);
			
			Label lblName = new Label();
			lblName.setText("difficulty of mining");
			lblName.setPadding(new Insets(20, 20, 20, 20));
	
			//Defining the Last Name text field
			final TextField txtCode = new TextField();
			txtCode.setPromptText("Enter the difficulty of mining");
			txtCode.setPadding(new Insets(20, 20, 20, 20));
			//Defining the Submit button
			Button submit = new Button("Submit");
			submit.setMinSize(350, 50);

			submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			    public void handle(ActionEvent e) {
			        if ((txtCode.getText() != null && !txtCode.getText().isEmpty())) {
			        	difficulty = Integer.parseInt(txtCode.getText());
						txtarea.setText("Mining difficulty set to " + txtCode.getText() + "\n\n");
						hospGraph = Utility.CreateGaph("HospitalFile.txt", difficulty);
			            subWindow.close();
			        } 
			     }
			 });
			//adding to scene
			VBox layout = new VBox(10);
			layout.getChildren().addAll(lblName, txtCode, submit);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			subWindow.setScene(scene);
			subWindow.showAndWait();
		} else if(event.getSource() == btnTransferPatientRecord) {
			Stage subWindow = new Stage();
			
			subWindow.initModality(Modality.APPLICATION_MODAL);
			subWindow.setTitle("Transfering patients");
			subWindow.setMinWidth(400);
			
			Label lblName = new Label();
			lblName.setText("Enter Patient ID, Source Hosp, and Dest Hosp");
			lblName.setPadding(new Insets(20, 20, 20, 20));
	
			//Defining the Last Name text field
			final TextField txtCod = new TextField();
			txtCod.setPromptText("Enter the Patient Code 1");
			final TextField txtCode = new TextField();
			txtCode.setPromptText("Enter the source Hospital Code");
			txtCode.setPadding(new Insets(20, 20, 20, 20));
			final TextField txtCode2 = new TextField();
			txtCode2.setPromptText("Enter the destination Hospital Code");
			txtCode2.setPadding(new Insets(20, 20, 20, 20));

			//Defining the Submit button
			Button submit = new Button("Submit");
			submit.setPadding(new Insets(20, 20, 20, 20));
			submit.setMinSize(350, 50);
			submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			    public void handle(ActionEvent e) {
			        if ((txtCode.getText() != null && !txtCode.getText().isEmpty())) {
			        	if(hospGraph != null) {
			        		String hcode = txtCode.getText();
							HealthCenter hosSource = null;
							HealthCenter hosDest = null;
							for(HealthCenter h1 : hospGraph.getAllVertices()) {
								if(h1.getHospID().equals(txtCode2.getText())) {
									hosDest = h1;
								}
							}
							for(HealthCenter h : hospGraph.getAllVertices()) {
								if(h.getHospID().equals(hcode)) {
									hosSource = h;
									for (Block b : h.getHospTransactions().getBlockchain()) {
										if(b.getTransactions().getPatientID().equals(txtCod.getText())) {
											if(hospGraph.isAdjacent(hosSource, hosDest)) {
												hosDest.getHospTransactions().addBlock(b);
												txtarea.setText("Patient record successfully copied!!!\nDestinaiton Hospital: -\n" 
														+ Utility.viewInsight(hospGraph, txtCode2.getText()));
											} else {
												txtarea.setText("Hospitals do not have a partnership!!!");
											}
										}
									}
								}
							}
							if(hosSource == null || hosDest == null)
								txtarea.setText("Error hospital code!!!");
						}
						subWindow.close();
			        } 
			     }
			 });
			//adding to scene
			VBox layout = new VBox(10);
			layout.getChildren().addAll(lblName, txtCod, txtCode, txtCode2, submit);
			layout.setAlignment(Pos.CENTER);
			Scene scene = new Scene(layout);
			subWindow.setScene(scene);
			subWindow.showAndWait();
		}
	}
}
