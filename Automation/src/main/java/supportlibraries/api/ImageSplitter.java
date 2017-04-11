package supportlibraries.api;

	import javax.imageio.ImageIO;
	import java.awt.image.BufferedImage;
	import java.io.*;
	import java.awt.*;

	public class ImageSplitter {

		public int imageSplitter(File file) throws IOException{
//	        File file = new File("RUN_20160712-135901.jpg"); // I have bear.jpg in my working directory
	        FileInputStream fis = new FileInputStream(file);
	        BufferedImage image = ImageIO.read(fis); //reading the image file

	        int rows = (image.getHeight()/1024); //You should decide the values for rows and cols variables
	        if((image.getHeight()%1024) > 0){
	        	rows = (image.getHeight()/1024) + 1;
	        }
	        int cols = image.getWidth()/1024;
	        int chunks = rows * cols;

	        int chunkWidth = 1024;//image.getWidth() / cols; // determines the chunk width and height
	        int chunkHeight = 1024;//image.getHeight() / rows;
	        int count = 0;
	        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
	        for (int x = 0; x < rows; x++) {
	            for (int y = 0; y < cols; y++) {
	                
	                int chunkHeightnew = chunkHeight;
	                if(x==rows-1){
//	                	System.out.println((image.getHeight()%1024));
	                	chunkHeightnew = (image.getHeight()%1024);
	                }
	                //Initialize the image array with image chunks
	                imgs[count] = new BufferedImage(chunkWidth, chunkHeightnew, image.getType());
	                
	                // draws the image chunk
	                Graphics2D gr = imgs[count++].createGraphics();
	                gr.drawImage(image, 0, 0, chunkWidth, chunkHeightnew, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeightnew, null);
	                gr.dispose();
	            }
	        }
	        System.out.println("Splitting done");

	        //writing mini images into image files
	        for (int i = 0; i < imgs.length; i++) {
	            ImageIO.write(imgs[i], "jpg", new File(file.getParent()+"/" + "img" + i + ".jpg"));
	        }
	        System.out.println("Mini images created");
	        return  imgs.length;
	    }
	}
