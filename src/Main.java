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

    static JLabel ptsLabel;
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
        shopButton.setFont(new Font("SansSerif", Font.BOLD, 22));
        shopButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                shop.setVisible(true);
            }
        });

        //CREATE COMPONENTS




        //PTS LABEL
        ptsLabel = new JLabel();
        ptsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
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

        //UPG3
        JButton upg3Button = new JButton("POISON 1000");
        upg3Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(upg3 == false)
                {
                    if (points >= 10)
                    {
                        points -= 10;
                        ptsLabel.setText(points + " pts");
                        upg3 = true;
                    }
                }else
                {
                    System.out.println("Already purchased");
                }

            }
        });
        upg3Button.setSize(50,300);



            try{
                Thread.sleep(20);
            }
            catch(Exception e){
                System.out.println(e);
            }
            if(upg3 == true)
            hp--;






        //CREATED AN ICON AND ATTACHED IT TO THE LABEL
        ImageIcon icon = new ImageIcon("orangutang.png");
        icon.setImage(icon.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT));
        JLabel labil = new JLabel(icon);

        //ADD ELEMENTS TO THE PANEL

        leftSplitter.add(shopButton);
        leftSplitter.add(ptsLabel);
        shopPanel.add(upg1Button);
        shopPanel.add(upg2Button);
        shopPanel.add(upg3Button);
        leftPanel.add(leftSplitter);
        myPanel.add(leftPanel, BorderLayout.WEST);

        myPanel.add(bPanel, BorderLayout.CENTER);

        JLabel filler = new JLabel();
        filler.setPreferredSize(new Dimension(700,50));
        myPanel.add(filler,BorderLayout.SOUTH);

        //4.ADD THE PANEL TO THE FRAME
        main.add(myPanel);
        shop.add(shopPanel);
        //5.MAKE THE FRAME VISIBLE
        main.setVisible(true);


    }




}
