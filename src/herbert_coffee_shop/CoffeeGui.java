package herbert_coffee_shop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CoffeeGui extends JFrame implements ActionListener, KeyListener{
	
	JLabel label;
	JLabel[] imageLabel=new JLabel[8];
	
	JPanel panel1, panel2, panel3;
	
	JCheckBox brainCapuccino, shitenEspresso, mikeLatte, jheBlack;

	JCheckBox rolanMilkTea, pedroColdCoffee, jamColdBlack, morielBrown;
	
	JCheckBox[] small=new JCheckBox[8];
	JCheckBox[] medium=new JCheckBox[8];
	JCheckBox[] large=new JCheckBox[8];
	
	JTextField QuantitySmall[] = new JTextField[8];
	JTextField QuantityMedium[] = new JTextField[8];
	JTextField QuantityLarge[] = new JTextField[8];
	
	
	JButton TheTotal;
	
	JButton preTotal;
	
	JTextField cash, change, textTotal;
	
	String product="";
	
	String size="";

	
	double total=0, finaltotal, getCash;
	String getChange="",getTextTotal="";
	
	double price[]=new double[24];
	String getPrice="";
	
	int[] getQuantities=new int[24];
	
	String getQuantityValues="";
	
	
	public CoffeeGui() {
		super("HERBERT'S COFFEE SHOP");
		setLayout(null);
		
		setTitle();
		setCoffeeCheckboxes();
		setTransactionField();
		
		preTotal=new JButton("CHECK TOTAL");
		preTotal.setBounds(1000,300,100,30);
		preTotal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				preCompute();
			}
			
		});
		add(preTotal);
		
		TheTotal=new JButton("PROCESS");
		TheTotal.setBounds(1100,300,80,30);
		TheTotal.addActionListener(this);
		add(TheTotal);
		
		QuantitySmall[0].addKeyListener(this);
		
		
	}
	
	
public void setTitle(){
		
		JLabel title = new JLabel("                                  " +
				"                              "
				+ "                HERBERT'S COFFEE SHOP");
		title.setBounds(0,0,1200,25);
		title.setOpaque(true);
		title.setBackground(Color.MAGENTA);
		title.setFont(new Font("OLD ENGLISH MT",Font.BOLD,20));
		title.setForeground(Color.WHITE);
		add(title);
		
		setPanel1();
		setPanel2();
		
	}
	
	public void setCoffeeCheckboxes() {
		
		brainCapuccino=new JCheckBox("      BRAIN CAPPUCINO");
		brainCapuccino.setBounds(10,40,205,16);
		brainCapuccino.setOpaque(true);
		brainCapuccino.setBackground(Color.BLUE);
		brainCapuccino.setFont(new Font("Tahoma",Font.BOLD,12));
		brainCapuccino.setForeground(Color.WHITE);
		brainCapuccino.setSelected(true);
		panel1.add(brainCapuccino);
		
		shitenEspresso=new JCheckBox("     SHITEN ESPRESSO ");
		shitenEspresso.setBounds(250,40,205,16);
		shitenEspresso.setOpaque(true);
		shitenEspresso.setBackground(Color.BLUE);
		shitenEspresso.setFont(new Font("Tahoma",Font.BOLD,12));
		shitenEspresso.setForeground(Color.WHITE);
		shitenEspresso.setSelected(true);
		panel1.add(shitenEspresso);
		
		mikeLatte=new JCheckBox("           MIKE LATTE ");
		mikeLatte.setBounds(490,40,205,16);
		mikeLatte.setOpaque(true);
		mikeLatte.setBackground(Color.BLUE);
		mikeLatte.setFont(new Font("Tahoma",Font.BOLD,12));
		mikeLatte.setForeground(Color.WHITE);
		mikeLatte.setSelected(true);
		panel1.add(mikeLatte);
		
		jheBlack=new JCheckBox("       JHE BLACK COFFEE ");
		jheBlack.setBounds(730,40,205,16);
		jheBlack.setOpaque(true);
		jheBlack.setBackground(Color.BLUE);
		jheBlack.setFont(new Font("Tahoma",Font.BOLD,12));
		jheBlack.setForeground(Color.WHITE);
		jheBlack.setSelected(true);
		panel1.add(jheBlack);
		
		//panel 2
		
		rolanMilkTea=new JCheckBox("      ROLAN MILK TEA");
		rolanMilkTea.setBounds(10,40,205,16);
		rolanMilkTea.setOpaque(true);
		rolanMilkTea.setBackground(Color.BLUE);
		rolanMilkTea.setFont(new Font("Tahoma",Font.BOLD,12));
		rolanMilkTea.setForeground(Color.WHITE);
		rolanMilkTea.setSelected(true);
		panel2.add(rolanMilkTea);
		
		pedroColdCoffee=new JCheckBox("     PEDRO COLD COFFEE ");
		pedroColdCoffee.setBounds(250,40,205,16);
		pedroColdCoffee.setOpaque(true);
		pedroColdCoffee.setBackground(Color.BLUE);
		pedroColdCoffee.setFont(new Font("Tahoma",Font.BOLD,12));
		pedroColdCoffee.setForeground(Color.WHITE);
		pedroColdCoffee.setSelected(true);
		panel2.add(pedroColdCoffee);
		
		jamColdBlack=new JCheckBox("       JAM COLD BLACK ");
		jamColdBlack.setBounds(490,40,205,16);
		jamColdBlack.setOpaque(true);
		jamColdBlack.setBackground(Color.BLUE);
		jamColdBlack.setFont(new Font("Tahoma",Font.BOLD,12));
		jamColdBlack.setForeground(Color.WHITE);
		jamColdBlack.setSelected(true);
		panel2.add(jamColdBlack);
		
		morielBrown=new JCheckBox("         MORIEL BROWN ");
		morielBrown.setBounds(730,40,205,16);
		morielBrown.setOpaque(true);
		morielBrown.setBackground(Color.BLUE);
		morielBrown.setFont(new Font("Tahoma",Font.BOLD,12));
		morielBrown.setForeground(Color.WHITE);
		morielBrown.setSelected(true);
		panel2.add(morielBrown);
		
	}

	public void prepareLabelsHot(String str, int xpos, int ypos, int width, int height,Color color,Color fontColor,int fontSize){
		
		label = new JLabel(str);
		label.setBounds(xpos,ypos,width,height);
		label.setOpaque(true);
		label.setBackground(color);
		label.setForeground(fontColor);
		label.setFont(new Font("Tahoma",Font.PLAIN,fontSize));
		panel1.add(label);
		
	}
	
