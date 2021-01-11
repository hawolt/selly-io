## SellyIO

A simple to use Selly API wrapper for Java. This library makes it easy to interact with Selly in your apps.

## Disclaimer

This product is not endorsed, certified or otherwise approved in any way by Selly.

## Note

Current version does not automatically handle rate-limits

## Maven

```xml
<dependency>
  <groupId>com.github.hawolt</groupId>
  <artifactId>selly-io</artifactId>
  <version>Tag</version>
</dependency>
```
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```

## Example Usage

```java
import com.hawolt.Selly;
import com.hawolt.impl.Orders;
import com.hawolt.impl.Payments;
import com.hawolt.objects.Order;
import com.hawolt.objects.creator.PaymentCreator;
import com.hawolt.pagination.Pagination;

import java.io.IOException;
import java.util.List;

public class SellyExample {
    public static void main(String[] args) {
        Selly selly = Selly.authenticate(args[0], args[1]);
        /*
         * Iterating all orders
         */
        Orders orders = selly.getOrders();
        try {
            Pagination<Order> pagination = orders.getAll();
            while (pagination.hasNext()) {
                List<Order> list = pagination.next();
                for (Order order : list) {
                    System.out.println(order.getCustomerEmail());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * Creating a Payment
         */
        Payments payments = selly.getPayments();
        PaymentCreator creator = PaymentCreator.builder()
                .setTitle("Product Title")
                .setGateway("PayPal")
                .setCustomerEmail("customer@email.com")
                .setValue(4.99D)
                .setCurrency("EUR")
                .setIpAddress("123.211.123.211")
                .setReturnUrl("http://example.com")
                .setWhitelabel(true)
                .setWebhookUrl("https://mycoolwebhook.com")
                .build();
        try {
            payments.create(creator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
