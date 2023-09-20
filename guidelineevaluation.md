🔙 <a href="README.md">Back to previous page</a> 

<p align="center">
 <h2>Tools to create test classes</h2>
</p>
* Intellij IDEA

**Note**: For this research, the use of ChatGPT or similar cannot be used.

<p align="center">
 <h2>Calculator Task</h2>
</p>

## Production classes description

**Please, refer to [Calculator folder](https://github.com/dhennyacampos/testsmellspreventionguidelines/tree/main/code/Calculator) to access the production code.**

Diagram 1 - Relationship between the class MathOperations and IOHandler ![Diagram #5](Calculator-AllTasks.png)

**1) MathOperations:**
* MathOperations is the production class responsible for performing an operation between two operands.

**2) IOHandler**
* IOHandler reads an external file to perform several math operations, then saves the output in another file
* The expected format in the file is `operand operator operand` per line

**3) Main**
* It handles the calls for the MathOperations and IOHandler.
* It also creates a thread pool with a fixed number of threads to perform calculations in parallel.


## Task #1 - Testing the edge values for calculations

*Objective:* Create test cases to thoroughly test the divide method of the MathOperations class to verify the edge values for the division operation.

*Test steps:* Considering the class MathOperations, create a test class named MathOperationsTest for the scenarios:

1. Division of positive integers (dividend > divisor).
2. Division of negative integers (dividend < 0, divisor > 0).
3. Division by zero (divisor == 0)

## Task #2 - Reading from an External Database File

*Objective:*  Create test cases for production classes that involve reading data from external files, such as a database.

*Test steps:* Considering the IOHandler class, please create a IOHandlerTest class to verify the scenarios:
1. Test the IOHandler ability to read data from the external database file
3. Verify that the content read from the file matches the expected format `operand operator operand`, e.g., `1 + 5`


## Task #3 - Testing parallel calculations

*Objective:* Create a test case that verifies the evaluateOperation method of the MathOperations class correctly evaluates mathematical operations in parallel and produces the expected results.

*Test steps:* Considering the class MathOperations, create a test class named MathParallelOperationsTest for the scenario:
1. Create a thread pool with a fixed number of threads.
2. Create a task to execute the evaluateOperation method in parallel with the provided mathematical operation.
3. Verify whether the result obtained from the completed task is correct
