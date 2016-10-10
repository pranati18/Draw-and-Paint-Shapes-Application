/*
* Pranati Shrivastava
* pps35@drexel.edu
* CS530:DUI, Assignment 1, Program [MyShapes]
*/


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class MyShapes extends JPanel{
	
	int Xcoord,Ycoord;
	static int[] array ;
	static ArrayList<String> list= new ArrayList<>();
	static int selected_tab;
	static Line line;
	static Circle circle;
	static Rectangle rectangle;
	static Pentagon pentagon;
	static Octagon octagon;
	
	static boolean checkline=false, checkcircle=false ,checkrectangle=false, checkpentagon=false,
			checkoctagon=false;
	static JButton ok;
	
	static JTextField x1text;
	static JTextField y1text;
	static JTextField x2text;
	static JTextField y2text;
	
	static String getcxtext;
	static JFrame frame;
	
	static String fillColor;
	static String strokeColor="None";
	
	static String jlistSelect;
	static int jlistIndex;
	
	
	//method used to decide the color selected
		protected Color setStrokeColor(String strokeColor){
			Color color = Color.BLACK;
			if (strokeColor.equals("None"))
	        {
	        	color=Color.BLACK;
	        }
	        if (strokeColor.equals("Cyan"))
	        {
	        	color=Color.CYAN;
	        }
	        if (strokeColor.equals("Magenta"))
	        {
	        	color=Color.MAGENTA;
	        }
	        if (strokeColor.equals("Pink"))
	        {
	        	color=Color.PINK;
	        }
	        if (strokeColor.equals("Orange"))
	        {
	        	color=Color.ORANGE;
	        }
	        if (strokeColor.equals("Grey"))
	        {
	        	color=Color.GRAY;
	        }
	        else{
	        	color=Color.BLACK;
	        }
			return color;
		}
		protected Color setFillColor(String fillColor){
			Color color = null;
			if (strokeColor.equals("None"))
	        {
	        	color=Color.WHITE;
	        	System.out.println("white");
	        }
	        if (strokeColor.equals("Cyan"))
	        {
	        	color=Color.CYAN;

	        	System.out.println("cyan");
	        }
	        if (strokeColor.equals("Magenta"))
	        {
	        	color=Color.MAGENTA;

	        	System.out.println("magenta");
	        }
	        if (strokeColor.equals("Pink"))
	        {
	        	color=Color.PINK;

	        	System.out.println("pink");
	        }
	        if (strokeColor.equals("Orange"))
	        {
	        	color=Color.ORANGE;

	        	System.out.println("orange");
	        }
	        if (strokeColor.equals("Grey"))
	        {
	        	color=Color.GRAY;

	        	System.out.println("gray");
	        }
			return color;
		}
	//This method paints all the shapes on the canvas
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        // paint background
        g2D.setBackground(Color.WHITE);
       
        g2D.clearRect(0,0,getWidth(), getHeight());
 
        // paint shape
       // g2D.setColor(setStrokeColor(strokeColor));
        
        //for(int i=0;i<=list.size();i++){
       
        if(checkline==true || list.contains("Line"))
        {
        	drawLine(g2D, Double.parseDouble(line.getX1()), Double.parseDouble(line.getY1()),
        			Double.parseDouble(line.getX2()), Double.parseDouble(line.getY2()),setStrokeColor(strokeColor), setFillColor(fillColor));
        	System.out.println("HI");
        	
        }
        if(checkcircle==true || list.contains("Circle")){
        	drawCircle(g, Integer.parseInt(circle.getCx()), Integer.parseInt(circle.getCy()), Integer.parseInt(circle.getRadius()),
        			setStrokeColor(strokeColor), setFillColor(fillColor));
        }
        if(checkrectangle==true || list.contains("Rectangle")){
        	drawRectangle(g2D, Integer.parseInt(rectangle.getX()), Integer.parseInt(rectangle.getY()), Integer.parseInt(rectangle.getW()), 
        			Integer.parseInt(rectangle.getH()),setStrokeColor(strokeColor), setFillColor(fillColor));;
        }
        if(checkpentagon==true || list.contains("Pentagon")){
        	drawPolygon(g2D, Double.parseDouble(pentagon.getPx()), Double.parseDouble(pentagon.getPy()),
        			Double.parseDouble(pentagon.getPc()),setStrokeColor(strokeColor), setFillColor(fillColor));
        }
        if(checkoctagon==true || list.contains("Octagon")){
        	drawOctagon(g2D, Double.parseDouble(octagon.getOx()), Double.parseDouble(octagon.getOy()),
        			Double.parseDouble(octagon.getOc()), setStrokeColor(strokeColor), setFillColor(fillColor));
        }
        else{
        	System.out.println(":(:(:)"+list);
        }
        
        
      
    }
    
	/* Shape outline = tl.getOutline(textAt);
      g2D.setPaint(gp); 
      g2D.fill(outline);
      //
      g2D.setColor(Color.yellow);
      BasicStroke wideStroke = new BasicStroke(2);
      g2D.setStroke(wideStroke); 
      g2D.draw(outline);*/
	
	 //method to draw Circle
    private void drawCircle(Graphics g,int cx,int cy,int radius,Color strokeColor, Color fillColor){

        g.drawOval(cx-radius, cy-radius, 2*radius, 2*radius);
        g.setColor(fillColor);        
        g.fillOval(cx-radius, cy-radius, 2*radius, 2*radius);
    }
    
    //method to draw Line
    private void drawLine(Graphics2D g2D,double x1, double y1, double x2, double y2,Color strokeColor, Color fillColor){
        Line2D.Double line= new Line2D.Double(20, 30, 150, 200);
        g2D.setColor(fillColor);
        g2D.draw(line);
        
    }
    
  //method to draw Pentagon
    private void drawPolygon(Graphics g,double centerX, double centerY, double radius,Color strokeColor, Color fillColor){
        
        Polygon p = new Polygon();
        
        for (int i = 0; i < 5 ; i++)
        {
            double angle = 2 * Math.PI * i / 5;
            p.addPoint((int) (centerX + radius * Math.cos(angle)),
                    (int) (centerY + radius * Math.sin(angle)));
        }
        
        g.drawPolygon(p);
        g.setColor(fillColor);
        
        g.fillPolygon(p);
       /* for (int i = 0; i < 5; i++)
          p.addPoint((int) (centerX + radius * Math.cos(angle)),
              (int) (centerY + radius * Math.sin(angle)));

        g.drawPolygon(p);
        */
    }
    
    
  //method to draw Octagon
    private void drawOctagon(Graphics g, double centerX, double centerY, double radius, Color strokeColor, Color fillColor){
        
        Polygon p = new Polygon();
        
        for (int i = 0; i < 8 ; i++)
        {
            double angle = 2 * Math.PI * i / 8;
            p.addPoint((int) (centerX + radius * Math.cos(angle)),
                    (int) (centerY + radius * Math.sin(angle)));
        }
        
        g.drawPolygon(p);
        g.setColor(fillColor);
        g.fillPolygon(p);
    }		
  //method to draw Rectangle
    private void drawRectangle(Graphics2D g2D,int x,int y,int w,int h, Color strokeColor, Color fillColor){
        
        Rectangle2D.Double rectangle= new Rectangle2D.Double(x, y, w, h);
      
        g2D.draw(rectangle);
        g2D.setColor(fillColor);
        g2D.fill(rectangle);
    }
    
    
	
     
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Canvas canvas = new Canvas();
		MyShapes myShapes=new MyShapes();
	        frame = new JFrame("Paint");
	        
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(myShapes);
	        frame.setBounds(500,500,500,500);
	        
	       // frame.setSize(500, 500);
	        frame.setVisible(true);
	        //frame.pack();
	        frame.setLocationRelativeTo(null);
	        
	        
	        JPanel jpanel= new JPanel();
	        jpanel.setLayout(new FlowLayout());
	        
	      
	      //Creating Jlist and model
	         DefaultListModel model= new DefaultListModel();
	        
	        JButton add, change, remove;
	        add= new JButton("Add");
	        change= new JButton("Change");
	        change.setEnabled(false);
	        remove= new JButton("Remove");
	        	remove.setEnabled(false);       
	       
	         jpanel.add(add);
	         jpanel.add(change);
	         jpanel.add(remove);
	         
	         //Adding new window
	        final JDialog jdialog= new JDialog();
	         jdialog.setVisible(false);
	        // jdialog.setModal(true);
	 
	         //Adding tabbed pane in dialog box
	         final	JTabbedPane tabbedPane = new JTabbedPane();
				

	         line=new Line();
	         circle=new Circle();
	         rectangle= new Rectangle();
	         pentagon=new Pentagon();
	         octagon= new Octagon();
	         
	         
		        JComponent panel1 = makeTextPanelLine();
		        tabbedPane.addTab("Line", panel1);
		        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		         
		        JComponent panel2 = makeTextPanelCircle();
		        tabbedPane.addTab("Circle", panel2);
		        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		         
		        JComponent panel3 = makeTextPanelRect();
		        tabbedPane.addTab("Rectangle", panel3);
		        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		         
		        JComponent panel4 = makeTextPanelPentagon();
		        tabbedPane.addTab("Pentagon", panel4);
		        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		        
		        JComponent panel5 = makeTextPanelOctagon();
		        tabbedPane.addTab("Octagon", panel5);
		         
		        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
	         
	         
	         
	         jdialog.add(tabbedPane); 
	         
	         //Creating Jlist and model