public void prepareLabelsCold(String str, int xpos, int ypos, int width, int height,Color color,Color fontColor,int fontSize){
		
		label = new JLabel(str);
		label.setBounds(xpos,ypos,width,height);
		label.setOpaque(true);
		label.setBackground(color);
		label.setForeground(fontColor);
		label.setFont(new Font("Tahoma",Font.PLAIN,fontSize));
		panel2.add(label);
		
	}
	
	public void prepareLabelImageHot(int i,String path,int xpos, int ypos, int width, int height) {
		imageLabel[i] = new JLabel(new ImageIcon(path));
		imageLabel[i].setBounds(xpos,ypos,width,height);
		imageLabel[i].setOpaque(true);
		panel1.add(imageLabel[i]);
	}
	
	public void prepareLabelImageCold(int i,String path,int xpos, int ypos, int width, int height) {
		imageLabel[i] = new JLabel(new ImageIcon(path));
		imageLabel[i].setBounds(xpos,ypos,width,height);
		imageLabel[i].setOpaque(true);
		panel2.add(imageLabel[i]);
	}
	
	
	public void smallCheckBoxesHot(int i,int xpos,int ypos,int width,int height) {
		
		small[i]=new JCheckBox("Small");
		small[i].setBounds(xpos,ypos,width,height);
		small[i].setOpaque(true);
		small[i].setBackground(Color.CYAN);
		small[i].setFont(new Font("Tahoma",Font.BOLD,12));
		small[i].setForeground(Color.BLACK);
		panel1.add(small[i]);
		
	}
	
public void smallCheckBoxesCold(int i,int xpos,int ypos,int width,int height) {
		
		small[i]=new JCheckBox("Small");
		small[i].setBounds(xpos,ypos,width,height);
		small[i].setOpaque(true);
		small[i].setBackground(Color.CYAN);
		small[i].setFont(new Font("Tahoma",Font.BOLD,12));
		small[i].setForeground(Color.BLACK);
		panel2.add(small[i]);
		
	}
	
public void mediumCheckBoxesHot(int i,int xpos,int ypos,int width,int height) {
		
		medium[i]=new JCheckBox("Medium");
		medium[i].setBounds(xpos,ypos,width,height);
		medium[i].setOpaque(true);
		medium[i].setBackground(Color.CYAN);
		medium[i].setFont(new Font("Tahoma",Font.BOLD,12));
		medium[i].setForeground(Color.BLACK);
		panel1.add(medium[i]);
		
	}

public void mediumCheckBoxesCold(int i,int xpos,int ypos,int width,int height) {
	
	medium[i]=new JCheckBox("Medium");
	medium[i].setBounds(xpos,ypos,width,height);
	medium[i].setOpaque(true);
	medium[i].setBackground(Color.CYAN);
	medium[i].setFont(new Font("Tahoma",Font.BOLD,12));
	medium[i].setForeground(Color.BLACK);
	panel2.add(medium[i]);
	
}

