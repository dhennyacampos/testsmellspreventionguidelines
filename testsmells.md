🔙 <a href="README.md">Back to previous page</a> 


<p align="center">
 <h2>Definition and exemplo of test smells 🐞🐞🐞</h2>
</p>

<p align="justify">📌 This reade.me  xxxx </i> xxx </p>

<p align="center">
 <h2>Test smells 🐞</h2>
</p>

* <b>Assertion Roulette (AR):</b>
  It occurs when multiple assertion statements are present in a test method without any explanation or parameter in the assertion method,
  it can cause confusion and make it difficult to identify which assertion has failed if the test fails (Van Deursen et. al, 2001).
* <b>Conditional Logic Test (CTL):</b>
  It occurs test methods contain conditional logic statements (e.g., if-else, while, for). The presence of conditions in test methods can
  alter the test's behavior and expected outcomes. Consequently, this can create scenarios in which the tests fail to uncover defects in
  the production method (PERUMA et. al, 2018).
* <b>Duplicate Assert (DA):</b>
  It occurs when a test method checks the same assertion more than once in the same method but with different values.
  When a test method has multiple assertions that are repeated, it can make the purpose of the method harder to comprehend PERUMA, 2018).
* <b>Resource Optimism (RO):</b>
  The test method uses a resource without first checking its state. It's important to be cautious when testing code
  that relies on external resources like directories or database tables. Assuming that these resources exist or are in a certain state can
  lead to unpredictable results in your tests (Van Deursen et. al, 2001).
* <b>Sleepy Test (ST):</b>
  It occurs when test method pauses for a certain period by simulating or waiting for an external event (using Thread.sleep()),
  and then continues execution usually (PERUMA et. al, 2018).
*  <b>Unknown Test (UT):</b>
  It occurs when the test method that does not contain assertion. An assertion statement describes an expected condition
  for a test method (PERUMA et. al, 2018).

