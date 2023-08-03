
package logic;
public class Bird {

    private float x_coordinte, y_coordinate,velocity_Y;
    private final  float gravity=10.6f, jumpy_Strength=-6f;

    public Bird(float x, float y){
         x_coordinte=x;
         y_coordinate=y;
         velocity_Y=0;
    }
    public float getX_coordinte(){
        return x_coordinte;
    }
    public float getY_coordinate(){
        return y_coordinate;
    }
    public float getVelocity_Y(){
        return velocity_Y;
    }

    public float getJumpy_Strength() {
        return jumpy_Strength;
    }

    public float getGravity(){
        return gravity;
    }
    public void upgrade(){
        velocity_Y+=gravity;
        y_coordinate+=velocity_Y;

        if (y_coordinate<0){
            y_coordinate=0;
            velocity_Y=0;
        }
    }
    public void jump(){
        velocity_Y=jumpy_Strength;
    }


}
