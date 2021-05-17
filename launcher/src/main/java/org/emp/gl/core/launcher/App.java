package org.emp.gl.core.launcher;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gestionnairemontre.GuiWatch;
import org.emp.gl.gestionnairemontre.MyWatch;
import org.emp.gl.time.service.impl.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.gestionnairemontre.ActionsGui;
import org.emp.gl.gestionnairemontre.GuiButtons;

public class App {

    public static void main(String[] args) {
        Lookup.getInstance().register(TimerService.class, new TimerServiceImplWithDelegation());
        Lookup.getInstance().register(TimerChangeListener.class, new GuiWatch());
        GuiButtons g  = new GuiButtons();

        TimerService timerService= Lookup.getInstance().getService(TimerService.class);
        TimerChangeListener gui = (TimerChangeListener) Lookup.getInstance().getService(TimerChangeListener.class);
        timerService.addTimeChangeListener(gui);
        Lookup.getInstance().register(ActionsGui.class , new MyWatch()); 
    }

}
