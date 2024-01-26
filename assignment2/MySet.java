
/* my array list: an array that behaves like a list 
 * E/../..
 */

public class MySet<T/* Can we have any T */> { 

    int nextItem; 
    int currentCapacity; 
    T[] data; // DO NOT CHANGE

    private static int defaultSizeToCreate = 10; // how many elements to create 

    public MySet(int elements) { 
	this.nextItem = 0; 
	this.defaultSizeToCreate = elements; 
	this.currentCapacity = elements; 

	this.data = (T[]) new Object[this.defaultSizeToCreate]; 
    }

    public MySet() { 
	this(defaultSizeToCreate); 
    }

    public boolean isEmpty() { return this.nextItem == 0; } 
    public boolean isFull() { return false; /* never get filled */} 

    public boolean add(T item) { 
	data[nextItem] = null; // DO NOT CHANGE 


	//  if there is any element return false, checking for duplicated elements
	for(int i=0;i<currentCapacity;i++){
		if(data[i]  != null && data[i].equals(item) ){
			return false;

		}
	}


	/* How do you handle when the array is full: 
	* crate a new array with currentCapacity+defaultSizeToCreate, 
	* copy the old conents into that
	* Accessing array when full might be a problem
	*/
	if(isFull()){
		currentCapacity += defaultSizeToCreate;
		T[] newArray = (T[]) new Object[currentCapacity];

		System.arraycopy(data, 0, newArray, 0, data.length );

		data = newArray;

	}

	/* if there is any element delete it 
	 * then add the new element. 
	 * How do you handle when the array is full: 
	 * crate a new array with currentCapacity+defaultSizeToCreate, 
	 * copy the old conents into that
	 * Accessing array when full might be a problem
	 */

	/* Add the item to the array if the item is not there */
	data[nextItem]= item;
	nextItem++;
	
	return true;
	

    }


	public void print(){

		for(int i=0;i<currentCapacity;i++){

			System.out.println(data[i]);
		}
	}

    public T remove() { 
	/* remove the first element in the array 
	 * and copy the rest front. 
	 * FIFO structure. 
	 * If the ArrayList is empty return null
	 */
	/* Option 1: */

	


	if(isEmpty()) return null; 
	// IMPLEMENT THE REST 

	/* Option 2: */
	if(!isEmpty()) {
		T removedItem = data[0];
		data[0] = null;	//remove the first element in the array 
		int len = currentCapacity-1;
		System.arraycopy(data, 1, data, 0, len);
		currentCapacity--;
		return removedItem;
	    
	}
	return null;
	// which option is better? why? 
    }


}


