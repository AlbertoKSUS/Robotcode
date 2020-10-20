/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROPRobot;

import java.awt.Color;
import robocode.AdvancedRobot;
import static robocode.Rules.MAX_BULLET_POWER;
import robocode.util.Utils;
import robocode.ScannedRobotEvent;

/**
 *
 * @author Alberto, Pedro
 */
public class Terminator extends AdvancedRobot{
    /**
     * Aquest es el métode main del robot Terminator 
     **/
    @Override
    public void run(){
        //Canvien el color del robot
        Color c = new Color(150, 0, 150);
        setBodyColor(c);
        setGunColor(c);
        setScanColor(c);
        setBulletColor(Color.RED); 
        //nomes mantenim el radar, ja que s'apropa amb la f(acercarse)
        turnRadarRight(Double.POSITIVE_INFINITY);
    }
    /**
     * Aquest métode s'executa quan el radar detecta un robot enemic
     * @param e Robot enemic detectat
     **/
    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        setTurnRadarLeft(getRadarTurnRemaining());
        if (e.getDistance() > 250) acercarse(e); //s'aproxima al robot
        else girar(e);
    }
    /**
     * Aquest métode apropa a Terminator a una distancia de 150 del enemic i  comença a disparar a una distancia < 350 
     * @param e Robot enemic detectat
     **/
    public void acercarse(ScannedRobotEvent e) {
        apunta(e);
        setTurnRight(e.getBearing());
        setAhead(e.getDistance() - 150); // Queda a 150 de l'enemic
        if (e.getDistance() < 350) setFire(MAX_BULLET_POWER); // Si està a menys de 350 de l'enemic dispara
    }
    /**
     * Aquest métode calcula l'angle i aplica aquest angle per fer un girar el canó cap a l'enemic  
     * @param e Robot enemic detectat
     **/
    public void apunta(ScannedRobotEvent e) {
        double angle = e.getBearing() + getHeading() - getGunHeading() +(e.getVelocity()*4);
        //Utilitzem el metode utils per a normalitzar els graus
        double girGun = Utils.normalRelativeAngleDegrees(angle);
        setTurnGunRight(girGun);
    }
    /**
     * Aquest métode gira al voltant de l'enemic a una distancia > 150 del enemic i disparant
     * @param e Robot enemic detectat
     **/
    public void girar(ScannedRobotEvent e) {
        setTurnLeft(-90-e.getBearing());
        apunta(e);
        setAhead(e.getDistance() -150);
        setFire(MAX_BULLET_POWER);        
    }
    
}
