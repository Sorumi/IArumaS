package view;

import model.GameModel;
import model.UpdateMessage;
import model.po.ActualBlock;
import model.po.Position;
import model.po.SamuraiPO;
import view.eventhandler.ActionHandler;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Kray on 16/4/18.
 */
public class GamePanelOL extends GamePanel{


    public GamePanelOL(int size){
        super(size);
    }

    public void setCurrentSamurai(int i){
        if(currentSamurai != null){
            currentSamurai.setOnMouseClicked(null);
        }
        switch (i){
            case 1:
                this.currentSamurai = A1;
                break;
            case 2:
                this.currentSamurai = A2;
                break;
            case 3:
                this.currentSamurai = A3;
                break;
            case 4:
                this.currentSamurai = B1;
                break;
            case 5:
                this.currentSamurai = B2;
                break;
            case 6:
                this.currentSamurai = B3;
                break;
        }
        currentSamurai.setOnMouseClicked(actionHandler.samuraiEvent);
        playerA.setCurrentSamurai(currentSamurai.getNum());
        playerB.setCurrentSamurai(currentSamurai.getNum());
        if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)){
            arrow.setCurrentSamurai(currentSamurai);
            actionPanel.setCurrentSamurai(currentSamurai);
        }else{
            arrow.setInvisible();
            actionPanel.setVisible(false);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        UpdateMessage notifingObject = (UpdateMessage)arg;
        String key = notifingObject.getKey();

        if(key.equals("samurai")){
            this.setCurrentSamurai((int)notifingObject.getValue());

        }else if(key.equals("player")){
            this.setCurrentPlayer((int)notifingObject.getValue());

        }else if(key.equals("round")){
            this.setCurrentRound((int)notifingObject.getValue());

        }else if(key.equals("time")){
            System.out.println("time" + (int) notifingObject.getValue());
            int i = this.currentSamurai.getNum();
            if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)){
                this.currentPlayer.circlePanel.setTimeRest((int) notifingObject.getValue());
            }

        }else if(key.equals("actionPoint")){
            this.currentPlayer.pointsPanel.setPointsRest((int)notifingObject.getValue());

        }else if(key.equals("pointsTotal")){
            this.currentPlayer.pointsPanel.setPointsTotal((int)notifingObject.getValue());

        }else if(key.equals("samuraiMove")){
            Position position = (Position)notifingObject.getValue();
            int i = this.currentSamurai.getNum();
            this.currentSamurai.setActualLocation(position.getX(), position.getY());
            if((GameModel.isServer() && (i / 4) == 0) || (GameModel.isClient() && (i / 4) == 1)) {
                this.actionPanel.setActualLocation();
                this.arrow.setActualLocation();
            }

        }else if(key.equals("samuraiHide")){
            this.currentSamurai.setHide((boolean)notifingObject.getValue());

        }else if(key.equals("samuraiOccupy")){

        }else if(key.equals("samuraiKilled")){

        }else if(key.equals("visible")) {
            if(GameModel.isClient() && !GameModel.isServer()) {
                this.B1.setVisible(true);
                this.B2.setVisible(true);
                this.B3.setVisible(true);
                this.A1.setVisible(false);
                this.A2.setVisible(false);
                this.A3.setVisible(false);
                for (ActualBlock block : (ArrayList<ActualBlock>) notifingObject.getValue()) {
                    if (block.getX() == this.A1.x && block.getY() == this.A1.y) {
                        if (!this.A1.isHide()) {
                            this.A1.setVisible(true);
                        }
                    }
                    if (block.getX() == this.A2.x && block.getY() == this.A2.y) {
                        if (!this.A2.isHide()) {
                            this.A2.setVisible(true);
                        }
                    }
                    if (block.getX() == this.A3.x && block.getY() == this.A3.y) {
                        if (!this.A3.isHide()) {
                            this.A3.setVisible(true);
                        }
                    }
                }
            }else if(!GameModel.isClient() && GameModel.isServer()) {
                this.A1.setVisible(true);
                this.A2.setVisible(true);
                this.A3.setVisible(true);
                this.B1.setVisible(false);
                this.B2.setVisible(false);
                this.B3.setVisible(false);
                for (ActualBlock block : (ArrayList<ActualBlock>) notifingObject.getValue()) {
                    if (block.getX() == this.B1.x && block.getY() == this.B1.y) {
                        if (!this.B1.isHide()) {
                            this.B1.setVisible(true);
                        }
                    }
                    if (block.getX() == this.B2.x && block.getY() == this.B2.y) {
                        if (!this.B2.isHide()) {
                            this.B2.setVisible(true);
                        }
                    }
                    if (block.getX() == this.B3.x && block.getY() == this.B3.y) {
                        if (!this.B3.isHide()) {
                            this.B3.setVisible(true);
                        }
                    }
                }
            }
        }else if(key.equals("vision")){
            this.chessBoard.see((ArrayList<ActualBlock>)notifingObject.getValue());
            System.out.println(((ArrayList<ActualBlock>) notifingObject.getValue()).size());
            this.chessBoard.setTmpBlocks((ArrayList<ActualBlock>)notifingObject.getValue());
        }else if(key.equals("home")){
            SamuraiPO samuraiPO = (SamuraiPO)notifingObject.getValue();
            SamuraiPanel tmpView = null;
            switch (samuraiPO.getNumber()){
                case 1:
                    tmpView = this.A1;
                    break;
                case 2:
                    tmpView = this.A2;
                    break;
                case 3:
                    tmpView = this.A3;
                    break;
                case 4:
                    tmpView = this.B1;
                    break;
                case 5:
                    tmpView = this.B2;
                    break;
                case 6:
                    tmpView = this.B3;
                    break;
                default:
                    break;
            }
            tmpView.setActualLocation(samuraiPO.getHome().getX(), samuraiPO.getHome().getY());
            chessBoard.blocks[samuraiPO.getHome().getX()][samuraiPO.getHome().getY()].setHome();
        }
    }

}