//345	      //   DefaultListModel model= new DefaultListModel();
	         //This creates the list of the shapes in the main window
	         JList jlist =new JList(model);
	         
	         
	        //ok button and its listener.
	         ok= new JButton("OK");
	       
	         ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					System.out.println("OK is hit");
					change.setEnabled(true);
					remove.setEnabled(true);
					
					if(selected_tab==0){
					checkline=true;
					/*line.setX1(x1text.getText());
					line.setY1(y1text.getText());
					line.setX2(x2text.getText());
					line.setY2(y2text.getText());*/
					
					list.add("Line");
					model.addElement("Line");
					frame.repaint();
					System.out.println(checkline);
					System.out.println("x1text.gettext:"+x1text.getText());
					System.out.println("x1 get"+line.getX1());
					System.out.println("list:"+list);
					
					}
					if(selected_tab==1){
						checkcircle=true;
						/*circle.setCx(cxtext.getText());
						circle.setCy(cytext.getText());
						circle.setRadius(radiustext.getText());*/
						list.add("Circle");
						model.addElement("Circle");
						frame.repaint();
						System.out.println(checkline);
		
						System.out.println("cx get"+circle.getCx());
						System.out.println("list:"+list);
						
						}
					if(selected_tab==2){
						checkrectangle=true;
						/*circle.setCx(cxtext.getText());
						circle.setCy(cytext.getText());
						circle.setRadius(radiustext.getText());*/
						list.add("Rectangle");
						model.addElement("Rectangle");
						frame.repaint();
						System.out.println(checkrectangle);
				
						System.out.println("cx get"+rectangle.getX());
						System.out.println("list:"+list);
						
						}
					if(selected_tab==3){
						checkpentagon=true;
						/*circle.setCx(cxtext.getText());
						circle.setCy(cytext.getText());
						circle.setRadius(radiustext.getText());*/
						list.add("Pentagon");
						model.addElement("Pentagon");
						frame.repaint();
						System.out.println(checkpentagon);
	
						System.out.println("cx get"+pentagon.getPx());
						System.out.println("list:"+list);
						
						}
					if(selected_tab==4){
						checkoctagon=true;
						/*circle.setCx(cxtext.getText());
						circle.setCy(cytext.getText());
						circle.setRadius(radiustext.getText());*/
						list.add("Octagon");
						model.addElement("Octagon");
						frame.repaint();
						System.out.println(checkoctagon);
			
						System.out.println("cx get"+octagon.getOx());
						System.out.println("list:"+list);
						
						}
					
					 
			         jlist.setVisible(true);
			         jlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			         jlist.setLayout(new FlowLayout());
			         
			         
			       /* list.add("ADD"); 
			         list.add("ADD1");
			         list.add("ADD2");*/
