import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class momo extends Application {
	
	StackPane root = new StackPane();
	GridPane root1 = new GridPane();
	TableView<Graytable> table = new TableView<>();
	ObservableList<Graytable> data = FXCollections.observableArrayList();
	TableView<k_map> table1 = new TableView<>();
	TableColumn< Graytable, Integer > lastColumn;
	ObservableList<k_map> data1 = FXCollections.observableArrayList();
	Stage stage;
	Scene scene;
	int x;
	StackPane root2 = new StackPane();
	TextField txt = new TextField();
	MediaView video2;
	
	Scene scene1 = new Scene(root2); 
	
	public void kmap(MediaPlayer Music)
	{
		GridPane root3 = new GridPane();
		root3.setVgap(30);
		
		//Media
		
		root2.setMaxSize(350, 375);
		root2.setMinSize(350, 375);
		
		MediaPlayer video1 = new MediaPlayer( new Media(getClass().getResource("back2.mp4").toExternalForm()) );
		video1.setCycleCount( MediaPlayer.INDEFINITE );
		
		MediaView video3 = new MediaView( video1);
		video3.setPreserveRatio( false );
		video3.fitWidthProperty().bind( root3.widthProperty() );
		video3.fitHeightProperty().bind( root3.heightProperty() );
		video1.setAutoPlay(true);
		
		ButtonPane MusicBtn1 = new ButtonPane("Music", new Image(getClass().getResource("1.png").toExternalForm()),
				new Image(getClass().getResource("2.png").toExternalForm()),
				new AudioClip(getClass().getResource("ButtonOnMouse.wav").toExternalForm()),
				new AudioClip(getClass().getResource("Button.wav").toExternalForm()));
		
		MusicBtn1.setOnAction(e -> {
			video1.getOnPlaying();
			Music.play();
			if (video1.getStatus() == Status.PLAYING)
				Music.pause();
			 else {

					Music.play();

				}
		});
		//Back
		
		ButtonPane BackBtn = new ButtonPane("Back", new Image(getClass().getResource("solve2.png").toExternalForm()),
				new Image(getClass().getResource("solve1.png").toExternalForm()),
				new AudioClip(getClass().getResource("ButtonOnMouse.wav").toExternalForm()),
				new AudioClip(getClass().getResource("Button.wav").toExternalForm()));
		BackBtn.setTextSize(14);
		
		BackBtn.setOnAction(e -> {
			video2.fitWidthProperty().bind( root.widthProperty() );
			video2.fitHeightProperty().bind( root.heightProperty() );
			root2.getChildren().remove( video2 );
			root.getChildren().add( 0, video2 );
			stage.setScene(scene);
		});
		
		HBox controlBox1 = new HBox(BackBtn,MusicBtn1);
		controlBox1.setStyle("-fx-background-color:rgba(2 , 0 ,32 , 0.5); -fx-background-radius:25");
		controlBox1.setPadding(new Insets(2, 10, 2, 10));
		controlBox1.setSpacing(20);
		controlBox1.setAlignment(Pos.CENTER);
		
	//setColumn for K-map
		
		root3.getChildren().addAll(controlBox1);
		root3.setPadding(new Insets(20));
		root2.getChildren().add( root3);
		root3.add(table1, 0, 1);	
		Sovle.txt = txt;
		root3.add(txt, 0, 2);
	}
	
	@Override
	public void start( Stage stage ) {
		this.stage = stage;
		table1.setItems( data1 );
		root1.setVgap( 30 );
		
		//alert when we didn't choice the number of var
		
		Alert alert = new Alert( AlertType.ERROR, "Please, Choose the number of variables.", ButtonType.OK );
		// media
		
		MediaPlayer video = new MediaPlayer( new Media(getClass().getResource("back2.mp4").toExternalForm()) );
		video.setCycleCount( MediaPlayer.INDEFINITE );
		MediaPlayer Music = new MediaPlayer( new Media(getClass().getResource("music2.mp3").toExternalForm()) );
		Music.setCycleCount( MediaPlayer.INDEFINITE );
		video2 = new MediaView( video );
		video2.setPreserveRatio( false );
		video2.fitWidthProperty().bind( root.widthProperty() );
		video2.fitHeightProperty().bind( root.heightProperty() );
		video.setAutoPlay(true);
		Music.setAutoPlay(true);

		// musicButton

		ButtonPane MusicBtn = new ButtonPane("Music", new Image(getClass().getResource("1.png").toExternalForm()),
				new Image(getClass().getResource("2.png").toExternalForm()),
				new AudioClip(getClass().getResource("ButtonOnMouse.wav").toExternalForm()),
				new AudioClip(getClass().getResource("Button.wav").toExternalForm()));
		MusicBtn.setOnAction(e -> {
			video.play();
			Music.play();
			if (video.getStatus() == Status.PLAYING) {

				Music.pause();
			} else {

				Music.play();

			}
		});
		kmap(Music);
		// SolveButton

		ButtonPane SolveBtn = new ButtonPane("Solve", new Image(getClass().getResource("solve2.png").toExternalForm()),
				new Image(getClass().getResource("solve1.png").toExternalForm()),
				new AudioClip(getClass().getResource("ButtonOnMouse.wav").toExternalForm()),
				new AudioClip(getClass().getResource("Button.wav").toExternalForm()));
		SolveBtn.setTextSize(14);


		// chooseButton the variable number

		ChoiceBox<Integer> choice = new ChoiceBox<>();
		choice.getItems().addAll(2, 3, 4);
		choice.setTooltip(new Tooltip("number of variables"));
		SolveBtn.setOnAction(e -> {
			if ( choice.getValue() == null ) {
				alert.show();
				return;
			}
			
			fillrows( choice.getValue() );
			root.getChildren().remove(video2);
			root2.getChildren().add(0, video2);
			video2.fitWidthProperty().bind( root2.widthProperty() );
			video2.fitHeightProperty().bind( root2.heightProperty() );
			stage.setScene(scene1);
			fillmap();
			Sovle.solve( choice.getValue() );
		});

		// when we choice the variable number

		choice.setOnAction(e -> {
			int nofv = choice.getValue();
			data.clear();
			table.refresh();
			table.getColumns().clear();
			char c = 'A';
			for (int i = 0; i < nofv; ++i) {

				// add the Column name like A , B ,C ,D

				TableColumn<Graytable, Integer> col = new TableColumn<>("" + c);
				col.setCellValueFactory(new PropertyValueFactory<>("x" + (i + 1)));
				table.getColumns().add(col);
				col.setSortable(false);
				col.setReorderable(false);
				col.setResizable(false);
				col.setMaxWidth(25);
				col.setMinWidth(25);
				++c;
			}
			String[] k = {  "B\\A","0","1","00","10","11","01"};
			table1.getColumns().clear();
			table1.getItems().clear();
			table1.setFixedCellSize(25);
			table1.setMaxWidth( 25 * (nofv+1) + 25 );
			table1.setMinWidth( 25 * (nofv+1) + 25  );
			if ( nofv == 4 ) {
				table1.setMaxHeight( 25 * 5 + 25 );
				table1.setMinHeight( 25 * 5 + 25 );
			}
			else {
				table1.setMaxHeight( 25 * 3 + 25 );
				table1.setMinHeight( 25 * 3 + 25 );
			}
			//table.getColumns().get(1 ).getCellData( 2 );
			int startindex=(nofv == 2 ?0 :2);
			if (nofv==2) {
				k[2]="1";
			}
			else if (nofv==3 )
				k[2]="C\\AB";
			else if (nofv==4) {
				k[2]="CD\\AB";
			}
			int numcolumn =(nofv == 2 ?3:5);
				for (int i=0;i<numcolumn;i++)
				{
					TableColumn<k_map, String> col = new TableColumn<>(k[startindex + i ]);
					col.setCellValueFactory(new PropertyValueFactory<>("a" + (i + 1)));
					table1.getColumns().add(col);
					col.setSortable(false);
					col.setReorderable(false);
					col.setResizable(false);
					col.setMaxWidth(25);
					col.setMinWidth(25);
				}	
		
			
			// add the Last Column (the input for each column)

			TableColumn<Graytable, Integer> tableColumn = new TableColumn<>("Y");
			tableColumn.setCellFactory(s -> new RadioButtonTablecell<>());
			tableColumn.setCellValueFactory(new PropertyValueFactory<>("x5"));
			tableColumn.setOnEditCommit(s -> {
				((Graytable) s.getTableView().getItems().get(s.getTablePosition().getRow())).setX5(s.getNewValue());
			});
			
			table.getColumns().add(tableColumn);
			tableColumn.setSortable(false);
			tableColumn.setReorderable(false);
			lastColumn = tableColumn;
			tableColumn.setMaxWidth(135);
			tableColumn.setMinWidth(135);
			tableColumn.setResizable(false);

			// add rows data for each Column

			String[] a = { "", "", "", "", "00", "10", "11", "01", "000", "100", "010", "001", "110", "011", "101",
					"111", "0000", "1000", "0100", "0010", "0001", "1010", "1001", "1100", "0011", "0101", "0110",
					"1110", "1011", "1101", "0111", "1111" };
			int len = 1 << nofv;
			for (int i = len; i < len * 2; i++) {
				data.add(new Graytable(a[i], nofv));
			}

			// the Table size

			table.setMaxWidth(25 * table.getColumns().size() + 135);
			table.setMinWidth(25 * table.getColumns().size() + 135);

		});

		// instead of constructor

		table.setItems(data);

		// Allow the user to edit the table and it's contents

		table.setEditable(true);

		// add all of musicBtn and solveBtn and choiceBox to a container (to a HBox)

		HBox controlBox = new HBox(MusicBtn, SolveBtn, choice);
		controlBox.setStyle("-fx-background-color:rgba(2 , 0 ,32 , 0.5); -fx-background-radius:25");
		controlBox.setPadding(new Insets(2, 10, 2, 10));
		controlBox.setSpacing(20);
		controlBox.setAlignment(Pos.CENTER);
		root1.getChildren().addAll(controlBox);
		root1.add(table, 0, 1);
		root1.setPadding(new Insets(20));
		
		root.setMaxWidth(347);
		root.setMinWidth(347);
		root.setMaxHeight(584);
		root.setMinHeight(584.0);
		root.getChildren().addAll(video2, root1);
		

		scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("K-map");
		stage.show();
	}
	
	private void fillrows( int n ) {
		data1.clear();
		switch( n ) {
		case 2 : data1.add( new k_map( "0", lastColumn.getCellData( 0 ), lastColumn.getCellData( 1 ), 0, 0 ) );
			     data1.add( new k_map( "1", lastColumn.getCellData( 3 ), lastColumn.getCellData( 2 ), 0, 0 ) ); break;
			     
		case 3 : data1.add( new k_map( "0", lastColumn.getCellData( 0 ), lastColumn.getCellData( 1 ), lastColumn.getCellData( 4 ), lastColumn.getCellData( 2) ) );
				 data1.add( new k_map( "1", lastColumn.getCellData( 3 ), lastColumn.getCellData( 6 ), lastColumn.getCellData( 7 ), lastColumn.getCellData( 5 ) ) ); break;
				 
		case 4 : data1.add( new k_map( "00", lastColumn.getCellData( 0 ), lastColumn.getCellData( 1 ), lastColumn.getCellData( 7 ), lastColumn.getCellData( 2 ) ) );
		         data1.add( new k_map( "10", lastColumn.getCellData( 3 ), lastColumn.getCellData( 5 ), lastColumn.getCellData( 11 ), lastColumn.getCellData( 10 ) ) );
		         data1.add( new k_map( "11", lastColumn.getCellData( 8 ), lastColumn.getCellData( 12 ), lastColumn.getCellData( 15 ), lastColumn.getCellData( 14 ) ) );
		         data1.add( new k_map( "01", lastColumn.getCellData( 4 ), lastColumn.getCellData( 6 ), lastColumn.getCellData( 13 ), lastColumn.getCellData( 9 ) ) ); break;
		}
	}
	
	private void fillmap() {
		Sovle.Rows = data1.size() == 4 ? 4 : 2;
		Sovle.Colmun = table1.getColumns().size() - 1;
		 int i = -1;
		for ( TableColumn< k_map, ? > col : table1.getColumns() ) {
			if ( i == -1 ) {
				++i;
				continue;
			}
			for ( int j = 0; j < Sovle.Rows; ++j )
				Sovle.map[ j ][ i ] = (String) col.getCellData( j );
			++i;
		}
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
