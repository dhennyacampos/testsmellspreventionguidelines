🔙 <a href="README.md">Back to previous page</a> 


<p align="center">
 <h2>Test codre prevention</h2>
</p>


* <b>Assertion Roulette (AR):</b>
     * <b>Prevention 1:</b> Splitting into several methods.
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
     * <b>Prevention 2:</b>
       ``` java
       ```
     * <b>Prevention 3:</b>
       ``` java
       ```
* <b>Conditional Logic Test (CTL):</b>
     * <b>Prevention 1:</b>
       ``` java
       ```
     * <b>Prevention 2:</b>
       ``` java
       ```
   * <b>Prevention 3:</b>
       ``` java
       ```
* <b>Duplicate Assert (DA):</b>
     * <b>Prevention 1:</b>
       ``` java
       ```
     * <b>Prevention 2:</b>
       ``` java
       ```
     * <b>Prevention 3:</b>
       ``` java
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
