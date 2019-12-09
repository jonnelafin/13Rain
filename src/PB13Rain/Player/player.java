/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PB13Rain.Player;

import JFUtils.Input;
import JFUtils.dVector;
import PBEngine.Player;
import PBEngine.Supervisor;
import PBEngine.directory;
import java.awt.Color;

/**
 *
 * @author Elias Eskelinen <elias.eskelinen@protonmail.com>
 */
public class player extends Player{
    
    public player(int ypos, int xpos, int size, String tag, String ap, float mas, Color cot, int ID, Supervisor master) {
        super(ypos, xpos, size, tag, ap, mas, cot, ID, master);
        //"player/player2.png";
        this.imageName = dir.textures + "player/Player_idle_32.png";
        
    }
    @Override
    public void rot(Input inp){
        dVector reversed = masterParent.Logic.mouse_projected;
        double xc = reversed.x;
        double yc = reversed.y;
        double c = Math.sqrt(Math.pow(xc, 2) + Math.pow(yc, 2));
        //System.out.println(c);
        double rot = Math.atan2(reversed.y, reversed.x);
        if(!Double.isNaN(rot)){
            this.setDegrees(rot * (180/Math.PI));
            //System.out.println(rot);
        }
    }
}
