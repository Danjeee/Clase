let $libro := /bookstore/book
for $libto in /bookstore/book
return <libro>{$libro/title} <cantidad_libros_total>{count($libro)}</cantidad_libros_total></libro>