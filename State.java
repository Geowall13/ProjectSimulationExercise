import java.util.HashMap;
import java.util.Map;

public class State{
    private String name;
    private float receivedPoints;
    private float workPoints;
    private Map<State, Float> output = new HashMap<>();

    public State(String name, float workPoints){
        this.name = name;
        this.workPoints = workPoints;
    }

    public String getName(){
        return name;
    }

    public float getWorkPoints(){
        return workPoints;
    }

    public void setWorkPoints(float workPoints){
        this.workPoints = workPoints;
    }

    public void receievePoints(float receivedWorkPoints){
        receivedPoints += receivedWorkPoints;
    }
    
    public Map getOutput(){
        return output;
    }

    public void setOutput(State input, float ratio){
        this.output.put(input, ratio);
    }

    public void sendWork(){
        for (State s : output.keySet()) {
            System.out.println("Workpoints: " + workPoints);
            System.out.println("output: " + output.get(s));

            s.receievePoints(workPoints * output.get(s));
        }
    }

    public void movePoints(){
        workPoints = receivedPoints;
    }
}