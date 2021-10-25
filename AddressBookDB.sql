#UC1

mysql> create database Address_Book_Service;
show databases;
USE Address_Book_Service;

#UC2
mysql> CREATE TABLE  addressBook (firstName varchar(50) NOT NULL, lastName varchar(50) NOT NULL, mobileNumber varchar(20) NOT NULL,email varchar(50) NOT NULL, city varchar(50) NOT NULL, state varchar(50) NOT NULL,
 zip long NOT NULL, PRIMARY KEY(firstName));


mysql> desc addressbook;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| firstName    | varchar(50) | NO   | PRI | NULL    |       |
| lastName     | varchar(50) | NO   |     | NULL    |       |
| mobileNumber | varchar(20) | NO   |     | NULL    |       |
| email        | varchar(50) | NO   |     | NULL    |       |
| city         | varchar(50) | NO   |     | NULL    |       |
| state        | varchar(50) | NO   |     | NULL    |       |
| zip          | mediumtext  | NO   |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+


#UC3
mysql> INSERT INTO addressbook(firstName,lastName,mobileNumber,email,city,state,zip) VALUES
   ('Mohammed','Atif','9854712563','abc@gmail.com','Bangalore','Karnataka',560039),
   ('Salman','Khan','9652314750','xyz@gmail.com','Bangalore','Karnataka',560001),
   ('xyz','abc','8523697412','bca@gmail.com','Bangalore','Karnataka',560002);

mysql> select * from addressBook;
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| firstName | lastName | mobileNumber | email         | city      | state     | zip    |
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| Mohammed  | Atif     | 9854712563   | abc@gmail.com | Bangalore | Karnataka | 560039 |
| Salman    | Khan     | 9652314750   | xyz@gmail.com | Bangalore | Karnataka | 560001 |
| xyz       | abc      | 8523697412   | bca@gmail.com | Bangalore | Karnataka | 560002 |
+-----------+----------+--------------+---------------+-----------+-----------+--------+

#UC4
mysql> UPDATE addressBook set MobileNumber= "8547120325" where FirstName='Mohammed';

mysql> UPDATE addressBook set Zip= "560010" where FirstName='Mohammed';

mysql> UPDATE addressBook set State= 'Telangana' where FirstName='Mohammed';

mysql> UPDATE addressBook set City= 'Hyderabad' where FirstName='Mohammed';

mysql> select * from addressBook;
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| firstName | lastName | mobileNumber | email         | city      | state     | zip    |
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| Mohammed  | Atif     | 8547120325   | abc@gmail.com | Hyderabad | Telangana | 560010 |
| Salman    | Khan     | 9652314750   | xyz@gmail.com | Bangalore | Karnataka | 560001 |
| xyz       | abc      | 8523697412   | bca@gmail.com | Bangalore | Karnataka | 560002 |
+-----------+----------+--------------+---------------+-----------+-----------+--------+

#UC5
mysql> DELETE from addressBook where FirstName='Mohammed';

mysql> select * from addressBook;
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| firstName | lastName | mobileNumber | email         | city      | state     | zip    |
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| Salman    | Khan     | 9652314750   | xyz@gmail.com | Bangalore | Karnataka | 560001 |
| xyz       | abc      | 8523697412   | bca@gmail.com | Bangalore | Karnataka | 560002 |
+-----------+----------+--------------+---------------+-----------+-----------+--------+

#UC6
mysql> INSERT INTO addressbook(firstName,lastName,mobileNumber,email,city,state,zip) VALUES
    ('Mohammed','Atif','9854712563','abc@gmail.com','Bangalore','Karnataka',560039);

mysql> select * from addressBook;
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| firstName | lastName | mobileNumber | email         | city      | state     | zip    |
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| Mohammed  | Atif     | 9854712563   | abc@gmail.com | Bangalore | Karnataka | 560039 |
| Salman    | Khan     | 9652314750   | xyz@gmail.com | Bangalore | Karnataka | 560001 |
| xyz       | abc      | 8523697412   | bca@gmail.com | Bangalore | Karnataka | 560002 |
+-----------+----------+--------------+---------------+-----------+-----------+--------+

mysql> SELECT * from addressBook where city = 'Bangalore';
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| firstName | lastName | mobileNumber | email         | city      | state     | zip    |
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| Mohammed  | Atif     | 9854712563   | abc@gmail.com | Bangalore | Karnataka | 560039 |
| Salman    | Khan     | 9652314750   | xyz@gmail.com | Bangalore | Karnataka | 560001 |
| xyz       | abc      | 8523697412   | bca@gmail.com | Bangalore | Karnataka | 560002 |
+-----------+----------+--------------+---------------+-----------+-----------+--------+

