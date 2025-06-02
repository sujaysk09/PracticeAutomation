package practice;

import java.util.HashSet;

public class FirstDuplicateCharacterInString {

	public static void main(String[] args) {
		String str="suuuujjaaay";
		char[] ar=str.toCharArray();
		
		HashSet hs=new HashSet();
		
		for(char a:ar) {
			if(!hs.add(a)) {
				System.out.println(a);
				break;
			}
		}

	}

}
