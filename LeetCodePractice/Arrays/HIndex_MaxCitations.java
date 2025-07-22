package LeetCodePractice.Arrays;

public class HIndex_MaxCitations {
	
	// The h-index is defined as the maximum value of h such that the given array has at least h elements that have each been cited at least h times.
    public int hIndex(int[] citations) {
        int n = citations.length;
        // Create a new temp array equal to total number of papers citations
        int[] citations_cnt = new int[citations.length+1];
        
        // Loop through temp array and increment its count if that index number citation is present
        // Increment last index only if citation more than that is present
        for(int i : citations)
        {
            citations_cnt[Math.min(n,i)]++;
        }

        int count = 0;
        // Loop from back as we want maximum number of H-index (means max citation m which is present in atleast m papers)
        for(int i = n; i>=0; i--)
        {
        	// Get count by adding current citation
            count += citations_cnt[i];
            // Check if count is equal or greater than i (total paper), then return paper count
            if(count >= i)
            {
                return i;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
		int[] inputArr = new int[] {1,3,1};
		HIndex_MaxCitations hi = new HIndex_MaxCitations();
		System.out.println("Maximum citations are "+hi.hIndex(inputArr));
	}

}
