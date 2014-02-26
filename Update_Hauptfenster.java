//------------------------------------------------------------------------------
// Projekt:     "Elektro-Rechner"                                           
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
// Funktion:    Berechnung elektronischer Bauteile -> Ohm'sches Gesetz, 
//              Vowiderstände für LEDs, Kondensatorladungen, 
//              Bestückungsberechnung für spezielle Bauteile 
//              (z.B. Frequenzberechnung NE555)
//------------------------------------------------------------------------------
// Autoren:     Marcel Kolzau, Sven Oetken, Ben Laurinat
//------------------------------------------------------------------------------
// Datum:       19.02.2014
// Version:     v 1.0
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
// Einbindung der Bibliotheken
//------------------------------------------------------------------------------
import java.awt.*;
import java.awt.event.*;
//------------------------------------------------------------------------------

public class Hauptfenster extends Frame 
{
  //--------------------------------------------------------------------------
  int i=0;        // Variable zur Buttonfunktion (welcher Button wurde betaetigt)
  int Auswahl = 1;
  
  
  public Hauptfenster()
  {        
    //--------------------------------------------------------------------------
    // Farben definieren ( R G B )
    //--------------------------------------------------------------------------
    Color dunkelgruen = new Color(0x22,0xDD,0x88);
    //--------------------------------------------------------------------------
    
    // Fenster anpassen
    
    // Fenstertitel vergeben
    setTitle("Elektro-Rechner");
    
    // Einbindung der Funktion zum Schließen des Fensters
    addWindowListener (new WindowLauscher());
    
    // Menü einbinden
    //setMenuBar (this.getMenuBar ());
    
    // Fenstergröße bestimmen
    setSize (500,500);
    
    setBackground(dunkelgruen);
    // Sichtbarkeit einstellen
    setResizable(false);
    setVisible(true);         
    //}                                      
    
    // Menubar bearbeiten
    //public MenuBar getMenuBar ()
    //{
    //--------------------------------------------------------------------------
    // Anlegen der übergeordneten Menüleiste, auf welcher die Menüelemente 
    // liegen werden
    //--------------------------------------------------------------------------
    MenuBar menueLeiste = new MenuBar ();
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    // Anlegen der Menüelemente
    //--------------------------------------------------------------------------
    
    
    //--------------------------------------------------------------------------
    Menu ELEKTRO_RECHNER = new Menu ("Elektro-Rechner");
    //--------------------------------------------------------------------------
    
    MenuItem Startseite = new MenuItem ("Startseite");
    Startseite.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Graphics graphics = getGraphics();
        graphics.setColor(Color.black);
        graphics.drawOval(100, 200, 80, 80);
      }
    }
    );
    MenuItem Beenden = new MenuItem ("Beenden");
    
    Beenden.addActionListener(
    new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    }
    );
    
    
    ELEKTRO_RECHNER.add(Startseite);
    
    ELEKTRO_RECHNER.addSeparator();
    ELEKTRO_RECHNER.add(Beenden);
    
    menueLeiste.add(ELEKTRO_RECHNER);
    
    
    //--------------------------------------------------------------------------
    Menu SCHALTUNGEN = new Menu ("Schaltungen");
    //--------------------------------------------------------------------------
    
    Menu Grundlagen = new Menu ("Grundlagen");
    
    Menu Ne555 = new Menu ("NE555");
    
    SCHALTUNGEN.add(Grundlagen);    
    SCHALTUNGEN.add(Ne555);
    
    MenuItem Kondensatoren = new MenuItem ("Kondensatoren");
    //Kondensatoren.addActionListener(new ActionLauscher());
    Grundlagen.add(Kondensatoren);
    
    MenuItem Spannungsteiler = new MenuItem ("Spannungsteiler");
    //Spannungsteiler.addActionListener(new ActionLauscher());
    Grundlagen.add(Spannungsteiler);
    
    MenuItem Astabil = new MenuItem("Astabil");
    //Astabil.addActionListener(new ActionLauscher());
    Ne555.add(Astabil);
    
    MenuItem Monostabil = new MenuItem("Monostabil");
    //Monostabil.addActionListener(
    
    
    Ne555.add(Monostabil);
    
    menueLeiste.add(SCHALTUNGEN);
    
    
    //--------------------------------------------------------------------------
    Menu INFO = new Menu ("Informationen");
    //--------------------------------------------------------------------------
    
    Menu Version = new Menu ("Version");
    MenuItem Hilfe = new MenuItem ("Hilfe");
    Hilfe.addActionListener(
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
    
    
    INFO.add(Version);
    INFO.add(Hilfe);
    
    Version.addSeparator();
    Version.add ("v 1.0");
    Version.addSeparator();
    
    menueLeiste.add(INFO);
    
    setMenuBar(menueLeiste);
  }
  
  class WindowLauscher extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
  }
  
  public static void main (String[] args) 
  {
    Hauptfenster H = new Hauptfenster ();   
  }
}
