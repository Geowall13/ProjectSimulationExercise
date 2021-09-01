import java.util.Map;

public class State{
    private String name;
    private double receivedPoints;
    private double workPoints;
    private Map<State, Double> output;

    public State(String name, double workPoints){
        this.name = name;
        this.workPoints = workPoints;
    }

    public String getName(){
        return name;
    }

    public double getWorkPoints(){
        return workPoints;
    }

    public void receievePoints(double receivedWorkPoints){
        receivedPoints += receivedWorkPoints;
    }
    
    public Map getOutput(){
        return output;
    }

    public void setOutput(Map output){
        this.output = output;
    }

    public void sendWork(){
        for (State s : output.keySet()) {
            System.out.println("Workpoitns: " + workPoints);
            System.out.println("output: " + output.get(s));

            s.receievePoints(workPoints * output.get(s));
        }
    }

    public void movePoints(){
        workPoints = receivedPoints;
    }
}