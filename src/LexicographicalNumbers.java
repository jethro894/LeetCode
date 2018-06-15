import java.util.ArrayList;
import java.util.List;


public class LexicographicalNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 13;
		System.out.println(new LexicographicalNumbers().lexicalOrder(n));
	}
	
	public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        helper(res, n, 0);
        return res;
    }
    
    public void helper(List<Integer> res, int n, int prefix){
    	if (prefix*10 > n) {
    		return;
    	}
    	
    	for (int i = 0; i <= 9; i++) {
    		int num = prefix*10 + i;
    		
    		//System.out.print(num + ",");
    		if (num > n) {
    			break;
    		}
    		
    		if (num > 0){
    			res.add(num);
    			helper(res, n, num);
    		}
    	}
    }

}
