 
class node { 
    int distance = 0;

    // true if track has been accessed
    boolean accessed = false;
}
 
public class SSTFAlgorithm {
     
    public static void calculateDifference(int queue[],int head, node diffrence[])                              
    {
        for (int i = 0; i < diffrence.length; i++)
            diffrence[i].distance = Math.abs(queue[i] - head);
    }
 
    public static int findMinimum(node diffrence[])
    {
        int index = -1, minimum = Integer.MAX_VALUE;
 
        for (int i = 0; i < diffrence.length; i++) {
            if (!diffrence[i].accessed && minimum > diffrence[i].distance) {
                 
                minimum = diffrence[i].distance;
                index = i;
            }
        }
        return index;
    }
 
    public static void shortestSeekTimeFirst(int request[],int head)
                                                      
    {
        if (request.length == 0)
            return;
             
        // create array of objects of class node   
        node diff[] = new node[request.length];
         
        // initialize array
        for (int i = 0; i < diff.length; i++)
         
            diff[i] = new node();
         
   
        int seek_count = 0;
         
        // stores sequence that done
        int[] seek_sequence = new int[request.length + 1];
         
        for (int i = 0; i < request.length; i++) {
             
            seek_sequence[i] = head;
            calculateDifference(request, head, diff);
             
            int index = findMinimum(diff);
             
            diff[index].accessed = true;
             
  
            seek_count += diff[index].distance;
             
             
            head = request[index];
        }
         
        // for last accessed track
        seek_sequence[seek_sequence.length - 1] = head;
         
        System.out.println("All Seek Operations are      > "+ seek_count + " Operation");
                                                      
        System.out.print("Seek Sequence of the Head is > ");
        for (int i = 0; i < seek_sequence.length; i++)
            System.out.print(seek_sequence[i] + " , " );
        System.out.println("" );
        System.out.println("Finish" );
    }
 
    public static void main(String[] args)
    {
        //operations 
        int arr[] = { 300, 40, 120, 50, 44, 9, 8, 120 };
        int head = 90 ;
        
        System.out.println("Initial position of head is  > " + head);
        shortestSeekTimeFirst(arr, head);
    }
}