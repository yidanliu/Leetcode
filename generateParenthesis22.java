import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {
	private void generateHelper(int left, int right, StringBuffer sb, List<String> output) {
		if (left > right) {
			return;
		}
		
		if (left == 0) {
			StringBuffer nsb = new StringBuffer(sb);
			for (int i = 0; i < right; i++) {
				nsb.append(")");
			}
			output.add(nsb.toString());
			return;
		}
		sb.append("(");
		generateHelper(left-1, right, sb, output);
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		generateHelper(left, right-1, sb, output);
		sb.deleteCharAt(sb.length()-1);
		
	}
	public List<String> generateParenthesis(int n) {
		List<String> output = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		generateHelper(n, n, sb, output);
		return output;
	}
}