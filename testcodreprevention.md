🔙 <a href="README.md">Back to previous page</a> 


<p align="center">
 <h2>Test codre prevention</h2>
</p>


* <b>Assertion Roulette (AR):</b>
     * <b>Prevention 1:</b> Splitting into several methods into others to avoid multiple assertions within the same test method.
       ``` java
       package storage;
       
       public class AuthenticationTests {

        @Test
        public void testInitUserRole_ID() {
            Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
                    .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")

                    .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
                            ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")

                    .build();

            //test user
            assertEquals(authentication.getUser().getId(), "admin");
        }

        @Test
        public void testInitUserRole_Name() {
            Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
                    .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")

                    .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
                            ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")

                    .build();

            //test user
            assertEquals(authentication.getUser().getUsername(), "admin");
        }

        @Test
        public void testInitUserRole_FullName() {
            Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
                    .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")

                    .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
                            ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")

                    .build();

            assertEquals(authentication.getUser().getName(), "Administrator");
        }
       } 
       ```
     * <b>Prevention 2:</b> Including the explanation parameter.
       ``` java
        package storage;

        public class MetodoSetupExtracaoAssertions {
        @Test
        public void testInitUserRoleAndPermission() {
            Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
                    .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")

                    .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
                            ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")

                    .build();

            //test user
           assertEquals("Mensagem explanatória 01", authentication.getUser().getId(),"admin");
           assertEquals("Mensagem explanatória 02",authentication.getUser().getUsername(),"admin");
           assertEquals("Mensagem explanatória 03",authentication.getUser().getName(),"Administrator");
           assertEquals("Mensagem explanatória 04",authentication.getUser().getUserType(), "default")

        }

       ```
     * <b>Prevention 3:</b> Put the setup into a specific method.
       ``` java
         package storage;

         public class AuthenticationTests {

         @Before
         public void setUp(){
            Authentication authentication = builder.user("{\"id\":\"admin\",\"username\":\"admin\",\"name\":\"Administrator\",\"userType\":\"default\"}")
                    .role("[{\"id\":\"admin-role\",\"name\":\"admin\"}]")

                    .permission("[{\"id\":\"user-manager\",\"actions\":[\"query\",\"get\",\"update\"]" +
                            ",\"dataAccesses\":[{\"action\":\"query\",\"field\":\"test\",\"fields\":[\"1\",\"2\",\"3\"],\"scopeType\":\"CUSTOM_SCOPE\",\"type\":\"DENY_FIELDS\"}]}]")

                    .build();
        }
        @Test
        public void testInitUserRole_ID() {
            assertEquals(authentication.getUser().getId(), "admin");
        }

        @Test
        public void testInitUserRole_Name() {
            assertEquals(authentication.getUser().getUsername(), "admin");
        }

        @Test
        public void testInitUserRole_FullName() {
            assertEquals(authentication.getUser().getName(), "Administrator");
        }

        @Test
        public void testInitUserRole_Default() {
            assertEquals(authentication.getUser().getUserType(), "default");
        }
       }
       ```
* <b>Conditional Logic Test (CTL):</b>
     * <b>Prevention 1:</b> Splitting the method into more methods to reach the conditional structures.
       ``` java
       ```
     * <b>Prevention 2:</b> Abstraction of the content of the conditional structure in an auxiliary method.
       ``` java
       ```
* <b>Duplicate Assert (DA):</b>
     * <b>Prevention 1:</b> Dividing the original method into more test methods for each new value that the variable assumes.
       ``` java
             public class HashMapTwoFactorTokenManagerTest {
         HashMapTwoFactorTokenManager tokenManager = new HashMapTwoFactorTokenManager();
         TwoFactorToken twoFactorToken = tokenManager.getToken("test", "test");
     
         @Test
         @SneakyThrows
         public void test() {
             Assert.assertTrue(twoFactorToken.expired());
         }
         
         @Test
         @SneakyThrows
         public void test() {
             twoFactorToken.generate(1000L);
             Assert.assertFalse(twoFactorToken.expired());
         }
         
             @Test
         @SneakyThrows
         public void test() {
             twoFactorToken.generate(1000L);
             Thread.sleep(1100);
             Assert.assertTrue(twoFactorToken.expired());
         }
       }
       ```

* <b>Resource Optimism (RO):</b>
     * <b>Prevention 1:</b>
       ``` java
       ```
    * <b>Prevention 2:</b>
       ``` java
       ```
     * <b>Prevention 3:</b>
       ``` java
       ```
* <b>Sleepy Test (ST):</b>
     * <b>Prevention 1:</b>
       ``` java
       ```
     * <b>Prevention 2:</b>
       ``` java
       ```
    * <b>Prevention 3:</b>
       ``` java
       ```
* <b>Unknown Test (UT):</b>
     * <b>Prevention 1:</b>
       ``` java
       ```
     * <b>Prevention 2:</b>
       ``` java
       ```
     * <b>Prevention 3:</b>
       ``` java
       ```
