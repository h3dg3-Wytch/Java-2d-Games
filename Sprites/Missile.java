package Sprites;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class Missile extends Sprite {

    private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y){
        super(x,y);

        initMissile();

    }

    private void initMissile() {
        loadImage("star.png");
        getImageDimensions();
    }

    //Missile moves at constant speed. When it hits the right border of the board,
    //it becomes invisble. It is then removed from the list of missles.
    public void move(){
        x += MISSILE_SPEED;

        if(x > BOARD_WIDTH){
            vis= false;
        }
    }




}
