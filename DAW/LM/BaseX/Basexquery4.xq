for $l in /bookstore/book
return
<libro>
  <tit>{$l/title/text()}</tit>
  <precio>{$l/price/text()}</precio>
  <precioiva>{ xs:double($l/price) + xs:double(xs:double($l/price)*xs:double(21)/xs:double(100)) }</precioiva>
</libro>
