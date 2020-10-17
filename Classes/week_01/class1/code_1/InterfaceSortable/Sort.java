//  class Sort -- a class containing static sorting methods that can
//                sort any array of Sortable objects

package InterfaceSortable;
public class Sort {
	// bubble sort
	public static void bubbleSort(Sortable arr[]){
		boolean flag = true;
		for (int i=0; flag && i <arr.length; i++){
			flag = false;
			for (int j=0; j < arr.length-1-i; j++){
				if(arr[j].compare(arr[j+1]) > 0){
					flag = true;
					Sortable temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}		
	}

	//  we could add other sorting methods here

}   //  end class Sort

