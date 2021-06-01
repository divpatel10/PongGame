package com.divyanshu.ponggame;

import android.graphics.RectF;


/**
 * Represents the Obstacles
 */
public class Obstacle {

    private RectF mRect;
    private float mLength;
    private float mXCoord;
    private float mObstacleSpeed;
    private int mScreenX;

    // Keeps track of total objects
    private static int TOTAL_OBSTACLES = 0;


    final int STOPPED = 0;
    final int LEFT = 1;
    final int RIGHT = 2;
    // Keeps track of if and how the obstacle is moving
    // Starting with STOPPED condition
    private int mObstacleState = STOPPED;

    /**
     * Constructs the obstacles
     * @param sx Screen width
     * @param sy Screen height
     */
    public Obstacle(int sx, int sy){

        // Bat needs to know the screen
        // horizontal resolution
        // Outside of this method
        mScreenX = sx;
        // Configure the size of the obstacle based on
        // the screen resolution
        // One tenth the screen width
        mLength = mScreenX / 10;
        // One fortieth the screen height
        float height = sy / 50;
        // Configure the starting location of the obstacle
        // Roughly the middle horizontally
        mXCoord = mScreenX / 2;

        TOTAL_OBSTACLES++;


        // The height of the obstacle
        // off the bottom of the screen
        // The height is set to be 1/5th the height of the screen from top
        // all the next obstacles will be 100 pixels below the previous obstacle
        float mYCoord = ((sy/5) + height + (100 * TOTAL_OBSTACLES));

        // Initialize mRect based on the size and position
        mRect = new RectF(mXCoord, mYCoord,
                mXCoord + mLength,
                (mYCoord + height));
        // Configure the speed of the obstacle
        // This code means the bat can cover the
        // width of the screen in 1/3 of a second
        mObstacleSpeed = mScreenX/3;


    }

    RectF getRect(){
        return mRect;
    }

    void setMovementState(int state){
        mObstacleState = state;
    }


    /**
     * update the position of the obstacles for each frame
     */
    void update(long fps){

        if(mObstacleState == LEFT){
            mXCoord = mXCoord - mObstacleSpeed / fps;
        }
        if(mObstacleState == RIGHT){
            mXCoord = mXCoord + mObstacleSpeed / fps;
        }

        // If the obstacle reaches extreme left, have it move to the right and vice-versa
        if(mXCoord <= 0){
            mObstacleState = RIGHT;

        }
        else if(mXCoord + mLength >= mScreenX)
        {
            mObstacleState = LEFT;
        }

        mRect.left = mXCoord;
        mRect.right = mXCoord + mLength;

    }


}
