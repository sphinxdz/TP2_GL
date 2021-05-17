
package org.emp.gl.timer.service;


public interface TimeChangeProvider {
    public void addTimeChangeListener(TimerChangeListener pl);
    public void removeTimeChangeListener(TimerChangeListener pl);
}
