CREATE TABLE IF NOT EXISTS sales_data(
    id serial,
	purchaser_name varchar not null,
	item_description varchar not null,
	item_price decimal(10, 1) not null,
	purchase_count int not null,
	merchant_address varchar not null,
	merchant_name varchar not null
);