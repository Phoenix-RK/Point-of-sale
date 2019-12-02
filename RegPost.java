package projectnew;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class RegPost extends JFrame {
	

	String lists[]= {"Null","Letter","Parcel"};
	String ack[]= {"Null","Yes","No"};
	 
	 private JTextField fromadd = new JTextField();
	 private JTextField toadd = new JTextField();
	 private JTextField weight = new JTextField();
	 private JTextField holderName = new JTextField();
	 private JTextField accno = new JTextField();
	 private JComboBox<String> type=new JComboBox<String>(lists);
	 private JComboBox<String> acknowledgement=new JComboBox<String>(ack);
	 private JTextField TotalPayment = new JTextField();	
	 private JButton Compute = new JButton("Compute Payment");
	 private JButton pay = new JButton("Pay");
	
	 
	 public RegPost(){	
		 JPanel p1 = new JPanel(new GridLayout(8, 2));
	
		 p1.add(new JLabel("Holder Name"));
		 p1.add(holderName);
		 
		 p1.add(new JLabel("Account number"));
		 p1.add(accno);
		 
		 p1.add(new JLabel("From address"));
		 p1.add(fromadd);
		 
		 p1.add(new JLabel("To address"));
		 p1.add(toadd);
		 
		 p1.add(new JLabel("Type"));
		 p1.add(type);	
		 
		 p1.add(new JLabel("weight(in grams)"));
		 p1.add(weight);
		 
		 p1.add(new JLabel("Acknowledgement"));
		 p1.add(acknowledgement);	
		 
		 p1.add(new JLabel("Total Payment"));
		 p1.add(TotalPayment);
		 
		 p1.setBorder(new TitledBorder("Enter holder name,from address,to address,weight"));

		 JPanel p2 = new JPanel(new GridLayout(1,2));
	
		 p2.add(Compute);
	     p2.add(pay);
		 
	     TotalPayment.setEditable(false);
		 
		 add(p1, BorderLayout.CENTER);
		 add(p2, BorderLayout.SOUTH);
		 
		 Compute.addActionListener(new ButtonListener());
	
		 pay.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
			int p=JOptionPane.showConfirmDialog(null,"Are you sure to proceed ?","PaymentGateway",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		
			if(p==JOptionPane.YES_OPTION)
			 JOptionPane.showMessageDialog(null,"Payment Successful");
			
			else
			 if(p==JOptionPane.NO_OPTION)
			 JOptionPane.showMessageDialog(null,"Payment Aborted!");
			 }
		 }
				 );
		 
	 }
	 
	 
	 private class ButtonListener implements ActionListener {
		
		 public void actionPerformed(ActionEvent e) {
			 
			 double w=Double.parseDouble(weight.getText());
			 int a_in=acknowledgement.getSelectedIndex();
			 int t_in=type.getSelectedIndex();
			 
			 CalcDetails c=new CalcDetails(w,t_in,a_in);
			 
			 TotalPayment.setText(String.format("%.2f",c.Payment()));
				 	  
		 }
	 }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegPost frame = new RegPost();
		 frame.setSize(700,500);
		 frame.setTitle("Point Of Sale");
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
	}

}
