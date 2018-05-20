import javax.swing.JFrame;


public class CashRegisterTester
{
   public static void main()
   {
      JFrame frame = new CashRegister();
      
      frame.setTitle("The 2015 Cash Register");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
