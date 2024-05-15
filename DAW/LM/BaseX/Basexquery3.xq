let $libro := /bookstore/book
return <precios><max>{max($libro/price)}</max><min>{min($libro/price)}</min></precios>