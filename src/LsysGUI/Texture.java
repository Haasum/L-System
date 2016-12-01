package LsysGUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by naja on 30-11-2016.
 */
public class Texture {

    public static BufferedImage backImg;
    public static BufferedImage leafImg;
    public static BufferedImage leafImg2;
    private BufferedImage soilImg;
    private BufferedImage barkImg;
    public static TexturePaint soilTex;
    public static TexturePaint barkTex;

    public Texture() {

                loadImages();
        barkTex = new TexturePaint(this.barkImg, new Rectangle(0, 0, 150, 150));
        soilTex = new TexturePaint(this.soilImg, new Rectangle(0,0,400,400));

            }

            public void loadImages() {
                try {
                    this.backImg = ImageIO.read(new File("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysGUI\\back14.jpg"));
                    this.soilImg = ImageIO.read(new File("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysGUI\\soilTex.jpg"));
                    this.barkImg = ImageIO.read(new File("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysGUI\\bark2Tex.jpg"));
                    this.leafImg = ImageIO.read(new File("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysGUI\\leaf2.png"));
                    this.leafImg2 = ImageIO.read(new File("C:\\Users\\naja\\IdeaProjects\\GITHUB\\Proto2\\src\\LsysGUI\\leaf3.png"));
                } catch (IOException var2) {
                    Logger.getLogger(Texture.class.getName()).log(Level.SEVERE, (String)null, var2);
                }



            }




}
