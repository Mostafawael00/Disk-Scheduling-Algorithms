 
import java.util.*;
 
class GFG{
     
static int size = 8;
static int disk_size = 200;
 
public static void LOOKAlgorithm(int arr[], int head, String direction)
{
    int seek_count = 0;
    int distance, cur_track;
     
    Vector<Integer> left = new Vector<Integer>();
    Vector<Integer> right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();
   
    // for loop to know what values are in the left of the head and what in the right
    for(int i = 0; i < size; i++)
    {
        if (arr[i] < head)
            left.add(arr[i]);
        if (arr[i] > head)
            right.add(arr[i]);
    } 
   
    // Sorting left and right arrays
    Collections.sort(left); 
    Collections.sort(right); 
     
  
     //scan the right array and the left array
    int run = 2;
    while (run-- > 0)
    {
        if (direction == "left")
        {
            for(int i = left.size() - 1;
                    i >= 0; i--)
            {
                cur_track = left.get(i);
   
                // Appending current track to
                // seek sequence
                seek_sequence.add(cur_track);
   
                // Calculate  distance
                distance = Math.abs(cur_track - head);

                seek_count += distance;
   
                head = cur_track;
            }
             
            // Reversing the direction
            direction = "right";
        }
        else if (direction == "right")
        {
            for(int i = 0; i < right.size(); i++)
            {
                cur_track = right.get(i);
                 
           
                seek_sequence.add(cur_track);
   
                // Calculate  distance
                distance = Math.abs(cur_track - head);
   
                // Increase the total count
                seek_count += distance;
   
                head = cur_track;
            }
             
            // Reversing the direction
            direction = "left";
        }
    }
     
    System.out.println("All seek operations are     > " + seek_count + " Operation");
   
    System.out.print("Seek Sequence is            > ");
   
    for(int i = 0; i < seek_sequence.size(); i++)
    {
        System.out.print(seek_sequence.get(i)+ " ,");
    }
    System.out.println(" " );
    System.out.println("Finish" );
}

public static void main(String[] args) throws Exception
{
     
    // Request array
    int arr[] = { 125, 255, 45, 238, 85, 13, 45, 157 };
    int head = 300;
    String direction = "right";
   
    System.out.println("Initial position of head is > " + head);
   
    LOOKAlgorithm(arr, head, direction);
}

}
 