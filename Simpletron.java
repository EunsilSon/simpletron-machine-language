import java.util.Scanner;

public class Simpletron {

    int[] memory = new int[100]; // 메모리

    int accumulator = 0; // 누산기
    int instructionCounter = 0; // 명령에서 뽑은 메모리 위치
    int instructionRegister; // 입력한 명령
    int operationCode; // 연산
    int operand; // 메모리 위치

    public void run() {
        /*
         * 1. 프로그램 실행
         */

        System.out.print("*** Welcome to Simpletron! ***\n" +
                "*** Please enter your program one instruction ***\n" +
                "*** (or data word) at a time. I will type the ***\n" +
                "*** location number and a question mark (?) ***\n" +
                "*** You then type the word for that location. ***\n" +
                "*** Type the sentinel -99999 to stop entering ***\n" +
                "*** your program ****\n\n");

        /*
         * 2. 명령 입력
         */

        Scanner input = new Scanner(System.in);

        int op;
        while (instructionCounter < memory.length) {

            System.out.printf("%02d ?  +", instructionCounter);
            op = input.nextInt();

            if (op == -99999) { // 입력 종료
                System.out.println("*** Program loading completed ***\n" +
                        "*** Program execution begins ***\n");
                break;
            } else if (checkOverflow(op)) { // 입력 범위 초과
                System.out.println("*** Input Range Exceeded ***");
            } else { // 명령 저장
                memory[instructionCounter] = op;
                instructionCounter++;
            }
        }

        /*
         * 3. 명령 인출 + 해독
         */

        instructionCounter = 0;
        while (instructionCounter < memory.length) {
            instructionRegister = memory[instructionCounter++];

            operationCode = instructionRegister / 100;
            operand = instructionRegister % 100;

            switch (operationCode) {
                case 10: // READ
                    System.out.printf("%02d ?  ", operand);
                    memory[operand] = input.nextInt();
                    break;
                case 11: // WRITE
                    System.out.printf("%02d : %d\n\n", operand, memory[operand]);
                    break;
                case 20: // LOAD
                    accumulator = memory[operand];
                    break;
                case 21: // STORE
                    memory[operand] = accumulator;
                    break;
                case 30: // ADD
                    accumulator += memory[operand];

                    if (checkOverflow(accumulator)) {
                        System.out.println("\n*** Attempt to divide by zero ***");
                        return;
                    }
                    break;
                case 31: // SUBTRACT
                    accumulator -= memory[operand];

                    if (checkOverflow(accumulator)) {
                        System.out.println("\n*** Attempt to divide by zero ***");
                        return;
                    }
                    break;
                case 32: // DIVIDE
                    if (accumulator == 0 || memory[operand] == 0) {
                        return;
                    } else {
                        accumulator /= memory[operand];
                    }

                    if (checkOverflow(accumulator)) {
                        System.out.println("\n*** Attempt to divide by zero ***");
                        return;
                    }
                    break;
                case 33: // MULTIPLY
                    accumulator *= memory[operand];

                    if (checkOverflow(accumulator)) {
                        System.out.println("\n*** Attempt to divide by zero ***");
                        return;
                    }
                    break;
                case 40: // BRANCH
                    instructionCounter = operand;
                    break;
                case 41: // BRANCHING
                    if (accumulator < 0) {
                        instructionCounter = operand;
                    }
                    break;
                case 42: // BRANCH ZERO
                    if (accumulator == 0) {
                        instructionCounter = operand;
                    }
                    break;
                case 43: // HALT
                    return;
                default:
                    System.out.println("*** Wrong OP-CODE ***\n*** Attempt to divide by zero ***");
                    return;
            }
        }
    }

    public boolean checkOverflow (int range) {
        return range > 9999 || range < -9999;
    }

    public void halt() {
        System.out.println("*** Simpletron execution anomaly terminated ***\n");

        System.out.printf("REGISTERS :\n\t" +
                        "accumulator\t\t\t\t+%04d\n\t" +
                        "instructionCounter\t\t+%02d\n\t" +
                        "instructionRegister\t\t+%04d\n\t" +
                        "operationCode\t\t\t+%02d\n\t" +
                        "operand\t\t\t\t\t+%02d\n\n"
                ,accumulator ,instructionCounter ,instructionRegister ,operationCode ,operand);

        System.out.println("MEMORY:");
        System.out.printf("\t\t\t0\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9");

        int count = 0;
        for (int op : memory) {
            if (count % 10 == 0) {
                System.out.print("\n\t" + count);
            }
            System.out.printf("\t+%04d", op);
            count++;
        }

        System.exit(0);
    }

    public static void main(String[] args) {
        Simpletron simpletron = new Simpletron();
        simpletron.run(); // 실행
        simpletron.halt(); // 종료 + 메모리 출력
    }
}