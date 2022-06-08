package 剑指offer;

public class _剑指Offer_17_打印从1到最大的n位数 {
	/*public int[] printNumbers(int n) {	
		int length = (int) Math.pow(10, n) - 1;
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			res[i] = i + 1;
		}
		return res;	
	}*/
	//考虑大数
	int[] res;
	int count = 0;
	public int[] printNumbers(int n) {
		res = new int[(int)Math.pow(10, n) - 1];
		for (int digit = 1; digit < n + 1; digit++) {
			//digit表示要生成数字的位数
			for (char first = '1'; first <= '9'; first++) {
				char[] num = new char[digit];
				num[0] = first;
				dfs(1, num, digit);
			}
		}
		return res;
	}
	
	private void dfs(int index, char[] num, int digit) {
		if (index == digit) {
			res[count++] = Integer.parseInt(String.valueOf(num));
			return;
		}
		for (char i = '0'; i <= '9'; i++) {
			num[index] = i;
			dfs(index + 1, num, digit);
		}
	}
}
