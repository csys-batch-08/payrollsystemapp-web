----------user table----------------
create table 
admin_details
(email_id varchar2(40) ,
password varchar2(20) not null);

insert into admin_details values('maniselvam11@gmail.com','Maniselvam11@');
commit;

-------------employees table---------------
create table employees
(emp_id int GENERATED ALWAYS AS IDENTITY START WITH 1 ,
emp_name varchar2(30) not null,
emp_dob date not null,
emp_doj date not null,
emp_address varchar2(40) not null,
emp_city varchar2(20) not null,
emp_pincode int ,
emp_mobile_no int not null,
emp_state varchar2(20),
emp_email_id varchar2(40) not null,
emp_pan_no varchar2(30) not null,
dept_id number,
grade_id number,
constraint pk_empid primary key(emp_id),
constraint fk_depart_id foreign key (dept_id)references departments (dept_id),
constraint fk_grade_id foreign key (grade_id)references grades (grade_id));



--------department table--------------
create table 
departments
(dept_id int,
dept_name varchar2(30) not null,
grade_id number ,
CONSTRAINT pk_deptid PRIMARY KEY (dept_id),
constraint fk_grade_id foreign key (grade_id) references grades (grade_id));

-------------grade table---------
create table 
grades 
(grade_id int GENERATED ALWAYS AS IDENTITY START WITH 1201 increment by 1  ,
grade_name varchar2(30) not null,
grade_basic int not null,
grade_bonus int not null,
grade_pf int not null,
grade_pt int not null,
dept_id int not null,
constraint pk_gradeid primary key (grade_id),
constraint fk_dept_id foreign key (dept_id)references departments (dept_id));

insert into  grades(grade_name,grade_basic,grade_bonus,grade_pf,grade_pt) values('Trainee',15000,1500,1000,1700);

----------------salary table------------------
create table salarys 
(trans_id int GENERATED ALWAYS AS IDENTITY START WITH 1,
emp_id int,
dept_id int ,
total_leave int ,
grade_id int ,
paid_date date default sysdate,
gross_salary int,
total_salary int,
nextpay_date date,
constraint pk_transid primary key (trans_id),
constraint fk_empid foreign key (emp_id) references employees (emp_id),
constraint fk_gradeid foreign key (grade_id) references grades (grade_id),
constraint fk_deptid foreign key (dept_id) references departments (dept_id));

---------------------------------------------leave Details---------------------------------------------------------
create table leave_details (leave_id int GENERATED ALWAYS AS IDENTITY START WITH 1,
emp_id int,
leave_date date,
reason varchar2(40),
constraint pk_leave_id primary key(leave_id),
constraint fk_emp_id foreign key (emp_id) references employees(emp_id));


insert into departments values(11,'oracle',1202);
insert into departments values(14,'service',1206);
insert into departments values(15,'product',1203);

insert into departments values(2,'product',1201);

-----------perday salary--------------
select grade_name,(grade_basic /(30 - (select count(leave_id),emp_id from leave_details where emp_id=2 group by emp_id ))) as perday from grades;
select grade_basic,grade_name from grades;


select (grade_basic/30) as perDaySalary from grades where grade_name='Technical Lead';




select grade_id,grade_name,grade_basic,grade_bonus,grade_pf,grade_pt,(grade_basic + grade_bonus 
+ grade_pt + grade_pf)gross,(grade_basic+grade_bonus) as total 
from grades;


-----------basic--------
insert into leave_details (emp_id,leave_date,reason) values(2,'11-03-2020','dengu');

select e.emp_id,d.dept_id,g.grade_id,l.leave_id from leave_details l join employees e
on l.emp_id=e.emp_id join departments d on e.dept_id=d.dept_id join grades g
on d.grade_id=g.grade_id;



update employees set emp_address='gokaya' where emp_id=5;

