package usefulresource;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class popupincorrect 
{
    Timer t;
    JLabel wrong;
    public popupincorrect(int second, JLabel w, String s)
    {
        this.wrong = w;
        wrong.setVisible(true);
        wrong.setText(s);
        t = new Timer();
        t.schedule(new rt(), second*1000);
    }

class rt extends TimerTask
{
    @Override
    public void run() {
        t.cancel();
        wrong.setVisible(false);
    }
    
}
}

