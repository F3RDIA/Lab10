
import java.util.*;

public class Lab10 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // Q1();

        //Q2();

        //Q3();

         Q4();

        scan.close();
        

    }

    public static void Q1() {
        // clean code principles = no magic numbers, well named variables etc
        while (true) {

            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            String input = scan.nextLine();
            if (input.equals("q")) {

                return;

            }
            double length_A;
            double length_B;
            if (input.equals("square")) {

                System.out.println("Enter the length of side a: ");

                length_A = Double.parseDouble(scan.nextLine());

                System.out.println("The circumference of the square is: " + length_A * 4);

                System.out.println("The area of the square is: " + Math.pow(length_A, 2));

            } else if (input.equals("rectangle")) {

                System.out.println("Enter the length of side a: ");

                length_A = Double.parseDouble(scan.nextLine());

                System.out.println("Enter the length of side b: ");

                length_B = Double.parseDouble(scan.nextLine());

                System.out.println("The circumference of the rectangle is: " + (2 * (length_A + length_B)));

                System.out.println("The area of the rectangle is: " + (length_A * length_B));

            } else if (input.equals("circle")) {
                System.out.println("Enter the radius: ");

                length_A = Double.parseDouble(scan.nextLine());

                System.out.println("The circumference of the circle is: " + (Math.PI * length_A * 2));

                System.out.println("The area of the circle is: " + (Math.PI * Math.pow(length_A, 2)));
            }
        }
    }

    public static void Q2() {

        System.out.println("Q2: Enter the current day (1-31): ");

        int date = Integer.parseInt(scan.nextLine());

        System.out.println("Enter the current month: (1-12)");

        int month = Integer.parseInt(scan.nextLine());
        String monthPrint = "";

        if (date > 0 && date < 32) {
            if (month > 0 && month < 13) {
                switch (month) {
                    case 1:
                        monthPrint = "January";
                        break;
                    case 2:
                        monthPrint = "February";
                        break;
                    case 3:
                        monthPrint = "March";
                        break;
                    case 4:
                        monthPrint = "April";
                        break;
                    case 5:
                        monthPrint = "May";
                        break;
                    case 6:
                        monthPrint = "June";
                        break;
                    case 7:
                        monthPrint = "July";
                        break;
                    case 8:
                        monthPrint = "August";
                        break;
                    case 9:
                        monthPrint = "September";
                        break;
                    case 10:
                        monthPrint = "October";
                        break;
                    case 11:
                        monthPrint = "November";
                        break;
                    case 12:
                        monthPrint = "December";
                        break;
                    default:
                        System.out.println("Invalid month");
                }

                if (date == 1 || date == 21 || date == 31) {
                    System.out.println("You selected " + date + "st of " + monthPrint);

                } else if (date == 2 || date == 22 || date == 32) {
                    System.out.println("You selected " + date + "nd of " + monthPrint);

                } else if (date == 3 || date == 23) {
                    System.out.println("You selected " + date + "rd of " + monthPrint);

                } else {
                    System.out.println("You selected " + date + "th of " + monthPrint);
                }
            }
        } else {
            System.out.println("Invalid day");
        }
    }

    
      public static void Q3() {
      
      System.out.
      println("Q3: Enter how many numbers you want to check for primality: ");
      
      int n = Integer.parseInt(scan.nextLine());
      
      int counter = 0;
      
      for (int i = 0; i < n; i++) {
      
      if (i < 2)
      
      continue;
      
      boolean check = true;

      for (int j = 2; j * j <= i; j++) {
      
      if (i % j == 0) {
      
      check = false;
      
      break;
      
      }
      }
      
      if (check == true) {
      
      counter++;
      
      }
      
      }
      System.out.println("There are: " + counter + " primes between 0 and "
      + n);
      
      }
      
      public static void Q4() {
      
      Random rng = new Random();
      
      String input;
      
      System.out.println("Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack. Kill the enemy to win!");
      System.out.println("Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
      System.out.println("Q4: Your damage is 2-16 (2d8)");
      
      int enemyHP = 100;
      int a = 0;
      
      boolean buffCheck = false;
      
      while (true) {
      
      boolean doAttack = false;
      boolean inputGiven = false;
      
      while (!inputGiven) {
      
      input = scan.nextLine();
      inputGiven = true;

      switch (input) {
      
        case "A", "a":
            doAttack = true;
            break;
        case "B", "b":
            buffCheck = true;
            System.out.println("Buffing! +5 to your next attack roll and damage");
            break;
        default:
            System.out.println("Invalid input");
            inputGiven = false;
        }
      }
      if (doAttack) {
      a++;
      
      int attackRoll = rng.nextInt(20) + 1;
      int damage = 0;
      System.out.print("You rolled: " + attackRoll);
      
      if(buffCheck) {
      attackRoll += 5;
      System.out.print(" + 5 (buff active)\n");
      
      } else {
      System.out.println();
      }
      if (attackRoll >= 12) {
      damage = rng.nextInt(8) + 1;
      damage += rng.nextInt(8) + 1;
      
      if(buffCheck) {
      damage += 5;
      }
      
      if (attackRoll == 20 || (buffCheck && attackRoll == 20 + 5))
      {
      
      damage *= 2;
      System.out.print("Critical hit! ");
      }
      System.out.print("You dealt " + damage + " damage");
      if(buffCheck) {
      System.out.print(" (buffed attack)");
      }
      enemyHP -= damage;
      System.out.println("\nEnemy HP: " + Math.max(0,
      enemyHP));
      } else {
      
      System.out.println("Miss");
      }
      buffCheck = false;
      
      if (enemyHP <= 0) {
      System.out.println("Enemy died in " + a + " turns");
      scan.close();
      return;
      }
    }   
    } 
}
}