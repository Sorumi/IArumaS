package view;

import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class RoundPanel extends OrderPanel{
	
	private Label roundTotal;
	private Label roundCurrent;
	private Circle currentRing;
	private int currentSamurai;

	public RoundPanel(int total){
		//bounds
		this.setLayoutX(25);
		this.setLayoutY(25);
		this.setPrefWidth(137);
		this.setPrefHeight(72);
//		this.setStyle("-fx-background-color: #DDDDDD");
		
		Rectangle totalCircle = new Rectangle();
		totalCircle.setWidth(100);
		totalCircle.setHeight(50);
		totalCircle.setX(36);
		totalCircle.setY(11);
		totalCircle.setArcWidth(50);
		totalCircle.setArcHeight(50);
		totalCircle.setFill(Color.WHITE);
		this.getChildren().add(totalCircle);
		
		Circle currentCircle = new Circle();
		currentCircle.setCenterX(36);
		currentCircle.setCenterY(36);
		currentCircle.setRadius(31);
		currentCircle.setStroke(Color.WHITE);
		currentCircle.setStrokeType(StrokeType.OUTSIDE);
		currentCircle.setStrokeWidth(5);
		currentCircle.setFill(Color.WHITE);
		this.getChildren().add(currentCircle);
		
		currentRing = new Circle();
		currentRing.setCenterX(36);
		currentRing.setCenterY(36);
		currentRing.setRadius(28);
		currentRing.setStrokeType(StrokeType.OUTSIDE);
		currentRing.setStrokeWidth(3);
		currentRing.setFill(Color.WHITE);
		this.getChildren().add(currentRing);
		
		roundTotal = new Label(total + "");
		roundTotal.setId("round-total");
		roundTotal.setLayoutX(70);
		roundTotal.setLayoutY(23);
		roundTotal.setPrefWidth(50);
		this.getChildren().add(roundTotal);
		
		roundCurrent = new Label("30");
		roundCurrent.setId("round-current");
		roundCurrent.setLayoutX(2);
		roundCurrent.setLayoutY(22);
		roundCurrent.setPrefWidth(70);
		this.getChildren().add(roundCurrent);
		
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(2.0);
		dropShadow.setOffsetX(0.0);
		dropShadow.setOffsetY(1.0);
		dropShadow.setColor(Color.rgb(0,0,0,0.5));
		
		this.setEffect(dropShadow);
		
	}
	
	public void setRoundTotal(int total){
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				roundTotal.setText(total + "");
			}
		});
	}
	
	public void setRoundCurrent(int current){
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				roundCurrent.setText(current + "");
			}
		});
	}

	public void setCurrentSamurai(int num) {

		Timeline tl = new Timeline(new KeyFrame(Duration.millis(500), new KeyValue(currentRing.strokeProperty(), GameColor.getBlockColor(num))));
		tl.play();
	}
	
}
