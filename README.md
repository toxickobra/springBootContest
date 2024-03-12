What all feature it has 

(GET) get all cart - localhost:8080/carts 
returns all the cart items
(GET) get single cart - localhost:8080/carts/{id}
returns single cart with id 
(GET) get cart by user id - localhost:8080/carts/user/{id}
returns user cart with user id
(POST) add new cart - localhost:8080/carts
add new cart to current cart
(PATCH) update cart - localhost:8080/carts/{id}
update existing cart at id
(PUT) replace cart - localhost:8080/carts/{id}
replace cart with body at id
(GET) get cart within date range - localhost:8080/carts?startDate={startDate}&endDate={endDate}
return all the cart within date range

you can simply run and after it you can either use browser or postman to use the functionallity