mysql> SELECT * from addressBook where state = 'Karnataka';
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| firstName | lastName | mobileNumber | email         | city      | state     | zip    |
+-----------+----------+--------------+---------------+-----------+-----------+--------+
| Mohammed  | Atif     | 9854712563   | abc@gmail.com | Bangalore | Karnataka | 560039 |
| Salman    | Khan     | 9652314750   | xyz@gmail.com | Bangalore | Karnataka | 560001 |
| xyz       | abc      | 8523697412   | bca@gmail.com | Bangalore | Karnataka | 560002 |
+-----------+----------+--------------+---------------+-----------+-----------+--------+

#UC7
mysql> SELECT city,COUNT(city) as count from addressBook group by city;
+-----------+-------+
| city      | count |
+-----------+-------+
| Bangalore |     3 |
+-----------+-------+

mysql> SELECT state,COUNT(state) as count from addressBook group by state;
 +-----------+-------+
 | state     | count |
 +-----------+-------+
 | Karnataka |     3 |
 +-----------+-------+

#UC8
mysql> SELECT firstName,lastName from addressBook ORDER BY city;
+-----------+----------+
| firstName | lastName |
+-----------+----------+
| Mohammed  | Atif     |
| Salman    | Khan     |
| xyz       | abc      |
+-----------+----------+

#UC9
mysql> alter table addressBook add type varchar(15) after lastName ;


mysql> desc addressBook;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| firstName    | varchar(50) | NO   | PRI | NULL    |       |
| lastName     | varchar(50) | NO   |     | NULL    |       |
| type         | varchar(15) | YES  |     | NULL    |       |
| mobileNumber | varchar(20) | NO   |     | NULL    |       |
| email        | varchar(50) | NO   |     | NULL    |       |
| city         | varchar(50) | NO   |     | NULL    |       |
| state        | varchar(50) | NO   |     | NULL    |       |
| zip          | mediumtext  | NO   |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+

mysql> update addressBook set type = 'Family' where firstName = 'Mohammed';

mysql>  update addressBook set type = 'Profession' where firstName='Salman';

mysql>  update addressBook set type = 'Friend' where firstName = 'xyz';

mysql> select * from addressBook;
+-----------+----------+------------+--------------+---------------+-----------+-----------+--------+
| firstName | lastName | type       | mobileNumber | email         | city      | state     | zip    |
+-----------+----------+------------+--------------+---------------+-----------+-----------+--------+
| Mohammed  | Atif     | Family     | 9854712563   | abc@gmail.com | Bangalore | Karnataka | 560039 |
| Salman    | Khan     | Profession | 9652314750   | xyz@gmail.com | Bangalore | Karnataka | 560001 |
| xyz       | abc      | Friend     | 8523697412   | bca@gmail.com | Bangalore | Karnataka | 560002 |
+-----------+----------+------------+--------------+---------------+-----------+-----------+--------+

mysql> select type, Count(type) from addressBook group by type;
+------------+-------------+
| type       | Count(type) |
+------------+-------------+
| Family     |           1 |
| Profession |           1 |
| Friend     |           1 |
+------------+-------------+

mysql> INSERT INTO addressbook(firstName,lastName,type,mobileNumber,email,city,state,zip) VALUES
    ('Rohit','Sharma','Friend','9856321478','abc@yahoo.com','Hyderabad','Telangana',560039);

mysql> INSERT INTO addressbook(firstName,lastName,type,mobileNumber,email,city,state,zip) VALUES
    ('Virat','Kholi','Family','9632105478','xyz@yahoo.com','Mumbai','Maharashtra',560040);

mysql> select * from addressbook;
+-----------+----------+------------+--------------+---------------+-----------+-------------+--------+
| firstName | lastName | type       | mobileNumber | email         | city      | state       | zip    |
+-----------+----------+------------+--------------+---------------+-----------+-------------+--------+
| Mohammed  | Atif     | Family     | 9854712563   | abc@gmail.com | Bangalore | Karnataka   | 560039 |
| Rohit     | Sharma   | Friend     | 9856321478   | abc@yahoo.com | Hyderabad | Telangana   | 560039 |
| Salman    | Khan     | Profession | 9652314750   | xyz@gmail.com | Bangalore | Karnataka   | 560001 |
| Virat     | Kholi    | Family     | 9632105478   | xyz@yahoo.com | Mumbai    | Maharashtra | 560040 |
| xyz       | abc      | Friend     | 8523697412   | bca@gmail.com | Bangalore | Karnataka   | 560002 |
+-----------+----------+------------+--------------+---------------+-----------+-------------+--------+