public void largeCheckBoxesHot(int i,int xpos,int ypos,int width,int height) {
	
	large[i]=new JCheckBox("Large");
	large[i].setBounds(xpos,ypos,width,height);
	large[i].setOpaque(true);
	large[i].setBackground(Color.CYAN);
	large[i].setFont(new Font("Tahoma",Font.BOLD,12));
	large[i].setForeground(Color.BLACK);
	panel1.add(large[i]);
	
}

public void largeCheckBoxesCold(int i,int xpos,int ypos,int width,int height) {
	
	large[i]=new JCheckBox("Large");
	large[i].setBounds(xpos,ypos,width,height);
	large[i].setOpaque(true);
	large[i].setBackground(Color.CYAN);
	large[i].setFont(new Font("Tahoma",Font.BOLD,12));
	large[i].setForeground(Color.BLACK);
	panel2.add(large[i]);
	
}
	
	public void smallQuantityHot(int i,int xpos,int ypos,int width,int height) {
		
		QuantitySmall[i] = new JTextField();
		QuantitySmall[i].setBounds(xpos,ypos,width,height);
		QuantitySmall[i].setOpaque(true);
		//QuantitySmall[i].setText("0");
		
		panel1.add(QuantitySmall[i]);
		
	}
	
public void smallQuantityCold(int i,int xpos,int ypos,int width,int height) {
		
		QuantitySmall[i] = new JTextField();
		QuantitySmall[i].setBounds(xpos,ypos,width,height);
		QuantitySmall[i].setOpaque(true);
		QuantitySmall[i].setText("0");
		
		panel2.add(QuantitySmall[i]);
		
	}
	
public void mediumQuantityHot(int i,int xpos,int ypos,int width,int height) {
		
		QuantityMedium[i] = new JTextField();
		QuantityMedium[i].setBounds(xpos,ypos,width,height);
		QuantityMedium[i].setOpaque(true);
		QuantityMedium[i].setText("0");
		
		panel1.add(QuantityMedium[i]);
		
	
	}

public void mediumQuantityCold(int i,int xpos,int ypos,int width,int height) {
	
	QuantityMedium[i] = new JTextField();
	QuantityMedium[i].setBounds(xpos,ypos,width,height);
	QuantityMedium[i].setOpaque(true);
	QuantityMedium[i].setText("0");
	
	panel2.add(QuantityMedium[i]);
	

}


public void largeQuantityHot(int i,int xpos,int ypos,int width,int height) {
	
	QuantityLarge[i] = new JTextField();
	QuantityLarge[i].setBounds(xpos,ypos,width,height);
	QuantityLarge[i].setOpaque(true);
	QuantityLarge[i].setText("0");
	
	panel1.add(QuantityLarge[i]);
	
}
	
