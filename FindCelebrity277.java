import java.util.HashSet;
import java.util.Set;

public class FindCelebrity277 {
	private boolean knows(int i, int j) {
		return true;
	}
	public int findCelebrity(int n) {
		int cel = 0;
		for (int i = 1; i < n; i++) {
			if (knows(cel, i)) {
				cel = i;
			}
		}
		boolean realCel = true;
		for (int i = 0; i < n; i++) {
			if (i == cel || (knows(i,cel) && !knows(cel,i))) {
				continue;
			}
			realCel = false;
			break;
		}
		return realCel ? cel : -1;
		
	}
	
	public int findCelebrityII(int n) {
		int cel = -1;
		Set<Integer> common = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (common.contains(i)) {
				continue;
			}
			boolean isCel = true;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (knows(i,j) == knows(j,i)) {
					common.add(i);
					common.add(j);
					isCel = false;
				} else if (knows(i,j)) {
					common.add(i);
					isCel = false;
				} else {
					common.add(j);
				}
			}
			if (isCel) {
				return i;
			}
		}
		return cel;
	}
}