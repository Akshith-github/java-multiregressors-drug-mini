import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

class frt extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Container c;
    JTextField one, two, three, four;
    BCKEND bckend;JLabel result;

    frt() {
        this.setLayout(null);
        // title
        this.setTitle("Drug Demand Prediction");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 850, 476);
        this.setResizable(false);
        this.setBackground(Color.black);
        c = getContentPane();

        // head
        JPanel heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 50));
        heading.setBounds(0, 0, 970, 80);
        JLabel head = new JLabel("    Drug Demand Prediction");
        head.setBounds(20, 5, 850, 80);
        head.setForeground(Color.black);
        head.setFont(new Font("times new roman", Font.ITALIC, 60));

        // labels
        JLabel csv = new JLabel("CSV File Path                  :");
        csv.setFont(new Font("times new roman", Font.ITALIC, 22));
        csv.setForeground(Color.black);
        csv.setBounds(10, 90, 260, 28);
        JLabel fore = new JLabel("NO.of Forecasts              :");
        fore.setFont(new Font("times new roman", Font.ITALIC, 22));
        fore.setForeground(Color.black);
        fore.setBounds(10, 150, 260, 28);
        JLabel inter = new JLabel("Period of interval           :");
        inter.setFont(new Font("times new roman", Font.ITALIC, 22));
        inter.setForeground(Color.black);
        inter.setBounds(10, 210, 260, 28);
        JLabel out = new JLabel("Output for next Periodic :");
        out.setFont(new Font("times new roman", Font.ITALIC, 22));
        out.setForeground(Color.black);
        out.setBounds(10, 270, 260, 28);
        result = new JLabel("== output to be calculated ==");
        result.setFont(new Font("times new roman", Font.BOLD, 22));
        result.setForeground(Color.red);
        result.setBackground(Color.white);
        result.setBounds(360, 270, 10080, 25);
        JLabel algo = new JLabel("Algorithm : ");
        algo.setFont(new Font("times new roman", Font.BOLD, 22));
        algo.setForeground(Color.white);
        algo.setBounds(10, 380, 150, 28);
        JLabel algoname = new JLabel("Multiple linear regressions ");
        algoname.setFont(new Font("times new roman", Font.BOLD, 22));
        algoname.setForeground(Color.white);
        algoname.setBounds(165, 383, 200, 25);
        JLabel mini = new JLabel("Java Mini Project");
        mini.setFont(new Font("times new roman", Font.BOLD, 30));
        mini.setForeground(Color.black);
        mini.setBounds(580, 406, 250, 28);

        // text fileds
        one = new JTextField();
        one.setFont(new Font("times new roman", Font.BOLD, 16));
        one.setForeground(Color.black);
        one.setBackground(Color.blue);
        one.setCaretColor(Color.blue);
        one.setBorder(null);
        one.setBounds(360, 90, 380, 25);
        two = new JTextField();
        two.setFont(new Font("times new roman", Font.BOLD, 16));
        two.setForeground(Color.black);
        two.setBackground(Color.blue);
        two.setCaretColor(Color.blue);
        two.setBorder(null);
        two.setBounds(360, 150, 380, 25);
        three = new JTextField();
        three.setFont(new Font("times new roman", Font.BOLD, 16));
        three.setForeground(Color.black);
        three.setBackground(Color.blue);
        three.setCaretColor(Color.blue);
        three.setBorder(null);
        three.setBounds(360, 210, 380, 25);
        
        JButton b = new JButton("Click Here to submit");
        b.setBounds(50, 100, 95, 30);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String msg="";
                String fname = one.getText();
                int intl = Integer.parseInt(three.getText()); 
                int fore = Integer.parseInt(two.getText());
                try {
                    bckend = new BCKEND(fname, fore, intl);
                    for(double d :bckend.predictions){
                        msg+=String.format("%.1f  ", d);}
                    result.setText(msg);
                } catch (FileNotFoundException e1) {
                    result.setText("file not found error");
                }
                
            }  });
        b.setBounds(185,350,200,25);
        
        JLabel background_lbl404 = new JLabel("");
        background_lbl404.setBackground(Color.black);
        background_lbl404.setBounds(10,0,860,760);
        background_lbl404.add(heading);
        background_lbl404.add(head);
        background_lbl404.add(csv);
        background_lbl404.add(fore);
        background_lbl404.add(out);
        background_lbl404.add(mini);
        background_lbl404.add(algo);
        background_lbl404.add(inter);
        background_lbl404.add(one);
        background_lbl404.add(two);
        background_lbl404.add(three);
        background_lbl404.add(result);// background_lbl404.add(four);
        background_lbl404.add(algoname);// background_lbl404.add(five);
        background_lbl404.add(b);
        c.add(background_lbl404);
        this.setVisible(true);
    }
}


public class FrntEnd{
    public static void main(String[] args) {
        new frt();}}




// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.io.FileNotFoundException;

// class frt extends JFrame{
//     Container c;
//     JTextField one, two, three, four;
//     BCKEND bckend;JLabel result;

//     frt() {
//         this.setLayout(null);
//         // title
//         this.setTitle("Drug Demand Prediction");
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         this.setBounds(50, 50, 850, 476);
//         this.setResizable(false);

//         c = getContentPane();

//         // head
//         JPanel heading = new JPanel();
//         heading.setBackground(new Color(0, 0, 0, 50));
//         heading.setBounds(0, 0, 970, 80);
//         JLabel head = new JLabel("    Drug Demand Prediction");
//         head.setBounds(20, 5, 850, 80);
//         head.setForeground(Color.white);
//         head.setFont(new Font("times new roman", Font.ITALIC, 60));

