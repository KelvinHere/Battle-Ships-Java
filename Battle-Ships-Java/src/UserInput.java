import java.util.Scanner;

public class UserInput {
	public static int getNumber(String prompt) {
		String input;
		int result;
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print(prompt + ": ");
			input = scanner.nextLine();
			
			try  {
				result = Integer.parseInt(input);
				return result;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter a number.");
			}
		}
	}
}
