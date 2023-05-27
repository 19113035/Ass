import mpi.MPI;
import mpi.MPIException;
public class DistributedSum {
public static void main(String[] args) throws MPIException {
MPI.Init(args);
int rank = MPI.COMM_WORLD.Rank(); // get the rank of the current process
int size = MPI.COMM_WORLD.Size(); // get the total number of processes
int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // sample input array
int n = array.length; // total number of elements
int local_n = n / size; // number of elements to be processed by each process
int remainder = n % size; // number of remaining elements
int[] local_array = new int[local_n + (rank < remainder ? 1 :
0)]; // local array to hold the elements for each process
int offset = rank * local_n + Math.min(rank, remainder); // compute the offset for the current process
for (int i = 0; i < local_array.length; i++) {
local_array[i] = array[offset + i];
}
int local_sum = 0; // compute the sum of the local elements
for (int i = 0; i < local_array.length; i++) {
local_sum += local_array[i];
}
int[] global_sums = new int[size]; // array to hold the global sum from each process
MPI.COMM_WORLD.Allgather(new int[] { local_sum }, 0, 1,
MPI.INT, global_sums, 0, 1, MPI.INT); // gather the local sums to all processes
// print the intermediate and final sums
if (rank == 0) {
System.out.println("Number of Processes Entered: " +
size);
System.out.println("\nIntermediate Sums:");
int sum = 0;
for (int i = 0; i < size; i++) {
sum += global_sums[i];
System.out.println("Process " + i + ": " +
global_sums[i]);
}
System.out.println("Total Sum: " + sum);
}
MPI.Finalize();
}
}