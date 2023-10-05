import java.util.ArrayList;
import java.util.List;

public class WorkerDistribution {
    private int numWorkers;
    private int numJobs;
    private List<List<Integer>> adjacencyList;

    public WorkerDistribution(int numWorkers, int numJobs) {
        this.numWorkers = numWorkers;
        this.numJobs = numJobs;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i <=numWorkers; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int worker, int job){
        adjacencyList.get(worker).add(job);
    }

    public void distributeWorkers(){
        boolean[] visited= new boolean[numWorkers +1];
        int [] jobAssigned =new int[numJobs + 1];
        int maxWorkers = 0;

        // Начиная с каждого работника, обходим всех работников,
        // чтобы найти максимальное количество занятых работников
        for (int worker = 1; worker <= numWorkers ; worker++) {
            if (!visited[worker]) {
                maxWorkers +=dfs(worker, visited, jobAssigned);
            }
        }
        System.out.println("Максимальное количество занятых работников: " + maxWorkers);
    }

    private int dfs(int worker, boolean[] visited, int[] jobAssigned) {
        visited[worker] = true;
        for (int job:adjacencyList.get(worker)) {
            if (jobAssigned[job] ==0){
               jobAssigned[job] = worker;
               return 1;
            }
        }
        for (int job:adjacencyList.get(worker)) {
            if (!visited[jobAssigned[job]]){
                if (dfs(jobAssigned[job], visited, jobAssigned) == 1) {
                    jobAssigned[job] = worker;
                    return 1;
                }
            }
        }
        return 0;
    }
}
