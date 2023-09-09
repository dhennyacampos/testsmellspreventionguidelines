🔙 <a href="README.md">Back to previous page</a> 

<p align="center">
 <h2>Tools to create test classes</h2>
</p>

* Eclipse

* Intellij IDEA

* Visual Studio

**Note**: For this research, the use of chatgpt or simitares cannot be used.

<p align="center">
 <h2>Calculator Task</h2>
</p>

## Production classes description

**Please, refer to [Calculator folder](https://github.com/dhennyacampos/testsmellspreventionguidelines/tree/main/code/Calculator) to access the production code.**

**1) MathOperations:**
* MathOperations is the production class responsible for performing an operation between two operands.

**2) IOHandler**
* IOHandler reads an external file to perform several math operations, then saves the output in another file
* The expected format in the file is `operand operator operand` per line

**3) Main**
* Mains handles the calls for the MathOperations and IOHandler.


## Task #1 - Develop Test Code for the Calculator Class

*Description:*
Objective: Create test cases to thoroughly test the divide method of the Calculator class to verify the edge values for the division operation.

Diagram 5 - Relationship between the class MathOperations and IOHandler ![Diagram #5](Calculator-AllTasks.png)

*Test steps:* Considering the class MathOperations, create a test class named MathOperationsTest for the scenarios:

1. Division of positive integers (dividend > divisor).
2. Division of negative integers (dividend < 0, divisor > 0).
3. Division by zero (divisor == 0)

## Task #2 - Reading from an External Database File

*Description:*
Objective:  Create test cases for production classes that involve reading data from external files, such as a database.

*Test steps:* Considering the IOHandler class, please create a IOHandlerTest class to verify the scenarios:
1. Test the IOHandler ability to read data from the external database file
3. Verify that the content read from the file matches the expected format `operand operator operand`, e.g., `1 + 5`






