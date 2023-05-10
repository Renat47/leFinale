import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Main
{
    static boolean upg1 = false;
    static boolean upg2 = false;
    static boolean upg3 = false;

    static boolean upg4 = false;
    static double hp = 25;
    static double damage = 1;

    static int lvl = 1;
    static int points = 0;

    static JLabel ptsLabel;
    static JLabel dmgLabel;
    static JFrame main;
    static JFrame shop;

    static JLabel filler;

    static String name = "Turip-ip-ip Monke";
    public static void main(String[] args)
    {

        //1.CREATED THE FRAMES
        main = new JFrame();
        main.setTitle("monke cleke alfa test 0.01");
        main.setSize(700,700);
        main.setResizable(false);
        shop = new JFrame();
        shop.setSize(300,200);
        shop.setTitle("shawp");
        shop.setResizable(false);


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
        leftPanel.setPreferredSize(new Dimension(100 , 50));
        //ANOTHER LEFT PANEL THAT SPLITS THE TOP PART OF THE LEFT PANEL
        JPanel leftSplitter = new JPanel();
        leftSplitter.setLayout(new GridLayout(4,1));
        //DRAWING PANEL
        MonkePanel mPanel = new MonkePanel(Color.white);




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
        //DAMAGE LABEL
        dmgLabel = new JLabel();
        dmgLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        dmgLabel.setText(damage + " dmg");
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
                        dmgLabel.setText(damage + " ATK");
                        upg1Button.setText("Upgrade#1 purchased");
                        upg1 = true;
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null,"oldredi purcha");

                }

            }
        });
        upg1Button.setMaximumSize(new Dimension(300,50));

        JButton upg2Button = new JButton("15 DAMAGE - 300pts");
        upg2Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(upg2 == false)
                {
                    if (points >= 300)
                    {
                        points -= 300;
                        ptsLabel.setText(points + " pts");
                        damage = 15;
                        dmgLabel.setText(damage + " ATK");
                        upg2Button.setText("Upgrade#2 purchased");
                        upg2 = true;
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null,"oldredi purcha");

                }

            }
        });
        upg2Button.setMaximumSize(new Dimension(300,50));


        //UPG3
        JButton upg3Button = new JButton("20 DAMAGE - 600pts");
        upg3Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(upg3 == false)
                {
                    if (points >= 600)
                    {
                        points -= 600;
                        ptsLabel.setText(points + " pts");
                        damage = 20;
                        dmgLabel.setText(damage + " ATK");
                        upg3Button.setText("Upgrade#3 purchased");
                        upg3 = true;
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null,"oldredi purcha");

                }

            }
        });
        upg3Button.setMaximumSize(new Dimension(300,50));


        JButton upg4Button = new JButton("30 DAMAGE - 1500pts");
        upg4Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(upg4 == false)
                {
                    if (points >= 1500)
                    {
                        points -= 1500;
                        ptsLabel.setText(points + " pts");
                        damage = 30;
                        dmgLabel.setText(damage + " ATK");
                        upg4Button.setText("Upgrade#4 purchased");
                        upg4 = true;
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null,"oldredi purcha");
                }

            }
        });
        upg4Button.setMaximumSize(new Dimension(300,50));






        //CREATED AN ICON AND ATTACHED IT TO THE LABEL
        ImageIcon icon = new ImageIcon("orangutang.png");
        icon.setImage(icon.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT));
        JLabel labil = new JLabel(icon);

        //ADD ELEMENTS TO THE PANEL

        leftSplitter.add(shopButton);
        leftSplitter.add(ptsLabel);
        leftSplitter.add(dmgLabel);
        shopPanel.add(upg1Button);
        shopPanel.add(upg2Button);
        shopPanel.add(upg3Button);
        shopPanel.add(upg4Button);
        leftPanel.add(leftSplitter);
        myPanel.add(leftPanel, BorderLayout.WEST);

        myPanel.add(mPanel, BorderLayout.CENTER);

        filler = new JLabel(name);
        filler.setFont(new Font("SansSerif", Font.BOLD, 20));
        filler.setPreferredSize(new Dimension(700,50));
        filler.setHorizontalAlignment(SwingConstants.CENTER);
        myPanel.add(filler,BorderLayout.SOUTH);

        //4.ADD THE PANEL TO THE FRAME
        main.add(myPanel);
        shop.add(shopPanel);
        //5.MAKE THE FRAME VISIBLE
        main.setVisible(true);
        //comment


    }




}
