🔙 <a href="README.md">Back to previous page</a> 


<p align="center">
 <h2>Task Store</h2>
</p>

## Production classes description

1) Product:
- A Product represents an item available in an online store. 
- Each Product has various attributes like dimensions, SKU, manufacturer, type, etc. 
- It has a set of ProductDescription instances that provide details about the product in different languages. 
- It is associated with one or more Category instances, indicating the categories to which the product belongs. 

2) MerchantStore:
- A MerchantStore represents an online store. 
- It serves as the context for products and categories, indicating which products and categories belong to which store.

3) Category:
- A Category represents a product category or classification.
- Each Category has a set of CategoryDescription instances that provide details about the category in different languages.
- It can have child categories, indicating a hierarchical structure.
- It can have parent categories, indicating its position in the hierarchy.
- It is associated with one or more Product instances, indicating the products that belong to the category.

4) category description:
- A CategoryDescription provides details about a category in a specific language.
- It is associated with a Category, indicating the category it describes.




## Task #1 - Verifying Product Categorization in an Online Store

*Description:* 
Diagram #1 presents the relationship between the Product, MerchantStore, Category, and CategoryDescription.
Our goal is to verify that product categorization within an online store is functioning correctly.

*Rationale:* The developer has to test the creation of two different categories. The developer can create one test method to test each category separately or test both of them in one test method.
If the developer decides to create only one test method, then we expect a Duplicate Assert test smell because the same structures are being tested with different values. 

Diagram 1 - Relationship between products, merchant and categories ![Diagram #1](/diagrams/Store-Task1.png)

*Test Steps:*
Please, use the `MerchantStore` object to test the scenarios of creating different category of products for a store. 
1. A store with one category of products
   2. Create a `Category` of objects called `book` and set it into the `MerchantStore`
   2. Create a `Set` of `CategoryDescription` objects and add two books. 
   3. Insert the `Set` of `CategoryDescription` into book category 
   4. Insert the `MerchantStore` object into `Product` object; 
   4. Check the if the number of categories into the object `Product` is equal to 2
1. Expand the store with another category of products 
   2. Create a `Category` of objects called `music` and set it into the `MerchantStore`
   3. Create a `Set` of `CategoryDescription` objects and add two discographies.
   3. Insert the `Set` of `CategoryDescription` into the music category 
   4. Insert the `MerchantStore` object into `Product` object
   4. Check the if the number of categories into the object `Product` is equal to 4
   
## Task #2 - Verifying Image Insertion for a Product

*Description:*
Diagram #2 presents the relationship between the Product and ProductImage.
Our goal is to verify that an image can be successfully inserted into a product's list of images.

*Rationale:* The developer has to set a local file into a product. 
If the developer does not check the existence of the file before using it, he will insert a Resource Optimist test smell.

Diagram 2 - Relationship between products and images ![Diagram #2](/diagrams/Store-Task2.png)

*Test steps:*
Please, create a test method called `testInsertImage` to insert a local file into a product.
1. Specify the path to the image file you want to read.  
2. Create the `File` object representing the file you want to read.
3. Use the `FileInputStream` - an external Java class - to create an `InputStream` object that reads from the specified file (e.g., `InputStream inputStream = new FileInputStream(file);`).
4. Create an `ProductImage` object. Then set the image as an `InputStream` object, set the `Product` object, and other attributes you may find necessary.
5. Insert the `ProductImage` object into the list of images (`Set<ProductImage>`) of the `Product` object.
6. Check whether the `Product` constains the `ProductImage`.  


## Task #3: Verifying Product Availability After Order

*Description:*
Diagram #3 presents the relationship between the Product and ProductAvailability.
Our goal is to verify that the product availability decreases as expected after orders are placed.

*Rationale:* The store has 100 items of a product and 5 consumers will order 20 items of it. The developer has to decrease 20 from 100 items until there are not more items to sell.  
We expect developers to create a condition to check whether it there is enough products to place a new order. 
In addition, we expect developers to create a loop to simulate the orders. Therefore, the developer may insert two Conditional Test Logic test smells. 

Diagram 3 - Relationship between products and products availability ![Diagram #3](/diagrams/Store-Task3.png)

*Test steps:*
The `ProductAvailabilityTest` class contains two fields that are initialized in the `setup` method. 
Please, use those fields to develop a test method called `testOrderDecreasesProductAvailability`. The test method should simulate orders of 20 items of a product. 
Note that the store has 100 items available of such products.
1. Simulate an order by decreasing the `productQuantity` of the `ProductAvailability` object by the test order quantity.
2. Retrieve the updated `productQuantity` value after the order.
3. Verify whether the updated `productQuantity` value matches the initial value minus the test order quantity.

## Task 4: Asynchronous Email Notification

*Description:*
Diagram #4 presents the class `OrderFacadeImpl` to deal with asyncronous events.
Our goal is to verify that the `notify` method properly sends order confirmation emails to customers and merchants asynchronously.

*Rationale:* The developer has to use some structure to wait for the order to be sent via email.
We expect the test method to have a Sleep Test test smell.

Diagram 3 - Relationship between products and products availability ![Diagram #4](/diagrams/Store-Task4.png)

*Test steps:*
The `testNotifyMethod` provides some dummy configuration to call the `notify` production method. 
In addition, it provides Autowire an instance of the `AsyncService` class to the test.
Please, use this initial configuration to verify whether the email is sent following the steps:
1. Call the `notifyA` method of the `AsyncService` class to start the asynchronous method.
2. Simulate the asynchronous processing by waiting for 3 seconds.
3. Verify that the `isEmailSent` method of the `AsyncService` class returns true, indicating that the email was sent.


> Note that the Assertion Roulette and Unknown Test test smells can occur in any of the tasks but they cannot occur in the same task. 
> If the developer uses two assertions without explanation messages, it will result in an Assertion Roulette test smell.
> If the developer does not use assertions, it will result in an Unknown Test test smell.
> Therefore, the correct way is to use assertions with an explanatory message.

<p align="center">
 <h2>Task Calculator</h2>
</p>

