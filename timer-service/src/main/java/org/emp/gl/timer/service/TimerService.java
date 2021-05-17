
package org.emp.gl.timer.service;

public interface TimerService extends TimeChangeProvider {
    int getMinutes();
    int getHeures();
    int getSecondes();
    int getDixiemeDeSeconde();
}
