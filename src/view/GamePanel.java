package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import model.UpdateMessage;
import model.po.ActualBlock;
import view.listener.GameListener;

public class GamePanel extends JPanel implements Observer {

    private final int WINDOW_WIDTH = 1200;
	private final int WINDOW_HEIGHT = 800;
	private final int FIELD_WIDTH = 1050;
	private final int FIELD_HEIGHT = 600;
	private final int FIELD_FIX = 20;
	
	private int sideBlockQuantity;
	private int blockWidth;
	private int blockHeight;
	//TODO
	private int timeTotal = 5;
	private int roundTotal = 12;
	
	public ChessBoardPanel chessBoard;

	private JLabel playerLabel;
	private JLabel roundLabel;
	private JLabel timeLabel;
	private JLabel actionPointLabel;

	private Arrow arrow;
	private SamuraiView currentSamurai; //0：无 1 2 3 4 5 6
	
	private SamuraiView A1;
	private SamuraiView A2;
	private SamuraiView A3;
	private SamuraiView B1;
	private SamuraiView B2;
	private SamuraiView B3;
	
	private PlayerPanel currentPlayer;
	private PlayerPanel playerA;
	private PlayerPanel playerB;
	
	private ActionButtonPanel actionButtonPanel;
	private GameListener gameListener;
	
	private Image bgImage = Images.BG_0;
	
	public GamePanel(int size){
		this.sideBlockQuantity = size;
		this.setLayout(null);
		this.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
//		this.setBackground(null);
//		this.setOpaque(false);

		
		//playerInfo
		playerA = new PlayerPanel(0, timeTotal);
		playerB = new PlayerPanel(1, timeTotal);
		playerA.getCirclePanel().setSideBlockQuantity(size);
		playerB.getCirclePanel().setSideBlockQuantity(size);
		this.add(playerA);
		this.add(playerB);

		//player 标签
		this.playerLabel = new JLabel("Player");
		this.playerLabel.setBounds(800,20,100,40);
		this.add(this.playerLabel);

		//round 标签
		this.roundLabel = new JLabel("Round");
		this.roundLabel.setBounds(1000, 20, 100, 40);
		this.add(this.roundLabel);

		//time 标签
		this.timeLabel = new JLabel("Time");
		this.timeLabel.setBounds(900,20,100,40);
		this.add(this.timeLabel);

		//actionPoint 标签
		this.actionPointLabel = new JLabel("ActionPoint");
		this.actionPointLabel.setBounds(700,20,100,40);
		this.add(this.actionPointLabel);

		//chessboard
		chessBoard = new ChessBoardPanel(sideBlockQuantity);
		this.add(chessBoard);

		//samurais 需要设置初始位置home
		//TODO
		A1 = new SamuraiView(1, size, 0, 0);
		A2 = new SamuraiView(2, size, 0, 7);
		A3 = new SamuraiView(3, size, 0, 14);
		B1 = new SamuraiView(4, size, 14, 0);
		B2 = new SamuraiView(5, size, 14, 7);
		B3 = new SamuraiView(6, size, 14, 14);
	
		this.add(A1);
		this.add(A2);
		this.add(A3);
		this.add(B1);
		this.add(B2);
		this.add(B3);
		
		//listener
		gameListener = new GameListener(this);
		this.addMouseListener(gameListener);
		A1.addMouseListener(gameListener);
		A2.addMouseListener(gameListener);
		A3.addMouseListener(gameListener);
		B1.addMouseListener(gameListener);
		B2.addMouseListener(gameListener);
		B3.addMouseListener(gameListener);
		
		//arrow & actionButtons
		arrow = new Arrow();
		this.add(arrow);
		
		actionButtonPanel = new ActionButtonPanel(gameListener);
		this.add(actionButtonPanel);
	
		//order
		this.setComponentZOrder(A1, 0);
		this.setComponentZOrder(A2, 1);
		this.setComponentZOrder(A3, 2);
		this.setComponentZOrder(B1, 3);
		this.setComponentZOrder(B2, 4);
		this.setComponentZOrder(B3, 5);
		this.setComponentZOrder(arrow, 6);
		this.setComponentZOrder(actionButtonPanel, 7);
		this.setComponentZOrder(chessBoard, 8);
		this.setComponentZOrder(playerA, 9);
		this.setComponentZOrder(playerB, 10);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(bgImage, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, null);
		
	}

