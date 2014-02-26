import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Menues extends Frame {
 	
 	protected CheckboxMenuItem rechteck, oval, gefuellt, ungefuellt;
 	protected Random random = new Random();
 	
 	public Menues() {
  		super("Aufgabe 12.1: Menüs");
  		addWindowListener(
 			new WindowAdapter() {
  				public void windowClosing(WindowEvent event) {
   					event.getWindow().dispose();
  				}
 			}
  		);
  		setSize(640, 480);
  		MenuBar menuBar = new MenuBar();
  		Menu figur = new Menu("Figur");
  		rechteck = new CheckboxMenuItem("Rechteck", true);
  		rechteck.addItemListener(
 			new ItemListener() {
  				public void itemStateChanged(ItemEvent e) {
   					oval.setState(!rechteck.getState());
  				}
 			}
  		);
  		figur.add(rechteck);
  		oval = new CheckboxMenuItem("Oval", false);
  		oval.addItemListener(
 			new ItemListener() {
  				public void itemStateChanged(ItemEvent e) {
   					rechteck.setState(!oval.getState());
  				}
 			}
  		);
  		figur.add(oval);
  		figur.add(new MenuItem("-"));
  		gefuellt = new CheckboxMenuItem("gefüllt", true);
  		gefuellt.addItemListener(
 			new ItemListener() {
  				public void itemStateChanged(ItemEvent event) {
   					ungefuellt.setState(!gefuellt.getState());
  				}
 			}
  		);
  		figur.add(gefuellt);
  		ungefuellt = new CheckboxMenuItem("ungefüllt", false);
  		ungefuellt.addItemListener(
 			new ItemListener() {
  				public void itemStateChanged(ItemEvent event) {
   					gefuellt.setState(!ungefuellt.getState());
  				}
 			}
  		);
  		figur.add(ungefuellt);
  		menuBar.add(figur);
  		Menu aktion = new Menu("Aktion");
  		MenuItem zeichnen = new MenuItem("Zeichnen");
  		zeichnen.addActionListener(
 			new ActionListener() {
  				public void actionPerformed(ActionEvent event) {
   					Graphics graphics = getGraphics();
   					graphics.setColor(
  						new Color(
 							random.nextInt(256),
 							random.nextInt(256),
 							random.nextInt(256)
  						)
   					);
   					Insets insets = getInsets();
   					int x = insets.left + random.nextInt(getWidth() - insets.left - insets.right);
   					int y = insets.top + random.nextInt(getHeight() - insets.top - insets.bottom);
   					int width = random.nextInt(getWidth() - x - insets.right);
   					int height = random.nextInt(getHeight() - y - insets.bottom);
   					if (rechteck.getState())
  						if (gefuellt.getState())
 							graphics.fillRect(x, y, width, height);
  						else
 							graphics.drawRect(x, y, width, height);
   					else
  						if (gefuellt.getState())
 							graphics.fillOval(x, y, width, height);
  						else
 							graphics.drawOval(x, y, width, height);
  				}
 			}
  		);
  		aktion.add(zeichnen);
  		aktion.add(new MenuItem("-"));
  		MenuItem loeschen = new MenuItem("Löschen");
  		loeschen.addActionListener(
 			new ActionListener() {
  				public void actionPerformed(ActionEvent event) {
   					repaint();
  				}
 			}
  		);
  		aktion.add(loeschen);
  		menuBar.add(aktion);
  		Menu optionen = new Menu("Optionen");
  		MenuItem hilfe = new MenuItem("Hilfe");
  		hilfe.addActionListener(
 			new ActionListener() {
  				public void actionPerformed(ActionEvent event) {
   					Frame hilfsFenster = new Frame("Hilfe") {
    						public void paint(Graphics graphics) {
     							graphics.setFont(new Font("Arial", Font.PLAIN, 15));
     							graphics.setColor(Color.BLACK);
     							graphics.drawString("Im Menü Figur kann die Zeichenfigur festgelegt", 10, 40);
     							graphics.drawString("werden. Im Menü Zeichnen kann eine neue", 10, 60);
     							graphics.drawString("Zeichenfigur gezeichnet oder der Zeichen-", 10, 80);
     							graphics.drawString("bereich gelöscht werden. Im Menü Optionen", 10, 100);
     							graphics.drawString("kann diese Hilfe angezeigt werden.", 10, 120);
    						}
   					};
   					hilfsFenster.addWindowListener(
  						new WindowAdapter() {
   							public void windowClosing(WindowEvent event) {
    								event.getWindow().dispose();
   							}
  						}
   					);
   					hilfsFenster.setSize(320, 140);
   					hilfsFenster.setResizable(false);
   					hilfsFenster.setVisible(true);
  				}
 			}
  		);
  		optionen.add(hilfe);
  		menuBar.add(optionen);
  		setMenuBar(menuBar);
 	}
  
 	public static void main(String[] args) {
  		new Menues().setVisible(true);
 	}
  
}
