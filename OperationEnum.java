package MathGame;

public class OperationEnum{
	public enum operations{additon,subtract,multiply,Algebra,division,exponents}
	String operation;
	static operations Value=operations.additon;
	OperationEnum(operations op){
		Value=op;
		if(Value==operations.additon) {
			operation="+";
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
