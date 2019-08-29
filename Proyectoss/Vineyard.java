import java.util.ArrayList;
import java.awt.*;
/**
 * Write a description of class Vineyard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vineyard{
    private String name;
    private int xi;
    private int xf;
    ArrayList<Rectangle> lviñedos = new ArrayList<Rectangle>();
    ArrayList<Integer> positionxi = new ArrayList<Integer>();
    ArrayList<Integer> positionxf = new ArrayList<Integer>();
    ArrayList<String> vineNames = new ArrayList<String>();

    public Vineyard(String name,int xi,int xf,int height,int width){
        this.name=name;
        this.xi=xi;
        this.xf=xf;
        if (xf > width && xi > xf){
            System.out.println("Se salió del valle, no se puede construir el viñedo");
        }
        else if(positionxi.size() > 0){
            System.out.println(positionxi);
            for (int i=0;i < positionxi.size();i++){
                if (xi >= positionxi.get(i) && xi <= positionxf.get(i) && xf >= positionxi.get(i) && xf <= positionxf.get(i)){
                    System.out.println("No se puede construir el viñedo,indicaciones ya establecidas");
                    break;
                }
                else if (xi <= positionxi.get(i) && xi <= positionxf.get(i) && xf >= positionxi.get(i) && xf <= positionxf.get(i)){
                    System.out.println("No se puede construir el viñedo,indicaciones ya establecidas");
                    break;
                }
                else if (xi >= positionxi.get(i) && xi <= positionxf.get(i) && xf >= positionxi.get(i) && xf >= positionxf.get(i)){
                    System.out.println("No se puede construir el viñedo,indicaciones ya establecidas");
                    break;    
                }
                else if (xi==positionxi.get(i) && xf==positionxf.get(i)){
                    System.out.println("No se puede construir el viñedo,indicaciones ya establecidas");
                    break;
                }
                else{
                    Rectangle viñedo = new Rectangle();
                    viñedo.changeSize(10,xf-xi);
                    viñedo.moveHorizontal(xi);
                    viñedo.moveVertical(height-10);
                    viñedo.changeColor(name);
                    viñedo.makeVisible();
                    lviñedos.add(viñedo);
                    vineNames.add(name);
                    positionxi.add(xi);
                    positionxf.add(xf); 
                    break;
                } 
            }
        }
        
        else if (positionxi.size() == 0){
            Rectangle viñedo = new Rectangle();
            viñedo.changeSize(10,xf-xi);
            viñedo.moveHorizontal(xi);
            viñedo.moveVertical(height-10);
            viñedo.changeColor(name);
            viñedo.makeVisible();
            lviñedos.add(viñedo);
            vineNames.add(name);
            positionxi.add(xi);
            positionxf.add(xf); 
        }
    }
}

