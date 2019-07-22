SELECT customer_number FROM (
    SELECT customer_number, COUNT(order_number) AS cnt FROM orders GROUP BY customer_number
) p ORDER BY cnt DESC LIMIT 1