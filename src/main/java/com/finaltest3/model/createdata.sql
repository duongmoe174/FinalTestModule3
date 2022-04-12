create database quanlisanpham;
use quanlisanpham;
create table category (
    id int auto_increment primary key not null ,
    name varchar(50) unique not null
);
create table product(
    id int auto_increment primary key not null ,
    name varchar(50),
    number int,
    price float,
    color varchar(50),
    description varchar(500),
    category_id int,
    foreign key (category_id) references category(id)
);
DELIMITER //
create procedure selectAllProduct()
begin
    select p.id as id_product,
           p.name as name_product,
           p.number as number,
           p.price as price,
           p.color as color,
           p.description as description,
           c.name as name_category
           from product p join quanlisanpham.category c on c.id = p.category_id;
end //
DELIMITER ;

DELIMITER //
create procedure insertNewProduct(
IN  p_name varchar(50),
IN p_number int,
IN p_price float,
IN p_color varchar(50),
IN p_description varchar(500),
IN p_category int
)
begin
    insert into product (name, number, price, color, description, category_id) VALUES (p_name, p_number, p_price, p_color, p_description, p_category);
end //
DELIMITER ;

DELIMITER //
create procedure getProductById(IN  p_id int)
begin
    select name, number, price, color, description from product where id = p_id;
end //
DELIMITER  ;

DELIMITER //
create procedure deleteProductById (IN p_id int)
begin
    delete from product where  id = p_id;
end //
DELIMITER ;

DELIMITER //
create procedure updateProduct(
    IN p_id int,
    IN  p_name varchar(50),
    IN p_number int,
    IN p_price float,
    IN p_color varchar(50),
    IN p_description varchar(500),
    IN p_category int
)
begin
    update product set name = p_name, number = p_number, price = p_price, color = p_color, description = p_description, category_id = p_category
    where id = p_id;
end //
DELIMITER  ;

DELIMITER //
create procedure getCategoryById (IN c_id int)
begin
    select name from category where id = c_id;
end //
DELIMITER ;

DELIMITER //
create procedure selectAllCategory()
begin
    select * from category;
end //
DELIMITER ;