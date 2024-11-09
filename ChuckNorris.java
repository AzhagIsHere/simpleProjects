package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operation;

        while (true) {
            System.out.print("Please input operation (encode/decode/exit): ");
            operation = sc.nextLine();

            switch (operation) {
                case "encode":
                    encode(sc);
                    break;
                case "decode":
                    decode(sc);
                    break;
                case "exit":
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("There is no '" + operation + "' operation");
                    break;
            }
        }
    }

    private static void encode(Scanner sc) {
        System.out.print("Input string: ");
        String input = sc.nextLine();
        StringBuilder binaryResult = new StringBuilder();

        // Convert the entire message to binary
        for (char c : input.toCharArray()) {
            String binaryValue = String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0');
            binaryResult.append(binaryValue);
        }

        // Convert the binary representation to Chuck Norris code
        StringBuilder chuckNorrisResult = new StringBuilder();
        char currentChar = binaryResult.charAt(0);
        int count = 1;

        for (int i = 1; i < binaryResult.length(); i++) {
            if (binaryResult.charAt(i) == currentChar) {
                count++;
            } else {
                chuckNorrisResult.append((currentChar == '1') ? "0 " : "00 ");
                chuckNorrisResult.append("0".repeat(count));
                chuckNorrisResult.append(" ");
                currentChar = binaryResult.charAt(i);
                count = 1;
            }
        }

        // Add the last block
        chuckNorrisResult.append((currentChar == '1') ? "0 " : "00 ");
        chuckNorrisResult.append("0".repeat(count));

        // Print the result
        System.out.println("Encoded string:");
        System.out.println(chuckNorrisResult.toString().trim());
    }

    private static void decode(Scanner sc) {
        System.out.print("Input encoded string: ");
        String input = sc.nextLine();

        // Validate the input
        if (!input.matches("[0 ]+")) {
            System.out.println("Encoded string is not valid");
            return;
        }

        String[] blocks = input.split(" ");

        // Check if the number of blocks is odd
        if (blocks.length % 2 != 0) {
            System.out.println("Encoded string is not valid");
            return;
        }

        StringBuilder binaryResult = new StringBuilder();

        // Process the blocks in pairs
        for (int i = 0; i < blocks.length; i += 2) {
            String firstBlock = blocks[i];
            String secondBlock = blocks[i + 1];

            // Validate the first block
            if (!firstBlock.equals("0") && !firstBlock.equals("00")) {
                System.out.println("Encoded string is not valid");
                return;
            }

            // Determine the bit value
            char bitValue = (firstBlock.equals("0")) ? '1' : '0';

            // Append the bit value repeated by the length of the second block
            for (int j = 0; j < secondBlock.length(); j++) {
                binaryResult.append(bitValue);
            }
        }

        // Check if the length of the binary result is a multiple of 7
        if (binaryResult.length() % 7 != 0) {
            System.out.println("Encoded string is not valid");
            return;
        }

        // Convert the binary result to characters
        StringBuilder decodedResult = new StringBuilder();
        for (int i = 0; i < binaryResult.length(); i += 7) {
            String binaryChar = binaryResult.substring(i, i + 7);
            int charValue = Integer.parseInt(binaryChar, 2);
            decodedResult.append((char) charValue);
        }

        // Print the result
        System.out.println("Decoded string:");
        System.out.println(decodedResult.toString());
    }
}
