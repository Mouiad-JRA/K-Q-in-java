package it.kmaps.project;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

class ButtonPane extends StackPane {
	private Label lbl;
	@SuppressWarnings("unused")
	private Image img1, img2;
	private ImageView img;
	private AudioClip a1, a2;
	
	public ButtonPane( String txt, Image img1, Image img2, AudioClip a1, AudioClip a2 ) {
		this.lbl = new Label( txt );
		this.img1 = img1;
		this.img2 = img2;
		this.a1 = a1;
		this.a2 = a2;
		img = new ImageView( img1 );
		
		img.setFitWidth( img1.getWidth() );
		setMaxWidth( img1.getWidth() );
		
		lbl.setFont( Font.font( "Times New Roman", FontWeight.BOLD, 22 ) );
		
		setOnMouseEntered( e -> {
			lbl.setEffect( new Glow( 1.0 ) );
			setCursor( Cursor.HAND );
			img.setImage( img2 );
			lbl.setTextFill( Color.YELLOW );
			if ( a1 != null )
				a1.play();
		});
		
		setOnMouseExited( e -> {
			lbl.setEffect( null );
			lbl.setTextFill( Color.WHITE );
			setCursor( Cursor.DEFAULT );
			img.setImage( img1 );
		});
		
		setOnMousePressed( e -> {
			lbl.setTextFill( Color.WHITE );
			lbl.setEffect( null );
			if ( a2 != null )
			a2.play();
			setCursor( Cursor.DEFAULT );
		} );

		getChildren().addAll( img, lbl );
	}
	
	public ImageView getImage() {
		return img;
	}
	
	public void setA1( AudioClip a1 ) {
		this.a1 = a1;
	}
	
	public void setA2( AudioClip a2 ) {
		this.a2 = a2;
	}
	
	public AudioClip getA1() {
		return a1;
	}
	
	public AudioClip getA2() {
		return a2;
	}
	
	public void setOnAction( EventHandler< MouseEvent > e ) {
		setOnMouseClicked( e );
	}
	
	public void setTextColor( Paint value ) {
		lbl.setTextFill( value );
	}
}