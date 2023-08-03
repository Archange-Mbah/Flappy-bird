import logic.*;

public class Tests {


      public static void main(String[] args){

          Pipe p=new Pipe(23,35,20,30);
          Bird b= new Bird(1,2);
        b.upgrade();
        assert b.getVelocity_Y()==b.getGravity();
        b.upgrade();
        assert b.getVelocity_Y()!=b.getGravity();
        b.jump();
        assert b.getVelocity_Y()==b.getJumpy_Strength();

        assert !p.collission_with_Bird(b);
      }

}
