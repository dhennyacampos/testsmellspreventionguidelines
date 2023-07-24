🔙 <a href="README.md">Back to previous page</a> 


<p align="center">
 <h2>Test codre prevention</h2>
</p>


* <b>Assertion Roulette (AR):</b>
     * <b>Prevention 1:</b> Splitting into several methods into others to avoid multiple assertions within the same test method.
     * <b>Exemple:</b>
       
       ``` java
       1 package storage;
       2
       3 public class AuthenticationTests {
       4
       5 @Test
       6 public void testInitUserRole_ID() {
       7     Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
       8             .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")
       9
       10             .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
       11                     ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")
       12
       13             .build();
       14 
       15     //test user
       16     assertEquals(authentication.getUser().getId(), "admin");
       17 }
       17 
       18 @Test
       19 public void testInitUserRole_Name() {
       20     Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
       21             .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")
       22
       23             .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
       24                     ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")
       25
       26             .build();
       27
       28     //test user
       29     assertEquals(authentication.getUser().getUsername(), "admin");
       30 }
       31
       32 @Test
       33 public void testInitUserRole_FullName() {
       34     Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
       35             .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")
       36
       37             .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
       38                     ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")
       39
       40             .build();
       41
       42     assertEquals(authentication.getUser().getName(), "Administrator");
       43 }
       44 } 
       ```
     * <b>Prevention 2:</b> Including the explanation parameter.
     * <b>Exemple:</b>
       
       ``` java
       1 package storage;
       2
       3 public class MetodoSetupExtracaoAssertions {
       4 @Test
       5 public void testInitUserRoleAndPermission() {
       6     Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
       7             .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")
       8 
       9            .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
       10                     ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")
       11 
       12             .build();
       13
       14    //test user
       15    assertEquals("Mensagem explanatória 01", authentication.getUser().getId(),"admin");
       16    assertEquals("Mensagem explanatória 02",authentication.getUser().getUsername(),"admin");
       17    assertEquals("Mensagem explanatória 03",authentication.getUser().getName(),"Administrator");
       18    assertEquals("Mensagem explanatória 04",authentication.getUser().getUserType(), "default")
       19
       20 }
       ```
     * <b>Prevention 3:</b> Put the setup into a specific method.
     * <b>Exemple:</b>
       
       ``` java
        1 package storage;
        2
        3 public class AuthenticationTests {
        4
        5 @Before
        6 public void setUp(){
        7    Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
        8            .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")
        9
        10            .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
        11                    ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")
        12
        13            .build();
        14 }
        15 @Test
        16 public void testInitUserRole_ID() {
        17    assertEquals(authentication.getUser().getId(), "admin");
        19 }
        20
        21 @Test
        22 public void testInitUserRole_Name() {
        23    assertEquals(authentication.getUser().getUsername(), "admin");
        24 }
        25
        26 @Test
        27 public void testInitUserRole_FullName() {
        28    assertEquals(authentication.getUser().getName(), "Administrator");
        29 }
        30
        31 @Test
        32 public void testInitUserRole_Default() {
        33    assertEquals(authentication.getUser().getUserType(), "default");
        34 }
        35 }
       ```
* <b>Conditional Logic Test (CTL):</b>
     * <b>Prevention 1:</b> Splitting the method into more methods to reach the conditional structures.
     * <b>Exemple:</b>
       
``` java
1  public class CounterStorageTest {
2     @Test
3     public void testDeleteObsoleteCounterFiles() throws IOException {
4         final Counter counter = new Counter("http", null);
5         counter.setApplication("test counter");
6         final File storageDir = Parameters.getStorageDirectory(counter.getApplication());
7         final File obsoleteFile = new File(storageDir, "obsolete.ser.gz");
8         final File notObsoleteFile = new File(storageDir, "notobsolete.ser.gz");
9         checkSetup(storageDir, obsoleteFile, notObsoleteFile); \\ setup logic
10
11         setLastModified(obsoleteFile); \\ ensure that the obsoleteFile has a modified timestamp
12
13         CounterStorage.deleteObsoleteCounterFiles(counter.getApplication());
14
15         assertObsoleteFileIsDeleted(obsoleteFile);
16         assertNotObsoleteFileIsDeleted(notObsoleteFile);
17
18         Utils.setProperty(Parameter.OBSOLETE_STATS_DAYS, "1");
19         CounterStorage.deleteObsoleteCounterFiles(counter.getApplication());
20    }
21
22    @Test
23    private void setLastModified(File file) {
24         Calendar nowMinus1YearAnd2Days = Calendar.getInstance();
25         nowMinus1YearAnd2Days.add(Calendar.YEAR, -1);
26         nowMinus1YearAnd2Days.add(Calendar.DAY_OF_YEAR, -2);
27
28         assertThrows("Failed to set last modified timestamp",
29               () -> file.setLastModified(nowMinus1YearAnd2Days.getTimeInMillis()));
30    }
31
32    @Test
33    private void assertObsoleteFileIsDeleted(File obsoleteFile) {
34          Assert.assertFalse("Obsolete file still exists", obsoleteFile.exists());
35    }
36
37    @Test
38    private void assertNotObsoleteFileIsDeleted(File notObsoleteFile) {
39         Assert.assertTrue("Not obsolete file was not deleted", notObsoleteFile.delete());
40    }
41 }
```

 * <b>Prevention 2:</b> Abstraction of the content of the conditional structure in an auxiliary method.
 * <b>Exemple:</b> 

