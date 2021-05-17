
package org.emp.gl.gestionnairemontre;


public class MinuteWatchState extends WatchState{
 
    public MinuteWatchState(MyWatch mw) {
        super(mw);
    }
  
    @Override
    public void mode()
    {
        watch.setState( new HourWatchState(watch));
    }

    @Override
    public void config() {
        watch.setState( new InitWatchState(watch));

    }
    
    
}
