package org.emp.gl.time.service.impl;

import java.beans.PropertyChangeSupport;
import java.util.Timer;
import java.time.LocalTime;
import java.util.TimerTask;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class TimerServiceImplWithDelegation extends TimerTask implements TimerService {
    
    public int dixiemeDeSeconde;
    public int minutes;
    public int secondes;
    public int heures;
    
    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();
        secondes = LocalTime.now().getSecond();
        minutes = LocalTime.now().getMinute();
        heures = LocalTime.now().getHour();
        dixiemeDeSeconde = LocalTime.now().getNano() / 100000000;
        timer.scheduleAtFixedRate(this, 100, 100);
    }
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
     private void timeChanged() {
        updateDixiemeSeconde();
    }

    @Override
    public void run() {
       timeChanged();
    }

    @Override
    public int getMinutes() {
          return minutes;
    }

    @Override
    public int getHeures() {
          return heures;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    @Override
    public int getDixiemeDeSeconde() {
         return dixiemeDeSeconde;
    }
    
    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
         pcs.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
         pcs.removePropertyChangeListener(pl);
    }
    
     private void updateDixiemeSeconde() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;
        pcs.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, oldValue, dixiemeDeSeconde);
        if (dixiemeDeSeconde == 0) {
            updateSecond();
        }
    }
     
     
    private void updateSecond() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;
        pcs.firePropertyChange(TimerChangeListener.SECONDE_PROP, oldValue, secondes);
        if (secondes == 0) {
            updateMinute();
        }
    }

    private void updateMinute() {
        int oldValue = minutes;
        minutes = (minutes + 1) % 60;
        pcs.firePropertyChange(TimerChangeListener.MINUTE_PROP, oldValue, minutes);
        if (minutes == 0) {
            updateHeure();
        }
    }
       
    private void updateHeure() {
        int oldValue = heures;
        heures = (heures + 1) % 24;
        pcs.firePropertyChange(TimerChangeListener.HEURE_PROP, oldValue, heures);
    }
  
}

