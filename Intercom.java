import javax.swing.*; //elements with J at the begining
import java.awt.event.*;  //listener
import java.awt.*;

public class Intercom extends JFrame{ //this class is a frame
   //instance variables
   private JButton buttonOk = new JButton("  - -OK- -  ");
   private JButton buttonCancel = new JButton(" CANCEL ");
   private JLabel label = new JLabel(" Lets play Jan Ken Po ");
   private Choice choice = new Choice( );
   private TextField tf = new TextField(45 );
   private TextArea ta = new TextArea(5, 45 );
   private JButton buttona = new JButton("  add  ");
   private JButton buttons = new JButton(" subtract ");
   private JLabel label2 = new JLabel("clicked: 0");
   
   private int count = 0;
   private final int WIDTH = 1000;
   private final int HEIGHT = 300;  
 
   public Intercom( ){
    //instructions to initialize the frame
      this.setSize(WIDTH, HEIGHT);  
      this.setTitle("Intercommunication ICS211 Demo");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
        this.setResizable(false);
   }
 
   /* puts the elements in the screen where they belong
      adds listeners to elements that will monitor events
      */
   public void initializeGUI( ) throws Exception{
      //add action listeners to buttons only
      ActionListener ears = new MyListener( );
      buttonOk.addActionListener(ears);
      buttonCancel.addActionListener(ears);
      
      JPanel mPanel = new JPanel( );  //main
      mPanel.setLayout(new BorderLayout( ));
      mPanel.add("North", label);
      
      JPanel bPanel = new JPanel( );  //bottom/flow layout
      bPanel.add(buttonOk);
      bPanel.add(buttonCancel);
      mPanel.add("South", bPanel);
      
      JPanel cPanel = new JPanel( ); //center
      
      choice.add("blue");
      choice.add("pink");
      choice.add("red");
      choice.add("black");
      choice.add("white");
      
      cPanel.add(choice);
      cPanel.add(new Label("Name"));
      cPanel.add(tf);
      cPanel.add(ta);
      ta.setText("Status: initializing\n\n\n");
      mPanel.add("Center", cPanel);
      
      //add action listeners to graphic elements
      ActionListener counter = new MyCounter( );
      buttona.addActionListener(counter);
      buttons.addActionListener(counter);
      
      JPanel panel = new JPanel( );
      panel.add(buttona);
      panel.add(label2);
      panel.add(buttons);
      mPanel.add("East", panel);   
      
      this.add(mPanel); //adds the panel to "this" frame      
   }
 
  //inner class
   private class MyListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
      
         if(e.getSource( ) == buttonOk){
            String s ="Button OK was pressed\n SCREEN STATUS:\n";
            s = s + "Name = "+ tf.getText( );
            s = s + "\n"+ "Choice: " + choice.getSelectedItem( );
            ta.setText(s);         
         }
         else{
            String s ="Button CANCEL was pressed\n ";
            s = s + "ALL CLEAR";
            tf.setText(""); //clear it up
            ta.setText(s);         
         }    
      
      }
   }
   
     //inner class
   private class MyCounter implements ActionListener{
      public void actionPerformed(ActionEvent event) {
       
         if(event.getSource( )==buttons){
            count--;
            if(count<0){
               JOptionPane.showMessageDialog(new JFrame( ),
                               "Can\'t go negative!!",
                               "ICS211-Exception",
                                JOptionPane.ERROR_MESSAGE);
                      buttons.setEnabled(false);                                                   
            }        
         }
         else {
            count++;
            buttons.setEnabled(true);
         }    
         label.setText("clicked:" + count);
      }
   }
 
}