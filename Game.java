package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame
{
    public static final String gamename = "First Game!";
    public static final int menu = 0;
    public static final int play = 0;

    public Game(String name) {
        super(name);
        this.addState(new Menu(menu));
        this.addState(new Play(play));

    }

    public static void main(String[] args)
    {
        AppGameContainer appGameContainer;
        try
        {
            appGameContainer = new AppGameContainer(new Game(gamename));
            appGameContainer.setDisplayMode(640,360,false);
            appGameContainer.start();
            //appGameContainer.setShowFPS(false);

        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.getState(menu).init(gameContainer,this);
        this.getState(play).init(gameContainer,this);

        this.enterState(menu);
    }

}
