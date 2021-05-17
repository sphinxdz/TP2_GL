
package org.emp.gl.core.launcher;

import java.beans.PropertyChangeEvent;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;


public class CompteARebour implements TimerChangeListener {

    private int compteArebours;

    public CompteARebour(int compteARebour) {
        this.compteArebours = compteARebour ;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        compteArebours--;
        System.out.println("Il me reste : " + compteArebours);
        if (compteArebours == 0) { // se désabonner du TimerService ! 
            Lookup.getInstance()
                    .getService(TimerService.class)
                    .removeTimeChangeListener(this);
        }
    }

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
