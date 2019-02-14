package MathGame;

public class OperationEnum{
	public enum operations{add,subtract,multiply,Algebra,division,exponents}
	String operation;
	static operations Value=operations.add;
	OperationEnum(operations op){
		Value=op;
		if(Value==operations.add) {
			operation=" +";
		}
		else if(Value==operations.subtract) {
			operation="-";
		}
		else if (Value==operations.multiply) {
			
			operation="*";
		}
	}
	void SetEnum(operations op) {
		Value=op;
	}
	String getSymbol() {
		return operation;
	}
	operations GetEnum() {
		return Value;
	}
	operations GetOP() {
		return Value;
	}
}
