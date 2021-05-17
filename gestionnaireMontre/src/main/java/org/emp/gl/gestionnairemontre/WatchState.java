
package org.emp.gl.gestionnairemontre;


public abstract class WatchState {

    final MyWatch watch;
 
    public WatchState( MyWatch mw) {
        this.watch=mw; 
    }
    public void mode(){};
    public void config(){};
    
}

