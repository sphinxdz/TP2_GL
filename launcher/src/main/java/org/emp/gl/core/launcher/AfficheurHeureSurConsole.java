
package org.emp.gl.core.launcher;

import java.beans.PropertyChangeEvent;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;


public class AfficheurHeureSurConsole implements TimerChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        TimerService ts = Lookup.getInstance().getService(TimerService.class);    
        System.out.println("" + ts.getHeures() + ":" + ts.getMinutes() + ":"
                + ts.getSecondes() + "," + ts.getDixiemeDeSeconde());
    }

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
