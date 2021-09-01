import java.util.*;


public class ProjectSimulator{
    public void run(){
        List<State> states = new ArrayList<>();

        State state1 = new State("Communication", 1.0);
        State state2 = new State("Planning1", 0.0);
        State state3 = new State("Planning2", 0.0);
        State state4 = new State("Deployed", 0.0);

        states.add(state1);
        states.add(state2);
        states.add(state3);
        states.add(state4);

        Map<State, Double> fromCommunication = new HashMap<>();
        fromCommunication.put(state2, 1.0);
        state1.setOutput(fromCommunication);

        Map<State, Double> fromPlanning1 = new HashMap<>();
        fromPlanning1.put(state3, 1.0);
        state2.setOutput(fromPlanning1);

        Map<State, Double> fromPlanning2 = new HashMap<>();
        fromPlanning2.put(state1, 0.2);
        fromPlanning2.put(state4, 0.8);
        state3.setOutput(fromPlanning2);

        Map<State, Double> fromDeployed = new HashMap<>();
        fromDeployed.put(state4, 1.0);
        state4.setOutput(fromDeployed);

        int iterations = 0;

        while(state4.getWorkPoints() < 0.9){
            for (State s : states) {
                s.sendWork();
            }
            for (State s : states) {
                s.movePoints();
            }
            iterations++;
            System.out.println(state4.getWorkPoints());
        }
        System.out.println("We had " + iterations + " iterations, before the project was finished");
    }

    public static void main(String[] args){
        ProjectSimulator sim = new ProjectSimulator();
        sim.run();
    }
}