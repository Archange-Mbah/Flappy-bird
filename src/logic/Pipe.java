package logic;

public class Pipe {
    private float x_coordinate,gapY,pipeWidth,pipeGap;
    public Pipe(float x, float g, float pw,float pgap){
        x_coordinate=x;
        gapY=g;
        pipeWidth=pw;
        pipeGap=pgap;
    }

    public float getX_coordinate(){
        return x_coordinate;
    }
    public float getGapY(){
        return gapY;
    }
    public float getPipeWidth(){
        return pipeWidth;
    }
    public float getPipeGap(){
        return pipeGap;
    }

    public boolean collission_with_Bird(Bird b){
        if ((x_coordinate<b.getX_coordinte() && (x_coordinate+pipeWidth>b.getX_coordinte())) &&((b.getY_coordinate()<gapY)||(b.getY_coordinate()>gapY+pipeGap))){
                return true;
        } ;
        return false;
    }
}
