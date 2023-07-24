🔙 <a href="README.md">Back to previous page</a> 


<p align="center">
 <h2>Definition and exemple of test smells 🐞🐞🐞</h2>
</p>

<p align="justify">📌 This reade.me, we will introduce the definitions of each of the test smells and present examples of these test smells. </i>  </p>

<p align="center">
 <h2>Test smells 🐞</h2>
</p>

* <b>Assertion Roulette (AR):</b>
  It occurs when multiple assertion statements are present in a test method without any explanation or parameter in the assertion
   method, it can cause confusion and make it difficult to identify which assertion has failed if the test fails (Van Deursen et. al, 2001).
    * <b>Detection:</b> A test method that contains multiple assertion statements without an argument as a parameter.
    * <b>Exemple:</b> Listing 1 presents a test method containing AR (lines from 13 to 16). The example presents a method of test class AuthenticationTests of the [hsweb-framework](https://github.com/hs-web/hsweb-framework.git) project.

```java
1  public class AuthenticationTests {
2
3   @Test
4   public void testInitUserRoleAndPermission() {
5        Authentication authentication = builder.user( {\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")	
6                .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")                
7                .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
8                        ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":
9                        [\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")
10                .build();
11                
12       //test user
13        assertEquals(authentication.getUser().getId(), "admin");	
14        assertEquals(authentication.getUser().getUsername(), "admin");
15        assertEquals(authentication.getUser().getName(), "Administrator");
16        assertEquals(authentication.getUser().getUserType(), "default");
17  }
18 }
```

* <b>Conditional Logic Test (CTL):</b>
  It occurs test methods contain conditional logic statements (e.g., if-else, while, for). The presence of conditions in test methods can
  alter the test's behavior and expected outcomes. Consequently, this can create scenarios in which the tests fail to uncover defects in
  the production method (PERUMA et. al, 2018).
     * <b>Detection:</b> A test method that contains one or more control statements, i.e., if, switch, conditional expression, for, foreach, or while statements.
     * <b>Exemple:</b> Listing 2 presents a test method containing CTL (lines from 8 to 10, and 12 to 15). The example presents a method of test class FastBeanCopierTest from the [javamelody](https://github.com/javamelody/javamelody) project.

``` java
1  public class TestCounterStorage {
2  @Test
3  public void testDeleteObsoleteCounterFiles() throws IOException {
4 	 final Counter counter = new Counter("http", null);
5 	 counter.setApplication("test counter");
6 	 final File storageDir = Parameters.getStorageDirectory(counter.getApplication());
7 	 final File obsoleteFile = new File(storageDir, "obsolete.ser.gz");
8 	 final File notObsoleteFile = new File(storageDir, "notobsolete.ser.gz");
9 	 checkSetup(storageDir, obsoleteFile, notObsoleteFile); \\ setup logic
10	 final Calendar nowMinus1YearAnd2Days = Calendar.getInstance();
11	 nowMinus1YearAnd2Days.add(Calendar.YEAR, -1);
12	 nowMinus1YearAnd2Days.add(Calendar.DAY_OF_YEAR, -2);
13	 if (!obsoleteFile.setLastModified(nowMinus1YearAnd2Days.getTimeInMillis())) {
14	 	fail("setLastModified");
15	 }
16
17	 CounterStorage.deleteObsoleteCounterFiles(counter.getApplication());
18
19	 // le fichier doit avoir été supprimé
20	 if (obsoleteFile.exists()) {
21	 	fail("obsolete file still exists");
22	 }
23	 if (!notObsoleteFile.delete()) {
24	 	notObsoleteFile.deleteOnExit();
25	 }
26
27	 Utils.setProperty(Parameter.OBSOLETE_STATS_DAYS, "1");
28	 CounterStorage.deleteObsoleteCounterFiles(counter.getApplication());
29 }
```

 
* <b>Duplicate Assert (DA):</b>
  It occurs when a test method checks the same assertion more than once in the same method but with different values.
  When a test method has multiple assertions that are repeated, it can make the purpose of the method harder to comprehend PERUMA, 2018).
    * <b>Detection:</b> In the test method, there is more than one assertion statement with the same parameters.
    * <b>Exemple:</b>  Listing 3 presents a test method containing DA (lines from 9 to 13). The example presents a method of test class HashMapTwoFactorTokenManagerTest from the [hsweb-framework](https://github.com/hs-web/hsweb-framework.git) project.

  ``` java
  1 public class HashMapTwoFactorTokenManagerTest {
  2  HashMapTwoFactorTokenManager tokenManager = new HashMapTwoFactorTokenManager();
  3
  4  @Test
  5  @SneakyThrows
  6  public void test() {
  7      TwoFactorToken twoFactorToken = tokenManager.getToken("test", "test");
  8
  9       Assert.assertTrue(twoFactorToken.expired());
  10      twoFactorToken.generate(1000L);
  11      Assert.assertFalse(twoFactorToken.expired());
  12      Thread.sleep(1100);
  13      Assert.assertTrue(twoFactorToken.expired());
  14  }
  15 }

  ```
  
  
* <b>Resource Optimism (RO):</b>
  The test method uses a resource without first checking its state. It's important to be cautious when testing code
  that relies on external resources like directories or database tables. Assuming that these resources exist or are in a certain state can
  lead to unpredictable results in your tests (Van Deursen et. al, 2001).
    * <b>Detection:</b> Test method contains an instance of a File class without calling the methods exists(), isFile(), or noExists() methods of the object.
    * <b>Exemple:</b> Listing 4 presents a test method containing RO (Lines from 2 to 15). The example presents a method of test class FileUtilsTest from the [apollo](https://github.com/apolloconfig/apollo) project.
     
  ``` java
  1 public class LocalFileConfigRepositoryTest {	
  2  @Test	
  3  public void testLoadConfigWithLocalFileAndFallbackRepo() throws Exception {
  4    File file = new File(someBaseDir, assembleLocalCacheFileName());
  5 
  6     String someValue = "someValue";
  7 
  8     Files.write(defaultKey + "=" + someValue, file, Charsets.UTF_8);
  9 
  10    LocalFileConfigRepository localRepo = new LocalFileConfigRepository(someNamespace, upstreamRepo);
  11    localRepo.setLocalCacheDir(someBaseDir, true);
  12 
  13    Properties properties = localRepo.getConfig();
  14 
  15    assertEquals(defaultValue, properties.getProperty(defaultKey));
  16  }
  ```
  
* <b>Sleepy Test (ST):</b>
  It occurs when the test method pauses for a certain period by simulating or waiting for an external event (using Thread.sleep()),
  and then continues execution usually (PERUMA et. al, 2018).
    * <b>Detection:</b> A test method that invokes the \textit{Thread.sleep()} method.
    * <b>Exemple:</b> Listing 5 presents a test method containing ST (line 12). The example presents a method of test class DefaultTimeoutMapTest from the [pache/camel](https://github.com/apache/camel.git) project.
      
  ``` java
  1 public class DefaultTimeoutMapTest {
  2
  3  @Test
  4  public void testDefaultTimeoutMapPurge() throws Exception {
  5      DefaultTimeoutMap<String, Integer> map = new DefaultTimeoutMap<>(executor, 100);
  6      map.start();
  7      assertTrue(map.currentTime() > 0);
  8      assertEquals(0, map.size());
  9      map.put("A", 123, 50);
  10     assertEquals(1, map.size());
  11
  12      Thread.sleep(250);
  13      if (map.size() > 0) {
  14          LOG.warn("Waiting extra due slow CI box");
  15          Thread.sleep(1000);
  16      }
  17
  18      assertEquals(0, map.size());
  19
  20      map.stop();
  21  }
  22 }
  ```

  
* <b>Unknown Test (UT):</b>
  It occurs when the test method that does not contain assertion. An assertion statement describes an expected condition
  for a test method (PERUMA et. al, 2018).
    * <b>Detection:</b>  A test method does not contain a single assertion statement and \textbf{@Test} (expected) annotation parameter.
    * <b>Exemple:</b> Listing 6 presents a test method containing UT (lines from 2 to 15). The example presents a method of test class RedisUserTokenManagerTest from the [hsweb-framework](https://github.com/hs-web/hsweb-framework.git) project.
      
  ``` java
  1 public class JooqXMLTest extends BaseJooqTest {
  2  @Test
  3  public void testExecute() {
  4      ProducerTemplate producerTemplate = context.createProducerTemplate();
  5      producerTemplate.sendBody(context.getEndpoint("direct:execute"), ExchangePattern.InOut, "empty");
  6  }
  7 }
  ```

  
