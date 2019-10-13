// Assignment #: 6
//         Name: Nandakishore Vudumula
//    StudentID: 1214723796
//      Lecture: MWF 10:45
//	Description: This is the CreatePane class which gives the layout to be displayed to the user for movie creation, and enables user input to add movies to a list.

import java.util.ArrayList;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.collections.*;
//importing all necessary packages from javafx

public class CreatePane extends HBox {
	private ArrayList<Movie> movieList;
	private ReviewPane reviewPane;
	private Button CButton;
	private TextField title;
	private TextField length;
	private TextField year;
	private Label red;
	private TextArea Marea;
	//initializing all instance variables, that consist of objects of ArrayList, ReviewPane, button, textfield, textarea, and label
	public CreatePane(ArrayList list, ReviewPane rePane){
		this.movieList = list;
		this.reviewPane = rePane;
		//constructor of CreatePane class
		Label title1 = new Label("Title");
		title = new TextField("");
		Label length1 = new Label("Length");
		length = new TextField("");
		Label year1 = new Label("Year");
		year = new TextField("");
		Label CLabel = new Label("Create a Movie");
		CButton = new Button(CLabel.getText());
		red= new Label("Please fill all fields");
		red.setTextFill(Color.RED);
		//creating the labels, textfields, and button to be used in movie creation
		GridPane Mgrid = new GridPane();
		
		Mgrid.add(title1, 0, 0);
		Mgrid.add(length1, 0, 1);
		Mgrid.add(year1, 0, 2);
		Mgrid.add(title, 1, 0);
		Mgrid.add(length, 1, 1);
		Mgrid.add(year, 1, 2);
		//adding all the textfields and labels to a grid pane
		Mgrid.setMaxSize(350, 100);
		Mgrid.setPadding(new Insets(10,10,10,40));
		Mgrid.setHgap(5.0);
		Mgrid.setVgap(5.0);
		//setting the grid pane size and spacing
		Marea = new TextArea();
		Marea.setText("");
		//creating empty text area
		HBox message = new HBox();
		message.getChildren().add(red);
		//creating an HBox for the label that will display the red messages
		HBox Mbutton = new HBox();
		Mbutton.setAlignment(Pos.CENTER);
		Mbutton.getChildren().add(CButton);
		//creating an HBoc for the button that the user will press to add the movie
		VBox left = new VBox();
		left.setMinWidth(300.0);
		left.getChildren().addAll(message, Mgrid, Mbutton);
		//Vbox that adds all the left hand components in order from top to bottom
		HBox CPane = new HBox();
		CPane.setMinSize(750, 500);
		CPane.getChildren().addAll(left,Marea);
		//HBox that adds the left Vbox and the text area 
		this.getChildren().add(CPane);
		//this method that adds the HBox CPane that contains everything to createPane
		ButtonHandler handler = new ButtonHandler();
		CButton.setOnAction(handler);
		//creating the object of button handler and using setOnAction for the button the user will press
		
		
		
		
		
	}
	private class ButtonHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			if(title.getText().trim().isEmpty() || length.getText().trim().isEmpty()||year.getText().trim().isEmpty()) {
				red.setText("Please enter all fields");
			}//if statement that checks to make sure all fields have input in them, and prompts user to do so if they aren't
			else {
			
			try {
				int mlength = Integer.parseInt(length.getText());
				int myear = Integer.parseInt(year.getText());
					
			}catch(NumberFormatException ex) {
				red.setText("Incorrect data format");
				return;
			}//try catch that checks to make sure the input for length and year are integers, and has a NumberFormat Exception if they are not 
			Movie m1 = new Movie();
			//new object of movie class
			m1.setMovieTitle(title.getText());
			m1.setLength(Integer.parseInt(length.getText()));
			m1.setYear(Integer.parseInt(year.getText()));
			//setting the title, length, and year for the new movie added
			movieList.add(m1);
			//adds the new movie to ArrayList movieList
			red.setText("Movie Added");//lets the user know movie has been added
			reviewPane.updateMovieList(m1);
			//updates the movie list on reviewPane 
			
			Marea.setText("");
			for(int i = 0; i<movieList.size();i++) {
				Marea.setText(Marea.getText()+movieList.get(i).toString());
			}//for loop that sequentially goes through movieList and sets the Text for all the movies in the ArrayList
			
			title.setText("");
			length.setText("");
			year.setText("");
			//resets the textfields
		}
		}
	}

}
