package ufba.br;

public class MathOperations {
	double operand1;
	double operand2;

	public double evaluateOperation(String operation) throws Exception {
        // For simplicity, assume the input format is: "operand operator operand"
        String[] tokens = operation.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Invalid operation format");
        }

        double operand1 = Double.parseDouble(tokens[0]);
        String operator = tokens[1];
        double operand2 = Double.parseDouble(tokens[2]);

        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}

