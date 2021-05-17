
package org.emp.gl.gestionnairemontre;


public class HourWatchState extends WatchState{
    
    public HourWatchState(MyWatch mw)  {
        super(mw);
    }
    
    @Override
    public void mode()
    {
        watch.setState( new SecondWatchState(watch));
    }

    @Override
    public void config() {
        watch.setState( new InitWatchState(watch));

    }
    
}
