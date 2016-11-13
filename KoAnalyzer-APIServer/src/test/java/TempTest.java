/**
 * Created by parkjaesung on 2016. 11. 12..
 */
public class TempTest {
    {
        System.out.println("this is block");
    }

    public TempTest(){
        System.out.printf("this is constructor");
    }
    public static void main(String[] args){
        TempTest tempTest = new TempTest();
    }
}