//			        for(int i=0;i<list.size();i++){
//			         model.addElement(list.get(i));
//			        }
			         
			         jpanel.add(jlist);
			         jpanel.revalidate();
			       //  jpanel.repaint();
			         
			        
			         
				}
			});
	         
	         
	         remove.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.out.println("jlistslect$$$$$"+jlistSelect+"****"+jlistIndex);
						
						System.out.println("Eleemnt remove:"+list.indexOf(jlistSelect));
						//list.isEmpty()
						list.remove(list.indexOf(jlistSelect));
						//model.removeElement(jlistSelect);
						//model.remove(jlistIndex);
						if(jlistSelect.equals("Rectangle"))
						{
							checkrectangle=false;
						}
						if(jlistSelect.equals("Line"))
						{
							checkline=false;
						}
						if(jlistSelect.equals("Circle"))
						{
							checkcircle=false;
						}
						if(jlistSelect.equals("Pentagon"))
						{
							checkpentagon=false;
						}
						if(jlistSelect.equals("Octagon"))
						{
							checkoctagon=false;
						}
						
						frame.repaint();
						model.removeElement(jlistSelect);
					}
					

				});

	         //Jlist Listener
	         jlist.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub
						jlistSelect= String.valueOf(jlist.getSelectedValue());
						jlistIndex=jlist.getSelectedIndex();
					}
				});
	         
	         
	         //setEventforOk(ok);//setting list
		     JButton cancel=new JButton("Cancel");
		     
			cancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					jdialog.setVisible(false);
				}
			});
			
			jdialog.setLayout(new FlowLayout());	
			
			jdialog.add(ok);
			jdialog.add(cancel);
			
	         //event handling for add button
	         add.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					JPanel jpanel1= new JPanel();
					
					jdialog.setLocationRelativeTo(tabbedPane);
					jdialog.setVisible(true);
					jdialog.pack();
					
					tabbedPane.addChangeListener(new ChangeListener() {
						
						@Override
						public void stateChanged(ChangeEvent e) {
							// TODO Auto-generated method stub
							selected_tab = tabbedPane.getSelectedIndex();
							System.out.println(selected_tab);
						}
					});
					
					
				}
			});
	         
	         /*change button code start*/
	         
	         
	         final JDialog jdialog1= new JDialog();
	         jdialog1.setVisible(false);
	        // jdialog.setModal(true);
	 
	         
	         final	JTabbedPane tabbedPane1 = new JTabbedPane();
				//tabbedPane = new JTabbedPane();
		        JComponent panel11 =makeChangeTextPanelLine() ;
		        tabbedPane1.addTab("Line", panel11);
		        tabbedPane1.setMnemonicAt(0, KeyEvent.VK_1);
		         
		        JComponent panel22 = makeChangeTextPanelCircle();
		        tabbedPane1.addTab("Circle", panel22);
		        tabbedPane1.setMnemonicAt(1, KeyEvent.VK_2);
		         
		        JComponent panel33 = makeChangeTextPanelRect();
		        tabbedPane1.addTab("Rectangle", panel33);
		        tabbedPane1.setMnemonicAt(2, KeyEvent.VK_3);
		         
		        JComponent panel44 = makeChangeTextPanelPentagon();
		        tabbedPane1.addTab("Pentagon", panel44);
		        tabbedPane1.setMnemonicAt(3, KeyEvent.VK_4);
		        
		        JComponent panel55 = makeChangeTextPanelOctagon();
		        tabbedPane1.addTab("Octagon", panel55);
		         
		        tabbedPane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
	         
	         
	         
	         jdialog1.add(tabbedPane1); 
	
	         
	         /*change button code ends*/
	         
	         //event handling for cancel button
	         change.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						
						jdialog.setLocationRelativeTo(tabbedPane);
						jdialog.setVisible(true);
						jdialog.pack();
						
						tabbedPane.setSelectedIndex(jlistIndex);
						
						tabbedPane.addChangeListener(new ChangeListener() {
							
							@Override
							public void stateChanged(ChangeEvent e) {
								// TODO Auto-generated method stub
								selected_tab = tabbedPane.getSelectedIndex();
								System.out.println(selected_tab);
							}
						});
						
						
					}
				});
	         
	         
	         
	         frame.add(jpanel);
	         
	        
	        
	}
	
	
	/*Change button start*/
	//This method makes the panel used inside the Circle tab
		protected static JComponent makeChangeTextPanelCircle() {
	        JPanel panel = new JPanel(false);
	       // JLabel filler = new JLabel(text);
	        //filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new FlowLayout());
	        
	       // panel.add(filler);
	        
	        JLabel xlabel= new JLabel("Center x: ");
	        final JTextField cxtext= new JTextField(6);
	        cxtext.setText(circle.getCx());
	        JLabel ylabel= new JLabel("Center y: ");
	        final JTextField cytext= new JTextField(6);
	        cytext.setText(circle.getCy());
	        JLabel radiuslabel= new JLabel("Radius: ");
	        final JTextField cradiustext= new JTextField(6);
	        cradiustext.setText(circle.getRadius());
	        
	        panel.add(xlabel);
	        panel.add(cxtext);
	        panel.add(ylabel);
	        panel.add(cytext);
	        panel.add(radiuslabel);
	        panel.add(cradiustext);
	        
	        getComboBox(panel);
	        
	        
	        return panel;
	    }

		//This method makes the panel used inside the Pentagon tab
		protected static JComponent makeChangeTextPanelPentagon() {
	        JPanel panel = new JPanel(false);
	       // JLabel filler = new JLabel(text);
	        //filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new FlowLayout());
	        
	        JLabel xlabel= new JLabel("Center x: ");
	        final JTextField pxtext= new JTextField(6);
	        pxtext.setText(pentagon.getPx());
	        JLabel ylabel= new JLabel("Center y: ");
	        final JTextField pytext= new JTextField(6);
	        pytext.setText(pentagon.getPy());
	        JLabel radiuslabel= new JLabel("Radius: ");
	        final JTextField pradiustext= new JTextField(6);
	        pradiustext.setText(pentagon.getPc());
	        
	       	panel.add(xlabel);
	        panel.add(pxtext);
	        panel.add(ylabel);
	        panel.add(pytext);
	        panel.add(radiuslabel);
	        panel.add(pradiustext);
	        
	        getComboBox(panel);
	        
	        
	        return panel;
	    }

		//This method makes the panel used inside the Octagon tab
		protected static JComponent makeChangeTextPanelOctagon() {
	        JPanel panel = new JPanel(false);
	       // JLabel filler = new JLabel(text);
	        //filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new FlowLayout());
	        
	       // panel.add(filler);
	        
	        JLabel xlabel= new JLabel("Center x: ");
	        final JTextField oxtext= new JTextField(6);
	        oxtext.setText(octagon.getOx());
	        JLabel ylabel= new JLabel("Center y: ");
	        final JTextField oytext= new JTextField(6);
	        oytext.setText(octagon.getOy());
	        JLabel radiuslabel= new JLabel("Radius: ");
	        final JTextField oradiustext= new JTextField(6);
	        oradiustext.setText(octagon.getOc());
	        
	        panel.add(xlabel);
	        panel.add(oxtext);
	        panel.add(ylabel);
	        panel.add(oytext);
	        panel.add(radiuslabel);
	        panel.add(oradiustext);
	        
	        getComboBox(panel);
	        
	        
	        return panel;
	    }

		
		//This method makes the panel used inside the Line tab
		 protected static JComponent makeChangeTextPanelLine() {
		        JPanel panel = new JPanel(false);
		       // JLabel filler = new JLabel(text);
		        //filler.setHorizontalAlignment(JLabel.CENTER);
		        panel.setLayout(new FlowLayout());
		        
		       // panel.add(filler);
		        
		        JLabel x1label= new JLabel("x1: ");
		        x1text= new JTextField(6);
		        x1text.setText(line.getX1());
		        
		        JLabel y1label= new JLabel("y1: ");
		        y1text= new JTextField(6);
		        y1text.setText(line.getY1());
		        JLabel x2label= new JLabel("x2: ");
		        x2text= new JTextField(6);
		        x2text.setText(line.getX2());
		        JLabel y2label= new JLabel("y2: ");
		        y2text= new JTextField(6);
		        y2text.setText(line.getY2());
		        
		       
		        panel.add(x1label);
		        panel.add(x1text);
		        panel.add(y1label);
		        panel.add(y1text);
		        panel.add(x2label);
		        panel.add(x2text);
		        panel.add(y2label);
		        panel.add(y2text);
		        
		        getComboBox(panel);
		        
		        
		        return panel;
		    }
		 
		 

			//This method makes the panel used inside the Rectangle tab
		 protected static JComponent makeChangeTextPanelRect() {
		        JPanel panel = new JPanel(false);
		       // JLabel filler = new JLabel(text);
		        //filler.setHorizontalAlignment(JLabel.CENTER);
		        panel.setLayout(new FlowLayout());
		        
		       // panel.add(filler);
		        
		        JLabel rx1label= new JLabel("x: ");
		       final JTextField rx1text= new JTextField(6);
		       rx1text.setText(rectangle.getX());
		        JLabel ry1label= new JLabel("y: ");
		        final JTextField ry1text= new JTextField(6);
		        ry1text.setText(rectangle.getY());
		        JLabel rx2label= new JLabel("Width: ");
		        final JTextField rx2text= new JTextField(6);
		        rx2text.setText(rectangle.getW());
		        JLabel ry2label= new JLabel("Height: ");
		        final JTextField ry2text= new JTextField(6);
		        ry2text.setText(rectangle.getH());
		        
		        
		        panel.add(rx1label);
		        panel.add(rx1text);
		        panel.add(ry1label);
		        panel.add(ry1text);
		        panel.add(rx2label);
		        panel.add(rx2text);
		        panel.add(ry2label);
		        panel.add(ry2text);
		        
		        getComboBox(panel);
		        
		        
		        return panel;
		    }

	/*change button stop*/
		
		
		
		
	private static int setEventforTab(JTabbedPane tabbedPane){
		 int selected_tab = tabbedPane.getSelectedIndex();
		 switch (selected_tab){
		 case 0: //Line
			 break;
		 case 1://Circle
			 break;
		 case 2: //Rectangle
			 break;
		 case 3://pentagon
			 break;
		 default:
			 //octagon
			 break;
			 
		 }
		return selected_tab;
	 }
	
	private static Object setEventforComboBox(JComboBox<String> comboBox){
		 comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//comboBox.getSelectedItem();
				
			}
		});
		return comboBox.getSelectedItem();
	 }
	
	
	//This method makes the panel used inside the Circle tab
	protected static JComponent makeTextPanelCircle() {
        JPanel panel = new JPanel(false);
       // JLabel filler = new JLabel(text);
        //filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new FlowLayout());
        
       // panel.add(filler);
        
        JLabel xlabel= new JLabel("Center x: ");
        final JTextField cxtext= new JTextField(6);
        
        JLabel ylabel= new JLabel("Center y: ");
        final JTextField cytext= new JTextField(6);
        
        JLabel radiuslabel= new JLabel("Radius: ");
        final JTextField cradiustext= new JTextField(6);
       
        cxtext.getDocument().addDocumentListener(new DocumentListener(){
        		
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				circle.setCx(cxtext.getText());
				System.out.println("CX value"+ cxtext.getText());
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        cytext.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				circle.setCy(cytext.getText());
				System.out.println("CY value"+ cytext.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
       cradiustext.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				circle.setRadius(cradiustext.getText());
				System.out.println("radius value"+ cradiustext.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        panel.add(xlabel);
        panel.add(cxtext);
        panel.add(ylabel);
        panel.add(cytext);
        panel.add(radiuslabel);
        panel.add(cradiustext);
        
        getComboBox(panel);
        
        
        return panel;
    }
	
	//This method makes the panel used inside the Pentagon tab
	protected static JComponent makeTextPanelPentagon() {
        JPanel panel = new JPanel(false);
       // JLabel filler = new JLabel(text);
        //filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new FlowLayout());
        
       // panel.add(filler);
        
        JLabel xlabel= new JLabel("Center x: ");
        final JTextField pxtext= new JTextField(6);
        JLabel ylabel= new JLabel("Center y: ");
        final JTextField pytext= new JTextField(6);
        JLabel radiuslabel= new JLabel("Radius: ");
        final JTextField pradiustext= new JTextField(6);
        
        pxtext.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				pentagon.setPx(pxtext.getText());
				System.out.println("CX value"+ pxtext.getText());
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        pytext.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				pentagon.setPy(pytext.getText());
				System.out.println("CY value"+ pytext.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
       pradiustext.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				pentagon.setPc(pradiustext.getText());
				System.out.println("radius value"+ pradiustext.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        panel.add(xlabel);
        panel.add(pxtext);
        panel.add(ylabel);
        panel.add(pytext);
        panel.add(radiuslabel);
        panel.add(pradiustext);
        
        getComboBox(panel);
        
        
        return panel;
    }

	//This method makes the panel used inside the Octagon tab
	protected static JComponent makeTextPanelOctagon() {
        JPanel panel = new JPanel(false);
       // JLabel filler = new JLabel(text);
        //filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new FlowLayout());
        
       // panel.add(filler);
        
        JLabel xlabel= new JLabel("Center x: ");
        final JTextField oxtext= new JTextField(6);
        JLabel ylabel= new JLabel("Center y: ");
        final JTextField oytext= new JTextField(6);
        JLabel radiuslabel= new JLabel("Radius: ");
        final JTextField oradiustext= new JTextField(6);
        
        oxtext.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				octagon.setOx(oxtext.getText());
				System.out.println("CX value"+ oxtext.getText());
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        oytext.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				octagon.setOy(oytext.getText());
				System.out.println("CY value"+ oytext.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
       oradiustext.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				octagon.setOc(oradiustext.getText());
				System.out.println("radius value"+ oradiustext.getText());
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        panel.add(xlabel);
        panel.add(oxtext);
        panel.add(ylabel);
        panel.add(oytext);
        panel.add(radiuslabel);
        panel.add(oradiustext);
        
        getComboBox(panel);
        
        
        return panel;
    }

	
	//This method makes the panel used inside the Line tab
	 protected static JComponent makeTextPanelLine() {
	        JPanel panel = new JPanel(false);
	       // JLabel filler = new JLabel(text);
	        //filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new FlowLayout());
	        
	       // panel.add(filler);
	        
	        JLabel x1label= new JLabel("x1: ");
	        final JTextField lx1text= new JTextField(6);
	        JLabel y1label= new JLabel("y1: ");
	        final JTextField ly1text= new JTextField(6);
	        JLabel x2label= new JLabel("x2: ");
	        final JTextField lx2text= new JTextField(6);
	        JLabel y2label= new JLabel("y2: ");
	        final JTextField ly2text= new JTextField(6);
	        
	        lx1text.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					line.setX1(lx1text.getText());
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	        ly1text.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					line.setY1(ly1text.getText());
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	        lx2text.getDocument().addDocumentListener(new DocumentListener() {
	
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		line.setX2(lx2text.getText());
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
});
	        ly2text.getDocument().addDocumentListener(new DocumentListener() {
	
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		line.setY2(ly2text.getText());
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
});
	     
	        panel.add(x1label);
	        panel.add(lx1text);
	        panel.add(y1label);
	        panel.add(ly1text);
	        panel.add(x2label);
	        panel.add(lx2text);
	        panel.add(y2label);
	        panel.add(ly2text);
	        
	        getComboBox(panel);
	        
	        
	        return panel;
	    }
	 
	 

		//This method makes the panel used inside the Rectangle tab
	 protected static JComponent makeTextPanelRect() {
	        JPanel panel = new JPanel(false);
	       // JLabel filler = new JLabel(text);
	        //filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new FlowLayout());
	        
	       // panel.add(filler);
	        
	        JLabel rx1label= new JLabel("x: ");
	       final JTextField rx1text= new JTextField(6);
	        JLabel ry1label= new JLabel("y: ");
	        final JTextField ry1text= new JTextField(6);
	        JLabel rx2label= new JLabel("Width: ");
	        final JTextField rx2text= new JTextField(6);
	        JLabel ry2label= new JLabel("Height: ");
	        final JTextField ry2text= new JTextField(6);
	        
	        rx1text.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					rectangle.setX(rx1text.getText());
					System.out.println("RX:"+rx1text.getText());
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	        
	        ry1text.getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					rectangle.setY(ry1text.getText());
					System.out.println("RY:"+ry1text.getText());
				}
				
				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
	        
	        rx2text.getDocument().addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			rectangle.setW(rx2text.getText());
			System.out.println("W:"+rx2text.getText());
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	        ry2text.getDocument().addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			rectangle.setH(ry2text.getText());
			System.out.println("H:"+ry2text.getText());
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	        
	        
	        
	        panel.add(rx1label);
	        panel.add(rx1text);
	        panel.add(ry1label);
	        panel.add(ry1text);
	        panel.add(rx2label);
	        panel.add(rx2text);
	        panel.add(ry2label);
	        panel.add(ry2text);
	        
	        getComboBox(panel);
	        
	        
	        return panel;
	    }
	 
	 protected static JComponent makeTextPanel() {
	        JPanel panel = new JPanel(false);
	       // JLabel filler = new JLabel(text);
	        //filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new FlowLayout());
	        
	       // panel.add(filler);
	        
	        
	        getComboBox(panel);
	        
	        return panel;
	    }
	
	 //method to generate combo boxes in panel
	 protected static  void getComboBox(JPanel panel) {
		 JLabel filllabel= new JLabel("Select Stroke Color: ");
	        
	        JComboBox<String> fillcombobox= new JComboBox();
	        fillcombobox.addItem("None");
	        fillcombobox.addItem("Cyan");
	        fillcombobox.addItem("Magenta");
	        fillcombobox.addItem("Pink");
	        fillcombobox.addItem("Orange");
	        fillcombobox.addItem("Grey");
	        setEventforComboBox(fillcombobox);
	        
	       fillcombobox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fillColor=String.valueOf(fillcombobox.getSelectedItem());
				 System.out.println("get fill selected item"+fillcombobox.getSelectedItem());
			}
		}); 
	        
	       
	       
	        JLabel strokelabel= new JLabel("Select Fill Color: ");
	        
	        
	        JComboBox<String> strokecombobox= new JComboBox();
	        strokecombobox.addItem("None");
	        strokecombobox.addItem("Cyan");
	        strokecombobox.addItem("Magenta");
	        strokecombobox.addItem("Pink");
	        strokecombobox.addItem("Orange");
	        strokecombobox.addItem("Grey");
	        setEventforComboBox(strokecombobox);
	        
	        
	        strokecombobox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					strokeColor=String.valueOf(strokecombobox.getSelectedItem());
					System.out.println("get stroke selected item"+strokecombobox.getSelectedItem());
				}
			});
	       /* JButton ok= new JButton("OK");
	        JButton cancel=new JButton("Cancel");*/
	        
	        panel.add(strokelabel);
	        panel.add(strokecombobox);
	        panel.add(filllabel);
	        panel.add(fillcombobox);
	       /* panel.add(ok);
	        panel.add(cancel);*/
	 }	
		
	

}
