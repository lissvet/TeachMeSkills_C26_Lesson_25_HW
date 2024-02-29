package by.tms.lesson25.calculator.service;

import by.tms.lesson25.calculator.model.Operation;

public class OperationService {

	public static Operation calculate(Operation operation) {
		double result;
		switch (operation.getType()) {
			case "+": //%2B в URL
				result = operation.getNum1() + operation.getNum2();
				operation.setResult(result);
				return operation;
			case "-":
				result = operation.getNum1() - operation.getNum2();
				operation.setResult(result);
				return operation;
			case "*":
				result = operation.getNum1() * operation.getNum2();
				operation.setResult(result);
				return operation;
			case "/":
				if (operation.getNum2() == 0) {
					throw new IllegalArgumentException("Can't divide by zero");
				} else {
					result = operation.getNum1() / operation.getNum2();
					operation.setResult(result);
					return operation;
				}
		}
		throw new IllegalArgumentException("Unsupported operation");
	}

}
