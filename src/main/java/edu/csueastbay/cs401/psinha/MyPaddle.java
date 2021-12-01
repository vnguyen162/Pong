package edu.csueastbay.cs401.psinha;
import edu.csueastbay.cs401.pong.*;


import edu.csueastbay.cs401.classic.GameController;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class MyPaddle extends Rectangle implements Collidable{
    public static final double STARTING_SPEED = 5.0;
    private String id;
    private double speed;
    private double topBound;
    private double bottomBound;

    enum Direction {UP, Down, LEFT, RIGHT ,STILL}
    private Direction moving;


    public MyPaddle(String id, double x, double y, double width, double height, double topBound, double bottomBound) {
        super(x, y, width, height);
        this.id = id;
        this.topBound = topBound;
        this.bottomBound = bottomBound;
        moving = Direction.STILL;
        speed = STARTING_SPEED;
    }




    @Override
    public Collision getCollision(Shape shape) {
        return new Collision(
                "Paddle",
                this.id,
                this.getLayoutBounds().intersects(shape.getLayoutBounds()),
                this.getLayoutBounds().getMinY(),
                this.getLayoutBounds().getMaxY(),
                this.getLayoutBounds().getMinX(),
                this.getLayoutBounds().getMaxX()
        );
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getType() {
        return "Paddle";
    }

    public void move() {
        if (moving == Direction.UP) {
            setY(getY() - speed);
        } else if (moving == Direction.Down) {
            setY(getY() + speed) ;
        } else if (moving == Direction.LEFT)
        {
            setX(getX() - speed/1.25);
        }
        else if (moving == Direction.RIGHT)
        {
            setX(getX() + speed/1.25);
        }
        if (getX() < 100)
        {
            setX(130);
        }
        if (getX() > 1350) //fieldwidth
        {
            setX(1320); // fieldwidth/1.05
        }



        if (getY() < topBound) setY(topBound);
        double floor = bottomBound - getHeight();
        if (getY() > floor) setY(floor);

    }

    public void stop() {
        moving = Direction.STILL;
    }

    public void moveUp() {
        moving = Direction.UP;
    }

    public void moveDown() {
        moving = Direction.Down;
    }
    public void moveLeft()
    {
        moving = Direction.LEFT;
    }
    public void moveRight()
    {
        moving = Direction.RIGHT;
    }

    public double getSpeed(){return speed;}

    public void setSpeed(double a){speed = a;}

    public void speedUp(){speed = speed + 1;}

    public void slowDown() {speed = speed -1 ;}





}
