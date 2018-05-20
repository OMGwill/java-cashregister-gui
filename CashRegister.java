//will Luttmann
import javax.swing.*;
import java.awt.event.*;


public class CashRegister extends JFrame
{
   private JButton button1;
   private JButton button2;
   private JButton button3;
   
   private JLabel priceLabel;
   private JTextField priceField;
   
   
   private JTextArea result;
    
   private static final double TAX_RATE =  .05;
   private static final int FRAME_WIDTH = 600;
   private static final int FRAME_HEIGHT = 400;
   
   private double price;
   private double subTotal;
   private double total;
   private int number;
   
   public CashRegister()
   {
       number = 1;
       
       button1 = new JButton("+ Tax");
       button2 = new JButton("No Tax");
       button3 = new JButton("Reset");
       
       priceLabel = new JLabel("Please Eneter Price: ");
       priceField = new JTextField(10);
       priceField.setText("");
       
       result = new JTextArea(19,40);
       result.setText("No\tPrice\tSubTotal\tTotal\n");
       JScrollPane scrollpane = new JScrollPane(result);
       
       ActionListener listener1 = new ClickListenerTAX();
       button1.addActionListener(listener1);
       
       ActionListener listener2 = new ClickListenerNOTAX();
       button2.addActionListener(listener2);
       
       ActionListener listener3 = new ClickListenerRESET();
       button3.addActionListener(listener3);
       
       JPanel panel = new JPanel();
       panel.add(priceLabel);
       panel.add(priceField);
       panel.add(button1);
       panel.add(button2);
       panel.add(button3);
       panel.add(scrollpane);
       //panel.add(result);
       
       
       add(panel);
       setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }
   
   class ClickListenerTAX implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         
         price = Double.parseDouble(priceField.getText());
         subTotal = price * TAX_RATE + price;
         total = total + subTotal;
         
         String output = String.format("%d\t%.2f\t%.2f\t%.2f\n",number, price, subTotal,total);
         result.append(output);
         number++;
      }            
   }

   
   class ClickListenerNOTAX implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         
         price = Double.parseDouble(priceField.getText());
         subTotal = price;
         total = total + subTotal;
         
         String output = String.format("%d\t%.2f\t%.2f\t%.2f\n",number, price, subTotal,total);
         result.append(output);
         number++;
      }            
   }
   
   class ClickListenerRESET implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         number = 1;
         subTotal = 0;
         total = 0;
         result.setText("No\tPrice\tSubTotal\tTotal\n");
      }            
   }
}

