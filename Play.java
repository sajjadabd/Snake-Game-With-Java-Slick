package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

//import org.newdawn.slick.state.GameState;

public class Play extends BasicGameState { //  implements GameState {

    Animation gamer ,
    movingUp ,
    movingDown ,
    movingLeft ,
    movingRight ;

    Image world ;

    boolean quit = false;

    int[] duration = {200,200};

    float gamerPositionX = 0;
    float gamerPositionY = 0;

    float shiftX = gamerPositionX + 360;
    float shiftY = gamerPositionY + 160;

    double worldSpeedWalk = 0.2;
    double gamerSpeedWalk = 0.1;


    public Play(int play) {
    }

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        world = new Image("res/world.png");
        Image[] walkUp = {new Image("res/buckysBack.png"),new Image("res/buckysBack.png")};
        Image[] walkDown = {new Image("res/buckysFront.png"),new Image("res/buckysFront.png")};
        Image[] walkLeft = {new Image("res/buckysLeft.png"),new Image("res/buckysLeft.png")};
        Image[] walkRight = {new Image("res/buckysRight.png"),new Image("res/buckysRight.png")};



        movingUp = new Animation(walkUp,duration,false);
        movingDown = new Animation(walkDown,duration,false);
        movingLeft = new Animation(walkLeft,duration,false);
        movingRight = new Animation(walkRight,duration,false);

        gamer = movingDown;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        //graphics.drawString("Welcome Here to play Game!!",200,100);
        world.draw(gamerPositionX,gamerPositionY);
        gamer.draw(shiftX,shiftY);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        Input input = gameContainer.getInput();

        if(input.isKeyDown(Input.KEY_W))
        {
            //setAllFalse();
            //up = true;


            //shiftY -= gamerSpeedWalk;
            gamerPositionY += worldSpeedWalk;
            gamer = movingUp;
        }
        else if (input.isKeyDown(input.KEY_S))
        {
            //setAllFalse();
            //down = true;


            //shiftY += gamerSpeedWalk;
            gamerPositionY -= worldSpeedWalk;
            gamer = movingDown;
        }
        else if (input.isKeyDown(input.KEY_A))
        {
            //setAllFalse();
            //left = true;


            //shiftX -= gamerSpeedWalk;
            gamerPositionX += worldSpeedWalk;
            gamer = movingLeft;
        }
        else if (input.isKeyDown(input.KEY_D))
        {
            //setAllFalse();
            //right = true;


            //shiftX += gamerSpeedWalk;
            gamerPositionX -= worldSpeedWalk;

            gamer = movingRight;
        }
    }
}
