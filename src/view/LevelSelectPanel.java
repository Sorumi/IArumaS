package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import view.eventhandler.MapHandler;

public class LevelSelectPanel extends Pane{
	private int width = 400;
	private int height = 300;
	
	private MapHandler mapHandler;
	
	public int level;
	private int strokeWidth = 3;
	
	private boolean isAppear;
	
	private SystemButton closeBtn; 
	
	private Rectangle bgRect;
	private Circle centralCircle;	 
	private Circle materialCircleOne;
	private Circle materialCircleTwo;
	
	private MaterialView materialOne;
	private MaterialView materialTwo;
	
	private Label levelName;
	private Label materialGet;
	private Label materialNameOne;
	private Label materialNameTwo;
	 
	private Button levelBtnOne;
	private Button levelBtnTwo;
	private Button levelBtnThree;

	
	public LevelSelectPanel(MapHandler mapHandler){
		this.mapHandler = mapHandler;
		
		//TODO
//		int itemNumOne = 00;
//		int itemNumTwo = 10;
		
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setId("level-select-panel");
		
		bgRect = new Rectangle();
		bgRect.setX(0);
		bgRect.setWidth(400);
		bgRect.setHeight(300);
		bgRect.setArcWidth(10);
		bgRect.setArcHeight(10);
		bgRect.setFill(Color.WHITE);
		
		centralCircle = new Circle();
		centralCircle.setCenterX(200.0);
		centralCircle.setRadius(50);
		centralCircle.setStroke(Color.web("#eeeeee"));
		centralCircle.setStrokeWidth(strokeWidth);
		centralCircle.setStrokeType(StrokeType.INSIDE);
		centralCircle.setFill(Color.WHITE);
		
		levelName = new Label("关卡名称");
		levelName.setLayoutX(152);
		levelName.setLayoutY(70);
		levelName.setId("LevelName-label");
		
		materialGet = new Label("可获得素材"); 
		materialGet.setLayoutX(30);
		materialGet.setLayoutY(135);
		materialGet.setId("materialName-label");
		 
		materialNameOne = new Label(""); 
		materialNameOne.setLayoutX(215);
		materialNameOne.setLayoutY(135);
		materialNameOne.setId("materialName-label"); 
		
		materialNameTwo = new Label(""); 
		materialNameTwo.setLayoutX(335);
		materialNameTwo.setLayoutY(135);
		materialNameTwo.setId("materialName-label");

		materialCircleOne = new Circle();
		materialCircleOne.setCenterX(175);
		materialCircleOne.setCenterY(140);
		materialCircleOne.setRadius(25);

		materialCircleTwo = new Circle();
		materialCircleTwo.setCenterX(295);
		materialCircleTwo.setCenterY(140);
		materialCircleTwo.setRadius(25);

		materialOne = new MaterialView();
//		materialOne.setLayoutX(125);
//		materialOne.setLayoutY(90);
//		materialOne.setScaleX(0.5);
//		materialOne.setScaleY(0.5);
		
		materialTwo = new MaterialView(); 
//		materialTwo.setLayoutX(245);
//		materialTwo.setLayoutY(90);
//		materialTwo.setScaleX(0.5);
//		materialTwo.setScaleY(0.5);
		
		levelBtnOne = new LevelButton("简 单", 1); 
		levelBtnTwo = new LevelButton("普 通", 2);
		levelBtnThree = new LevelButton("困 难", 3);
		
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(375);
		closeBtn.setLayoutY(-25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					LevelSelectPanel.this.setVisible(false);
				}
		});
		
		this.getChildren().addAll(bgRect, centralCircle, levelName, materialGet, materialNameOne, materialNameTwo, materialCircleOne, materialCircleTwo, materialOne, materialTwo, levelBtnOne, levelBtnTwo, levelBtnThree, closeBtn);
		this.setVisible(false);
	}
	
	//内部类
	public class LevelButton extends Button{
		
		public int num;
		
		public LevelButton(String str, int num){
			super(str);
			
			this.num = num;
			this.setPrefSize(100, 40);
			this.setId("level-btn");		
			this.setLayoutX(125*(num-1)+25);
			this.setLayoutY(220);
			this.setOnMouseClicked(mapHandler.startGameEvent);
			this.setOnMouseEntered(mapHandler.levelBtnEnterEvent);
			this.setOnMouseExited(mapHandler.levelBtnExitEvent);
			this.btnAbled();
			
		}
		public void btnPressed() {
			this.setLayoutY(224);
			this.setStyle("-fx-text-fill: " + GameColor.getLevelColorString(num+6) + ";"
					+ "-fx-background-color: " + GameColor.getLevelColorString(num) + ";"
					+ "-fx-effect: dropshadow(gaussian," + GameColor.getLevelColorString(num+3) +", 0, 0, 0, 4);");
		}
		public void btnAbled() {
			this.setLayoutY(220);
			this.setStyle("-fx-text-fill: " + GameColor.getLevelColorString(num+6) + ";"
					+ "-fx-background-color: " + GameColor.getLevelColorString(num) + ";"
					+ "-fx-effect: dropshadow(gaussian," + GameColor.getLevelColorString(num+3) +", 0, 0, 0, 8);");
		}
		
	}
	
	public void setLevel(int level){
		this.level = level;
		
		int itemNumOne = 00;
		int itemNumTwo = 10;
		switch(level){
		case 1:
			materialNameOne.setText("布料");
			materialNameTwo.setText("木材");
			itemNumOne = 0;
			itemNumTwo = 10;
			break;
		case 2:
			materialNameOne.setText("木材");
			materialNameTwo.setText("石材");
			itemNumOne = 10;
			itemNumTwo = 20;
			break;
		case 3:
			materialNameOne.setText("石材");
			materialNameTwo.setText("金属");
			itemNumOne = 20;
			itemNumTwo = 30;
			break;
		case 4:
			materialNameOne.setText("金属");
			materialNameTwo.setText("水晶");
			itemNumOne = 30;
			itemNumTwo = 40;
			break;
		case 5:
			materialNameOne.setText("水晶");
			materialNameTwo.setText("布料");
			itemNumOne = 40;
			itemNumTwo = 0;
			break;
		}
		this.getChildren().removeAll(materialOne, materialTwo);
		
		materialCircleOne.setFill(GameColor.getMaterialColor(itemNumOne/10));
		materialCircleTwo.setFill(GameColor.getMaterialColor(itemNumTwo/10));
		
		materialOne = new MaterialView(itemNumOne); 
		materialOne.setLayoutX(125);
		materialOne.setLayoutY(90);
		materialOne.setScaleX(0.5);
		materialOne.setScaleY(0.5);
		
		materialTwo = new MaterialView(itemNumTwo); 
		materialTwo.setLayoutX(245);
		materialTwo.setLayoutY(90);
		materialTwo.setScaleX(0.5);
		materialTwo.setScaleY(0.5);
		
		this.getChildren().addAll(materialOne, materialTwo);
	}
	
	public void setAppear(boolean isAppear) {
		// TODO Auto-generated method stub
		this.isAppear = isAppear;
		this.setVisible(isAppear);
	}

}