mysql> CREATE TABLE  contacts
   (firstName varchar(50) NOT NULL, lastName varchar(50) NOT NULL,
    mobileNumber varchar(20) NOT NULL,email varchar(50) NOT NULL, PRIMARY KEY(firstName));

mysql> desc contacts;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| firstName    | varchar(50) | NO   | PRI | NULL    |       |
| lastName     | varchar(50) | NO   |     | NULL    |       |
| mobileNumber | varchar(20) | NO   |     | NULL    |       |
| email        | varchar(50) | NO   |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+

mysql> create table address (
   zip varchar(6) not null,
    city varchar(30) not null,
    state varchar(30) not null,
   primary key(zip));

mysql> desc address;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| zip   | varchar(6)  | NO   | PRI | NULL    |       |
| city  | varchar(30) | NO   |     | NULL    |       |
| state | varchar(30) | NO   |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+

mysql> create table contacts_address(
   firstname varchar(30) not null,
   zip varchar(6) not null,
   foreign key (firstname) references contacts(firstname),
   foreign key (zip) references address(zip));

mysql> desc contacts_address;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| firstname | varchar(30) | NO   | MUL | NULL    |       |
| zip       | varchar(6)  | NO   | MUL | NULL    |       |
+-----------+-------------+------+-----+---------+-------+

mysql> create table relations (type varchar(15),primary key(type));

mysql> desc relations;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| type  | varchar(15) | NO   | PRI | NULL    |       |
+-------+-------------+------+-----+---------+-------+

mysql> create table contacts_relation(
     firstname varchar(30) not null,
    type varchar(15),
    foreign key(firstname) references contacts(firstname),
    foreign key(type) references relations(type));

mysql> desc contacts_relation;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| firstname | varchar(30) | NO   | MUL | NULL    |       |
| type      | varchar(15) | YES  | MUL | NULL    |       |
+-----------+-------------+------+-----+---------+-------+

mysql> insert into contacts values('Rohit','Sharma','7852031478','abc@gmail.com'),
  ('Virat','Kohli','6254782145','kohli@gmail.com'),
   ('rani','Mukerjhe','6587425365','rani@yahoo.com');

mysql>  select * from contacts;
+-----------+----------+--------------+-----------------+
| firstName | lastName | mobileNumber | email           |
+-----------+----------+--------------+-----------------+
| rani      | Mukerjhe | 6587425365   | rani@yahoo.com  |
| Rohit     | Sharma   | 7852031478   | abc@gmail.com   |
| Virat     | Kohli    | 6254782145   | kohli@gmail.com |
+-----------+----------+--------------+-----------------+

mysql> insert into relations values('family'),('friend'),('work');

mysql> select * from relations;
+--------+
| type   |
+--------+
| family |
| friend |
| work   |
+--------+

mysql> insert into address values ('560039','Bangalore','Karnataka'),
    ('560040','Mumbai','Maharashtra'),
    ('560001','Chennai','Tamil Nadu');

mysql> select * from address;
+--------+-----------+-------------+
| zip    | city      | state       |
+--------+-----------+-------------+
| 560001 | Chennai   | Tamil Nadu  |
| 560039 | Bangalore | Karnataka   |
| 560040 | Mumbai    | Maharashtra |
+--------+-----------+-------------+

mysql> insert into contacts_relation values
    ( 'Rohit', 'friend'),
  ('Virat','family'),
   ('rani','work');


mysql> select * from contacts_relation;
+-----------+--------+
| firstname | type   |
+-----------+--------+
| Rohit     | friend |
| Virat     | family |
| rani      | work   |
+-----------+--------+

mysql> insert into contacts_address values ('Rohit','560001');

mysql> insert into contacts_address values ('Virat','560039');

mysql> insert into contacts_address values ('rani','560040');

mysql> select * from contacts_address;
+-----------+--------+
| firstname | zip    |
+-----------+--------+
| Rohit     | 560001 |
| Virat     | 560039 |
| rani      | 560040 |
+-----------+--------+


UC13: Ensure all retrieve queries done especially in UC 6, UC 7, UC 8 and UC 10 are working with new AStable structure

mysql> select count(contacts.firstname) from contacts,contacts_address,address
    -> where contacts.firstname = contacts_address.firstname and contacts_address.zip = address.zip and address.state = 'karnataka';
+---------------------------+
| count(contacts.firstname) |
+---------------------------+
|                         1 |
+---------------------------+

mysql> select type, Count(firstName) from contacts_relation group by type;
+--------+------------------+
| type   | Count(firstName) |
+--------+------------------+
| family |                1 |
| friend |                1 |
| work   |                1 |
+--------+------------------+
