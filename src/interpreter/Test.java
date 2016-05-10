package interpreter;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input input = new Input(System.in);
		String[] fields;
		
		while(true){
			fields = input.readFields();
			if(fields[0].equals("sair")){
				System.out.println("ok");
				break;
			}
			for(int i = 0; i < fields.length; i++)
				System.out.println(fields[i]);
		}
	}

}
