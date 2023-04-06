import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BallPanel extends JPanel{
    private Color theColor;
    ArrayList<Ball> ballArray = new ArrayList<Ball>();
    int x = 80;
    int y = 20;
    int speedX = 3;
    int speedY = 3;
    int mouseX;
    int mouseY;

    Ball oneBall;


    public BallPanel(Color e)
    {
        setLayout(new BorderLayout());
        JPanel wrapperCenterPanel = new JPanel(new BoxLayout());
        this.add(wrapperCenterPanel, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(300,300));
        JButton clickButton = new JButton();
        try {
            clickButton.setIcon(new ImageIcon("MonkeUhOh.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ballArray.add(new Ball());
            }
        });
        clickButton.setMaximumSize(new Dimension(100,100));
        this.add(clickButton, BorderLayout.CENTER);


        theColor = e;
        setBackground(theColor);
        for(int i = 0; i < 20; i++)
        {
            ballArray.add(new Ball());
        }

        oneBall = new Ball(20,20,20,5,5);
        this.setFocusable(true);
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                for (Ball i : ballArray)
                {
                    if(mouseX<=i.getX()+i.getSize() && mouseX>=i.getX() && mouseY>=i.getY() && mouseY<=i.getY()+i.getSize())
                    {
                        ballArray.remove(i);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                System.out.println(key);
                if (key == KeyEvent.VK_W) {
                    oneBall.moveUp();
                }
                if (key == KeyEvent.VK_D) {
                    oneBall.moveRight();
                }
                if (key == KeyEvent.VK_A) {
                    oneBall.moveLeft();
                }
                if (key == KeyEvent.VK_S) {
                    oneBall.moveDown();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }


        });
    }

    @Override
    protected void paintComponent(Graphics g)
    {

        super.paintComponent(g);

        //super means that you still have methods of original class but you add your method to that list
        oneBall.teleport(this);



        for(Ball b : ballArray)
        {
            b.move(this);
            b.drawBall(g);
        }
        try{
            Thread.sleep(10);
        }
        catch(Exception e){
            System.out.println(e);
        }
        repaint();
        //fillOval(x,y,width,height)
    }


}