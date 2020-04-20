package org.comstudy21.Login;

class TimeThread extends Thread{
	int n=0;
	public void run(){
		while(n<11){
			System.out.println(n);
			n++;
			try{
				sleep(3000);
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
}
public class Ex extends Thread{
	int n=0;
	public void run(){
		while(n<11){
			System.out.println(n);
			n++;
			try{
				sleep(3000);
			}
			catch(InterruptedException e){
				return;
			}
		}
	}

	public static void main(String[] args) {
		Ex tt = new Ex();
		tt.start();
	}
	public static void test3(String[] args) {
		int[] a = { 1, 7, 6, 5, 3 };
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int d : a)
		System.out.println(d);
	}

	public static void test2(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까" + isNumber(str));
		str = null;
		System.out.println(str + "는 숫자입니까" + isNumber(str));
	}

	public static boolean isNumber(String str) {
		if (str.equals("") || str.equals(null)) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!('0' <= str.charAt(i) && str.charAt(i) <= '9')) {
				return false;
			}
		}
		return true;
	}

	public static void test(String[] args) {
		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };

		int total = 0;
		float average = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
		}
		average = total / 20f;

		System.out.println("tot=" + total);
		System.out.println("avg=" + average);

	}

}
