This solution uses the example reference string that is provided in the text:

7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1

To run the test program, enter

	java Test <size of reference string> <number of page frames>

The current default behavior ignores the size of the reference string. 

To test solutions using the above reference string, enter

	java Test 0 3

To test random reference strings, modify PageGenerator.java 

--------------------------------------------------------------------------------------

Java programs were ran in command prompt with vscode as the text editor.
Java files were first compiled and then Test.java was ran using the commands

java Test 0 3
java Test 0 4

reference strings under PageGenerator.java were also experimented with to test for solutions. (commented out on file, but available for use)

AAA is First In First Out Algorithm (FIFO)

	Using the test solution above and running the test program with 3 frames (range 0-3) the output for AAA was 15 page faults.

	Initially, we have an empty set of three frames for our example reference string. The first three references (7, 0, 1) result in page faults, 
	so they are brought into these empty frames. The next reference (2) replaces page 7 because page 7 was brought in first. When the reference is to 0 and 0 is already in memory, 
	there is no fault for this reference. However, when the first reference to 3 occurs, it replaces page 0 since it is now first in line. Due to this replacement, the next reference,
	which is to 0, will fault. Page 1 is then replaced by page 0 and this process continues and every time we run into a fault we display the set of 3 frames which accumulate to be 15 different
	sets being 15 faults. 

	An additional test was done with 3 and 4 frames using the reference string int[] str = {1,2,3,4,1,2,5,1,2,3,4,5}; the output for this
	came out to be 9 page faults for 3 frames and 10 page faults for 4 frames (Belady's Anomaly described in book 10.4.2) leading us to conclude that algorithm AAA is FIFO.

BBB is Least Recently Used Algorithm (LRU)

	Using the test solution above and running the test program with 3 frames (range 0-3) the output for BBB was 12 faults.

	When the reference to page 4 occurs within this algorithm, it replaces page 2 (noticing that it was the least recently used). After faulting for page 2 it then replaces page 3 which
	was the next least recently used of these 3 pages in memory. This observation led us to conclude that the algorithm was LRU.
	

