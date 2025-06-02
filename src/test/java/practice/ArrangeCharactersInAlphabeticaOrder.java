package practice;

import java.util.Arrays;

public class ArrangeCharactersInAlphabeticaOrder {

	public static void main(String[] args) {

		String str="poonam";
		char[] ar=str.toCharArray();
		char temp=' ';
		
		for(int i=0;i<ar.length;i++) {
			for(int j=i+1;j<ar.length;j++) {
				if(ar[i]>ar[j]) {
					temp=ar[i];
					ar[i]=ar[j];
					ar[j]=temp;
				}
			}
		}

		for(char a:ar) {
			System.out.print(a);
		}
		//System.out.println(Arrays.toString(ar));
	}

}
