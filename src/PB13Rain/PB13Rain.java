/*
 * The MIT License
 *
 * Copyright 2019 Elias Eskelinen.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package PB13Rain;

import JFUtils.dVector;
import PBEngine.*;
import java.awt.Color;

/**
 *
 * @author elias
 */
public class PB13Rain extends JFUtils.InputActivated{
    public String lastFile = null;
    
    public boolean bake = false;
    public boolean saved = false;
    public PBEngine.Supervisor k;
    public int mode = 0;
    Player p;
    
    @Override
    public void tog(){
        System.out.println("TOG!");
    }
    
    @SuppressWarnings("unchecked")
    public PB13Rain(){
        //Input ourInput = new Input(this);
        String[] argss = new String[2];
        argss[0] = "nodemo";
        Camera cam = new Camera(0, 0);
        k = new Supervisor(0, false, new dVector(0, 0), 0);
        //k.customInput = ourInput;
        k.timerType = 1;
        k.features_confFile = "editorConfig.txt";
        Thread A = new Thread(k);
        A.start();
        while(!k.ready){
            
        }
        k.Logic.window.setTitle("PointBreakEngine (Editor2)");
        k.Logic.Vrenderer.factor = 20;
        k.Logic.cam = cam;
        //k.Logic.input = ourInput;
        
        
        k.Logic.abright = true;
        k.Logic.Vrenderer.camMode = 1;
        k.Logic.Vrenderer.drawGrid = true;
        k.Logic.Vrenderer.gridColor = new Color(20, 20, 20);
        k.Logic.overrideRayBG = Color.WHITE;
        
        //add player
            p = new Player(25, 5, 1, "player1", "█", 1F, Color.black, 1, k);
            gameObject torso = new gameObject(25, 5, 1, "player1_torso", "T", 1F, Color.red, 2, k);
            gameObject torso2 = new gameObject(25, 5, 1, "player1_torso2", "T", 1F, Color.red, 3, k);
            //gameObject torso3 = new gameObject(25, 5, 1, "player1_torso2", "T", 1F, Color.red, 3, ref);
            p.addChild(torso);
            torso.addChild(torso2);
            torso2.setParent(torso);
       
            torso.setParent(p);
            torso.tag.add("nocoll");
            torso.collisions = false;
            torso2.tag.add("nocoll");
            torso2.collisions = false;
            torso.visible = false;
            torso2.visible = false;
            
            
            cam = new Camera(p.x, p.y);
            k.Logic.cam = cam;
            
            k.Logic.oM.addObject(torso2);
            k.Logic.oM.addObject(torso);
            k.Logic.oM.addObject(p);
        
        /*Input cursorInput = k.Logic.input;
        //new Input(k);
        Input kbr = (Input) k.Logic.getKeyListeners()[0];
        //k.Logic.addKeyListener(kbr);*/
        
        
        System.out.println("Editor initialization finished");
        System.out.println(k.Logic.running);
    }
    
}
