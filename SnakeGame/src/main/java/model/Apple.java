package model;

public class Apple {

    int appleX;
    int appleY;
//    Random random = new Random();
    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 50;
//    public void newApple(){
//        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
//        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
//    }

    public Apple(int x, int y) {
        appleX = x;
        appleY = y;
    }

//    public void checkApple() {
//        if((x[0] == appleX) && (y[0] == appleY)) {
//            bodyParts++;
//            applesEaten++;
//            newApple();
//        }
//    }

}
