
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char alp = 'A', last = 'E';
		for (int i = 0; i <= (last - 'A'+2); i++) {
			for (int j = 0; j <= i; j++) {
				System.out.println(alp + "");
			}
			++alp;
		}
	}

}
