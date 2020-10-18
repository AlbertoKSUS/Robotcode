/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROPRobot;

import java.awt.Color;
import static java.lang.Math.sqrt;
import robocode.AdvancedRobot;
import robocode.util.Utils;
import robocode.HitByBulletEvent;
import robocode.ScannedRobotEvent;
/**
 *
 * @author Alberto, Pedro
 */
public class Terminator2 extends AdvancedRobot{
    
    public void run(){
        //Canvien el color del robot
        Color c = new Color(150, 0, 150);
        setBodyColor(c);
        setGunColor(c);
        setScanColor(c);
        setBulletColor(Color.RED); 
        //nomes mantenin el radar, ja que s'apropa amb la f cercarse
        turnRadarRight(Double.POSITIVE_INFINITY);
    }
    
    public void onScannedRobot(ScannedRobotEvent e) {
        setTurnRadarLeft(getRadarTurnRemaining());
        if (e.getDistance() > 250) cercarse(e); //s'aproxima al robot
        else girar(e);
    }    
    public void cercarse(ScannedRobotEvent e) {
        apunta(e);
        setTurnRight(e.getBearing());
        setAhead(e.getDistance() - 150); // Queda 150 de l'enimic
        if (e.getDistance() < 350) setFire(3); // Si està a menys de 350 de l'enemic dispara
    }
    
    public void apunta(ScannedRobotEvent e) {
        double angle = e.getBearing() + getHeading() - getGunHeading() +(e.getVelocity()*3);
        //Utilitzem el metode utils per a normalitzar els graus
        double girGun = Utils.normalRelativeAngleDegrees(angle);
        setTurnGunRight(girGun);
    }
    //dona voultes sobre el robot
    public void girar(ScannedRobotEvent e) {
        setTurnLeft(-90-e.getBearing());
        apunta(e);
        setAhead(e.getDistance() -150);
        setFire(3);        
    }    
    
    
}
