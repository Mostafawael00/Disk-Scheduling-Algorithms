 
class GFG
{
static int size = 8;

static void FCFSAlgorithm(int arr[], int head)
{
	int seek_count = 0;
	int distance, cur_track;

	for (int i = 0; i < size; i++)
	{
		cur_track = arr[i];

		// calculate distance
		distance = Math.abs(cur_track - head);

		// increase the total count
		seek_count += distance;

		head = cur_track;
	}

	System.out.println("All seek operations are     > " + seek_count + " Operation");

	System.out.print("Seek Sequence is            >  ");

	for (int i = 0; i < size; i++)
		System.out.print(arr[i] + " , " );
	
    System.out.println(" " );
    System.out.println("Finish" );
}

 
public static void main(String[] args)
{
	//operations
	int arr[] = { 201 , 300 , 70 , 12 , 250 , 11 , 41 , 114 };
	int head = 0;
        
        System.out.println("Initial position of head is > " + head);
	FCFSAlgorithm(arr, head);
}
}
  