	public void setCurrentSamurai(int i){
		switch (i){
			case 1:
				this.currentSamurai = A1;
				break;
			case 2:
				this.currentSamurai = B1;
				break;
			case 3:
				this.currentSamurai = B2;
				break;
			case 4:
				this.currentSamurai = A2;
				break;
			case 5:
				this.currentSamurai = A3;
				break;
			case 6:
				this.currentSamurai = B3;
				break;
		}
		arrow.setCurrentSamurai(currentSamurai);
		actionButtonPanel.setCurrentSamurai(currentSamurai);
		playerA.setCurrentSamurai(currentSamurai.getNum());
		playerB.setCurrentSamurai(currentSamurai.getNum());
	}

	public SamuraiView getCurrentSamurai(){
		return this.currentSamurai;
	}
	
	public ActionButtonPanel getActionButtons(){
		return this.actionButtonPanel;
	}
	
	public Arrow getArrow(){
		return this.arrow;
	}
	
	public void setCurrentPlayer(int player){
		switch(player){
			case 0:
				this.currentPlayer = playerA;
				playerA.getPointsPanel().setIsShow(true);
				playerB.getPointsPanel().setIsShow(false);
				break;
			case 1:
				this.currentPlayer = playerB;
				playerA.getPointsPanel().setIsShow(false);
				playerB.getPointsPanel().setIsShow(true);
				break;
		}
	}
	
	public void setCurrentRound(int round){
		playerA.setCurrentRound(round);
		playerB.setCurrentRound(round);
		playerA.repaint();
		playerB.repaint();
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		UpdateMessage notifingObject = (UpdateMessage)arg;
		String key = notifingObject.getKey();

		//如果听到的消息是‘samurai’时
		if(key.equals("samurai")){
			this.setCurrentSamurai((int)notifingObject.getValue());
		}else if(key.equals("player")){
			this.playerLabel.setText("玩家 " + Integer.toString((int)notifingObject.getValue()));
			this.setCurrentPlayer((int)notifingObject.getValue());
		}else if(key.equals("round")){
			this.roundLabel.setText("第 " + Integer.toString((int)notifingObject.getValue()) + " 轮");
			this.setCurrentRound((int)notifingObject.getValue());
		}else if(key.equals("time")){
			this.timeLabel.setText("还有 " + Integer.toString((int)notifingObject.getValue()) + " 秒");
			this.currentPlayer.getCirclePanel().setTimeRest((int)notifingObject.getValue());
			this.currentPlayer.repaint();
		}else if(key.equals("actionPoint")){
			this.actionPointLabel.setText("点数剩余 " + Integer.toString((int)notifingObject.getValue()));
			this.currentPlayer.getPointsPanel().setPointsRest((int)notifingObject.getValue());
			this.currentPlayer.repaint();
		}else if(key.equals("pointsTotal")){
			this.currentPlayer.getPointsPanel().setPointsTotal((int)notifingObject.getValue());
		}else if(key.equals("samuraiPosition")){
			ActualBlock block = (ActualBlock)notifingObject.getValue();
			System.out.println(block.getX() + "," + block.getY());
			this.currentSamurai.setActualLocation(block.getX(),block.getY());
			this.actionButtonPanel.setActualLocation();
			this.arrow.setActualLocation();
		}else if(key.equals("start")){
			System.out.println("Initialize...");

		}
		

	}
}

