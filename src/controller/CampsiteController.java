package controller;

import model.StoryModel;
import model.po.Weapon;

/**
 * Created by Kray on 16/5/4.
 */
public class CampsiteController extends TerritoryController {

    public void changeWeapon(int samuraiNum, int weaponNum){
        storyModel.changeWeapon(samuraiNum,weaponNum);
    }

}
