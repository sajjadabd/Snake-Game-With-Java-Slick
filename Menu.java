package javagame;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.XRandR;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

//import org.newdawn.slick.state.GameState;

public class Menu extends BasicGameState{ // implements GameState {

    public String mouse = "No Input Yet!";

    Image play,exit;
    int Xposition,Yposition;

    int width = 640;
    int height = 360;


    boolean right = false;
    boolean left  = false;
    boolean up  = false;
    boolean down = false;

    boolean way = false;

    float x=300,y=100;

    public Menu(int menu) {
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        play = new Image("res/playNow.png");
        exit = new Image("res/exitGame.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        gameContainer.setShowFPS(false);
        graphics.setBackground(Color.white);
        graphics.setColor(Color.black);

        //img = new Image("res/play.png");
        graphics.drawImage(play,230,50);
        //play.draw(230,50);
        graphics.drawImage(exit,230,180);
        //exit.draw(230,180);
        graphics.drawString("X : " + Xposition,50,50);
        graphics.drawString("Y : " + Yposition,50,150);

        //graphics.drawString("X_Rotate : " + play.getWidth(),50,250);
        //graphics.drawString("Y_Rotate : " + play.getHeight(),50,300);
        //graphics.drawRect(100,100,100,100);
        //graphics.drawOval(100,100,100,100);

        //graphics.drawOval(Xposition,height - Yposition,10,10);
        //graphics.fillOval(Xposition,height - Yposition,10,10);

        //graphics.fillOval(x,y,10,10);

    }

    public void setAllFalse()
    {
        down = false;
        up = false;
        right = false;
        left = false;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {


        Xposition = Mouse.getX();
        Yposition = Mouse.getY();

        Input input = gameContainer.getInput();

        //233,431
        //144,177

        //235,429
        //272,307



        if( (Xposition > 233 && Xposition < 431 ) && (Yposition > 144 && Yposition < 177) )
        {
            if(input.isMouseButtonDown(0))
            {
                //stateBasedGame.enterState(1);
                System.exit(0);
            }
        }
        else if( (Xposition > 235 && Xposition < 429 ) && (Yposition > 272 && Yposition < 307) )
        {
            if(input.isMouseButtonDown(0))
            {
                stateBasedGame.enterState(1);
            }
        }


    }
}