``` java
1  public class CounterStorageTest {
2
3     @Test
4     public void testDeleteObsoleteCounterFiles() throws IOException {
5         final Counter counter = new Counter("http", null);
6         counter.setApplication("test counter");
7         final File storageDir = Parameters.getStorageDirectory(counter.getApplication());
8         final File obsoleteFile = new File(storageDir, "obsolete.ser.gz");
9         final File notObsoleteFile = new File(storageDir, "notobsolete.ser.gz");
10        checkSetup(storageDir, obsoleteFile, notObsoleteFile); \\ setup logic
11
12        assertThrows("Failed to set last modified timestamp",
29               () -> setLastModified(obsoleteFile));
30
31        CounterStorage.deleteObsoleteCounterFiles(counter.getApplication());
32
33        // Assertions
34        assertThat("Obsolete file was not deleted", assertObsoleteFileIsDeleted(obsoleteFile), equalTo(true));
35        assertThat("Not obsolete file was not deleted", assertNotObsoleteFileIsDeleted(notObsoleteFile), equalTo(true));
36
37        Utils.setProperty(Parameter.OBSOLETE_STATS_DAYS, "1");
38        CounterStorage.deleteObsoleteCounterFiles(counter.getApplication());
39
40    }
41
42    private void setLastModified(File file) {
43        Calendar nowMinus1YearAnd2Days = Calendar.getInstance();
44        nowMinus1YearAnd2Days.add(Calendar.YEAR, -1);
45        nowMinus1YearAnd2Days.add(Calendar.DAY_OF_YEAR, -2);
46
47        return !file.setLastModified(nowMinus1YearAnd2Days.getTimeInMillis());
48    }
49
50    private boolean assertObsoleteFileIsDeleted(File obsoleteFile) {
51        return !obsoleteFile.exists();
52    }
53
54    private boolean assertNotObsoleteFileIsDeleted(File notObsoleteFile) {
55        return notObsoleteFile.delete();
56    }
57
58 }
```

* <b>Duplicate Assert (DA):</b>
 * <b>Prevention 1:</b> Dividing the original method into more test methods for each new value that the variable assumes.
 * <b>Exemple:</b>
       
       ``` java
       1 public class HashMapTwoFactorTokenManagerTest {
       2   HashMapTwoFactorTokenManager tokenManager = new HashMapTwoFactorTokenManager();
       3   TwoFactorToken twoFactorToken = tokenManager.getToken("test", "test");
       4  @Test
       5  @SneakyThrows
       6  public void test() {
       7      Assert.assertTrue(twoFactorToken.expired());
       8  }
       9  
       10 @Test
       11 @SneakyThrows
       12 public void test() {
       13      twoFactorToken.generate(1000L);
       14      Assert.assertFalse(twoFactorToken.expired());
       15  }
       16  
       17 @Test
       18 @SneakyThrows
       19 public void test() {
       20      twoFactorToken.generate(1000L);
       21      Thread.sleep(1100);
       22      Assert.assertTrue(twoFactorToken.expired());
       23  }
       24 }
       ```

* <b>Resource Optimism (RO):</b>
     * <b>Prevention 1:</b> Using abstractions for the resource (e.g., mock).
     * <b>Exemple:</b>
       
       ``` java
       ```
    * <b>Prevention 2:</b> Creating the resource using the setup method.
    * <b>Exemple:</b>
      
       ``` java
       ```
     * <b>Prevention 3:</b> Using JUnit resources to handle temporary files.
     * <b>Exemple:</b>
       
       ``` java
       ```
    * <b>Prevention 4:</b> Splitting into more tests to verify a possible exception launch.
    * <b>Exemple:</b>
      
       ``` java
       ```
* <b>Sleepy Test (ST):</b> 
     * <b>Prevention 1:</b> Using an intelligent waiting library (e.g., Awaitility)
     * <b>Exemple:</b>
       
       ``` java
        1 public class DefaultTimeoutMapTest {
        2 
        3 @Test
        4 public void testDefaultTimeoutMapPurge() throws Exception {
        5      DefaultTimeoutMap<String, Integer> map = new DefaultTimeoutMap<>(executor, 100);
        6      map.start();
        7      assertTrue(map.currentTime() > 0);
        8      assertEquals(0, map.size());
        9      map.put("A", 123, 50);
        10     assertEquals(1, map.size());
        11  
        12      await().atMost(Duration.ofSeconds(2))
        13              .untilAsserted(() -> assertEquals(0, map.size()));
        14 
        15      map.stop();
        26   }
        27 }
       ```
     * <b>Prevention 2:</b>  Make the request asynchronous (e.g., mock);
     * <b>Exemple:</b>
       
       ``` java
       ```
    * <b>Prevention 3:</b> Separate it in a method with a test step in a more indicative place.
    * <b>Exemple:</b>
      
       ``` java
       ```
    * <b>Prevention 4:</b> Ordering the tests’ execution, adding tests containing thread.Sleep command at the end of the test suite.
    * <b>Exemple:</b>
      
       ``` java
       ```
* <b>Unknown Test (UT):</b>
     * <b>Prevention 1:</b> Including an assertion in the test method.
     * <b>Exemple:</b>
       
       ``` java
       1 public class JooqXMLTest extends BaseJooqTest {
       2  @Test
       3  public void testExecute() {
       4       ProducerTemplate producerTemplate = context.createProducerTemplate();
       5       Endpoint ep = context.getEndpoint("direct:execute");
       6       assertDoesNotThrow(() -> producerTemplate.sendBody(ep, ExchangePattern.InOut, "empty"));
       7      }
       8 }
       ```
     * <b>Prevention 2:</b> Removing this test method depending on its purpose (or lack of purpose).

