
package org.emp.gl.gestionnairemontre;

import java.beans.PropertyChangeEvent;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.time.service.impl.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;


public class GuiWatch extends javax.swing.JFrame implements TimerChangeListener{

    int dixiemeDeSec=0;
    int seconde = 0;
    int minute = 0;
    int heure = 0;

    int ajoutHeur=0;
    int ajoutMinute=0;
    int ajoutSeconde=0;

      public GuiWatch() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible( true );
    }
    
    public void timeChanged() {
        TimerServiceImplWithDelegation a =  (TimerServiceImplWithDelegation) Lookup.getInstance().getService(TimerService.class);
        heure = a.getHeures();
        minute = a.getMinutes();
        seconde = a.getSecondes();
        dixiemeDeSec = a.getDixiemeDeSeconde();
        heure = (heure+ajoutHeur)%24;
        minute = (minute+ajoutMinute)%60;
        seconde = (seconde+ajoutSeconde)%60;
        clock.setText(heure + ":" + minute + ":" + seconde  + ":" + dixiemeDeSec);
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        timeChanged();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();
        buttons = new javax.swing.JPanel();
        labelWatch = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/macos/Downloads/Azores Mountain Landscape - Affiche abordable - Photowall_files/azores-mountain-landscape-1.jpg")); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        getContentPane().setLayout(null);

        clock.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        clock.setText("00:00:00");
        getContentPane().add(clock);
        clock.setBounds(530, 290, 190, 86);

        buttons.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(buttons);
        buttons.setBounds(395, 294, 0, 0);

        labelWatch.setLayout(null);
        getContentPane().add(labelWatch);
        labelWatch.setBounds(10, 53, 0, 220);

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/macos/Documents/khbich/Génie Log/tp-gl-1/azores-mountain-landscape-1.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, -70, 1120, 790);

        setBounds(500, 200, 966, 668);
    }// </editor-fold>//GEN-END:initComponents

   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttons;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel labelWatch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

   

  

}
