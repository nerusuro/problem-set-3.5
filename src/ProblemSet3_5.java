/**
 * INSTRUCTIONS.
 * 
 * The following exercises are, perhaps, more mathematically inclined than previous
 * problem sets. While they might be challenging, they are certainy doable.
 * 
 * You can (and should!) solve each of them using only the operators, conditional control
 * structures, and iterative control strucurs we've covered. You are not permitted to use
 * recursive code in your solutions.
 * 
 * Please be mindful of the expected outputs, as your code will be tested against that
 * directly. If you're unsure, please ask for clarification.
 * 
 * This problem set is worth 25 points and is due no later than 11:59pm on October 28, 2018.
 */
import java.util.Scanner;
public class ProblemSet3_5 {
	
	public static void main(String[] args) {
		ProblemSet3_5 ps = new ProblemSet3_5();
		
		// scanner
		Scanner in = new Scanner(System.in);
		
		/*//ex 1
		System.out.println("Exercise 1");
		System.out.println("Starting value will be 1.");
		int start = 1;
		System.out.println("Please enter ending value.");
		int end = in.nextInt();
		ps.primes(start, end);
		
		//ex 2
		System.out.println("Exercise 2");
		System.out.println("Year assumed to be 2018.");
		System.out.println("Enter how many future leap years you want to see.");
		int count = in.nextInt();
		ps.leapYears(count); */
		
		//ex 3
		System.out.println("Exercise 3");
		System.out.println("Enter number to see if it is palindromic.");
		int number = in.nextInt();
		ps.palindromicNumbers(number);
		
		/*//ex 4
		System.out.println("Exercise 4");
		System.out.println("What fibonacci number do you want to see?");
		int n = in.nextInt();
		ps.fibonacci(n); 
		
		//ex 5
		System.out.println("Exercise 5");
		System.out.println("Enter value for x.");
		int x = in.nextInt();
		System.out.println("Enter value for y.");
		int y = in.nextInt();
		System.out.println("Enter value for limit.");
		int limit = in.nextInt();
		ps.multiples(x, y, limit); */
		
		//close scanner
		in.close();
	}
	
	/**
	 * How many prime numbers are there between @start and @end, where @start and @end
	 * are positive integers in the range [1, @Integer.MAX_VALUE]?
	 * 
	 * Print your solution in the following formats: "There is X prime number."
	 *                                               "There are X prime numbers."
	 * 
	 * @param start
	 * @param end
	 */
	
	public void primes(int start, int end) {
		int count = 0;
		int countPrime = 0;
		// makes sure to include 2
		if (end > 1) {
			countPrime++;
		}
		while (start <= end) {
			//how many numbers it is divisible by
			//resets for every number
			count = 0;
			for(int i = 2; i < start; i++) {
				if (start % i == 0) {
					count++;
				}
				if (i == start - 1) {
					//if it wasnt divisible by anything then its prime
					if (count == 0) {
						countPrime++;
					}
				}
			}
			start++;
		}
		if (countPrime == 1) {
			System.out.println("There is " + countPrime + " prime number.");
		}
		else if (countPrime > 1 || countPrime == 0) {
			System.out.println("There are " + countPrime + " prime numbers.");
		}
	}
	
	/**
	 * What are the next @count leap years?
	 * 
	 * Print your solution in the following formats: "The next leap year is X."
	 *                                               "The next 2 leap years are X and Y."
	 *                                               "THe next N leap years are A, ..., X, Y, and Z."
	 * 
	 * @param count
	 */
	
	public void leapYears(int count) {
		int year = 2018;
		boolean isLeapYear = false;
		int leapYear = 0;
		int numLeapYears = 0;
		//num of years until last leap year from 2018
		int num = 0;
		for (int i = 4; i > 0; i--) {
			if ((year + i) % 4 == 0) {
				num = i + (4 * count);
			}
		}
		if (count == 1) {
			System.out.print("The next leap year is ");
			for (int i1 = 0; i1 < num; i1++) {
				leapYear = year + i1;
				isLeapYear = false;
				if ((year + i1) % 100 == 0) {
					if ((year + i1) % 400 == 0) {
						isLeapYear = true;
					}
					else if ((year + i1) % 400 != 0) {
						isLeapYear = false;
					}
				}
				else if ((year + i1) % 4 == 0) {
					isLeapYear = true;
				}
				if (isLeapYear == true) {
					System.out.println(leapYear + ".");
				}
			}
		}
		if (count == 2) {
			System.out.print("The next 2 leap years are ");
			for (int i1 = 0; i1 < num; i1++) {
				leapYear = year + i1;
				isLeapYear = false;
				if ((year + i1) % 100 == 0) {
					if ((year + i1) % 400 == 0) {
						isLeapYear = true;
						numLeapYears++;
					}
					else if ((year + i1) % 400 != 0) {
						isLeapYear = false;
					}
				}
				else if ((year + i1) % 4 == 0) {
					isLeapYear = true;
					numLeapYears++;
				}
				if (numLeapYears == 1) {
					if (isLeapYear == true) {
						System.out.print(leapYear + " and");
					}
				}
				else {
					if (isLeapYear == true) {
						System.out.println(leapYear + ".");
					}
				}
			}
		}
		else if (count > 2) {
			System.out.print("The next " + count + " leap years are ");
			for (int i1 = 0; i1 < num; i1++) {
				leapYear = year + i1;
				isLeapYear = false;
				if ((year + i1) % 100 == 0) {
					if ((year + i1) % 400 == 0) {
						isLeapYear = true;
						numLeapYears++;
					}
					else if ((year + i1) % 400 != 0) {
						isLeapYear = false;
					}
				}
				else if ((year + i1) % 4 == 0) {
					isLeapYear = true;
					numLeapYears++;
				}
				if (numLeapYears == count) {
					if (isLeapYear == true) {
						System.out.println("and " + leapYear + ".");
					}
				}
				else {
					if (isLeapYear == true) {
						System.out.print(leapYear + ", ");
					}
				}
			}
		}
	}

