public class Iteration{
    private String name;
    private double workCount;
    private Map<Iteration, Double> pointers;

    public Student(String name, int workCount, Map<Iteration, Double> pointers){
        this.name = name;
        this.workCount = workCount;
        this.pointers = pointers;
    }

    public String getName(){
        return name;
    }

    public int getWorkCount(){
        return workCount;
    }
    
    public Map getPointers(){
        return pointers;
    }
}