public void largeQuantityCold(int i,int xpos,int ypos,int width,int height) {
	
	QuantityLarge[i] = new JTextField();
	QuantityLarge[i].setBounds(xpos,ypos,width,height);
	QuantityLarge[i].setOpaque(true);
	QuantityLarge[i].setText("0");
	
	panel2.add(QuantityLarge[i]);
	
}
	public void setPanel1() {
		
		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(10,30,950,330);
		panel1.setOpaque(true);
		panel1.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		prepareLabelsHot("                        "
				+ "                                     "
				+ "                       HOT COFFEE ",5,5,940,20,Color.BLACK,Color.WHITE,16);
		
		prepareLabelsHot(" SIZE",10,240,75,14,Color.MAGENTA,Color.WHITE,12);
		prepareLabelImageHot(0,"res/brain-capuccino.jpg",10,60,205,170);
		smallCheckBoxesHot(0,10,260,75,16);
		mediumCheckBoxesHot(0,10,280,75,16);
		largeCheckBoxesHot(0,10,300,75,16);
		
		prepareLabelsHot(" PRICE",95,240,40,14,Color.MAGENTA,Color.WHITE,12);
		
		prepareLabelsHot("  P25 ",95,260,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsHot("  P35 ",95,280,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsHot("  P45 ",95,300,40,14,Color.CYAN,Color.BLACK,12);
		
		prepareLabelsHot(" QUANTITY",145,240,70,14,Color.MAGENTA,Color.WHITE,12);
		smallQuantityHot(0,145,260,70,16);
		mediumQuantityHot(0,145,280,70,16);
		largeQuantityHot(0,145,300,70,16);
		
		//prepareLabelsHot("  SHITEN ESPRESSO ",250,40,120,14,Color.BLUE,Color.WHITE,12);
		prepareLabelsHot(" SIZE",250,240,75,14,Color.MAGENTA,Color.WHITE,12);
		prepareLabelImageHot(1,"res/shiten-espresso.jpg",250,60,205,170);
		smallCheckBoxesHot(1,250,260,75,16);
		mediumCheckBoxesHot(1,250,280,75,16);
		largeCheckBoxesHot(1,250,300,75,16);
		
		prepareLabelsHot(" PRICE",335,240,40,14,Color.MAGENTA,Color.WHITE,12);
		
		prepareLabelsHot("  P30 ",335,260,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsHot("  P40 ",335,280,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsHot("  P50 ",335,300,40,14,Color.CYAN,Color.BLACK,12);
		
		prepareLabelsHot(" QUANTITY",385,240,70,14,Color.MAGENTA,Color.WHITE,12);
		smallQuantityHot(1,385,260,70,16);
		mediumQuantityHot(1,385,280,70,16);
		largeQuantityHot(1,385,300,70,16);
		
		//MIKE LATTE
		prepareLabelsHot(" SIZE",490,240,75,14,Color.MAGENTA,Color.WHITE,12);
		prepareLabelImageHot(2,"res/mike-latte.jpg",490,60,205,170);
		smallCheckBoxesHot(2,490,260,75,16);
		mediumCheckBoxesHot(2,490,280,75,16);
		largeCheckBoxesHot(2,490,300,75,16);
		
		prepareLabelsHot(" PRICE",575,240,40,14,Color.MAGENTA,Color.WHITE,12);
		
		prepareLabelsHot("  P20 ",575,260,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsHot("  P30 ",575,280,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsHot("  P40 ",575,300,40,14,Color.CYAN,Color.BLACK,12);
		
		prepareLabelsHot(" QUANTITY",625,240,70,14,Color.MAGENTA,Color.WHITE,12);
		smallQuantityHot(2,625,260,70,16);
		mediumQuantityHot(2,625,280,70,16);
		largeQuantityHot(2,625,300,70,16);
		
		
		//JHE BLACK
		prepareLabelsHot(" SIZE",730,240,75,14,Color.MAGENTA,Color.WHITE,12);
		prepareLabelImageHot(3,"res/jhe-black.jpg",730,60,205,170);
		smallCheckBoxesHot(3,730,260,75,16);
		mediumCheckBoxesHot(3,730,280,75,16);
		largeCheckBoxesHot(3,730,300,75,16);

		prepareLabelsHot(" PRICE",815,240,40,14,Color.MAGENTA,Color.WHITE,12);

		prepareLabelsHot("  P20 ",815,260,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsHot("  P30 ",815,280,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsHot("  P40 ",815,300,40,14,Color.CYAN,Color.BLACK,12);

		prepareLabelsHot(" QUANTITY",865,240,70,14,Color.MAGENTA,Color.WHITE,12);
		smallQuantityHot(3,865,260,70,16);
		mediumQuantityHot(3,865,280,70,16);
		largeQuantityHot(3,865,300,70,16);
		
		add(panel1);
		
	}
	
	
public void setPanel2() {
		
		panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(10,370,950,330);
		panel2.setOpaque(true);
		panel2.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		prepareLabelsCold("                        "
				+ "                                     "
				+ "                       COLD COFFEE ",5,5,940,20,Color.GREEN,Color.BLUE,16);
		
		//ROLAN MILK TEA
		prepareLabelsCold(" SIZE",10,240,75,14,Color.MAGENTA,Color.WHITE,12);
		prepareLabelImageCold(4,"res/cold1.jpg",10,60,205,170);
		smallCheckBoxesCold(4,10,260,75,16);
		mediumCheckBoxesCold(4,10,280,75,16);
		largeCheckBoxesCold(4,10,300,75,16);
		
		prepareLabelsCold(" PRICE",95,240,40,14,Color.MAGENTA,Color.WHITE,12);
		
		prepareLabelsCold("  P25 ",95,260,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsCold("  P35 ",95,280,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsCold("  P45 ",95,300,40,14,Color.CYAN,Color.BLACK,12);
		
		prepareLabelsCold(" QUANTITY",145,240,70,14,Color.MAGENTA,Color.WHITE,12);
		smallQuantityCold(4,145,260,70,16);
		mediumQuantityCold(4,145,280,70,16);
		largeQuantityCold(4,145,300,70,16);
		
		//PEDRO COLD COFFEE
		prepareLabelsCold(" SIZE",250,240,75,14,Color.MAGENTA,Color.WHITE,12);
		prepareLabelImageCold(5,"res/cold2.jpg",250,60,205,170);
		smallCheckBoxesCold(5,250,260,75,16);
		mediumCheckBoxesCold(5,250,280,75,16);
		largeCheckBoxesCold(5,250,300,75,16);
		
		prepareLabelsCold(" PRICE",335,240,40,14,Color.MAGENTA,Color.WHITE,12);
		
		prepareLabelsCold("  P30 ",335,260,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsCold("  P40 ",335,280,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsCold("  P50 ",335,300,40,14,Color.CYAN,Color.BLACK,12);
		
		prepareLabelsCold(" QUANTITY",385,240,70,14,Color.MAGENTA,Color.WHITE,12);
		smallQuantityCold(5,385,260,70,16);
		mediumQuantityCold(5,385,280,70,16);
		largeQuantityCold(5,385,300,70,16);
		
		//JAM COLD BLACK
		prepareLabelsCold(" SIZE",490,240,75,14,Color.MAGENTA,Color.WHITE,12);
		prepareLabelImageCold(6,"res/cold3.jpg",490,60,205,170);
		smallCheckBoxesCold(6,490,260,75,16);
		mediumCheckBoxesCold(6,490,280,75,16);
		largeCheckBoxesCold(6,490,300,75,16);
		
		prepareLabelsCold(" PRICE",575,240,40,14,Color.MAGENTA,Color.WHITE,12);
		
		prepareLabelsCold("  P20 ",575,260,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsCold("  P30 ",575,280,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsCold("  P40 ",575,300,40,14,Color.CYAN,Color.BLACK,12);
		
		prepareLabelsCold(" QUANTITY",625,240,70,14,Color.MAGENTA,Color.WHITE,12);
		smallQuantityCold(6,625,260,70,16);
		mediumQuantityCold(6,625,280,70,16);
		largeQuantityCold(6,625,300,70,16);
		
		
		//MORIEL BROWN
		prepareLabelsCold(" SIZE",730,240,75,14,Color.MAGENTA,Color.WHITE,12);
		prepareLabelImageCold(7,"res/cold4.jpg",730,60,205,170);
		smallCheckBoxesCold(7,730,260,75,16);
		mediumCheckBoxesCold(7,730,280,75,16);
		largeCheckBoxesCold(7,730,300,75,16);

		prepareLabelsCold(" PRICE",815,240,40,14,Color.MAGENTA,Color.WHITE,12);

		prepareLabelsCold("  P20 ",815,260,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsCold("  P30 ",815,280,40,14,Color.CYAN,Color.BLACK,12);
		prepareLabelsCold("  P40 ",815,300,40,14,Color.CYAN,Color.BLACK,12);

		prepareLabelsCold(" QUANTITY",865,240,70,14,Color.MAGENTA,Color.WHITE,12);
		smallQuantityCold(7,865,260,70,16);
		mediumQuantityCold(7,865,280,70,16);
		largeQuantityCold(7,865,300,70,16);
		
		add(panel2);
		
	}


	public void compute() {
		
		System.out.println("=========================================");
		System.out.println("         HERBERT'S COFFEE SHOP");
		System.out.println("=========================================");
		System.out.println();
		
		System.out.println("PRODUCT                QUANTITY     PRICE");
		System.out.println();
		
		if(brainCapuccino.isSelected()) {
			
			
			if(small[0].isSelected() || medium[0].isSelected() || large[0].isSelected()) {
				product+="* BRAIN CAPUCCINO *";
				System.out.println(product);
				System.out.println();
			}
			
			if(small[0].isSelected()) {
				size="Small (P25)";
				//increment
				getQuantityValues=QuantitySmall[0].getText().toString();
				//increment
				getQuantities[0]=Integer.parseInt(QuantitySmall[0].getText().toString());
				//increment
				price[0]=getQuantities[0]*25;
				total+=price[0];
				System.out.println(size+"               "+getQuantityValues+"         "+price[0]);
			}
			if(medium[0].isSelected()) {
				size="Medium (P35)";
				getQuantityValues=QuantityMedium[0].getText().toString();
				getQuantities[1]=Integer.parseInt(QuantityMedium[0].getText().toString());
				price[1]=getQuantities[1]*35;
				total+=price[1];
				System.out.println(size+"              "+getQuantityValues+"         "+price[1]);
			}
			if(large[0].isSelected()) {
				size="Large (P45)";
				getQuantityValues=QuantityLarge[0].getText().toString();
				getQuantities[2]=Integer.parseInt(QuantityLarge[0].getText().toString());
				price[2]=getQuantities[2]*45;
				total+=price[2];
				System.out.println(size+"               "+getQuantityValues+"         "+price[2]);
			}
			
			product="";
			
		}
		
		
if(shitenEspresso.isSelected()) {
	
	if(small[1].isSelected() || medium[1].isSelected() || large[1].isSelected()) {
		product+="* SHITEN ESPRESSO *";
		System.out.println();
		System.out.println(product);
		System.out.println();
	}
			
		
			
			if(small[1].isSelected()) {
				size="Small (P30)";
				getQuantityValues=QuantitySmall[1].getText().toString();
				getQuantities[3]=Integer.parseInt(QuantitySmall[1].getText().toString());
				price[3]=getQuantities[3]*30;
				total+=price[3];
				System.out.println(size+"               "+getQuantityValues+"         "+price[3]);
			}
			if(medium[1].isSelected()) {
				size="Medium (P40)";
				getQuantityValues=QuantityMedium[1].getText().toString();
				getQuantities[4]=Integer.parseInt(QuantityMedium[1].getText().toString());
				price[4]=getQuantities[4]*40;
				total+=price[4];
				System.out.println(size+"              "+getQuantityValues+"         "+price[4]);
			}
			if(large[1].isSelected()) {
				size="Large (P50)";
				getQuantityValues=QuantityLarge[1].getText().toString();
				getQuantities[5]=Integer.parseInt(QuantityLarge[1].getText().toString());
				price[5]=getQuantities[5]*50;
				total+=price[5];
				System.out.println(size+"               "+getQuantityValues+"         "+price[5]);
			}
			
			product="";
			
		
		}

		
		if(mikeLatte.isSelected()) {
			
			if(small[2].isSelected() || medium[2].isSelected() || large[2].isSelected()) {
				product+="* MIKE MOCHA *";
				System.out.println();
				System.out.println(product);
				System.out.println();
			}
			
			
			
			if(small[2].isSelected()) {
				size="Small (P20)";
				//increment
				getQuantityValues=QuantitySmall[2].getText().toString();
				//increment
				getQuantities[6]=Integer.parseInt(QuantitySmall[2].getText().toString());
				//increment
				price[6]=getQuantities[6]*20;
				total+=price[6];
				System.out.println(size+"               "+getQuantityValues+"         "+price[6]);
			}
			if(medium[2].isSelected()) {
				size="Medium (P30)";
				//increment
				getQuantityValues=QuantityMedium[2].getText().toString();
				//increment
				getQuantities[7]=Integer.parseInt(QuantityMedium[2].getText().toString());
				//increment
				price[7]=getQuantities[7]*30;
				total+=price[7];
				System.out.println(size+"              "+getQuantityValues+"         "+price[7]);
			}
			
			if(large[2].isSelected()) {
				size="Large (P40)";
				//increment
				getQuantityValues=QuantityLarge[2].getText().toString();
				//increment
				getQuantities[8]=Integer.parseInt(QuantityLarge[2].getText().toString());
				//increment
				price[8]=getQuantities[8]*40;
				total+=price[8];
				System.out.println(size+"               "+getQuantityValues+"         "+price[8]);
			}
			
			product="";
		}
		
		
if(jheBlack.isSelected()) {
			
			if(small[3].isSelected() || medium[3].isSelected() || large[3].isSelected()) {
				product+="* JHE MILK CAFE *";
				System.out.println();
				System.out.println(product);
				System.out.println();
			}
			
			
			
			if(small[3].isSelected()) {
				size="Small (P30)";
				//increment
				getQuantityValues=QuantitySmall[3].getText().toString();
				//increment
				getQuantities[9]=Integer.parseInt(QuantitySmall[3].getText().toString());
				//increment
				price[9]=getQuantities[9]*30;
				total+=price[9];
				System.out.println(size+"               "+getQuantityValues+"         "+price[9]);
			}
			if(medium[3].isSelected()) {
				size="Medium (P35)";
				//increment
				getQuantityValues=QuantityMedium[3].getText().toString();
				//increment
				getQuantities[10]=Integer.parseInt(QuantityMedium[3].getText().toString());
				//increment
				price[10]=getQuantities[10]*35;
				total+=price[10];
				System.out.println(size+"              "+getQuantityValues+"         "+price[10]);
			}
			
			if(large[3].isSelected()) {
				size="Large (P40)";
				//increment
				getQuantityValues=QuantityLarge[3].getText().toString();
				//increment
				getQuantities[11]=Integer.parseInt(QuantityLarge[3].getText().toString());
				//increment
				price[11]=getQuantities[11]*40;
				total+=price[11];
				System.out.println(size+"               "+getQuantityValues+"         "+price[11]);
			}
			
			product="";
		}

if(rolanMilkTea.isSelected()) {
	
	if(small[4].isSelected() || medium[4].isSelected() || large[4].isSelected()) {
		product+="* ROLAN MILK TEA *";
		System.out.println();
		System.out.println(product);
		System.out.println();
	}
	
	
	
	if(small[4].isSelected()) {
		size="Small (P25)";
		//increment
		getQuantityValues=QuantitySmall[4].getText().toString();
		//increment
		getQuantities[12]=Integer.parseInt(QuantitySmall[4].getText().toString());
		//increment
		price[12]=getQuantities[12]*25;
		total+=price[12];
		System.out.println(size+"               "+getQuantityValues+"         "+price[12]);
	}
	if(medium[4].isSelected()) {
		size="Medium (P35)";
		//increment
		getQuantityValues=QuantityMedium[4].getText().toString();
		//increment
		getQuantities[12]=Integer.parseInt(QuantityMedium[4].getText().toString());
		//increment
		price[12]=getQuantities[12]*35;
		total+=price[12];
		System.out.println(size+"              "+getQuantityValues+"         "+price[12]);
	}
	
	if(large[4].isSelected()) {
		size="Large (P45)";
		//increment
		getQuantityValues=QuantityLarge[4].getText().toString();
		//increment
		getQuantities[13]=Integer.parseInt(QuantityLarge[4].getText().toString());
		//increment
		price[13]=getQuantities[13]*45;
		total+=price[13];
		System.out.println(size+"               "+getQuantityValues+"         "+price[13]);
	}
	
	product="";
}

if(pedroColdCoffee.isSelected()) {
	
	if(small[5].isSelected() || medium[5].isSelected() || large[5].isSelected()) {
		product+="* PEDRO COLD COFFEE *";
		System.out.println();
		System.out.println(product);
		System.out.println();
	}
	
	
	
	if(small[5].isSelected()) {
		size="Small (P30)";
		//increment
		getQuantityValues=QuantitySmall[5].getText().toString();
		//increment
		getQuantities[13]=Integer.parseInt(QuantitySmall[5].getText().toString());
		//increment
		price[13]=getQuantities[13]*30;
		total+=price[13];
		System.out.println(size+"               "+getQuantityValues+"         "+price[13]);
	}
	if(medium[5].isSelected()) {
		size="Medium (P40)";
		//increment
		getQuantityValues=QuantityMedium[5].getText().toString();
		//increment
		getQuantities[14]=Integer.parseInt(QuantityMedium[5].getText().toString());
		//increment
		price[14]=getQuantities[14]*40;
		total+=price[14];
		System.out.println(size+"              "+getQuantityValues+"         "+price[14]);
	}
	
	if(large[5].isSelected()) {
		size="Large (P50)";
		//increment
		getQuantityValues=QuantityLarge[5].getText().toString();
		//increment
		getQuantities[15]=Integer.parseInt(QuantityLarge[5].getText().toString());
		//increment
		price[15]=getQuantities[15]*50;
		total+=price[15];
		System.out.println(size+"               "+getQuantityValues+"         "+price[15]);
	}
	
	product="";
}

if(jamColdBlack.isSelected()) {
	
	if(small[6].isSelected() || medium[6].isSelected() || large[6].isSelected()) {
		product+="* JAM COLD BLACK *";
		System.out.println();
		System.out.println(product);
		System.out.println();
	}
	
	
	
	if(small[6].isSelected()) {
		size="Small (P20)";
		//increment
		getQuantityValues=QuantitySmall[6].getText().toString();
		//increment
		getQuantities[14]=Integer.parseInt(QuantitySmall[6].getText().toString());
		//increment
		price[14]=getQuantities[14]*20;
		total+=price[14];
		System.out.println(size+"               "+getQuantityValues+"         "+price[14]);
	}
	if(medium[6].isSelected()) {
		size="Medium (P30)";
		//increment
		getQuantityValues=QuantityMedium[6].getText().toString();
		//increment
		getQuantities[15]=Integer.parseInt(QuantityMedium[6].getText().toString());
		//increment
		price[15]=getQuantities[15]*30;
		total+=price[15];
		System.out.println(size+"              "+getQuantityValues+"         "+price[15]);
	}
	
	if(large[6].isSelected()) {
		size="Large (P40)";
		//increment
		getQuantityValues=QuantityLarge[6].getText().toString();
		//increment
		getQuantities[16]=Integer.parseInt(QuantityLarge[6].getText().toString());
		//increment
		price[16]=getQuantities[16]*40;
		total+=price[16];
		System.out.println(size+"               "+getQuantityValues+"         "+price[16]);
	}
	
	product="";
}

if(morielBrown.isSelected()) {
	
	if(small[7].isSelected() || medium[7].isSelected() || large[7].isSelected()) {
		product+="* MORIEL BROWN *";
		System.out.println();
		System.out.println(product);
		System.out.println();
	}
	
	
	
	if(small[7].isSelected()) {
		size="Small (P20)";
		//increment
		getQuantityValues=QuantitySmall[7].getText().toString();
		//increment
		getQuantities[17]=Integer.parseInt(QuantitySmall[7].getText().toString());
		//increment
		price[17]=getQuantities[17]*20;
		total+=price[17];
		System.out.println(size+"               "+getQuantityValues+"         "+price[17]);
	}
	if(medium[7].isSelected()) {
		size="Medium (P30)";
		//increment
		getQuantityValues=QuantityMedium[7].getText().toString();
		//increment
		getQuantities[17]=Integer.parseInt(QuantityMedium[7].getText().toString());
		//increment
		price[17]=getQuantities[17]*30;
		total+=price[17];
		System.out.println(size+"              "+getQuantityValues+"         "+price[17]);
	}
	
	if(large[7].isSelected()) {
		size="Large (P40)";
		//increment
		getQuantityValues=QuantityLarge[7].getText().toString();
		//increment
		getQuantities[17]=Integer.parseInt(QuantityLarge[7].getText().toString());
		//increment
		price[17]=getQuantities[17]*40;
		total+=price[17];
		System.out.println(size+"               "+getQuantityValues+"         "+price[17]);
	}
	
	product="";
}

		getCash = Integer.parseInt(cash.getText().toString());
		
		finaltotal= getCash - total;
		
		getTextTotal+=total;
		
		getChange+=finaltotal;
		
		change.setText(getChange);
		textTotal.setText(getTextTotal);
		
		System.out.println();
		System.out.println("=========================================");
		System.out.println();
		System.out.println("Total                               P"+total);
		
		
		total=0;
		
		
	}
	
	
	public void preCompute() {
	
		
if(brainCapuccino.isSelected()) {
			
			
			if(small[0].isSelected()) {
				
				if(QuantitySmall[0].getText().toString().equals("")) {
					//getQuantities[0]=Integer.parseInt(QuantitySmall[0].getText().toString());
					getQuantities[0]=0;
				}else {
					getQuantityValues=QuantitySmall[0].getText().toString();
					//increment
					getQuantities[0]=Integer.parseInt(QuantitySmall[0].getText().toString());
					//increment
					price[0]=getQuantities[0]*25;
					total+=price[0];
				}
				
				getTextTotal=""+total;
				
				textTotal.setText(getTextTotal);
			}
			
		}
		
	}
	
	public void clearFields() {
		
		//para sa clearings ng mga fields mamaya after confirmation
		for(int i=0;i<small.length;i++) {
			small[i].setSelected(false);
		}
		
		for(int j=0;j<QuantitySmall.length;j++) {
			QuantitySmall[j].setText("0");
		}
		
		for(int i=0;i<medium.length;i++) {
			medium[i].setSelected(false);
		}
		
		for(int j=0;j<QuantityMedium.length;j++) {
			QuantityMedium[j].setText("0");
		}
		
		for(int i=0;i<large.length;i++) {
			large[i].setSelected(false);
		}
		
		for(int j=0;j<QuantityLarge.length;j++) {
			QuantityLarge[j].setText("0");
		}
		
	}
	
	
public void prepareLabelTransaction(String str, int xpos, int ypos, int width, int height,Color color,Color fontColor,int fontSize){
		
		label = new JLabel(str);
		label.setBounds(xpos,ypos,width,height);
		label.setOpaque(true);
		label.setBackground(color);
		label.setForeground(fontColor);
		label.setFont(new Font("Tahoma",Font.PLAIN,fontSize));
		add(label);
		
	}
	
	public void setTransactionField() {
		
		prepareLabelTransaction("          CASH ",1000,70,150,20,Color.BLUE,Color.WHITE,16);
		
		cash = new JTextField();
		cash.setBounds(1000,100,150,20);
		//cash.setHorizontalAlignment(JTextField.CENTER);
		add(cash);
		
		prepareLabelTransaction("         TOTAL ",1000,150,150,20,Color.BLUE,Color.WHITE,16);
		
		textTotal = new JTextField();
		textTotal.setBounds(1000,180,150,20);
		textTotal.setHorizontalAlignment(JTextField.CENTER);
		textTotal.setEditable(false);
		add(textTotal);
		
		prepareLabelTransaction("         CHANGE ",1000,230,150,20,Color.BLUE,Color.WHITE,16);
		
		change = new JTextField();
		change.setBounds(1000,260,150,20);
		change.setHorizontalAlignment(JTextField.CENTER);
		change.setEditable(false);
		add(change);
	
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		compute();
		clearFields();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		preCompute();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		preCompute();
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		preCompute();
	}

}