	/**
	 * Is @number a palindromic number?
	 * 
	 * Print your solution in the following formats: "X is a palindromic number."
	 *                                               "X is not a palindromic number."
	 *                                               
	 * @param number
	 */
	//currently works with an even amount of digits
	//working on the odd ones
	public void palindromicNumbers(int number) {
		int numBefore = 0;
		int numOfZeros = 0;
		int numBeforeZero = 0;
		boolean isPalindromicNumber = false;
		
		for (int i = 0; i < 10; i++) {
			if ((number - i) % 10 == 0) {
				numBefore = i;
			}
		}
		for (int j = 0; j <= number; j++) {
			//say the number is 1011.
			//should subtract 1011 - 1 - 10 to equal 1000.
			//then it should divide it by 1000
			//it should find the amount of zeros in the number
			if (((number - numBefore) - j) / Math.pow(10,((Integer.toString(((number - numBefore) - j) - 1).length()))) == 1) {
				if (numBeforeZero == 0) {
					numBeforeZero = j;
					numOfZeros = (int)Math.pow(10,((Integer.toString(((int)(((number - numBefore) - numBeforeZero) - 1))).length())));
				}
			}
		}
		if (numOfZeros % 2 == 0 && number > 9) {
			if (number % 11 == 0) {
				isPalindromicNumber = true;
			}
		}
		else if (number > 0 && number < 10) {
			isPalindromicNumber = true;
		}
		if (number % 10 == 0) {
			isPalindromicNumber = false;
		}
		if (isPalindromicNumber == false) {
			System.out.println("This is not a palindromic number.");
		}
		else if (isPalindromicNumber == true) {
			System.out.println("This is a palindromic number.");
		}
	}
	
	/**
	 * What is the @nth Fibonacci number, where @n is a positive integer?
	 * 
	 * Print your solution in the following formats: "The 21st Fibonacci number is X."
	 *                                               "The 22nd Fibonacci number is X."
	 *                                               "The 23rd Fibonacci number is X."
	 *                                               "The 24th Fibonacci number is X."
	 *                                               
	 * @param n
	 */
	
	public void fibonacci(int n) {
		int sum = 0;
		int prev1 = 0;
		int prev2 = 0;
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				sum = 0;
			}
			if (i == 1) {
				sum = i;
				prev1 = sum;
			}
			else if (i == 2) {
				sum = prev1;
				prev2 = prev1;
			}
			else if (i > 2) {
				sum = prev1 + prev2;
				prev2 = prev1;
				prev1 = sum;
			}
		}
		int num = 0;
		for (int i = 0; i < 10; i++) {
			if ((n - i) % 10 == 0) {
				num = i;
			}
		}
		if (num == 1) {
			System.out.println("The " + n + "st Fibonacci number is " + sum);
		}
		else if (num == 2) {
			System.out.println("The " + n + "nd Fibonacci number is " + sum);
		}
		else if (num == 3) {
			System.out.println("The " + n + "rd Fibonacci number is " + sum);
		}
		else {
			System.out.println("The " + n + "th Fibonacci number is " + sum);
		}
	}
	
	/**
	 * What is the sum of all multiples of @x and @y less than @limit, where @x, @y, and
	 * @limit are positive integers?
	 * 
	 * Print your solution in the following format: "The sum is X."
	 * 
	 * @param limit
	 */
	
	public void multiples(int x, int y, int limit) {
		int sum = 0;
		for (int i = 1; i <= x; i++) {
			if (x % i == 0) {
				if (i < limit) {
					sum = sum + i;
				}
			}
		}
		for (int i = 1; i <= y; i++) {
			if (y % i == 0) {
				if (i < limit) {
					sum = sum + i;
				}
			}
		}
		System.out.println("The sum is " + sum + ".");
	}
}
