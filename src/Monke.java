import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Monke{
    private int x;
    private int y;

    int ballSpeedX = 10;
    int ballSpeedY = 10;
    private int size = 50;
    private int speedX = (int)(Math.random()*100)+1;
    private int speedY = (int)(Math.random()*100)+1;
    private Color color;

    private BufferedImage img = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);;


    public Monke()
    {
        if(Main.lvl == 1)
        {
            try {
                this.img = ImageIO.read(new File("chillmonkey.png"));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(Main.lvl == 2)
        {
            try {
                this.img = ImageIO.read(new File("manki.png"));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(Main.lvl == 3)
        {
            try {
                this.img = ImageIO.read(new File("MonkeUhOh.png"));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(Main.lvl == 4)
        {
            try {
                this.img = ImageIO.read(new File("Sumatran_Orangutan_29_M.png"));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(Main.lvl == 5)
        {
            try {
                this.img = ImageIO.read(new File("cute-orang-utan-in-style-free-png.png"));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

        this.x = (int)(Math.random()*400)+15;
        this.y = (int)(Math.random()*400)+15;
        this.speedX = (int)(Math.random()*2)+1;
        this.speedY = (int)(Math.random()*2)+1;
        this.size = (int)(Math.random()*25)+10;

    }
    public Monke(int x, int y, int size, int speedX, int speedY)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.speedX = speedX;
        this.speedY = speedY;
    }
    public void moveRight()
    {
        x += ballSpeedX;
    }
    public void moveLeft()
    {
        x -= ballSpeedX;
    }
    public void moveUp()
    {
        y -= ballSpeedY;
    }
    public void moveDown()
    {
        y += ballSpeedY;
    }

    public void move(JPanel h)
    {
        x += speedX;
        y += speedY;
        if(x>=h.getWidth()-size || x<=0)
        {
            speedX *= -1;
        }
        if(y>=h.getHeight()-size || y<=0)
        {
            speedY *= -1;
        }

    }

    public void drawMonke(Graphics cow)
    {
        cow.drawImage(img,x,y,size,size,null);
    }
    public void drawSpecialBall(Graphics cow)
    {
        cow.setColor(color);
        cow.fillOval(x,y,size,size);
    }


    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getSize()
    {
        return size;
    }



}