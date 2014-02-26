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
    Frame f = new Frame ("Elektro-Rechner");
    
    // Einbindung der Funktion zum Schließen des Fensters
    f.addWindowListener (new WindowLauscher());
    
    // Menü einbinden
    f.setMenuBar (this.getMenuBar ());
    
    // Fenstergröße bestimmen
    f.setSize (500,500);
    
    f.setBackground(dunkelgruen);
    // Sichtbarkeit einstellen
    f.setVisible(true);         
  }                                      
  
  // Menubar bearbeiten
  public MenuBar getMenuBar ()
  {
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
    MenuItem Beenden = new MenuItem ("Beenden");
    Startseite.addActionListener(new ActionLauscher());
    Beenden.addActionListener(new ActionLauscher());
    
    
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
    Kondensatoren.addActionListener(new ActionLauscher());
    Grundlagen.add(Kondensatoren);
    
    MenuItem Spannungsteiler = new MenuItem ("Spannungsteiler");
    Spannungsteiler.addActionListener(new ActionLauscher());
    Grundlagen.add(Spannungsteiler);
    
    MenuItem Astabil = new MenuItem("Astabil");
    Astabil.addActionListener(new ActionLauscher());
    Ne555.add(Astabil);
    
    MenuItem Monostabil = new MenuItem("Monostabil");
    Monostabil.addActionListener(new ActionLauscher());
    Ne555.add(Monostabil);
    
    menueLeiste.add(SCHALTUNGEN);
    
    
    //--------------------------------------------------------------------------
    Menu INFO = new Menu ("Informationen");
    //--------------------------------------------------------------------------
    
    Menu Version = new Menu ("Version");
    MenuItem Kontakt = new MenuItem ("Kontakt");
    
    INFO.add(Version);
    INFO.add(Kontakt);
    
    Version.addSeparator();
    Version.add ("v 1.0");
    Version.addSeparator();
    
    menueLeiste.add(INFO);
    
    
    
    
    
    
    
    //--------------------------------------------------------------------------
    
    /*
    //--------------------------------------------------------------------------
    // Aktionen zu den jeweiligen Feldern
    //--------------------------------------------------------------------------
    
    Startseite.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {    
    
    System.out.println("Willkommen beim Elektro-Rechner");
    }
    }
    );
    
    Beenden.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {  
    
    System.out.println("Beenden");
    System.exit(0);
    }
    }
    );
    
    Kondensatoren.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {  
    
    System.out.println("Seite: Kondensatoren");
    }
    }
    );      
    
    Spannungsteiler.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {  
    
    System.out.println("Seite: Spannungsteiler");
    }
    }
    );
    
    Ne555.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {  
    
    System.out.println("Seite: NE555");
    }
    }
    );
    
    Kontakt.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {  
    
    System.out.println("Seite: Kontakt");
    }
    }
    );
    //--------------------------------------------------------------------------
    */
    return menueLeiste; 
  }
  
  
  
  // Aktionen auf Menübefehle
  class ActionLauscher implements ActionListener
  {
    public void actionPerformed( ActionEvent e )
    { 
      String action = e.getActionCommand();  
      if (action=="Startseite") 
      {
        i=1;
      }
      if (action=="Beenden") 
      {
        i=2;
      } 
      
      Graphics g = getGraphics();
      
      if(i==1)
      {   
          
        g.setColor(Color.black);
        g.fillRect(100,200,200,200);
        g.drawString("Willkommen beim Elektro-Rechner",120,50); 
      }
      if (i==2) 
      {
        System.exit(0);
      }
    }
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
