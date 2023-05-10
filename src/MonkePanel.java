import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

public class MonkePanel extends JPanel{
    private Color theColor;
    static JLabel hpLabel;
//comment
    private static ArrayList<Monke> monkeArray = new ArrayList<Monke>();
    int x = 80;
    int y = 20;
    int speedX = 3;
    int speedY = 3;
    int mouseX;
    int mouseY;
    Timer bozo = new Timer();



    String turip = "Turi-ip-ip-ip-Song.wav";
    String doom = "doom.wav";
    String forest = "burghrecords__birds-singing-forest-scotland.wav";

    public MonkePanel(Color e)
    {
        if(Main.lvl == 1)
        {
            musicStuff.playMusic(turip);
        }
        if(Main.lvl == 2)
        {
            musicStuff.playMusic(doom);
        }
        if(Main.lvl == 3 || Main.lvl == 4)
        {
            musicStuff.playMusic(forest);
        }
        setLayout(new BorderLayout());

        this.setPreferredSize(new Dimension(300,300));
        JButton clickButton = new JButton();
        try {
            clickButton.setIcon(new ImageIcon("chillmonkey.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        //HP LABEL
        hpLabel = new JLabel("",SwingConstants.CENTER);
        hpLabel.setPreferredSize(new Dimension(150,150));
        hpLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        hpLabel.setForeground(Color.RED);
        hpLabel.setOpaque(false);
        hpLabel.setText(Main.hp + " hp");

        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monkeArray.add(new Monke());
                if(Main.hp > 0)
                {
                    Main.hp -= Main.damage;

                    hpLabel.setText(Main.hp + " hp");
                    Main.points += Main.damage;
                    Main.ptsLabel.setText(Main.points + " pts");
                    hpLabel.setBackground(Color.red);
                }
                if(Main.hp <= 0)
                {
                    if(Main.lvl < 7)
                    {
                        Main.lvl++;
                        if(Main.lvl == 2)
                        {
                            Main.hp = 50;
                            Main.name = "Laughing Monke";
                            Main.filler.setText(Main.name);
                            hpLabel.setText(Main.hp + " hp");
                            musicStuff.stopPlaying();
                            musicStuff.playMusic(forest);
                            setBackground(Color.green);
                            try {
                                clickButton.setIcon(new ImageIcon("manki.png"));
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            refresh();

                        }
                        else if(Main.lvl == 3)
                        {
                            Main.hp = 150;
                            Main.name = "Stinky Monke";
                            Main.filler.setText(Main.name);
                            hpLabel.setText(Main.hp + " hp");
                            try {
                                clickButton.setIcon(new ImageIcon("MonkeUhOh.png"));
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            refresh();
                        }
                        else if(Main.lvl == 4)
                        {
                            Main.hp = 1000;
                            Main.name = "Stronk Monke";
                            Main.filler.setText(Main.name);
                            hpLabel.setText(Main.hp + " hp");
                            try {
                                clickButton.setIcon(new ImageIcon("Sumatran_Orangutan_29_M.png"));
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            refresh();
                        }
                        else if(Main.lvl == 5)
                        {
                            clickButton.setOpaque(true);
                            Main.hp = 5000;
                            Main.name = "Monke Boss";
                            Main.filler.setText(Main.name);
                            hpLabel.setText(Main.hp + " hp");
                            musicStuff.stopPlaying();
                            musicStuff.playMusic(doom);
                            setBackground(Color.RED);
                            hpLabel.setForeground(Color.WHITE);
                            try {
                                clickButton.setIcon(new ImageIcon("cute-orang-utan-in-style-free-png.png"));
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            refresh();

                        }
                        else if(Main.lvl == 6)
                        {
                            JOptionPane.showMessageDialog(null, "Congrats, you won");
                            Main.main.dispatchEvent(new WindowEvent(Main.main, WindowEvent.WINDOW_CLOSING));
                            Main.shop.dispatchEvent(new WindowEvent(Main.shop, WindowEvent.WINDOW_CLOSING));
                            musicStuff.stopPlaying();
                        }


                    }
                }
            }
        });
        clickButton.setMaximumSize(new Dimension(100,100));
        JLabel empty = new JLabel();
        JLabel empty2 = new JLabel();
        JLabel empty3 = new JLabel();
        JLabel empty4 = new JLabel();


        this.add(clickButton, BorderLayout.CENTER);
        //adding empty labels to center the button
        empty.setPreferredSize(new Dimension(150,150));
        empty2.setPreferredSize(new Dimension(150,150));
        empty3.setPreferredSize(new Dimension(150,150));
        empty4.setPreferredSize(new Dimension(150,150));

        this.add(empty, BorderLayout.WEST);
        this.add(empty2, BorderLayout.EAST);
        this.add(empty3, BorderLayout.NORTH);
        this.add(hpLabel, BorderLayout.SOUTH);




        theColor = e;
        setBackground(theColor);
        for(int i = 0; i < 100; i++)
        {
            monkeArray.add(new Monke());
        }

        this.setFocusable(true);
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                for (Monke i : monkeArray)
                {
                    if(mouseX<=i.getX()+i.getSize() && mouseX>=i.getX() && mouseY>=i.getY() && mouseY<=i.getY()+i.getSize())
                    {
                        monkeArray.remove(i);
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


    }
    //PAINTIN
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for(Monke b : monkeArray)
        {
            b.move(this);
            b.drawMonke(g);
        }
        try{
            Thread.sleep(10);
        }
        catch(Exception e){
            System.out.println(e);
        }
        repaint();
    }

    public static void refresh()
    {
        monkeArray.clear();
        for(int i = 0; i < 100; i++)
        {
            monkeArray.add(new Monke());
        }
    }


}