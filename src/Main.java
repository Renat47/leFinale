import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Main
{
    static boolean upg1 = false;
    static boolean upg2 = false;
    static boolean upg3 = false;
    static double hp = 100000;
    static double damage = 1;
    static int points = 0;
    public static void main(String[] args)
    {

        //1.CREATED THE FRAMES
        JFrame main = new JFrame();
        main.setSize(700,700);
        JFrame shop = new JFrame();
        shop.setSize(300,300);


        //2.CREATED TNE PANELS
        //MAIN PANEL
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());
        myPanel.setBackground(Color.orange);
        //SHOP PANEL
        JPanel shopPanel = new JPanel();
        shopPanel.setLayout(new BoxLayout(shopPanel, BoxLayout.PAGE_AXIS));
        shopPanel.setBackground(Color.gray);
        //LEFT PANEL
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(2,1));
        leftPanel.setPreferredSize(new Dimension(70 , 50));
        //ANOTHER LEFT PANEL THAT SPLITS THE TOP PART OF THE LEFT PANEL
        JPanel leftSplitter = new JPanel();
        leftSplitter.setLayout(new GridLayout(3,1));
        //DRAWING PANEL
        BallPanel bPanel = new BallPanel(Color.white);



        //3.ADD COMPONENTS TO THE PANEL
        //SHOP BUTTON
        JButton shopButton = new JButton("shop");
        shopButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                shop.setVisible(true);
            }
        });

        //CREATE COMPONENTS



        //HP LABEL
        JLabel hpLabel = new JLabel();
        hpLabel.setText(hp + " hp");
        //PTS LABEL
        JLabel ptsLabel = new JLabel();
        ptsLabel.setText(points + " pts");
        //UPGRADE BUTTONS
        JButton upg1Button = new JButton("5 DAMAGE   30pts");
        upg1Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(upg1 == false)
                {
                    if (points >= 30)
                    {
                        points -= 30;
                        ptsLabel.setText(points + " pts");
                        damage = 5;
                        upg1 = true;
                    }
                }else
                {
                    System.out.println("Already purchased");
                }

            }
        });
        upg1Button.setSize(50,300);
        JButton upg2Button = new JButton("30 DAMAGE   300pts");
        upg2Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(upg2 == false)
                {
                    if (points >= 300)
                    {
                        points -= 300;
                        ptsLabel.setText(points + " pts");
                        damage = 30;
                        upg2 = true;
                    }
                }else
                {
                    System.out.println("Already purchased");
                }

            }
        });
        upg2Button.setSize(50,300);
        //THE CLICKABLE IMAGE
        JButton button = new JButton();
        try {
            button.setIcon(new ImageIcon("MonkeyUhOh.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(hp > 0)
                {
                    hp -= damage;
                    hpLabel.setText(hp + " hp");
                    points += damage;
                    ptsLabel.setText(points + " pts");
                    hpLabel.setBackground(Color.red);
                }
                if(hp <= 0)
                {
                    hpLabel.setText("You won");
                }

            }
        });



        //CREATED AN ICON AND ATTACHED IT TO THE LABEL
        ImageIcon icon = new ImageIcon("orangutang.png");
        icon.setImage(icon.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT));
        JLabel labil = new JLabel(icon);

        //ADD ELEMENTS TO THE PANEL

        leftSplitter.add(shopButton);
        leftSplitter.add(ptsLabel);
        shopPanel.add(upg1Button);
        shopPanel.add(upg2Button);
        leftPanel.add(leftSplitter);
        myPanel.add(leftPanel, BorderLayout.WEST);

        myPanel.add(bPanel, BorderLayout.CENTER);

        myPanel.add(hpLabel,BorderLayout.SOUTH);

        //4.ADD THE PANEL TO THE FRAME
        main.add(myPanel);
        shop.add(shopPanel);
        //5.MAKE THE FRAME VISIBLE
        main.setVisible(true);


    }




}
