import java.util.ArrayList;
import java.awt.*;
/**
 *A valley that has vineyards and canvases that can be manipulated
 * 
 * @author (Angélica Alfaro-César Ortiz)
 * @version 1.0 (08/2019)
 */
public class Valley{
    private String name;
    private int xi;
    private int xf;
    private int height;
    private int width;
    private Rectangle valle;
    private boolean isVisible;
    ArrayList<Rectangle> lviñedos = new ArrayList<Rectangle>();
    ArrayList<Integer> positionxi = new ArrayList<Integer>();
    ArrayList<Integer> positionxf = new ArrayList<Integer>();
    ArrayList<String> vineNames = new ArrayList<String>();
    /**
     * Create a new valley with the given arguments and the default color.
     * @param height and width of the valley
     */
    public Valley(int height,int width){
        this.height=height;
        this.width=width;
        valle = new Rectangle();
        valle.changeSize(height,width);
        isVisible=false;
    }
    
    /**
     *Create a new vineyard with your name and position
     * @param name of the vineyard
     * @param xi initial position of the vineyard
     * @param xf final position of the vineyard
    */
    public void openVineyard(String name,int xi,int xf){
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
                else if (xi <= positionxi.get(i) && xi <= positionxf.get(i) && xf >= positionxi.get(i) && xf >= positionxf.get(i)){
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
    
    /**
     * Remove a vineyard by name
     * @param name of the vineyard
    */
    public void closeVineyard(String name){
        boolean verificar=false;
        for(int i=0; i<lviñedos.size();i++){
            if (returnColor(i).equals(name)){
                lviñedos.get(i).erase();
                lviñedos.remove(i);
                verificar=true;
            }
       
            if (verificar==false){
                System.out.println("No hay un viñedo con ese nombre");
            }
        }
    }
    
    public void addTrap(int []lowerEnd,int []higherEnd){
        isVisible=true;
        String color="black";
        int x1=lowerEnd[0];
        int x2=higherEnd[0];
        int y1=lowerEnd[1];
        int y2=higherEnd[1];
        if (x1 > 70 && x2 > 70 && x1 < (width+70)&& x2 < (width+70) && y1 > 70 && y2 > 70 && y1 < (height+70) && y2 < (height+70)){ 
            if (isVisible){
                int[] xpoints={x1,x2,x2,x1};
                int[] ypoints={y1,y2,y2+5,y1+5};
                Canvas canvas=Canvas.getCanvas();
                canvas.draw(this,color,new Polygon(xpoints,ypoints,4));
                canvas.wait(10);
            }  
        }
        else{
            System.out.println("No se puede crear la lona. Fuera de rango");
        }
    }
    
    /**
     * Return the color of a vineyard
     * @param i,position in the vineyard list
    */
    private String returnColor(int i){
        Rectangle retorne=lviñedos.get(i);
        return retorne.getColor();
    }
    
    /**
     * Make this valley visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        valle.makeVisible();
        for (int i=0;i < lviñedos.size();i++){
            lviñedos.get(i).makeVisible();
        }
    }
    
    
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        isVisible = false;
        for (int i=0;i < lviñedos.size();i++){
            lviñedos.get(i).makeInvisible();
        }
    }
}   


   

    
    
    

  
    
        
        
