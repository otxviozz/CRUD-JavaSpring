CREATE table product (
	id TEXT PRIMARY KEY UNIQUE NOT NULL,
	name TEXT NOT NULL,
	price_in_cents NUMBER NOT NULL
)