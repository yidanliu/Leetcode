import java.util.Stack;

public class TrappingRainWater {
	public int trap(int[] height) {
		Stack<Integer> stackIndex = new Stack<Integer>();
		int res = 0;
		stackIndex.push(0);
		for (int i = 1; i <height.length; i++) {
			int stackTop = height[stackIndex.peek()];
			if (height[i] <= stackTop) {
				stackIndex.push(i);
			} else if (height[i] > stackTop) {
				
				while (!stackIndex.isEmpty() && height[i] > stackTop) {
					int lowHeight = stackTop;
					stackIndex.pop();
					if (stackIndex.isEmpty()) {
						break;
					}
					System.out.println("===" + lowHeight);
					stackTop = height[stackIndex.peek()];
					int highHeight = Math.min(stackTop, height[i]);
					res += (highHeight-lowHeight) * (i - stackIndex.peek()-1);
					
				}
				stackIndex.push(i);
			}
			System.out.println(stackIndex.peek() + "," + res);
		}
		return res;
	}
}