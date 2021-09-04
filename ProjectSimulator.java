import java.util.*;

public class ProjectSimulator{
    private List<State> states = new ArrayList<>();
    private float finishCriteria;
    private int finishStateIndex;

    public void run(){
        int iterations = 0;

        while(states.get(finishStateIndex).getWorkPoints() < finishCriteria){
            sendPoint();
            iterations++;
        }
        System.out.println("We had " + iterations + " iterations, before the project was finished");
    }

    public void addState(String name){
        states.add(new State(name, 0.0f));
    }

    public void createMapping(int output, int input, float ratio){
        State outputState = states.get(output);
        State inputState = states.get(input);
        outputState.setOutput(inputState, ratio);
    }

    public void setFinishCriteria(float finishCriteria){
        this.finishCriteria = finishCriteria;
    }

    public void setStartState(int startStateIndex){
        states.get(startStateIndex).setWorkPoints(1.0f);
    }

    public void setFinalState(int finalStateIndex){
        this.finishStateIndex = finalStateIndex;
    }

    public void sendPoint(){
        for (State s : states) {
            s.sendWork();
        }
        for (State s : states) {
            s.movePoints();
        }
    }

    public static void main(String[] args){
        ProjectSimulator sim = new ProjectSimulator();
        Scanner userInput = new Scanner(System.in);

        while(true){
            System.out.println("Input: 1 to add new state\n" +
            "2 to create mapping\n" +
            "3 to input finish criteria\n" +
            "4 to input start state\n" +
            "5 to input final state\n" +
            "6 to run");
            switch(userInput.nextLine()){
                case "1":
                    System.out.println("Input state name");
                    sim.addState(userInput.nextLine());
                    break;
                case "2":
                    System.out.println("Input state index to output from");
                    int output = Integer.parseInt(userInput.nextLine());
                    System.out.println("Input state index to input to");
                    int input = Integer.parseInt(userInput.nextLine());
                    System.out.println("Input ratio of points to move");
                    String ratioString = userInput.nextLine();
                    float ratio = Float.parseFloat(ratioString);
                    sim.createMapping(output, input, ratio);
                    break;
                case "3":
                    System.out.println("Input amount before project is considered done");
                    String finishString = userInput.nextLine();
                    sim.setFinishCriteria(Float.parseFloat(finishString));
                    break;
                case "4":
                    System.out.println("Input index of start state");
                    sim.setStartState(Integer.parseInt(userInput.nextLine()));
                    break;
                case "5":
                    System.out.println("Input index of final state");
                    sim.setFinalState(Integer.parseInt(userInput.nextLine()));
                    break;
                case "6":
                    sim.run();
                    userInput.close();
                    return;
                case "exit":
                    userInput.close();
                    return;
                default:
                    System.out.println("Did not understand input");
            }
        }
    }
}