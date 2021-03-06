package view.campsite;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import model.StoryModel;
import view.StoryPanel;
import view.SystemButton;
import view.TerritoryPanel;
import view.TransitionPanel;
import view.eventhandler.CampsiteHandler;

public class CampsitePanel extends TransitionPanel{

	private CampsiteHandler campsiteHandler;
	
	private CampsiteItemsWrapper itemsPanel;
	public CampsiteItemInfo infoPanel;
	public CampsiteSamuraiWrapper samuraiPanel;
	
	private SystemButton closeBtn;
	
	public CampsitePanel(){
		super();
		
		this.setPrefSize(1200, 800);
		campsiteHandler = new CampsiteHandler(this);
		
		itemsPanel = new CampsiteItemsWrapper(campsiteHandler);		
		infoPanel = new CampsiteItemInfo();
		samuraiPanel = new CampsiteSamuraiWrapper(campsiteHandler);

		//closeBtn
		closeBtn = new SystemButton(0);
		closeBtn.setLayoutX(1125);
		closeBtn.setLayoutY(25);
		closeBtn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				TerritoryPanel parent =  (TerritoryPanel) CampsitePanel.this.getParent();
				parent.getChildren().remove(CampsitePanel.this);
				parent.setBlur(false);
				//退出时保存storyModel
//				campsiteHandler.getCampsiteController().save(StoryModel.getFileNum());
				parent.getTerritoryHandler().updateSamurai();
			}
		});

		this.getChildren().addAll(itemsPanel, infoPanel, samuraiPanel, closeBtn);
		
		campsiteHandler.update();
		this.transitionAnimation(true);
	}

	public CampsiteHandler getCampsiteHandler() {
		return campsiteHandler;
	}
	
	public CampsiteItemsWrapper getItemsPanel(){
		return this.itemsPanel;
	}
}
