import java.io.File;

public class Axis2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Axis2Test().generateCpString("D:\\Downloads\\axis2-1.7.4-bin\\axis2-1.7.4\\lib"));
	}

	public String generateCpString(String libDir){
		StringBuilder prefix = new StringBuilder();
		
		prefix.append("set CP=");
		
		final File folder = new File(libDir);
		for (final File fileEntry : folder.listFiles()) {
	        if (!fileEntry.isDirectory() && fileEntry.getName().endsWith(".jar")) {
	        	prefix.append(libDir + "\\" + fileEntry.getName() + ";");
	        }
	    }
		
		return prefix.toString();
	}

}
