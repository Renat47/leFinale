import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ball{
    private int x;
    private int y;

    int ballSpeedX = 10;
    int ballSpeedY = 10;
    private int size = 50;
    private int speedX = (int)(Math.random()*100)+1;
    private int speedY = (int)(Math.random()*100)+1;
    private Color color;

    private BufferedImage img = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);;


    public Ball()
    {
        try {
            this.img = ImageIO.read(new File("MonkeUhOh.png"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        this.x = (int)(Math.random()*400)+15;
        this.y = (int)(Math.random()*400)+15;
        this.speedX = (int)(Math.random()*2)+1;
        this.speedY = (int)(Math.random()*2)+1;
        this.size = (int)(Math.random()*25)+10;

    }
    public Ball(int x, int y, int size, int speedX, int speedY)
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
    public void teleport(JPanel h)
    {
        if(x>=h.getWidth()+size)
        {
            x = size*-1;
        }
        if(x<size*-1)
        {
            x = h.getWidth();
        }
        if(y>h.getHeight()-size)
        {
            y = h.getHeight()-size;
        }
        if(y<0)
        {
            y = 0;
        }
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
//comment
    }
    //public void bounceCheck(JPanel h)
    //
    //if(x>=h.getWidth()-size || x<=0)
    //{
    // speedX *= -1;
    //  }
    //  if(y>=h.getWidth()-size || y<=0)
    //  {
    //      speedY *= -1;
    //  }
    // }
    public void drawBall(Graphics cow)
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