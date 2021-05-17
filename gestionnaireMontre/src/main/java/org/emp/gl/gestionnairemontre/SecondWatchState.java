
package org.emp.gl.gestionnairemontre;


public class SecondWatchState extends WatchState{
  
  
    public SecondWatchState(MyWatch mw) {
        super(mw);
    }
    
    @Override
    public void mode()
    {
        watch.setState( new MinuteWatchState(watch));
    }
}
