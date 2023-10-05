import java.util.*;

/*
В распоряжении имеются N работников и M различных типов работ. Разные работники могут выполнять разные
типы работ. Необходимо распределить работников, чтобы максимальное количество из их было занято.
Для решения строим граф
 */

public class Main {
    public static void main(String[] args) {
        int numWorkers = 5; //кол-во работников
        int numJobs = 7;  //кол-во работ

        WorkerDistribution workerDistribution = new WorkerDistribution(numWorkers, numJobs);
        workerDistribution.addEdge(1, 1);
        workerDistribution.addEdge(1, 3);
        workerDistribution.addEdge(2, 4);
        workerDistribution.addEdge(2, 5);
        workerDistribution.addEdge(3, 6);
        workerDistribution.addEdge(4, 7);
        workerDistribution.addEdge(5, 2);

        workerDistribution.distributeWorkers();

    }

}
