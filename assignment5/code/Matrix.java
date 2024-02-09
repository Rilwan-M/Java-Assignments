public class Matrix extends Thread { 

    private int [][] a; 
    private int [][] b; 
    private static int [][] c; 


	private int i=0;
	private int j=0;
	private int z1=0;


    public Matrix(int[][] a,int[][] b, int i,int j, int z1) { // need to change this, might need some information

		this.a =a;
		this.b=b;
		this.i = i;
		this.j = j;
		this.z1 = z1;
	   }

    // public static int [][] multiply(int [][] a, int [][] b) {

	// /* check if multipication can be done, if not 
	//  * return null 
	//  * allocate required memory 
	//  * return a * b
	//  */
	// int x = a.length; 
	// int y = b[0].length; 

	// int z1 = a[0].length; 
	// int z2 = b.length; 

	// if(z1 != z2) { 
	//     System.out.println("Cannnot multiply");
	//     return null;
	// }

	// c = new int[x][y];

	// int result;
	// 	for(i=0;i<x;i++){
	// 		for(int j=0;j<y;j++){
	// 			result=0;
	// 			for(int k=0;k<z1;k++){
	// 				result+=a[i][k]*b[k][j];
	// 			}
	// 			c[i][j] = result;

	// 	}

	// 	}
	
	// return c;
    // }

	
	public static int [][] multiplyUsingThreads(int [][] a, int [][] b) {

		/* check if multipication can be done, if not 
		 * return null 
		 * allocate required memory 
		 * return a * b
		 */
		int x = a.length; 
		int y = b[0].length; 
	
		int z1 = a[0].length; 
		int z2 = b.length; 
	
		if(z1 != z2) { 
			System.out.println("Cannnot multiply");
			return null;
		}
	
		c = new int[x][y];
	
		
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){

				Matrix t = new Matrix(a,b,i,j,z1);

				t.start();
				

		}

		}
	
		return c;
		}

	// public static int [][] multiply(int [][] a, int [][] b,int numOfThreads) {

	// 	/* check if multipication can be done, if not 
	// 	 * return null 
	// 	 * allocate required memory 
	// 	 * return a * b
	// 	 */

	// 	int x = a.length; 
	// 	int y = b[0].length; 
	
	// 	int z1 = a[0].length; 
	// 	int z2 = b.length; 
	// 	int end = 0;
	// 	int rowsPerThread = x/numOfThreads;
	// 	int remainingRows = x%numOfThreads;

	// 	Matrix[] threads = new Matrix[numOfThreads];

	// 	if(z1 != z2) { 
	// 		System.out.println("Cannnot multiply");
	// 		return null;
	// 	}
	
	// 	c = new int[x][y];
	
	// 	//loop until numOfThreads finishes
	// 	for(int i=0, start=0;i<numOfThreads;i++,start+=rowsPerThread){

	// 		end = start + rowsPerThread -1;

	// 		if(i == numOfThreads-1)
	// 			end+=remainingRows;
			
	// 		threads[i] = new Matrix(a,b,start, end);
	// 		threads[i].start();

	// 	}

	// 	// // Wait for all threads to finish
	// 	// for (Matrix thread : threads) {
	// 	// 	try {
	// 	// 		thread.join();
	// 	// 	} catch (InterruptedException e) {
	// 	// 		e.printStackTrace();
	// 	// 	}
	// 	// }
		
		
		
	// 	return c;
	// 	}

	
	@Override
	public void run(){

		int result=0;
		for(int k=0;k<z1;k++){
			result+=a[i][k]*b[k][j];
		}
		c[i][j] = result;

		}
	}


