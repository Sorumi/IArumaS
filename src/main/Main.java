package main;

import controller.msgqueue.OperationQueue;
import controller.msgqueue.StartGameOperation;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.GameModel;
import view.GamePanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import view.MenuPanel;
import view.StoryPanel;

public class Main extends Application {
	
	private Scene scene;
	public Pane basePanel;
	
	public MenuPanel menuPanel; 
	
	public GamePanel gamePanel; 
	public GameModel gameModel;
	
	public StoryPanel storyPanel;

	public Thread operationThread;
	
	@Override
	public void start(Stage primaryStage) {

		basePanel = new Pane();
		scene = new Scene(basePanel);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		menuPanel = new MenuPanel(this);
		menuPanel.setPrefWidth(1200);
		menuPanel.setPrefHeight(800);
		basePanel.getChildren().add(menuPanel);
		
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}

	public void startGame(){
		menuPanel.samuraiTimer.stop();
		basePanel.getChildren().add(gamePanel);
		this.gameModel = new GameModel(24, 14, gamePanel, 0);
		this.gameModel.addObserver(this.gamePanel);
		this.gameModel.getChessBoardModel().addObserver(this.gamePanel);
		OperationQueue operationQueue = new OperationQueue(this.gameModel,this.gamePanel);
		operationThread = new Thread(operationQueue);
		operationThread.start();
	}

	public void startClassicGame(){
		menuPanel.samuraiTimer.stop();
		gamePanel = new GamePanel(15, 99);
		
		basePanel.getChildren().add(gamePanel);
		this.gameModel = new GameModel(24, 14, gamePanel, 99);
		this.gameModel.addObserver(this.gamePanel);
		this.gameModel.getChessBoardModel().addObserver(this.gamePanel);
		OperationQueue operationQueue = new OperationQueue(this.gameModel,this.gamePanel);
		OperationQueue.addOperation(new StartGameOperation());
		
		operationThread = new Thread(operationQueue);
		operationThread.start();
	}
	
	public void startStory(){
		menuPanel.samuraiTimer.stop();
		this.storyPanel = new StoryPanel();
		basePanel.getChildren().add(storyPanel);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
