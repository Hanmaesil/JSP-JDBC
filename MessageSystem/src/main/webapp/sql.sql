1. ȸ�������� ������ ������ �� �ִ� 'web_member'���̺��� ����ÿ�.
   �÷��� : m_email / m_pw / m_tel / m_address
   
create table web_member(
m_email varchar(50),
m_pw varchar(50) not null,
m_tel varchar(50) not null,
m_address varchar(50) not null,
constraint m_email_web_member_pk primary key(m_email)
)

select * from web_member

drop table web_message 

create table web_message(
m_num number,
m_sendName varchar(50) not null,
m_receiveEmail varchar(50) not null,
m_content varchar(200) not null,
m_sendDate date not null,
constraint m_num_web_member_pk primary key(m_num)
)

select * from web_message

create sequence num_seq
increment by 1 start with 1
-- https://m.blog.naver.com/opgj123/221322082219  ������ ������ ������ ��--
insert into web_message values(num_seq.nextval,'test','asdf@naver.com','�׽�Ʈ �Դϴ�2',sysdate)












