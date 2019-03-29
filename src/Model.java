import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Model contains data and views
 */
public class Model {

    //Data Structure holding data
    ArrayList<String> model;

    //Data Structure holding Views
    ArrayList<ChangeListener> listenerList;

    /**
     * Construct Model
     */
    public Model(){
        model = new ArrayList<>();
        listenerList = new ArrayList<>();
    }

    /**
     * Get a new TextLine
     * @return textLine
     */
    public String getTextFromModel(){
        String textLine = "";
        for(String s : model){

            textLine += s +"\n";
        }
        return textLine;
    }

    /**
     * Add a Change Listener to ArrayList holding Views
     * @param l - Change Listener
     */
    public void addChangeListener(ChangeListener l){
        this.listenerList.add(l);
    }

    /**
     * Add a model to ArrayList of Model and notify observers dataChange
     */
    public void addText(String textLine){
        model.add(textLine);
        ChangeEvent changeEvent = new ChangeEvent(this);
        for(ChangeListener l: listenerList)
        {
            l.stateChanged(changeEvent);
        }
    }
}
