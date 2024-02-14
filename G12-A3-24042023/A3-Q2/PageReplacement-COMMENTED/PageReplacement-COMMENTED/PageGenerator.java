/*
This class sets the size and range for generating a random reference string
and then genrates the random reference string and stores it in the instance
variable referenceString. The method getReferenceSting() returns a 
pre-set reference string in variabe "str".  However, if we want to 
use the random refernce string, this method should be modified to
return referenceSsting. 
 */

public class PageGenerator
{
	private static final int DEFAULT_SIZE = 100;
	private static final int RANGE = 9;

	// an array of integers that represents the reference string
	int[] referenceString;

	// This is the constructor of the class PageGenerator that sets the size of the reference string
	public PageGenerator() {
		this(DEFAULT_SIZE);
	}

	// This is the constructor of the class PageGenerator that sets the size of the reference string and the range of the reference string
	public PageGenerator(int count) {
		if (count < 0)
			throw new IllegalArgumentException();

		java.util.Random generator = new java.util.Random();
		referenceString = new int[count];

		for (int i = 0; i < count; i++)
			referenceString[i] = generator.nextInt(RANGE + 1);
	}

	// This method returns the reference string
	public int[] getReferenceString() {
        
        	int[] str = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
			//int[] str = {1,2,3,4,1,2,5,1,2,3,4,5};

	               	return str;
		//return referenceString;
	}
}
