package com.divyanshu.ponggame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class BrickWall {


    int mScreenX;
    int mScreenY;
    int brickWidth;
    int brickHeight;
    int totalBricks;
    int rows;
    int cols;
    Brick[] bricks;


    /**
     * Constructs and initializes Brick objects
     * @param numRows  number of rows
     * @param numCols  number of columns
     * @param sx       screen width
     * @param sy        screen height
     */
    public BrickWall(int numRows, int numCols, int sx, int sy){

        mScreenX = sx;
        mScreenY = sy;
        brickWidth = mScreenX / 10;
        brickHeight = mScreenY / 15;
        totalBricks = numRows * numCols;
        rows = numRows;
        cols = numCols;

        bricks = new Brick[totalBricks];
        build();

    }


    /**
     *  Creates brick object for each row and Columns element and sets their position to be placed on the screen
     */
   public void build(){
        int position = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                bricks[position++] = new Brick(i,j,brickHeight,brickWidth);
            }
        }
    }

    /**
     * Updates the Canvas Object with bricks that are not yet hit
     * @param mCanvas  Canvas object that is to be updated
     */
    public void update(Canvas mCanvas){
        Paint brickPaint = new Paint();
        brickPaint.setColor(Color.argb
                (255, 200, 0, 0));

        for(int i=0; i<totalBricks; i++){
            if(!bricks[i].isBrickHit()) {

                mCanvas.drawRect(bricks[i].getRect(), brickPaint);
            }
        }
    }

    public int getTotalBricks(){
        return totalBricks;
    }

    public Brick getBrick(int position){
        return bricks[position];
    }

    public void hitBrick(int position){
        bricks[position].hitBrick();
    }


}
