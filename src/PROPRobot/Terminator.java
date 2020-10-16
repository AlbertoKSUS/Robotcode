/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PROPRobot;

import static java.lang.Math.sqrt;
import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.ScannedRobotEvent;

/**
 *
 *
 * @author alpez
 */
public class Terminator extends AdvancedRobot{
    
    public void run(){
       double x = getBattleFieldWidth();
       double y = getBattleFieldHeight();
        System.out.println("=>"+ x +"=>"+ y);
       while(true){
        //turnLeft(getHeading());
        while(((getX()<= x/2) && (getY()<= y/2)) ||((getX()>= (x/2) && (getY()<= y/2)))){
            System.out.println("Q1");
            double gir = 360 - getHeading();
            turnRight(gir);
            ahead(Math.random()* (y - getY())+ 20 );

            //execute();
        }

        while((getX()<= x/2) && (getY()>= y/2)){
            System.out.println("Q3");
            double gir = 135 - getHeading();
            turnRight(gir);
            ahead(Math.random()*sqrt(((x-getX())*(x-getX())) + (getY()* getY()))+20);


            //execute();
        }
        while((getX()>= x/2 ) && (getY()>= y/2) ){
            System.out.println("Q4");
            double gir = 225 - getHeading();
            turnRight(gir);
            ahead(Math.random()*sqrt((getX()*getX()) + (getY()* getY()))+20);

            //execute();
        }
        /*System.out.println("Q0");
        double gir = 225 - getHeading();
        turnRight(gir);
        ahead(sqrt(y*y + x*x));*/
       }
       //execute();

    }
    public void onScannedRobot(ScannedRobotEvent e){
        //fire(1);
    }
    public void inHitByBullet (HitByBulletEvent e){
       // turnLeft(180);
    }
}
