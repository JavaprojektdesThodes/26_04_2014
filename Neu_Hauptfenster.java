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
  int i=1;        // Variable zur Buttonfunktion (welcher Button wurde betaetigt)
  int Auswahl = 1;
  
  //--------------------------------------------------------------------------
  // Farben definieren ( R G B )
  //--------------------------------------------------------------------------
  Color dunkelgruen = new Color(0x22,0xDD,0x88);
  //--------------------------------------------------------------------------
  
  //----------------------------------------------------------------------------
  // Schriftarten definieren
  //----------------------------------------------------------------------------
  Font Ueberschrift = new Font("Arial", Font.BOLD, 16);
  Font Normal = new Font("Arial", Font.PLAIN, 12);
  //----------------------------------------------------------------------------
  
  public Hauptfenster()
  {        
    
    
    
    //--------------------------------------------------------------------------
    // Fenster-Einstellungen
    //--------------------------------------------------------------------------
    // Fenstertitel vergeben
    setTitle("Elektro-Rechner");
    
    // Einbindung der Funktion zum Schließen des Fensters
    addWindowListener (new WindowLauscher());
    
    // Fenstergröße bestimmen
    setSize (600,600);
    
    setBackground(dunkelgruen);
    
    // Sichtbarkeit einstellen
    setResizable(false);
    setVisible(true);  
    //--------------------------------------------------------------------------       
    
    
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
        Graphics g = getGraphics();
        g.setColor(Color.black);
        g.fillRoundRect(49,69,502,512,30,30);
        g.setColor(Color.white);
        g.fillRoundRect(50,70,500,510,30,30);
        g.setColor(Color.black);
        
        g.setFont(Ueberschrift);
        
        g.drawString("Elektro-Rechner",230,100);
        
        g.setFont(Normal);
        
        g.drawString("Dies ist ein schwules Homo-Javaprojekt des Thodes",60,130);
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
          public void paint(Graphics g) {
            g.setFont(new Font("Arial", Font.PLAIN, 15));
            g.setColor(Color.BLACK);
            g.drawString("Im Menü Figur kann die Zeichenfigur festgelegt", 10, 40);
            g.drawString("werden. Im Menü Zeichnen kann eine neue", 10, 60);
            g.drawString("Zeichenfigur gezeichnet oder der Zeichen-", 10, 80);
            g.drawString("bereich gelöscht werden. Im Menü Optionen", 10, 100);
            g.drawString("kann diese Hilfe angezeigt werden.", 10, 120);
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
