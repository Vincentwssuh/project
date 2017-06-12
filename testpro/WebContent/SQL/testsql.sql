select * from seq;
select * from tab;
--회원가입
create table memberinfo(
  id varchar2(20) primary key,
  passwd varchar2(20) not null,
  name varchar2(20) not null,
  phone varchar2(30) not null,
  email varchar2(50) not null,
  nickname varchar2(30) not null,
  reg_date date not null
);

select * from memberinfo;

insert into memberinfo values('test','test','test','test','test','test',sysdate);

--게시판
create table board(
  id varchar2(20) REFERENCES memberinfo(id),
  no number PRIMARY key,
  subject varchar2(50) not null,
  content varchar2(2000) not null,
  ip varchar2(30) not null,
  readcount number default 0,
  file_name varchar2(50),
  nickname varchar2(30),
  section varchar2(30) CHECK(section in('java', 'jsp', 'javascript', 'oracle', 'html', 'css')),
  wirte_date date not null
);


alter table board add(
good number default 0,
bad number degault 0
);


create SEQUENCE seq_board_no
INCREMENT BY 1
START WITH 1;


insert into board values(
  'test',
  seq_board_no.nextval,
  'test',
  'test',
  '0',
  0,
  'test.jpg',
  'test',
  'test',
  sysdate
);