//         // labels
//         JLabel csv = new JLabel("CSV File Path                  :");
//         csv.setFont(new Font("times new roman", Font.ITALIC, 22));
//         csv.setForeground(Color.white);
//         csv.setBounds(10, 90, 260, 28);
//         JLabel fore = new JLabel("NO.of Forecasts              :");
//         fore.setFont(new Font("times new roman", Font.ITALIC, 22));
//         fore.setForeground(Color.white);
//         fore.setBounds(10, 150, 260, 28);
//         JLabel inter = new JLabel("Period of interval           :");
//         inter.setFont(new Font("times new roman", Font.ITALIC, 22));
//         inter.setForeground(Color.white);
//         inter.setBounds(10, 210, 260, 28);
//         JLabel out = new JLabel("Output for next Periodic :");
//         out.setFont(new Font("times new roman", Font.ITALIC, 22));
//         out.setForeground(Color.white);
//         out.setBounds(10, 270, 260, 28);
//         result = new JLabel("== output to be calculated ==");
//         result.setFont(new Font("times new roman", Font.BOLD, 22));
//         result.setForeground(Color.red);
//         result.setBackground(Color.white);
//         result.setBounds(360, 270, 10080, 25);
//         JLabel algo = new JLabel("Algorithm : ");
//         algo.setFont(new Font("times new roman", Font.BOLD, 22));
//         algo.setForeground(Color.white);
//         algo.setBounds(10, 380, 150, 28);
//         JLabel algoname = new JLabel("Multiple linear regressions ");
//         algoname.setFont(new Font("times new roman", Font.BOLD, 22));
//         algoname.setForeground(Color.white);
//         algoname.setBounds(165, 383, 200, 25);
//         JLabel mini = new JLabel("Java Mini Project");
//         mini.setFont(new Font("times new roman", Font.BOLD, 30));
//         mini.setForeground(Color.black);
//         mini.setBounds(580, 406, 250, 28);

//         // text fileds
//         one = new JTextField();
//         one.setFont(new Font("times new roman", Font.BOLD, 16));
//         one.setForeground(Color.black);
//         // one.setBackground(Color.blue);
//         one.setCaretColor(Color.blue);
//         one.setBorder(null);
//         one.setBounds(360, 90, 380, 25);
//         two = new JTextField();
//         two.setFont(new Font("times new roman", Font.BOLD, 16));
//         two.setForeground(Color.black);
//         // two.setBackground(Color.blue);
//         two.setCaretColor(Color.blue);
//         two.setBorder(null);
//         two.setBounds(360, 150, 380, 25);
//         three = new JTextField();
//         three.setFont(new Font("times new roman", Font.BOLD, 16));
//         three.setForeground(Color.black);
//         // three.setBackground(Color.blue);
//         three.setCaretColor(Color.blue);
//         three.setBorder(null);
//         three.setBounds(360, 210, 380, 25);
//         // JTextField four = new JTextField();
//         // four.setFont(new Font("times new roman",Font.BOLD,16));
//         // four.setForeground(Color.white);
//         // // four.setBackground(Color.blue);
//         // four.setCaretColor(Color.white);
//         // four.setBorder(null);
//         // four.setBounds(360,270,380,25);

//         // JTextField five = new JTextField();
//         // five.setFont(new Font("times new roman",Font.BOLD,16));
//         // five.setForeground(Color.white);
//         // // five.setBackground(Color.blue);
//         // five.setCaretColor(Color.white);
//         // five.setBorder(null);
//         // five.setBounds(165,383,200,25);
//         JButton b = new JButton("Click Here to submit");
//         b.setBounds(50, 100, 95, 30);
//         b.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 String msg="";
//                 String fname = one.getText();
//                 int intl = Integer.parseInt(three.getText());
//                 int fore = Integer.parseInt(two.getText());
//                 try {
//                     bckend = new BCKEND(fname, fore, intl);
//                     for(double d :bckend.predictions){
//                         msg+=String.format("%.1f  ", d);}
//                     result.setText(msg);
//                 } catch (FileNotFoundException e1) {
//                     result.setText("file not found error");
//                 }
                
//             }  });
//         b.setBounds(185,350,200,25);
        
//         ImageIcon background_img = new ImageIcon("C:/Users/akshi/Desktop/klu/java/java_PROJECT/miniproject/src/samplewallpaper.jpg");
//         JLabel background_lbl404 = new JLabel("",background_img,JLabel.CENTER);
//         background_lbl404.setBounds(-1000,0,1000,760);
//         background_lbl404.add(heading);
//         background_lbl404.add(head);
//         background_lbl404.add(csv);
//         background_lbl404.add(fore);
//         background_lbl404.add(out);
//         background_lbl404.add(mini);
//         background_lbl404.add(algo);
//         background_lbl404.add(inter);
//         background_lbl404.add(one);
//         background_lbl404.add(two);
//         background_lbl404.add(three);
//         background_lbl404.add(result);// background_lbl404.add(four);
//         background_lbl404.add(algoname);// background_lbl404.add(five);
//         background_lbl404.add(b);
//         c.add(background_lbl404);
//         this.setVisible(true);
//     }
// }


// public class FrntEnd{
//     public static void main(String[] args) {
//         frt obj1 = new frt();}}