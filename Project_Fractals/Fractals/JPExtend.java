
import java.awt.*; /* java abstract window toolkit */
import javax.swing.*;
import java.awt.image.BufferedImage;


public class JPExtend extends JPanel {

    private int width, height; 
    
    protected static BufferedImage picture = new BufferedImage(800,800,BufferedImage.TYPE_INT_RGB);


    public JPExtend(){

    }
    
    public JPExtend(int width, int height) { 
	// set the panel size 
	this.width  = width; 
	this.height = height; 
	setPreferredSize(new Dimension(width, height)); 

	}


    protected void plotFractal( String fractalSet ){
        JFrame canvas = new JFrame( fractalSet );
        canvas.setContentPane(this);
        canvas.setPreferredSize( new Dimension( 800 , 800 ) );
        canvas.setSize( 800, 800 );
        canvas.pack();
        canvas.setVisible(true);
        canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }



    public void formCanvas(String fractalSet) { 

        // create a frame
        JFrame frame = new JFrame(fractalSet); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
        // set the content of the frame as one of this panel
        frame.setContentPane(new JPExtend(800, 800)); 
    
        frame.pack(); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true); 
        }

    @Override
    protected void paintComponent(Graphics r){
        r.drawImage(picture,0,0,this); 
    }

    protected void plotInSet( int x, int y ){                  //RGB setting for points in fractal set
        picture.setRGB(x,y,Color.black.getRGB());
        repaint();
    }

    protected void plotNotInSet( int x, int y, int ITR ){      //RGB setting for points not in fractal set
        picture.setRGB(x,y,Color.HSBtoRGB(ITR/256f,1,ITR/(ITR+16f)));
        repaint();
    }
    


}
