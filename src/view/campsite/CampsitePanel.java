package view.campsite;

import javafx.scene.layout.Pane;
import view.eventhandler.CampsiteHandler;

public class CampsitePanel extends Pane{

	private CampsiteHandler campsiteHandler;
	
	private CampsiteItemsWrapper itemsPanel;
	private CampsiteItemInfo infoPanel;
	private CampsiteSamuraiWrapper samuraiPanel;
	
	public CampsitePanel(){
		this.setPrefSize(1200, 800);
		campsiteHandler = new CampsiteHandler();
		
		itemsPanel = new CampsiteItemsWrapper(campsiteHandler);
		this.getChildren().add(itemsPanel);
		
		infoPanel = new CampsiteItemInfo();
		this.getChildren().add(infoPanel);
		
		samuraiPanel = new CampsiteSamuraiWrapper();
		this.getChildren().add(samuraiPanel);
	}
}
