package com.divyanshu.ponggame;

import android.graphics.RectF;

/**
 * Represents each individual Bricks
 */
public class Brick {

    private RectF mRect;
    private boolean isHit;

    /**
     * Constructs a brick
     * @param row  Row of the brick
     * @param column    Column of the brick
     * @param brickHeight   Height of the brick
     * @param brickWidth    Width of the brick
     */
    public Brick(int row, int column, int brickHeight, int brickWidth){

        isHit = false;

        int padding = 4;

        mRect = new RectF(column * brickWidth + padding,
                row * brickHeight + padding,
                column * brickWidth + brickWidth - padding,
                row * brickHeight + brickHeight - padding);
    }

    /**
     * @return Returns a referece of the mRect  to PongGame
     */
    RectF getRect(){
        return mRect;
    }



    public Boolean isBrickHit(){
        return isHit;
    }

    /**
     * Modifies the isHit Boolean to true
     */
    public void hitBrick(){
        isHit = true;
    }




}
