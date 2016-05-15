package view.eventhandler;

import java.text.SimpleDateFormat;

import controller.ArchiveController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.StoryModel;
import view.ArchiveView;
import view.MenuPanel;

public class ArchiveHandler {

	private ArchiveView archiveView;
	private ArchiveController archiveController;
	private int num;
	
	public ArchiveHandler(ArchiveView archiveView, int num){
		this.archiveView = archiveView;
		this.num = num;
		this.archiveController = new ArchiveController();
		this.archiveController.setStoryModel(StoryModel.getStoryModel());

	}
	
	public EventHandler<MouseEvent> loadBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
			  //读取存档 num
			  archiveController.load(num);
			  if(archiveView.type == 1){
				  MenuPanel menu = (MenuPanel) archiveView.getParent().getParent();
				  menu.getMenuHandler().startStory();
			  }
		  }
	};
	
	public EventHandler<MouseEvent> saveBtnClickEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
			  //保存存档 num
			  archiveController.save(num);
			  SimpleDateFormat ft = new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss");
			  archiveView.setTime(ft.format(archiveController.getTime(num)));
	      }
	};
	
	public EventHandler<MouseEvent> loadBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  archiveView.btnPressed(0);
	      }
	};
	
	public EventHandler<MouseEvent> loadBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  archiveView.btnAbled(0);
	      }
	};
	
	public EventHandler<MouseEvent> saveBtnEnterEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  archiveView.btnPressed(1);
	      }
	};
	
	public EventHandler<MouseEvent> saveBtnExitEvent = new EventHandler<MouseEvent>() {  
	      public void handle(MouseEvent event) {
	    	  archiveView.btnAbled(1);
	      }
	};

	public ArchiveController getArchiveController() {
		return archiveController;
	}
}
