
/* 
This is an abstract class that initializes the instance variable
pageFrameCount, and returns the number of page faults using
the getter method getPageFaultCount. The class that extends this
abstract class must define the abstract method insert() which 
updates the instance variable pageFaultCount.
 */


 public abstract class ReplacementAlgorithm
 {
	 /*
	  * pageFaultCount represents the number of page faults
	  */
	 protected int pageFaultCount;
	 
	 /*
	  * pageFrameCount represents the number of page frames 
	  */
	 protected int pageFrameCount;
 
	 /*
	  * Method that checks if pageFrameCount is a negative or positive number
	  * Throws exception if it is a negative number
	  */
	 public ReplacementAlgorithm(int pageFrameCount) {
		 if (pageFrameCount < 0)
			 throw new IllegalArgumentException();
		 
		 this.pageFrameCount = pageFrameCount;
		 pageFaultCount = 0;
	 }
	 
	 /*
	  * Method that returns the number of page faults
	  */
	 public int getPageFaultCount() {
		 return pageFaultCount;
	 }
	 
	 /*
	  * Abstract method so other classes can define their own insert method
	  * Insert method is used to update pageFaultCount 
	  */
	 public abstract void insert(int pageNumber); 
 }
