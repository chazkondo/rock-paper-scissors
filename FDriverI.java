public class FDriverI{

   public static void main(String[ ] arg) throws Exception{
      Intercom f = new Intercom( );
      f.initializeGUI( );
      f.setVisible(true);
      ResponsiveFrame g = new ResponsiveFrame();
      g.initializeGUI();
      g.setVisible(true);
   }
}
