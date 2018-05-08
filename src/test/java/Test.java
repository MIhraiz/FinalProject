
public class Test {

	public static void main(String[] args) {
		
		String s = "mohammad";
		String s2 = Security.encrypt(s);
		System.out.println(s2);
		System.out.println(Security.decrypt(s2));
	}

}

