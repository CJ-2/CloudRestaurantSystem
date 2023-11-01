# CloudRestaurantSystem
Here is a brief overview of the main functionalities:

1. Ordering: Users can select items from the menu and place an order. The program keeps track of the total cost and time for each order.

2. Kitchen Status: The program allows the kitchen staff to prepare orders. They can view the list of orders and mark them as completed.

3. Drinks Vending Machine: Users can choose from a selection of drinks (juice, cola, water) from a vending machine.

4. Basket: Users can view and manage their current order by deleting items or deleting the entire order.

5. Admin: The admin has access to additional functionalities such as viewing total sales, managing item quantities, editing quantities, viewing order history, and filling item quantities.

6. Discount: The program allows the admin to apply a discount to a specific order.

7. Menu: Users can view the menu, which is organized into categories and items.

8. Add New Item: The admin can add a new item to the menu by providing the category ID, item ID, name, cost, preparing time, and quantity.
9. 9. Total Sales: The admin can view the total sales made by the restaurant.

10. Quantity Management: The admin can view the quantity of each item in the menu.

11. Edit Quantity: The admin can edit the quantity of a specific item in the menu.

12. History Orders: The admin can view the history of completed orders.

13. Fill Quantity: The admin can fill the quantity of all items in the menu.

The program utilizes a queue data structure to manage orders in the kitchen. Orders are enqueued when placed and dequeued when they are prepared.

The code also includes helper methods such as findCategoryById to find a category by its ID and menu to display the menu.

The program is designed to be run from the main method in the RestaurantSystem.java file.
