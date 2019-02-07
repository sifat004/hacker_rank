import java.util.ArrayList;

public class per_comb_sub {
	String[] subSets= new String[20];
	ArrayList<String> ss=new ArrayList<>();


	public static void main(String[] args)  
	{ 
	    String str = "abc";  
	        int index = 0; 
	        String curr=""; 
	    powerSet(str,index,curr);  
	  
	    } 
	
	
	private void permute(String str,int from,int to) {
		
		if(from==to) System.out.println(str);
		
		else {
		for(int i=from;i<=to;i++) {
			
			str=swap(str,from,i);
			permute(str,from+1,to);
			str=swap(str,from,i);
			
		}
		}
		
		
	}
	
	private void combination(String str,int from,int to,int r) {
		
		
		
	}
	
	static void powerSet(String str, int index,  
            String curr)  
      
{  
    int n = str.length();  
  
    // base case  
    if (index == n) 
    {  
        System.out.println(curr); 
        return;  
    }  
  
    // Two cases for every character  
    // (i) We consider the character  
    // as part of current subset  
    // (ii) We do not consider current  
    // character as part of current  
    // subset  
    powerSet(str, index + 1, curr + str.charAt(index));  
    powerSet(str, index + 1, curr); 
  
}  
	
	public String swap(String str,int i,int j) {
		
		char[] charArray=str.toCharArray();
		char temp=str.charAt(i);
		
		charArray[i]=charArray[j];
		charArray[j]=temp;
		
		return String.valueOf(charArray);
		
		
		
	}

}
