import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

class solve extends JFrame
{

    //frame
    static JFrame f;

    //lists
    static JList b;


    //main class
    public static void main(String[] args)
    {
        //create a new frame
        f = new JFrame("frame");

        //create a object
        solve s=new solve();

        //create a panel
        JPanel p =new JPanel();

        //create a new label
        JLabel l= new JLabel("select the day of the week");

        //String array to store weekdays
        String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday"};

        //create list
        b= new JList(week);

        //set a selected index
        b.setSelectedIndex(2);

        //add list to panel
        p.add(b);

        f.add(p);

        //set the size of frame
        f.setSize(400,400);

        f.show();
    }


}

