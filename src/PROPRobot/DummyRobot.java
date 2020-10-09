/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROPRobot;

import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 *
 * @author alpez
 */
public class DummyRobot extends Robot {
    public void run(){
        turnLeft(getHeading());;
        while(true){
            ahead(500);
            turnRight(90);
        }
    }
    public void onScannedRobot (ScannedRobotEvent e){
        fire(1);
    }
    public void onHitByBullet(HitByBulletEvent e){
        //turnLeft(180);
    }
}
