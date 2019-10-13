// Assignment #: 6
//         Name: Nandakishore Vudumula
//    StudentID: 1214723796
//      Lecture: MWF 10:45
//	Description: This ReviewPane class gives the layout to be displayed for the review tab, and allows the user to select a movie and give a rating, and then updates the rating

import java.util.ArrayList;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.collections.*;
//importing the packages from javafx
public class ReviewPane extends VBox {
	private ToggleGroup Mgroup;
	private ArrayList<Movie> movieList;
	private ObservableList<Movie> ObvList;
	private Button MButton;

	private RadioButton one;
	private RadioButton two;
	private RadioButton three;
	private RadioButton four;
	private RadioButton five;
	private ListView<Movie> MList;
	//initializing the instance variables, that include objects of ArrayList, ObservableList, toggleGroup, button, radiobutton, ListVeiw, etc
	public ReviewPane(ArrayList<Movie> list) {
		this.movieList= list;
		//constructor of ReviewPane 
		ObvList = FXCollections.observableArrayList(movieList);
		//object of ObservableList
		MList = new ListView<Movie>();
		//object of ListView
		one = new RadioButton("1 Poor");
		two = new RadioButton("2 Fair");
		three = new RadioButton("3 Average");
		four = new RadioButton("4 Good");
		five = new RadioButton("5 Excellent");
		//five objects of radiobutton for the five different radio button options for ratings
		Mgroup = new ToggleGroup();
		one.setToggleGroup(Mgroup);
		two.setToggleGroup(Mgroup);
		three.setToggleGroup(Mgroup);
		four.setToggleGroup(Mgroup);
		five.setToggleGroup(Mgroup);
		//setting the radiobuttons to the object of ToggleGroup
		
		Label MLabel = new Label("Submit Review");
		//creating new Label to be used by the button
		MButton = new Button(MLabel.getText());
		//button that uses the label from MLabel
		Label a1 = new Label("Choose a movie to give a review, and select a rating:");
		//top label that gives directions to the user
		HBox RBPane = new HBox();
		RBPane.setAlignment(Pos.CENTER);
		RBPane.setSpacing(5.0);
		RBPane.getChildren().addAll(one,two,three,four,five);
		//HBox that consists of al the radiobuttons
		
		Pane BPane = new Pane();
		BPane.getChildren().addAll(MButton);
		//pane that holds the button
		Pane LPane = new Pane();
		LPane.getChildren().addAll(MList);
		MList.setPrefSize(600, 200);
		//pane that holds the ListView MList
		
		
		VBox Vpane = new VBox();
		Vpane.setSpacing(7);
		Vpane.getChildren().addAll(a1,LPane,RBPane, BPane);
		//VBox that adds the directions label, the ListView, the radiobuttons, and the button in sequential order
		this.getChildren().add(Vpane);
		//this method that adds the VBox to the ReviewPane
		
		RatingHandler handle = new RatingHandler();
		//creating object handle of RatingHandler
		MButton.setOnAction(handle);
		//using setOnAction for the button the user will press
	
		
	}
	public void updateMovieList(Movie newMovie) {
		ObvList.add(newMovie);
		MList.setItems(ObvList);
		//void class that adds the newMovie to observable list, and then sets it in the ListView
		
		
	}
	private class RatingHandler implements EventHandler<ActionEvent>{
			public void handle(ActionEvent e) {
				
				
				int m = MList.getSelectionModel().getSelectedIndex();
				//integer that receives the index for the particular movie
				if (one.isSelected()==true) { 
					
	            	movieList.get(m).addRating(1);
	            	MList.refresh();
	            	
	            	return;
					
				}
				if (two.isSelected()==true) {
					
					movieList.get(m).addRating(2);
					MList.refresh();
	            	
	            	return;
				}
				if (three.isSelected()==true) {
					
					movieList.get(m).addRating(3);
					MList.refresh();
	            	
	            	return;
				}
				if (four.isSelected()==true) {
					
					movieList.get(m).addRating(4);
					MList.refresh();
	            	
	            	return;
				}
				if (five.isSelected()==true) {
					
					movieList.get(m).addRating(5);
					MList.refresh();
	            	
	            	return;
				}//five if statements that check which radio button is selected, and then adds the corresponding rating by using the addRating method from the movie class, and then refreshes the ListView so the user can see the updated score
				
				
				
			}
			
		}
		
	}

