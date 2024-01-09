create database task2;
<br/>
use task2;

----
 
create table order_info(   <br/>
	order_id int auto_increment primary key, <br/>
    customer_name varchar(40) not null,  <br/>
    product_id int not null,    <br/>
    order_qty int not null,    <br/>
    total_amount double    <br/>
    );
    
 ----   

    create table product_info(
		product_id int primary key,
        product_name varchar(40),
        product_qty int not null,
        product_price double
        );
        
  <br/>
  insert into product_info values(1013,'TV',4,12000),(1014,'AC',2,45000);

----    
    
delimiter // 

create procedure placeOrder( <br/>
    in cName varchar(30),  <br/>
    in proId int,      <br/>
    in orderQty int,    <br/>
    out sts boolean    <br/>
)    <br/>
begin    <br/>
    declare pQty int;    <br/>
    declare pPrice double;

    select product_qty, product_price into pQty, pPrice from product_info where product_id = proId;

    if pQty >= orderQty and orderQty > 0 then
        
        insert into order_info(customer_name, product_id, order_qty, total_amount)
        values(cName, proId, orderQty, orderQty * pPrice);
        
        update product_info set product_qty = product_qty - orderQty where product_id = proId;
        
        set sts = true;
    else
        set sts = false; 
    end if;
end //

delimiter ;
----


delimiter //
create procedure displayAllOrder(in cName varchar(30), out totalBill double) <br/>
begin    <br/>
	 select * from order_info where customer_name  = cName;    <br/>
    select sum(total_amount) into totalBill from order_info where customer_name = cName;    <br/>
end //      <br/>

delimiter ;
----
