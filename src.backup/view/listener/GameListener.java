package view.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GamePanel;

public class GameListener implements MouseListener{
	
	private GamePanel game;
	
	public GameListener(GamePanel game){
		this.game = game;
	}

	public GameListener() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == game.getCurrentSamurai()) {
			game.getActionButtons().setVisible(true);
			game.getArrow().setVisible(false);
		} else if (e.getSource() == game.getActionButtons().getMoveButton()) {
			game.getActionButtons().setSecondary(true);
			//发送判断
			//出现（四个方向的）尖头
		} else if (e.getSource() == game.getActionButtons().getOccupyButton()) {
			game.getActionButtons().setSecondary(true);
			//发送判断
			//出现四个方向的尖头
		} else if (e.getSource() == game.getActionButtons().getHideButton()) {
			game.getActionButtons().setSecondary(true);
			//
		} else if (e.getSource() == game.getActionButtons().getBackButton()) {
			game.getActionButtons().setSecondary(false);
			//
		} else if (e.getSource() == game.getActionButtons().getExitButton()) {
			game.getActionButtons().setSecondary(false);
			//进入下一轮
		} else {
			game.getActionButtons().setVisible(false);
			game.getActionButtons().setSecondary(false);
			game.getArrow().setVisible(true);
		}
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}