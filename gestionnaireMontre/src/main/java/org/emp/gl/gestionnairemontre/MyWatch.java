
package org.emp.gl.gestionnairemontre;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.time.service.impl.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerChangeListener;


public class MyWatch extends TimerServiceImplWithDelegation implements ActionsGui {
    
    public WatchState etat = new InitWatchState(this);
        
    public void setState(WatchState s) 
    {  
        this.etat=s;
    }
    
    @Override
    public void modeAction() {
       
        etat.mode();
    }

    @Override
     public void incrementAction() {
        GuiWatch fGui = (GuiWatch )Lookup.getInstance().getService(TimerChangeListener.class);
        if(etat.getClass()==HourWatchState.class)
        {
           fGui.ajoutHeur++;
        }
        if(etat.getClass()==MinuteWatchState.class)
        {
           fGui.ajoutMinute++;
        }
        if(etat.getClass()==SecondWatchState.class)
        {
           fGui.ajoutSeconde++;
        }
    }

    @Override
    public void configAction() {
        etat.config();
    }
     
     
     
}
