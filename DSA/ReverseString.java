public class ReverseString {
	public static void main(String[] args) {
		// using inplace approach
		char[] s = {'h', 'e', 'l', 'l', 'o'};
		int st = 0;
        int e = s.length - 1;
        while(st <= e){
            char temp = s[st];
            s[st] = s[e];
            s[e]=temp;
            st++;
            e--;
        }
	}
}
