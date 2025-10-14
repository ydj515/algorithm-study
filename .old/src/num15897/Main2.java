package num15897;

import java.util.*;

public class Main2 {

	/*
	    * 1 1 1 1 1 1 1 1 1 1 1 1
	    * i=1 : 12
	    * 2 2 2 2 2 2
	    * i=2 : 6
	    * 3 2 3 2
	    * i=3 : 4
	    * 4 3 3
	    * i=4 : 3
	    * 5 2 3
	    * i=5 : 3
	    * 6 4
	    * i=6 : 2
	    * 7 2
	    * i=7 : 2
	    * 8 4
	    * i=8 : 2
	    * 9 3
	    * i=9 : 2
	    * 10 4
	    * i=10 : 2
	    * 11 2
	    * i=11 : 2
	    * 12
	    * i=12 : 1
	    * 해석 : i=1이면 한번에 1칸씩 움직일 수 있으므로 총 12번 움직여야 12에 도달하므로 12가 나온다
	    * i=3이면 한번에 3칸씩 움직일 수 있으므로 총 4번 움직여야 12에 도달하므로 4가 나온다
	    */
	    

	   public static void main(String[] args) {

	      Scanner scanner = new Scanner(System.in);

	      int n = scanner.nextInt();

	      // int[] sieve = new int[n+1];
	      int cnt = 0;

	      // for(int i=1;i<=n;i++) {
	      // cnt = 0;
	      // for(int j=1;j<=n;j+=i) {
	      // sieve[j] += 1;
	      // System.out.print(sieve[j] + " ");
	      // cnt++;
	      // }
	      // System.out.println();
	      // System.out.println( "i=" + i + " : " + cnt);
	      // }

	      for (int i = 1; i <= n; i++) {
	         int temp = n;

	         while (true) {
	            temp -= i;
	            cnt++;

	            if (temp <= 0) {
	               break;
	            }
	         }
	         // System.out.println("i = " + i + " : " + cnt);
	      }
	      
	      System.out.println(cnt);
	   
	   }


}
