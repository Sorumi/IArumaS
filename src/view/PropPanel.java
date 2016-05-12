package view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import view.eventhandler.PropHandler;

public class PropPanel extends OrderPanel{
	private int width = 460;
	private int height = 95;
	
	
	private Rectangle bgRect;
	private Polygon triangle1;
	private Polygon triangle2;
	
	private PropHandler propHandler;
	public PropPanel(){
		this.setPrefHeight(height);
		this.setPrefWidth(width);
		
		this.propHandler = new PropHandler(this);
		bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setY(15);
		bgRect.setWidth(width);
		bgRect.setHeight(80);
		bgRect.setArcWidth(80);
		bgRect.setArcHeight(80);
		bgRect.setFill(Color.WHITE);
		
		triangle1 = new Polygon();
		triangle1.setFill(Color.web("#FFFFFF"));
		triangle1.getPoints().addAll(new Double[]{
			    214.0, 15.0,
			    244.0, 15.0,
			    229.0, 0.0 });
		
		triangle2 = new Polygon();
		triangle2.setFill(Color.web("#F9F1F1"));
		triangle2.getPoints().addAll(new Double[]{
			    217.0, 15.0,
			    241.0, 15.0,
			    229.0, 3.0 });
		triangle2.setOnMouseEntered(propHandler.showPropPanel);
		  
		
		this.getChildren().addAll(bgRect, triangle1, triangle2);
		
		for(int i=0;i<6;i++){
			PropItem item = new PropItem(0, 3);
			item.setLayoutX(5+75*i);
			item.setLayoutY(20);
			this.getChildren().add(item);
		}
		
		this.setOnMouseExited(propHandler.hidePropPanel); 
		this.setLayoutX(370);
		this.setLayoutY(775);
		this.setVisible(true);
		
	}
	
	public void show(){
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(this.layoutYProperty(), 705)));
		timeline.play();

	}
	
	public void hide(){ 
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(this.layoutYProperty(), 775)));
		timeline.play();

	}
	public class PropItem extends StackPane{
		private Circle bgCircle;
		private Label quantityLabel;
		private int RADIUS = 35;
		
		public PropItem(int itemNum, int quantity){
			this.setPrefSize(RADIUS*2, RADIUS*2);
			//圈圈的颜色以后根据传入道具的颜色改
			bgCircle = new Circle();
			bgCircle.setCenterX(RADIUS);
			bgCircle.setCenterY(RADIUS);
			bgCircle.setRadius(RADIUS);
			bgCircle.setFill(Color.web("#D8D8D8"));
			this.getChildren().add(bgCircle);
			
			quantityLabel = new Label(quantity+"");
			quantityLabel.setPrefSize(30, 30);
			quantityLabel.setId("item-quantity");
			this.getChildren().add(quantityLabel);
			StackPane.setAlignment(quantityLabel,Pos.BOTTOM_RIGHT);
		}
		
		
	}
	

}
