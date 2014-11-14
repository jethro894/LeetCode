import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Subset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {1,2,3};
		for(List<Integer> list : new Subset().subsets(s))
			System.out.println(list);
	}

	List<List<Integer>> result;
	public List<List<Integer>> subsets(int[] S) {
        result = new ArrayList<List<Integer>>();
        if(S.length == 0)
        	return result;
        Arrays.sort(S);
        
        List<Integer> empty = new ArrayList<Integer>();
        grow(empty, 0, S);
        
        Set<List<Integer>> distincts = new HashSet<List<Integer>>(result);
        return new ArrayList<List<Integer>>(distincts);
    }
	
	public void grow(List<Integer> pre, int index, int[] s){
		if(index == s.length){
			result.add(pre);
			return;
		}
		
		List<Integer> withThisDigit = new ArrayList<Integer>(pre);
		withThisDigit.add(s[index]);
		grow(withThisDigit, index + 1, s);
		
		List<Integer> withoutThisDigit = new ArrayList<Integer>(pre);
		grow(withoutThisDigit, index + 1, s);
	}
}
