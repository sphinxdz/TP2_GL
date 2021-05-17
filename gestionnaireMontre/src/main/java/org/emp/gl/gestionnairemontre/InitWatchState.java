
package org.emp.gl.gestionnairemontre;


public class InitWatchState extends WatchState{
    
    public InitWatchState(MyWatch mw)  {
        super(mw);
    }
      
    @Override
    public void config()
    {
        watch.setState( new SecondWatchState(watch));


    }
    
}
