import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<List<Integer>> result;
	public List<List<Integer>> subsets(int[] S) {
        result = new ArrayList<List<Integer>>();
        if(S.length == 0)
        	return result;
        Arrays.sort(S);
        
        
    }
}
