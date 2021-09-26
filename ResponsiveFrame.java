import javax.swing.*;  //contains graphic elements
import java.awt.event.*;  //allows graphic elements to work

public class ResponsiveFrame extends JFrame{ //this class is a frame
   //these are instance variables
   private JButton buttona = new JButton("  add  ");
   private JButton buttons = new JButton(" subtract ");
   private JLabel label = new JLabel("clicked: 0");
   private int count = 0;
   private final int WIDTH = 300;
   private final int HEIGHT = 200;  
 
   public ResponsiveFrame( ){
    //instructions to initialize the frame
      this.setSize(WIDTH, HEIGHT);  
      this.setTitle("ICS 211 Clicker");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
 
   /* puts the elements in the screen where they belong
      adds listeners to elements that will monitor events
      */
   public void initializeGUI( ) {//throws Exception{
      //add action listeners to graphic elements
      ActionListener ears = new MyListener( );
      buttona.addActionListener(ears);
      buttons.addActionListener(ears);
      
      JPanel panel = new JPanel( );
      panel.add(buttona);
      panel.add(label);
      panel.add(buttons);
      this.add(panel); //adds the panel to "this" frame      
   }
 
  //inner class
   private class MyListener implements ActionListener{
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
